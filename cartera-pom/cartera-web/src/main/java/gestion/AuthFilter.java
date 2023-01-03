package gestion;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comun.controlador.util.core.BaseControlador;


@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthFilter extends BaseControlador implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5889816543144394051L;

	public AuthFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// check whether session variable is set
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		try {

			HttpSession ses = req.getSession(false);
			// allow user to proccede if url is login.xhtml or user logged in or
			// user is accessing any page in //public folder
			String reqURI = req.getRequestURI();
			if (reqURI.indexOf("/login.xhtml") >= 0
					|| (ses != null && ses.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource"))
				chain.doFilter(request, response);
			else {
				// user didn't log in but asking for a page that is not allowed
				// so take user to login page
				res.sendRedirect(req.getContextPath() + "/login.xhtml"); // Anonymous
																			// user.
																			// Redirect
																			// to
																			// login
																			// page

			}
		} catch (Exception e) {
			LOGGER.info("IllegalStateException - :"+e.getMessage());
			res.sendRedirect(req.getContextPath() + "/login.xhtml");
		} catch (Throwable t) {
			LOGGER.info("Throwable");
			res.sendRedirect(req.getContextPath() + "/login.xhtml");
			// LOGGER.info(req.getContextPath().toString()+"-------xxxx---------> "+t.getMessage());
		}
	} // doFilter

	@Override
	public void destroy() {

	}

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub

	}
}