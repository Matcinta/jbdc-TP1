package optim;

import java.sql.*;

public class App {

    public static void main (String ... args) {

        // Connexion to database establishment
        String url = "jdbc:mysql://localhost:3306/digi-jdbc?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String pwd = "";

        try (Connection cnx = DriverManager.getConnection(url,login, pwd);
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM contact")){
            while (rs.next()) {

            }
        } catch (SQLException e) {

        }
    }
}
