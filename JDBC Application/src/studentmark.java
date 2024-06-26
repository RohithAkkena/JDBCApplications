import java.sql.*;
import java.util.Scanner;
public class studentmark {

	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");	
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter student details...");
		int sid=sc.nextInt();
		System.out.println("enter the firstname");
		String fname=sc.next();
		System.out.println("enter the lastname");
		String lname=sc.next();
		String fullName=fname+lname;

		int english=sc.nextInt();
		int maths=sc.nextInt();
		int hindi=sc.nextInt();
		int total=0;
		double percentage=0.0;
		String grade;
		String result;
		
		total=english+maths+hindi;
		
		percentage=(total/3);
		
		if(percentage>=90) {
			grade="A grade";
			result="pass";
		}
		else if (percentage>=80 ) {
			grade="B grade";
			result="pass";
		}
		else if (percentage>=70 ) {
			grade="C grade";
			result="pass";
		}
		else if (percentage>=60 ) {
			grade="D grade";
			result="pass";
		}
		else  {
			grade="F grade";
			result="fail";
		}
		
		PreparedStatement ps=con.prepareStatement("insert into studentmarks values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, sid);
		ps.setString(2, fullName);
		ps.setInt(3, english);
		ps.setInt(4, maths);
		ps.setInt(5,hindi);
		ps.setInt(6, total);
		ps.setDouble(7, percentage);
		ps.setString(8, grade);
		ps.setString(9, result);
		
		int i =ps.executeUpdate();
		System.out.println("student details updated..."+i);
		con.close();
		}	
		catch(Exception ex) {
			System.out.println(ex);
		}

	}

}
