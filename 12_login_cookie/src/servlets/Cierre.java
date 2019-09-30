package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cierre
 */
@WebServlet("/Cierre")
public class Cierre extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cierre() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//borramos cookie
		Cookie ck = new Cookie("usuario","");
		ck.setMaxAge(0);
		response.addCookie(ck);
		//destruimos sesion
		HttpSession sesion = request.getSession();
		sesion.invalidate();

		request.getRequestDispatcher("formulario.html").forward(request, response);
		//response.sendRedirect("Inicio");

	}

}
