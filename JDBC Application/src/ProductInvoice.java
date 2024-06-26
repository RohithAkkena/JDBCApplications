import java.sql.*;
import java.util.Scanner;
public class ProductInvoice {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","welcome");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter PID,PNAME,PRICE and SALARY VALUES...");
			int pid=sc.nextInt();
			String pname=sc.next();
			double price=sc.nextDouble();
			int quantity=sc.nextInt();
			double total=0.0,discount=0.0,gst=0.0,invoice_bill=0.0;
			total=price*quantity;
			if(total<2500)
			{
				discount=(total*5)/100;
			}
			else if (total>=2500 && total<5000) {
			    discount=(total*15)/100;
			}
			else if (total>=5000) {
				discount=(total*25)/100;
			}
			gst=(total*10)/100;
			invoice_bill=total-discount+gst;
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setDouble(3, price);
			ps.setInt(4, quantity);
			ps.setDouble(5, total);
			ps.setDouble(6, discount);
			ps.setDouble(7, gst);
			ps.setDouble(8, invoice_bill);
			
			int i =ps.executeUpdate();
			System.out.println(i+"Data inserted successfully....");
			con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}

	}

}
