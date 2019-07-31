package edu.tos.ui.ctrl.member;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.util.*;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/MemberLogin")

public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberLoginServlet() {
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

//		HttpSession session = request.getSession();
//		ServletContext application = request.getServletContext();
//		ServletConfig config = getServletConfig();
//		PrintWriter out = response.getWriter();

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
		case "loginout":
			loginOut(request, response);
			break;
		default:
			loginView(request, response);
			break;
		}
	}

	private void loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute(UIConst.FG_LOGINUSER_KEY, null);

		String toPage = "../index.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	protected void loginView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String toPage = "/WEB-INF/member/login.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	protected void loginDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
//		ServletContext application = request.getServletContext();
//		ServletConfig config = getServletConfig();
//		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		request.setAttribute("userName", userName);

		String toPage = "/WEB-INF/member/login.jsp";
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

		Member bean = memberService.loadByName(userName);

		if (bean == null) {
			request.setAttribute("msg", "账号不存在");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (!bean.getUserPass().equals(userPass)) {
			request.setAttribute("msg", "密码不正确");
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		
//		List<Announce> announceList = announceService.list();
//		request.setAttribute("announceList", announceList);
		session.setAttribute(UIConst.FG_LOGINUSER_KEY, bean);

		response.sendRedirect("MemberMain?oper=list");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
