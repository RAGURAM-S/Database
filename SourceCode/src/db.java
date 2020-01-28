import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
	
	public static void main(String[] args) {
		
		Connection connect = null;
		
		try {
			
			String dbUrl = "jdbc:sqlserver://localhost; integratedSecurity = true";
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connect = DriverManager.getConnection(dbUrl);
				System.out.println("Connection Established Successfullly...!");
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
