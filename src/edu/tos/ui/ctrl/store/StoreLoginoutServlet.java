package edu.tos.ui.ctrl.store;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tos.util.*;

/**
 * Servlet implementation class loginoutServlet
 */
@WebServlet("/store/Loginout")
public class StoreLoginoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreLoginoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset-utf-8");
		//Servlet的doxxx方法中的6个标准对象（含request和response）
		//从request里获取session对象和application对象
		javax.servlet.http.HttpSession session = request.getSession();
		javax.servlet.ServletContext application = request.getServletContext();
		//调用继承的方法来获取config对象
		javax.servlet.ServletConfig config = getServletConfig();
		//从response对象获取out对象-response。个体Writer()之前，要设置页面的编码
		java.io.PrintWriter out = response.getWriter();
		
		//移除会话数据
		session.removeAttribute(UIConst.BG_LOGINUSER_KEY);
		//设置当前会话失效
		session.invalidate();
		//跳转到登录页面
		response.sendRedirect(request.getContextPath()+"/store/Login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
