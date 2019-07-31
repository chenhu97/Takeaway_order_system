package edu.tos.ui.ctrl.map;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MapServlet
 */
@WebServlet("/member/Map")
public class MapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//*****防止乱码的解决方案
		//输入数据乱码解决方案：使用request对象获取浏览器提交数据前，先设置字符集
		request.setCharacterEncoding("utf-8");
		//输出数据乱码解决方案：使用request 输出数据前，先设置字符集和内容类型
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		java.io.PrintWriter out =response.getWriter();
		String toPage ="/WEB-INF/map/map.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
