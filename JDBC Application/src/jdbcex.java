import java.sql.*;
public class jdbcex {

	public static void main(String[] args) {
		
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
		Statement stmt=con.createStatement();
		int i=stmt.executeUpdate("insert into employee values(101,'rohit',49999)");
		System.out.println(i+"created successful....");	
		con.close();
	} catch (Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}

	}

}
