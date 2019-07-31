package edu.tos.ui.ctrl.store;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.liuvei.common.SysFun;

import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.util.*;
import sun.misc.Perf.GetPerfAction;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/store/StoreAnnounce")
public class AnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StoreService storeService = new StoreServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnnounceServlet() {
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
		case "list":
		listView(request, response);
		    break;
		case "update":
			updateView(request, response);
			break;
		case "updatedeal":
			updateDeal(request, response);
			break;
		default:
			listView(request, response);
			break;
		}
	}

	private void listView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();

		Store store = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		
		Long id = store.getStoreId();
		
		String announce = store.getAnnounce();
		
		request.setAttribute("id", id);
		request.setAttribute("announce", announce);
		
		String toPage = "/WEB-INF/store/announce_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void updateView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		
		Store store = null;
		
		store = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		
		Long storeId = store.getStoreId();
		String announce = store.getAnnounce();
		
		request.setAttribute("announce", announce);
		request.setAttribute("storeId", storeId);
		
		String toPage = "/WEB-INF/store/announce_update.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void updateDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String storeId = request.getParameter("storeId");
		String announce = request.getParameter("announce");

		request.setAttribute("storeId", storeId);
		request.setAttribute("announce", announce);

		String vMsg = "";
		if (SysFun.isNullOrEmpty(announce)) {
			vMsg += "公告内容不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}

		Store bean = null;

		Long vId = SysFun.parseLong(storeId);
		if (storeId == null) {
			vMsg = "没有指定主键；";
		} else {
			bean = storeService.load(vId);
			if (bean == null) {
				vMsg = "数据不存在；";
			}
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}

		bean.setStoreId(vId);
		bean.setAnnounce(announce);

		Long result = 0L;
		try {
			result = storeService.update(bean);
		} catch (Exception ex) {
			vMsg = "添加失败." + ex.getMessage();
		}

		if (result > 0) {
			// 如果修改成功，则回到列表页面
			session.setAttribute(UIConst.BG_LOGINUSER_KEY, bean);
			out.println("<script>");
			out.println("alert('修改成功');");
			out.println("location.href='Announce';");
			out.println("</script>");
			return;
		} else {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
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

}
