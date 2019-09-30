package listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class EscuchadorSesion implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  {
    	ServletContext contexto = se.getSession().getServletContext();
    	int numUsuarios = (Integer)contexto.getAttribute("numUsuarios");
    	numUsuarios++;
    	contexto.setAttribute("numUsuarios", numUsuarios);
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    	ServletContext contexto = se.getSession().getServletContext();
    	int numUsuarios = (Integer)contexto.getAttribute("numUsuarios");
    	numUsuarios--;
    	contexto.setAttribute("numUsuarios", numUsuarios);
    }
	
}
