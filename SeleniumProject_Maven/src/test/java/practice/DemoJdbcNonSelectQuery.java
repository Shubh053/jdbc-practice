package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DemoJdbcNonSelectQuery {
	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students2", "root", "root");
		Statement stm = con.createStatement();
		int result = stm.executeUpdate(" insert into students_info (regno, firstname, middlename, lastname) values('6', 'memdapalli','vijay', 'prashant')");
		if(result == 1) {
			System.out.println("user created");
		} else {
			System.out.println("user not created");
		}
		con.close();
	}
}
