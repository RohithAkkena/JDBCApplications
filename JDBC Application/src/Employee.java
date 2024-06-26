import java.sql.*;
import java.util.Scanner;
public class Employee {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter employee details....");
			int empid=sc.nextInt();
			String empname=sc.next();
			double salary=sc.nextDouble();
			double ta=0.0,da=0.0,pf=0.0,gross_salary=0.0,net_salary=0.0;
			if(salary<30000)
			{
				ta=(salary*7)/100;
				da=(salary*9)/100;
			}
			else if (salary>=30000 && salary<50000) {
				ta=(salary*12)/100;
				da=(salary*13)/100;
			}
			else if (salary>=50000) {
				ta=(salary*17)/100;
				da=(salary*19)/100;
			}
			
			if(salary<30000)
			{
				pf=(salary*15)/100;
			}
			else if (salary>=30000 && salary<50000) {
				pf=(salary*22)/100;
			}
			else if (salary>=50000) {
				pf=(salary*25)/100;
			}
			gross_salary=salary+ta+da;
			net_salary=gross_salary-pf;
			
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, empid);
			ps.setString(2, empname);
			ps.setDouble(3, salary);
			ps.setDouble(4, ta);
			ps.setDouble(5, da);
			ps.setDouble(6, pf);
			ps.setDouble(7, gross_salary);
			ps.setDouble(8, net_salary);
			
			int i=ps.executeUpdate();
			System.out.println("insert succesfull..."+i);
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}

	}

}
