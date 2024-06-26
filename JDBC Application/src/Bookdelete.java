import java.sql.*;
import java.util.Scanner;
public class Bookdelete {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
			Scanner s=new Scanner(System.in);
			System.out.println("enter bookid...");
			int bookid=s.nextInt();
			
			PreparedStatement ps=con.prepareStatement("delete from bookdetails where bookid=? ");
			
			ps.setInt(1, bookid);
			int i=ps.executeUpdate();
			System.out.println(i+"deleted successfully");
					con.close();
			
			
		}
		catch(Exception ex) {
		System.out.println(ex);
		}

	}

}
