package smartcare;
/**
 *
 * @author harry
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Smartcare {
     public static void main(String[] args) {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Smartcare.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/users","Harry", "123"); 
// replace your user name with <user> and your password with <passwd> 
        } catch (SQLException ex) {
            Logger.getLogger(Smartcare.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Users" );
            ResultSetMetaData metaData =  resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++)   
                System.out.print(metaData.getColumnName(i)+"\t");     
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++)
                    System.out.print(resultSet.getObject(i)+"\t");
                System.out.println();
            }
        resultSet.close();
        statement.close(); 		
        con.close();                                     
        }
        catch (SQLException s){
            System.out.println("SQL statement is not executed!");
            s.printStackTrace();
        }
    }
}
