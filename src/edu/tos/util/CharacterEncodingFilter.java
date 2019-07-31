package edu.tos.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
//@WebFilter("/CharacterEncodingFilter")
@javax.servlet.annotation.WebFilter(filterName="CharacterEncodingFilter"
,urlPatterns= {"/admin/*"}
,initParams= {@javax.servlet.annotation.WebInitParam(name="encoding",value="UTF-8")})
public class CharacterEncodingFilter implements Filter {

	private FilterConfig filterConfig = null;

	private String defaultCharset = "UTF-8";
	private String defaultIsUseWrapper = "false";

	/**
	 * Default constructor.
	 */
	public CharacterEncodingFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String charset = filterConfig.getInitParameter("encoding");
		if (charset == null) {
			charset = defaultCharset;
		}

		req.setCharacterEncoding(charset);
		res.setCharacterEncoding(charset);

		res.setContentType("text/html; charset = " + charset);
		
		String isUseWrapper = filterConfig.getInitParameter("isUseWrapper");
		if (isUseWrapper == null) {
			isUseWrapper = defaultIsUseWrapper;
		}
		ServletRequest servletRequest = request;
		if (servletRequest!=null&& isUseWrapper.equalsIgnoreCase("true")) {
			servletRequest = new MyCharacterEncodingRequest(req);
		}
		// pass the request along the filter chain
		chain.doFilter(servletRequest, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}
	class MyCharacterEncodingRequest extends HttpServletRequestWrapper{
		
		private HttpServletRequest request ;
		
		public MyCharacterEncodingRequest(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
			this.request = request;
		}
		public String getParameter(String name) {
			try {
				String value = this.request.getParameter(name);
				if (value == null) {
					return null;
				}
				if (!this.request.getMethod().equalsIgnoreCase("get")) {
					return value;
				}else {
					value = new String(value.getBytes("ISO8859-1"),this.request.getCharacterEncoding());
					return value;
				}
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}
	}
}
