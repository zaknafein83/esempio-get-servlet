package it.dstech.formazione.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametro = req.getParameter("nomeParametro");
		int limit = Integer.parseInt(req.getParameter("limite"));

		ServletOutputStream outputStream = resp.getOutputStream();
		outputStream.println("<html>");
		outputStream.println("<ul>");
		outputStream.println("<h1>Elenco città " + parametro.toUpperCase() + " </h1>");
		try {
			for (String nome : getCity(parametro, limit)) {
				outputStream.println("<li>" + nome + "</li>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputStream.println("</ul>");
		outputStream.println("</html>");

	}

	public static List<String> getCity(String country, int limit) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // in questo punto carichia nella JVM in esecuzione la nostra
													// libreria
		String password = "password"; // la vostra password
		String username = "root"; // la vostra username
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
