package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import factories.FactoryDao;
import model.Contacto;

/**
 * Servlet implementation class Alta
 */
@WebServlet("/AltaAction")
//@WebServlet(urlPatterns = {"/AltaAction", "/Alta"})
public class AltaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		Contacto contacto = new Contacto(0,nombre,email,edad);
		
//		DaoContactos dao=new DaoContactos();
		DaoContactos dao=FactoryDao.getDaoContactos();
		dao.altaContacto(contacto);

	}

}
