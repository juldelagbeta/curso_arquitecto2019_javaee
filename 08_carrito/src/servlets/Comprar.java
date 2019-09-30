package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrito;
import model.Producto;

@WebServlet("/Comprar")
public class Comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Comprar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreProducto=request.getParameter("producto");
		int unidades=Integer.parseInt(request.getParameter("unidades"));
		double precio=Double.parseDouble(request.getParameter("precio"));
		
		Producto producto = new Producto(nombreProducto, unidades, precio);
		Carrito listaProductos = new Carrito();
		listaProductos.addProducto(producto);
		
		HttpSession sesion = request.getSession();
		sesion.setAttribute("carrito", listaProductos);
		
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("verCarrito.jsp");
		rd.forward(request, response);
	}

}
