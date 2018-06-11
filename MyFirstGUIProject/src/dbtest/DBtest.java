package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBtest {

		public static void main(String[]args) {
			try {
				new DBtest();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public DBtest() throws SQLException {
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Moritz/git/javaintro/MyFirstGUIProject/db/dbtest1.accdb;memory=false");
			
			Statement stmt = conn.createStatement();
			stmt.execute("INSERT INTO adresse (vorname, nachname, ort, plz)" + "VALUES ('Clemens','Thalhammer','Wien',1190)");
		}
}
