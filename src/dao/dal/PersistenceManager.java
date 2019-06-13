package dao.dal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PersistenceManager {

    private static final int CHECK_CONNECTION_TIMEOUT = 10; // in seconds
    private static Connection connection;


    // Constructeur private pour empecher l'instanciation de la classe PersistenceManager
    private PersistenceManager(){

    }

    public static Connection getConnection() throws SQLException {
        //permet d'initialiser une connection
        if (null == connection // si la connection n'est pas déjà faite OU
                || connection.isClosed() // si elle a ete fermée OU
                || !connection.isValid(CHECK_CONNECTION_TIMEOUT)){ // si la connection n'est plus valide

            Properties props = new Properties();
            try (FileInputStream fis = new FileInputStream("resources/conf.properties")){
                props.load(fis);
            }catch ( IOException e ) {
                System.out.println(e.getMessage());
            }

            String url = props.getProperty("ds.jdbc.url");
            String login = props.getProperty("ds.user.login");
            String pwd = props.getProperty("ds.user.pwd");

            connection = DriverManager.getConnection(url, login, pwd);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (null != connection && !connection.isClosed()){
            connection.close();
        }
    }
}
