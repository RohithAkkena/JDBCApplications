import java.sql.*;
import java.util.Scanner;
public class Loginex {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter your sid and sname");
			int rno=sc.nextInt();
			String sname=sc.next();
			PreparedStatement ps=con.prepareStatement("select * from student where rno=? and sname=?");
			ps.setInt(1, rno);
			ps.setString(2, sname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("your login successfull");
			}
			else
			{
				System.out.println("Please insert valid sid and name");
			}
			con.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
