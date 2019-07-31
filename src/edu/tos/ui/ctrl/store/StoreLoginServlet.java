package edu.tos.ui.ctrl.store;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.util.*;

/**
 * Servlet implementation class StoreLoginServlet
 */
@WebServlet("/store/Login")
public class StoreLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreService storeService = new StoreServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreLoginServlet() {
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
		case "insert":
			insertView(request, response);
			break;
		case "insertdeal":
			insertDeal(request, response);
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

		String toPage = "/WEB-INF/store/storelogin.jsp";//
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	protected void loginDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		javax.servlet.http.HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");

		request.setAttribute("userName", userName);

		String toPage = "/WEB-INF/store/storelogin.jsp";
		// request.setAttribute("usePass", userPass);
		if (SysFun.isNullOrEmpty(userName)) {
			request.setAttribute("msg", "账号不能为空");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(userPass)) {
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}

		Store bean = storeService.loadByName(userName);

		if (bean == null) {
			request.setAttribute("msg", "账号不存在");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (!bean.getStorePass().equals(userPass)) {
			request.setAttribute("msg", "密码不正确");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (bean.getStatus() == 0) {
			request.setAttribute("msg", "账号正在审核中...请联系客服咨询进度");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}

		session.setAttribute(UIConst.BG_LOGINUSER_KEY, bean);

		response.sendRedirect("Main");

	}

	protected void insertView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String toPage = "/WEB-INF/store/storeRegister.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	protected void insertDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");

		request.setAttribute("userName", userName);

		String toPage = "/WEB-INF/store/storeRegister.jsp";
		// request.setAttribute("usePass", userPass);
		if (SysFun.isNullOrEmpty(userName)) {
			request.setAttribute("msg", "账号不能为空");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(userPass)) {

			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}

		Store bean = storeService.loadByName(userName);

		if (bean == null) {
			request.setAttribute("msg", "账号不存在");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (!bean.getStorePass().equals(userPass)) {
			request.setAttribute("msg", "密码不正确");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}

		response.sendRedirect("Main");

	}

}
