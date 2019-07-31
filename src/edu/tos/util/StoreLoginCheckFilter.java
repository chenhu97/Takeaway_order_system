package edu.tos.util;

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

import edu.tos.util.*;;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("/store/*")
public class StoreLoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public StoreLoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rsp;
		javax.servlet.http.HttpSession session = request.getSession();
		javax.servlet.ServletContext application = request.getServletContext();
		
		//1)登录页面与登录业务无需过滤
		String path = request.getRequestURI();
		if(path.indexOf("login")>-1 || path.indexOf("Login")>-1||path.indexOf("logout")>-1||path.indexOf("Logout")>-1) {
			chain.doFilter(request, response);
			return;
		}
		
		//2) 
		String toPage = null;
		Object obj = session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		if(obj == null) {
			toPage = application.getContextPath() + "/store/Login";
			response.sendRedirect(toPage);
			return;
		}
		// 继续
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
