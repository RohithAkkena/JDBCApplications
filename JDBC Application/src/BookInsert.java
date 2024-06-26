import java.sql.*;
import java.util.Scanner;
public class BookInsert {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
			Scanner s=new Scanner(System.in);
			System.out.println("enter the bookid,bname,isbn_no,price,author_name,publisher_name,publish_year,edition_name");
			int bookid=s.nextInt();
			String bName=s.next();
			int isbn_no =s.nextInt();
			double price=s.nextDouble();
			String author_name=s.next();
			String publisher_name=s.next();
			int publish_year=s.nextInt();
			String edition_name=s.next();
			PreparedStatement ps=con.prepareStatement("insert into bookdetails values(?,?,?,?,?,?,?,?)");
			ps.setInt(1,bookid);
			ps.setString(2,bName);
			ps.setInt(3,isbn_no);
			ps.setDouble(4,price);
			ps.setString(5,author_name);
			ps.setString(6,publisher_name);
			ps.setInt(7, publish_year);
			ps.setString(8, edition_name);
		int i=ps.executeUpdate();
		System.out.println("Insert updated...."+i);
		con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}

	}

}
