import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
 
public class Database {
 
    public static void main(String[] args) {
 
        Connection conn = null;
        HashMap<String, String> map = new HashMap<String, String>();
 
        try {
            String dbURL = "jdbc:sqlserver://<server_name>:1433; databaseName = <DB name>";
            String user = "user_name";
            String pass = "user_password";
//            String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                
                PreparedStatement ps = conn.prepareStatement( "select * from ix_str_store" ) ;
                ResultSet rs = ps.executeQuery() ;
                
                while( rs.next() ) {
                	map.put(rs.getString("DBKey"), rs.getString("Name"));
                	System.out.println( rs.getString("DBKey") + " " + rs.getString("Name") ) ;
                }
                    
                
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
