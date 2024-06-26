import java.sql.*;
import java.util.Scanner;
public class Bookupdate {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
			Scanner s=new Scanner(System.in);
			System.out.println("enter bookid,edition_name...");
			int bookid=s.nextInt();
			String edition_name=s.next();
			PreparedStatement ps=con.prepareStatement("update bookdetails set edition_name=? where bookid=? ");
			ps.setString(1, edition_name);
			ps.setInt(2, bookid);
			int i=ps.executeUpdate();
			System.out.println(i+"updated successfully");
					con.close();
			
			
		}
		catch(Exception ex) {
		System.out.println(ex);
		}

	}

}
