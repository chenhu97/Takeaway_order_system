package edu.tos.ui.ctrl.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuvei.common.PagerItem;
import com.liuvei.common.SysFun;

import edu.tos.bean.Member;
import edu.tos.service.MemberService;
import edu.tos.service.impl.MemberServiceImpl;

/**
 * Servlet implementation class AdminMemberServlet
 */
@WebServlet("/admin/Member")

public class AdminMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminMemberServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		javax.servlet.http.HttpSession session = request.getSession();
		javax.servlet.ServletContext application = getServletContext();
		javax.servlet.ServletConfig config = getServletConfig();
		java.io.PrintWriter out = response.getWriter();

		String oper = request.getParameter("oper");
		if (oper == null) {
			oper = "";
		} else {
			oper = oper.trim().toLowerCase();
		}
		switch (oper) {
		case "list":
			listView(request, response);
			break;
		case "listdeal":
			listDeal(request, response);
			break;
		case "deletedeal":
			deleteDeal(request, response);
			break;
		case "detail":
			detailView(request, response);
			break;
		default:
			System.out.println("操作不存在");
			break;
		}

	}

	private void listView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Member> vDataList = null;

		// 普通分页
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		Long rowCount = 0L;
		rowCount = memberService.count();
		pagerItem.changeRowCount(rowCount);
		vDataList = memberService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);
		// 转发页面
		String toPage = "/WEB-INF/admin/member_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void listDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 实现根据地址进行模糊查询查找
		String address = request.getParameter("search");
		request.setAttribute("search", address);
		List<Member> vDataList = null;
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		Long rowCount = 0L;
		rowCount = memberService.countBySearch(null, null, address);
		pagerItem.changeRowCount(rowCount);
		vDataList = memberService.pagerBySearch(null, null, address, pagerItem.getPageNum(), pagerItem.getPageSize());
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);

		String toPage = "/WEB-INF/admin/member_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);

	}

	private void deleteDeal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		java.io.PrintWriter out = response.getWriter();
		String vId = request.getParameter("id");
		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);
			Member member = memberService.load(iId);
			if (member == null) {
				out.print("nook");
				return;
			}
			Long result = memberService.delete(iId);
			if (result > 0) {
				out.print("ok");
				return;
			}
		}
		out.print("nook");
	}

	private void detailView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.io.PrintWriter out = response.getWriter();
		String vId = request.getParameter("id");
		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);
			Member bean = memberService.load(iId);
			if(bean != null)
			request.setAttribute("bean", bean);
			
			String toPage = "/WEB-INF/admin/member_detail.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		out.print("<script>");
		out.print("alert('数据不存在');");
		out.print("location.href='Member?oper=list';");
		out.print("<script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
