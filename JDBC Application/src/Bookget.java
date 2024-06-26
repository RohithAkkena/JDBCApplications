import java.sql.*;
public class Bookget {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from bookdetails ");
			System.out.println(rs);
			
			while(rs.next()) {
				for(int i=1;i<8;i++) {
					System.out.println(rs.getString(i));
				}
			} 
			con.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
