package DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataToDB {
	
public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_E18", "root", "H@neybunny2901");
		
		Statement stmt = conn.createStatement();
		
		int result = stmt.executeUpdate("update Ninza_CRM_Details set uname='admin' where Browser='firefox'");
		
		System.out.println(result);
		
		if(result != 0)
		{
			System.out.println("operation is done successfully");
		}
		else
		{
			System.out.println("operation failed");
		}
		
		conn.close();
	}
}
