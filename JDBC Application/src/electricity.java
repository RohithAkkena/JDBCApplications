import java.sql.*;
import java.util.Scanner;
public class electricity {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the electricity details.....");
			int consumer_id=sc.nextInt();
			String consumer_Name=sc.next();
			int current_reading=sc.nextInt();
			int previou_reading=sc.nextInt();
			int units=0;
			double total=0.0;
			units=current_reading-previou_reading;
			if(units<300)
			{
				total=units*1.75;
			}
			else if (units>=300 && units<700) {
				total=units*5.75;
			}
			else {
				total=units*7.25;
			}
		PreparedStatement ps=con.prepareStatement("insert into electricitybill values(?,?,?,?,?,?)");
		ps.setInt(1, consumer_id);
		ps.setString(2, consumer_Name);
		ps.setInt(3, current_reading);
		ps.setInt(4, previou_reading);
		ps.setInt(5, units);
		ps.setDouble(6, total);
		
		int i=ps.executeUpdate();
		System.out.println("inserted successful.........."+i);
		con.close();

			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}

	}

}
