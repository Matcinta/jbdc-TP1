package dao;

import dao.dal.DBConnection;
import dao.dal.PersistenceManager;

import java.sql.*;

public class App {

    public static void main (String ... args) throws SQLException {

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
