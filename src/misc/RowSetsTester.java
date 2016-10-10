package misc;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetsTester {

	public static void main(String[] args) {
		String url = "jdbc:derby://localhost:1521/BookSellerDB";
		String user = "bookguy";
		String pwd = "$3lleR";
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();
			RowSetFactory factory = RowSetProvider.newFactory();
			JdbcRowSet jdbcRowSet = factory.createJdbcRowSet();

			
		} catch (SQLException se) {
			System.out.println("SQLException: " + se);
		}
	}
}
