package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DemoJdbcSelectQuery  {
	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students2", "root", "root");
		Statement stm = con.createStatement();
		String query = "select * from students_info";
		ResultSet results = stm.executeQuery(query);
		while(results.next()) {
			System.out.println(results.getInt(1) + "\t" + results.getString(2) + "\t" + results.getString(3) + "\t" + results.getString(4));
		}
		con.close();
	}
}
