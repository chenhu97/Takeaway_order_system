package edu.tos.ui.ctrl.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuvei.common.*;
import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.ui.ctrl.*;
import edu.tos.util.*;

import java.util.*;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
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
		/* **************************************************************** */
		/* ********** Servlet的doXXX方法中的编码方式和6个标准对象 ********** */
		/* **************************************************************** */
		// ***** Servlet的doXXX方法中的编码方式
		// 设置请求对象的编码方式
		request.setCharacterEncoding("utf-8");
		// 设置响应对象的编码方式
		response.setCharacterEncoding("utf-8");
		// 设置响应的内容类型为text/html
		response.setContentType("text/html; charset=utf-8");

		// ***** Servlet的doxxx方法中的6个标准对象（含request和response）

		// 从request里获取session对象和application对象
		javax.servlet.http.HttpSession session = request.getSession();
		javax.servlet.ServletContext application = request.getServletContext(); 
		// 调用继承的方法来获取config对象
		javax.servlet.ServletConfig config = getServletConfig();
		// 从response对象里获取out对象——response.getWriter()之前，要先设置页面的编码

		java.io.PrintWriter out = response.getWriter();

		/* ----------------------------------------------------------------- */
		// 取得操作类型
		String oper = request.getParameter("oper");
		if (oper == null) {
			oper = "";
		} else {
			oper = oper.trim().toLowerCase();
		}
		// 根据不同的操作类型,调用不同的处理方法
		switch (oper) {
		case "list":
			listView(request, response); // 列表页面
			break;
		case "listdeal":
			listDeal(request, response); // 列表处理
			break;
		case "insert":
			insertView(request, response); // 添加页面
			break;
		case "insertdeal":
			insertDeal(request, response); // 添加处理
			break;
		case "update":
			updateView(request, response); // 修改页面
			break;
		case "updatedeal":
			updateDeal(request, response); // 修改处理
			break;
		case "deletedeal":
			deleteDeal(request, response); // 删除处理
			break;
		case "detail":
			detailView(request, response); // 查看页面
			break;
		default:
			// listView(request, response); // 列表页面 : 默认
			System.out.println("oper不存在。");
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

	/**
	 * @see HttpServlet#listView(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void listView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		javax.servlet.http.HttpSession session = request.getSession();
		Admin bean = (Admin) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		Long adminId = bean.getAdminId();
		List<Admin> vDataList = null;
		// ------------------------------------------------------------------------
		// 分页步骤1. 创建PagerIter对象, 处理url传过来的pagesize和pageindex
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));

		//分页步骤2.1根据条件，查找符合条件的所有记录******count（）要根据实际情况换成其他方法
		Long rowCount = adminService.count();
		//分页步骤2.2将记录数据给pagerItem，以便于进行分页的各类计算
		pagerItem.changeRowCount(rowCount);
		//分页步骤2.3从数据库中获取指定分页数据*****pager（）要根据实际情况换成其它方法
		vDataList = adminService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		//分页步骤2.4设置页面的跳转url
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
		// 分页步骤3. 将分页对象和数据列表,放到作用域,以便页面可以访问
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);
		// ------------------------------------------------------------------------

		// 转发到页面
		String toPage = "/WEB-INF/admin/admin_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	/**	
	 * @see HttpServlet#listDeal(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void listDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			javax.servlet.http.HttpSession session = request.getSession();
		
			Admin bean = (Admin) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
			Long adminId = bean.getAdminId();
			//获取搜索参数
			String searchName = request.getParameter("searchName");
			searchName = searchName == null? "": searchName;//为null,则赋值为""
			// 分页步骤1. 创建PagerIter对象, 处理url传过来的pagesize和pageindex
			PagerItem pagerItem = new PagerItem();
			pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
			pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));

			List<Admin> vDataList = null;
			// ------------------------------------------------------------------------
		
			//分页步骤2.1.条件，查找符合条件的所有记录数*****count()要根据实际换成其他方法
			Long rowCount = adminService.countByName(searchName);
			//分页步骤2.2将记录数据pagerItem,以便于进行分页的各类计算
			pagerItem.changeRowCount(rowCount);
			//分页步骤2.3从数据库中获取指定分页数据*****pager（）要根据实际情况换成其它方法
			vDataList = adminService.pagerByName(searchName,pagerItem.getPageNum(), pagerItem.getPageSize());
			//分页步骤2.4设置页面的跳转url
			pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
			//分页步骤3将分页对象和数据列表放在作用域,以便于页面可以访问
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);
		// 转发到页面
		String toPage = "/WEB-INF/admin/admin_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#insertView(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void insertView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String toPage = "/WEB-INF/admin/admin_insert.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#insertDeal(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void insertDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从response对象里获取out对象——response.getWriter()之前，要先设置页面的编码
		java.io.PrintWriter out = response.getWriter();
		javax.servlet.http.HttpSession session = request.getSession();
		
		//1 获取请求数据
		String adminName = request.getParameter("adminName");
		String adminPass = request.getParameter("adminPass");
		String adminSex = request.getParameter("adminSex");
		String phone = request.getParameter("phone");
	
		// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
		
		request.setAttribute("adminName", adminName);
		request.setAttribute("adminPass",adminPass);
		request.setAttribute("adminSex", adminSex);
		request.setAttribute("phone", phone);
		// 服务端验证
		String vMsg = "";
		if (SysFun.isNullOrEmpty(adminName)) {
			vMsg += "管理员名称不能为空!";
		}
		if (SysFun.isNullOrEmpty(adminPass)) {
			vMsg += "管理员密码不能为空!";
		}
		if (SysFun.isNullOrEmpty(adminSex)) {
			vMsg += "管理员性别不能为空!";
		}
		if (SysFun.isNullOrEmpty(phone)) {
			vMsg += "联系方式不能为空!";
		}
		
		
		// 如果验证失败,则将失败内容放到作用域变量,并转发到页面
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;
		}
		Admin bean = new Admin();
		bean.setAdminName(adminName);
		bean.setAdminPass(adminPass);
		bean.setAdminSex(adminSex);
		bean.setPhone(SysFun.parseLong(phone));
		
		Long result = 0L;
		try {
			result = adminService.insert(bean);
		} catch (Exception ex) {
			vMsg = "添加失败." + ex.getMessage();
		}
		if (result > 0) {
			// 如果添加成功，则回到列表页面
			out.println("<script>");
			out.println("alert('添加成功');");
			out.println("location.href='Admin?oper=list';");
			out.println("</script>");
		} else {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
		}
	}

	/**
	 * @see HttpServlet#updateView(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void updateView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				String toPage = "/WEB-INF/admin/admin_update.jsp";
				request.getRequestDispatcher(toPage).forward(request, response);
				return;
	}

	/**
	 * @see HttpServlet#updateDeal(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void updateDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.io.PrintWriter out = response.getWriter();
		javax.servlet.http.HttpSession session = request.getSession();
		Admin bean = (Admin) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		Long adminId = bean.getAdminId();
		
		String adminPass1 = request.getParameter("adminPass1");
		String adminPass2 = request.getParameter("adminPass2");
		
		
		// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
		
		request.setAttribute("adminPass1", adminPass1);
		request.setAttribute("adminPass2", adminPass2);
		// (1) 服务端验证
		String vMsg = "";
		String vMsg2 = "";
		if (SysFun.isNullOrEmpty(adminPass1)) {
			vMsg += "旧密码不能为空!";
		}
		// 如果验证失败,则将失败内容放到作用域变量,并转发到页面
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(adminPass2)) {
			vMsg2 += "新密码不能为空!";
		}
		
		// 如果验证失败,则将失败内容放到作用域变量,并转发到页面
		if (!SysFun.isNullOrEmpty(vMsg2)) {
			request.setAttribute("msg2", vMsg2);
			updateView(request, response);
			return;
		}

		// (2) 数据库验证
		Long iId = 0L;
		Admin bean1 = null;
		bean1 = adminService.load(adminId);
		if (!bean1.getAdminPass().equals(adminPass1)) {
			vMsg = "旧密码错误!请重新输入！";
		}
		
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			System.out.println(vMsg);
			updateView(request, response);
			return;
		}

		// (3) 真正处理
		
		bean.setAdminPass(adminPass2);
		
		
		Long result = 0L;
		try {
			result = adminService.update(bean);
		} catch (Exception ex) {
			vMsg = "修改失败." + ex.getMessage();
		}
		if (result > 0) {
			// 如果修改成功，则回到列表页面
			out.println("<script>");
			out.println("alert('修改成功');");
			out.println("location.href='Admin?oper=list';");
			out.println("</script>");
		} else {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
		}

	}

	/**
	 * @see HttpServlet#detailView(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void detailView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		javax.servlet.http.HttpSession session = request.getSession();
		Admin loginUser = (Admin) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		// 从response对象里获取out对象——response.getWriter()之前，要先设置页面的编码
		java.io.PrintWriter out = response.getWriter();
		// 取得主键，再根据主键，获取记录
		String vId = request.getParameter("id");
		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);
			Admin bean = adminService.load(iId);
			if (bean != null) {
				// 使用对象来回显
				request.setAttribute("bean", bean);
				// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
				// request.setAttribute("catId", bean.getCatId());
				// request.setAttribute("catName", bean.getCatName());
				// 数据存在才，转发到页面
				String toPage = "/WEB-INF/member/Admin_detail.jsp";
				request.getRequestDispatcher(toPage).forward(request, response);
				return;
			}
		}
		out.println("<script>");
		out.println("alert('数据不存在.');");
		out.println("location.href='Admin?oper=list';");
		out.println("</script>");
	}

	/**
	 * @see HttpServlet#deleteDeal(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void deleteDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从response对象里获取out对象——response.getWriter()之前，要先设置页面的编码
		java.io.PrintWriter out = response.getWriter();
		// 取得主键，再根据主键，获取记录
		String vId = request.getParameter("id");
		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);
			Long result = adminService.delete(iId);
			if (result > 0) {
				out.print("ok");// 不要使用println()
				return;
			}
		}
		out.println("nook");

	}

}
