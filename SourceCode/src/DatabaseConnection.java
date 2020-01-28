import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

	public static void main(String[] args) {
		
		Connection connect = null;

		try {
			String dbUrl = "jdbc:sqlserver://localhost";
			String dbUser = "ckbtest";
			String dbPassword = "ckbtest";
			String query = "select * from ix_spc_planogram";
			connect = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

			if (connect != null) {

				DatabaseMetaData metaData = connect.getMetaData();
				System.out.println("Driver Name --> " + metaData.getDriverName());
				System.out.println("Driver Version --> " + metaData.getDriverVersion());
				System.out.println("Product Name --> " + metaData.getDatabaseProductName());
				System.out.println("Product Version --> " + metaData.getDatabaseProductVersion());

				PreparedStatement statement = connect.prepareStatement(query);
				ResultSet result = statement.executeQuery();
				
				System.out.println("");
				System.out.println("DBCurrentUser " + " " + "DBKey");
				System.out.println(" ");
				while (result.next()) {
					System.out.println(result.getString("DBCurrentUser") + " " + result.getString("DBKey"));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
					if(connect != null && !connect.isClosed()) {
						connect.close();
				}
			}
					
			catch (SQLException e) {
					e.printStackTrace();
			}
		}	
	}

}
