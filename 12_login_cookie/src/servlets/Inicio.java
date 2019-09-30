package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Persona;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Inicio() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("formulario.html");
		
		if (cookies!=null) {
			for (Cookie ck:cookies) {
				if (ck.getName().equals("usuario")) {
					Persona persona = new Persona(ck.getValue(), "correo@mio.com", 50);
					request.getSession().setAttribute("persona", persona);
					dispatcher = request.getRequestDispatcher("preferencias.html");
				}
			}
		} 
		dispatcher.forward(request, response);
	}

}
