package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter("/*")
public class FiltroLogin implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Recuperamos la dirección original solicitada y si quiere autenticarse
		// le dejamos pasar
		String path=((HttpServletRequest)request).getServletPath();
		if (path.equals("/")||path.equals("/Autenticar")) {
			chain.doFilter(request, response);
		}
		
		// Comprobamos la existencia del atributo de sesión "persona"
		// si no existe, le mandamos a inicio
		
		HttpSession sesion = ((HttpServletRequest)request).getSession();
		if (sesion.getAttribute("persona")!=null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("Inicio").forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
