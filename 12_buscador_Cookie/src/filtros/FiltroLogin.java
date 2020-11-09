package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter({ "/login.html", "/" })
public class FiltroLogin implements Filter {
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Cookie [] cookies = ((HttpServletRequest) request).getCookies();
		if(cookies!=null) {
			for(Cookie ck:cookies) {
				if(ck.getName().equals("user")) {
					//creamos atributo de sesion con los datos de la cookie
					HttpSession sesion=((HttpServletRequest) request).getSession();
					sesion.setAttribute("usuario", ck.getValue());
					//pasamos directamente sin pasar por login
					request.getRequestDispatcher("buscador.jsp").forward(request, response);
				}
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
