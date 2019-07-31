package edu.tos.ui.ctrl.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuvei.common.SysFun;

import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.util.*;;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/admin/Login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		javax.servlet.http.HttpSession session = request.getSession();
		javax.servlet.ServletContext application = request.getServletContext();
		javax.servlet.ServletConfig config = getServletConfig();
		java.io.PrintWriter out = response.getWriter();
		String oper = request.getParameter("oper");
		if (oper == null) {
			oper = "";
		} else {
			oper = oper.trim().toLowerCase();
		}
		switch (oper) {
		case "logindeal":
			loginDeal(request, response);
			break;
		default:
			loginView(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void loginView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String toPage = "/WEB-INF/admin/login.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	protected void loginDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		javax.servlet.http.HttpSession session = request.getSession();
		javax.servlet.ServletContext application = request.getServletContext();
		javax.servlet.ServletConfig config = getServletConfig();
		java.io.PrintWriter out = response.getWriter();

		String adminName = request.getParameter("adminName");
		String adminPass = request.getParameter("adminPass");

		request.setAttribute("adminName", adminName);

		String toPage = "/WEB-INF/admin/login.jsp";
		// request.setAttribute("usePass", AdminPass);
		if (SysFun.isNullOrEmpty(adminName)) {
			request.setAttribute("msg", "账号不能为空");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(adminPass)) {
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}

		Admin bean = adminService.loadByName(adminName);

		if (bean == null) {
			request.setAttribute("msg", "账号不存在");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (!bean.getAdminPass().equals(adminPass)) {
			request.setAttribute("msg", "密码不正确");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}

		session.setAttribute(UIConst.FG_LOGINUSER_KEY, bean);

		response.sendRedirect("Main");

	}
}
