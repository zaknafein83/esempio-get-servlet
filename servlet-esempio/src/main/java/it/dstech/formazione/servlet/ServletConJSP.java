package it.dstech.formazione.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConJSP extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametro = req.getParameter("nomeParametro");
		int limit = Integer.parseInt(req.getParameter("limit"));
		try {
			req.setAttribute("listaCitta", getCity(parametro, limit));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("listaCittà.jsp").forward(req, resp);

	}

	public static List<String> getCity(String country, int limit) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String password = "password";
		String username = "root";
		String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		PreparedStatement statement = connessione
				.prepareStatement("select * from city where CountryCode =  ? limit ?;");
		statement.setString(1, country);
		statement.setInt(2, limit);
		ResultSet risultatoQuery = statement.executeQuery();
		List<String> elenco = new ArrayList<>();
		while (risultatoQuery.next()) {
			String nome = risultatoQuery.getString("Name");
			elenco.add(nome);
		}
		connessione.close();
		return elenco;
	}

}
