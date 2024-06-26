import java.sql.*;
import java.util.Scanner;
public class Account {

	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter account no....");
		int acno=sc.nextInt();
		PreparedStatement ps=con.prepareStatement("select * from account where acno=?");
		ps.setInt(1,acno);
		ResultSet rs=ps.executeQuery();
		double oldBalance=0.0,balanace=0.0;
		if(rs.next()) {
			oldBalance=rs.getDouble(2);
		}	
		System.out.println("my account number= "+acno);
		System.out.println("my balance= "+oldBalance);
		System.out.println("withdraw amount...");
		double withdraw=sc.nextDouble();
		if(oldBalance>withdraw) {
			balanace=oldBalance-withdraw;
		
		PreparedStatement ps2=con.prepareStatement("update account set balanace=? where acno=?");
		ps2.setDouble(1, balanace);
		ps2.setInt(2, acno);
		int i =ps2.executeUpdate();
		System.out.println("amount withdraw.....");
		System.out.println("My account balanace...="+balanace);
		con.close();
		}
		else
		{
			System.out.println("not sufficient ammout....");
		}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}

	}

}
