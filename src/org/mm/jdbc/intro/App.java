package org.mm.jdbc.intro;

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


		/* Instructions executions
		st.executeUpdate("INSERT INTO address (details) VALUES ('2, rue de Belleville - 75000 Paris')", Statement.RETURN_GENERATED_KEYS);

		ResultSet rs = st.getGeneratedKeys();
		if(rs.next()){
			st.executeUpdate("INSERT INTO contact (email, first_name, last_name, address_id) VALUES ('123456@gmail.com', 'Robert', 'Dupont'," + rs.getLong(1)+")");
		}

		ResultSet rsSelect = st.executeQuery("SELECT * FROM contact c INNER JOIN address a ON c.address_id = a.id");
		while(rsSelect.next()) {
			System.out.println(rsSelect.getString("email")+ " " + rsSelect.getString("first_name")+ " " + rsSelect.getString("details")+ " ");
		}
		*/

		// Closing the connexion
		//rsSelect.close();
		rs.close();
		st.close();
		connection.close();

	}

}
