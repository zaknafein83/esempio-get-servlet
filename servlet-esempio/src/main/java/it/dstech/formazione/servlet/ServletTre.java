package it.dstech.formazione.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.formazione.servlet.models.Macchina;
import it.dstech.formazione.servlet.models.Persona;

public class ServletTre extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Math.random() < 0.5) {
			
			Persona p = new Persona("pippo", "topolino");
			req.setAttribute("elemento", p);
			req.getRequestDispatcher("terzaJsp.jsp").forward(req, resp);

		}
		else {
			
			Macchina p = new Macchina("alfa romeo", 2000);
			req.setAttribute("elemento", p);
			
			req.getRequestDispatcher("terzaJsp.jsp").forward(req, resp);

		}
	}
}
