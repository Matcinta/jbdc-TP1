package dao;

import dao.dal.DBConnection;
import dao.dal.PersistenceManager;

import java.sql.*;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);

    public static void main (String ... args) throws SQLException {


        do {
            System.out.println("* 1 - Ajouter un contact");
            System.out.println("* 2 - Modifier un contact");
            System.out.println("* 3 - Supprimer un contact");
            System.out.println("* 4 - Afficher les contact");

        } while;
        try {
            DBConnection db = DBConnection.getSingle();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try ( Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM contact")){

            while (rs.next()) {
                System.out.println(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Attention :" + e.getMessage());
        }
    }
}
