package injection;

import java.sql.*;
import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        // Connexion to database establishment
        String url = "jdbc:mysql://localhost:3306/digi-jdbc?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String pwd = "";

        Connection connection = DriverManager.getConnection(url, login, pwd);

        // SQL instructions creation
        Statement st = connection.createStatement();



        System.out.println("****** Boîte de login ******");

        System.out.println("Entrez votre login: ");
        String loginUser = sc.nextLine();

        System.out.println("Entrez votre mot de passe: ");
        String password = sc.nextLine();

        String query = "SELECT * FROM contact WHERE email = ? AND first_name = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, loginUser);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        System.out.println(query);
        System.out.println(ps);

        if (rs.next()){
            System.out.println("Bienvenue dans votre espace de travail"
                    + rs.getString("first_name")
                    + " " + rs.getString("first_name"));
        } else {
            System.out.println("Erreur: login ou mot de passe incorrect");
        }


        // Closing the connexion

        rs.close();
        st.close();
        connection.close();

    }

}
