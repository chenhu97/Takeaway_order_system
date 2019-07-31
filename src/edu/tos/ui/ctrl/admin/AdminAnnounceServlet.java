package edu.tos.ui.ctrl.admin;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.liuvei.common.*;

import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.util.UIConst;
import edu.tos.util.UploadFileResult;
import edu.tos.util.UploadFileUtil;

/**
 * Servlet implementation class AnnounceServlet
 */
@WebServlet("/admin/Announce")
public class AdminAnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnnounceService announceService = new AnnounceServiceImpl();

	private Admin getAdmin(HttpServletRequest request) {
		javax.servlet.http.HttpSession session = request.getSession();
		Admin bean = null;
		bean = (Admin) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		return bean;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAnnounceServlet() {
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
		case "list":
			listView(request, response);
			break;
		case "listdeal":
			listDeal(request, response);
			break;
		case "insert":
			insertView(request, response);
			break;
		case "insertdeal":
			insertDeal(request, response);
			break;
		case "update":
			updateView(request, response);
			break;
		case "updatedeal":
			updateDeal(request, response);
			break;
		case "deletedeal":
			deleteDeal(request, response);
			break;
		case "detail":
			detailView(request, response);
			break;
		default:
			System.out.println("oper不存在");
			break;
		}

	}

	protected void listView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Admin bean = (Admin) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		// Long adminId = bean.getUserId();

		Admin bean = (Admin) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		Long adminId = bean.getAdminId();

		List<Announce> vDataList = null;

		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));

		Long rowCount = 0L;
		rowCount = announceService.countBySearch(adminId, null, null);

		pagerItem.changeRowCount(rowCount);

		vDataList = announceService.pagerBySearch(adminId, null, null, pagerItem.getPageNum(), pagerItem.getPageSize());

		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));

		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);

		String toPage = "/WEB-INF/admin/announce_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	protected void listDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Announce bean = (Announce) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		// Long announceId = bean.getAnnounceId();

		Admin bean = (Admin) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		Long adminId = bean.getAdminId();
		String title = request.getParameter("search");

		String content = null;

		request.setAttribute("search", title);
		List<Announce> vDataList = null;
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));
		Long rowCount = 0L;
		rowCount = announceService.countBySearch(adminId, content, title);
		pagerItem.changeRowCount(rowCount);
		vDataList = announceService.pagerBySearch(adminId, title, content, pagerItem.getPageNum(),
				pagerItem.getPageSize());
		// pagerItem.getPageNum(), pagerItem.getPageSize());
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);
		String toPage = "/WEB-INF/admin/announce_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	protected void insertView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String toPage = "/WEB-INF/admin/announce_insert.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	protected void insertDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		// Admin loginUser = (Admin) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		// Long adminId = loginUser.getUserId();

		Admin admin = (Admin) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		Long adminId = admin.getAdminId();

		UploadFileResult uploadFileResult = UploadFileUtil.uploadFile(request);

		String title = (String) request.getAttribute("title");
		String content = (String) request.getAttribute("content");

		// String picPath = (String) request.getAttribute("picPath");

		request.setAttribute("content", content);

		String vMsg = "";
		if (SysFun.isNullOrEmpty(title)) {
			vMsg += "标题不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(content)) {
			vMsg += "内容不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;
		}

		Announce bean = new Announce();
		bean.setAdminId(adminId);
		bean.setContent(content);
		bean.setTitle(title);
		if (uploadFileResult.getCode() == 0) {
			bean.setPicPath(uploadFileResult.getDesc());
		}

		Long result = 0L;
		try {
			result = announceService.insert(bean);
		} catch (Exception ex) {
			vMsg = "添加失败,原因如下:" + ex.getMessage();
		}
		if (result > 0) { //
			// 如果添加成功，则回到列表页面
			out.println("<script>");
			out.println("alert('添加成功');");
			out.println("location.href='Announce?oper=list';");
			out.println("</script>");
		} else {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
		}

	}

	protected void updateView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 取得主键，再根据主键，获取记录
		String vId = request.getParameter("id");

		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);

			Announce bean = announceService.load(iId);
			if (bean != null) {
				if (bean.getAdminId() != getAdmin(request).getAdminId()) {
					out.print("<script>");
					out.print("alert('请及时停止不恰当的操作!');");
					out.print("location.href='Announce?oper=list';");
					out.print("</script>");
					return;
				}

				// 使用对象来回显
				request.setAttribute("bean", bean);

				// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进 行获取
				request.setAttribute("announceId", bean.getAnnounceId());
				System.out.println("在updateViews时候announceId的值" + bean.getAnnounceId());
				// 数据存在才，转发到页面

				String toPage = "/WEB-INF/admin/announce_update.jsp";
				request.getRequestDispatcher(toPage).forward(request, response);
				return;
			}
		}
		out.println("<script>");
		out.println("alert('数据不存在!');");
		out.println("location.href='Announce?oper=list';");
		out.println("</script>");
	}

	protected void updateDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		UploadFileResult uploadFileResult = UploadFileUtil.uploadFile(request);

		String vId = (String) request.getAttribute("announceId");
		System.out.println("在updateDeal时候announceId的值" + vId);
		Long adminId = getAdmin(request).getAdminId();
		String title = (String) request.getAttribute("title");
		String content = (String) request.getAttribute("content");

		// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
		request.setAttribute("announceId", vId);

		request.setAttribute("content", content);
		// (1) 服务端验证
		String vMsg = "";
		if (SysFun.isNullOrEmpty(vId)) {
			vMsg += "公告编号不能为空；";
		}
		// System.out.println("提示信息为:" + vMsg);
		// 如果验证失败,则将失败内容放到作用域变量,并转发到页面
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(title)) {
			vMsg += "标题不能为空；";
		}
		// 如果验证失败,则将失败内容放到作用域变量,并转发到页面
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(content)) {
			vMsg += "内容不能为空；";
		}
		// 如果验证失败,则将失败内容放到作用域变量,并转发到页面
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		Long iId = 0L;
		Announce bean = null;
		if (SysFun.isNullOrEmpty(vId)) {
			vMsg = "没有指定主键；";
		} else {
			iId = SysFun.parseLong(vId);
			bean = announceService.load(iId);
			if (bean == null) {
				vMsg = "数据不存在；";
				return;
			}
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}

		bean.setTitle(title);
		bean.setAdminId(adminId);

		bean.setContent(content);
		if (uploadFileResult.getCode() == 0) {
			bean.setPicPath(uploadFileResult.getDesc());
		}

		Long result = 0L;
		try {
			result = announceService.update(bean);
		} catch (Exception ex) {
			vMsg = "修改失败." + ex.getMessage();
		}

		if (result > 0) {
			// 如果修改成功，则回到列表页面
			out.println("<script>");
			out.println("alert('修改成功');");
			out.println("location.href='Announce?oper=list';");
			out.println("</script>");
		} else {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
		}
	}

	protected void detailView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.io.PrintWriter out = response.getWriter();
		// 取得主键，再根据主键，获取记录
		String vId = request.getParameter("id");
		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);
			Announce bean = announceService.load(iId);
			if (bean != null) {
				if (bean.getAdminId() != getAdmin(request).getAdminId()) {
					out.print("<script>");
					out.print("alert('无法查看非当前用户的公告详情!');");
					out.print("location.href='Announce?oper=list';");
					out.print("</script>");
					return;
				}

				// 使用对象来回显
				request.setAttribute("bean", bean);
				// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进 行获取
				request.setAttribute("announceId", bean.getAnnounceId());
				request.setAttribute("picPath", bean.getPicPath());
				request.setAttribute("title", bean.getTitle());
				request.setAttribute("content", bean.getContent());
				request.setAttribute("createOn", bean.getCreateOn());
				request.setAttribute("updateOn", bean.getUpdateOn());
			}else {
				out.println("<script>");
				out.println("alert('数据不存在.');");
				out.println("location.href='Announce?oper=list';");
				out.println("</script>");
				return;
			}
			// 数据存在才，转发到页面
			String toPage = "/WEB-INF/admin/announce_detail.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		out.println("<script>");
		out.println("alert('数据不存在.');");
		out.println("location.href='Announce?oper=list';");
		out.println("</script>");
	}

	protected void deleteDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 取得主键，再根据主键，获取记录
		String vId = request.getParameter("id");
		Announce bean = null;
		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);
			bean = announceService.load(iId);
			if (bean == null) {
				out.print("nook");
				return;
			}
			Long result = announceService.delete(iId);
			if (result > 0) {
				out.print("ok");
				return;
			}
		}
		out.print("nook");

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
