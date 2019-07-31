package edu.tos.ui.ctrl.store;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuvei.common.*;

import edu.tos.service.impl.FoodCatServiceImpl;
import edu.tos.util.UIConst;
import edu.tos.bean.FoodCat;
import edu.tos.bean.Store;
import edu.tos.service.*;

import java.util.*;

/**
 * Servlet implementation class FoodCatServlet
 */
@WebServlet("/store/FoodCat")
public class FoodCatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodCatService FoodCatService = new FoodCatServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FoodCatServlet() {
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

		Store bean = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);

		Long storeId = bean.getStoreId();
		String name = null;
		List<FoodCat> vDataList = null;
		// ------------------------------------------------------------------------
		// 分页步骤1. 创建PagerIter对象, 处理url传过来的pagesize和pageindex
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));

		// 分页步骤2.1. 定义记录数变量
		Long rowCount = 0L;
		// 分页步骤2.2. 根据条件，查找符合条件的所有记录数 ***** count()要根据实际换成其它方法
		rowCount = FoodCatService.countByStoreIdAndName(storeId, name);
		// 分页步骤2.3. 将记录数赋给pagerItem，以便进行分页的各类计算
		pagerItem.changeRowCount(rowCount);
		// 分页步骤2.4. 从数据库取指定分页的数据 ***** pager()要根据实际换成其它方法
		vDataList = FoodCatService.pagerByStoreIdAndName(storeId, name, pagerItem.getPageNum(),
				pagerItem.getPageSize());
		// 分页步骤2.5. 设置页面的跳转url
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
		// 分页步骤3. 将分页对象和数据列表,放到作用域,以便页面可以访问
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);
		// ------------------------------------------------------------------------

		// 转发到页面
		String toPage = "/WEB-INF/store/foodcat_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#listDeal(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void listDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		javax.servlet.http.HttpSession session = request.getSession();
		Store bean = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		Long storeId = bean.getStoreId();
		String name = request.getParameter("catName");
		// 将搜索内容写到作用域，以便页面读取
		request.setAttribute("catName", name);
		List<FoodCat> vDataList = null;
		// ------------------------------------------------------------------------
		// 分页步骤1. 创建PagerIter对象, 处理url传过来的pagesize和pageindex
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));
		// 分页步骤2.1. 定义记录数变量
		Long rowCount = 0L;
		// 分页步骤2.2. 根据条件，查找符合条件的所有记录数 ***** count()要根据实际换成其它方法
		rowCount = FoodCatService.countByStoreIdAndName(storeId, name);
		// 分页步骤2.3. 将记录数赋给pagerItem，以便进行分页的各类计算
		pagerItem.changeRowCount(rowCount);
		// 分页步骤2.4. 从数据库取指定分页的数据 ***** pager()要根据实际换成其它方法
		vDataList = FoodCatService.pagerByStoreIdAndName(storeId, name, pagerItem.getPageNum(),
				pagerItem.getPageSize());
		// 分页步骤2.5. 设置页面的跳转url
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
		// 分页步骤3. 将分页对象和数据列表,放到作用域,以便页面可以访问
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);
		// ------------------------------------------------------------------------
		// 转发到页面
		String toPage = "/WEB-INF/store/foodcat_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#insertView(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void insertView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String toPage = "/WEB-INF/store/foodcat_insert.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);

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
		Store loginUser = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		Long storeId = loginUser.getStoreId();
		String catName = request.getParameter("catName");
		
		// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
		request.setAttribute("catName", catName);
		// 服务端验证
		String vMsg = "";
		if (SysFun.isNullOrEmpty(catName)) {
			vMsg += "类目名称不能为空；";
		}
		// 如果验证失败,则将失败内容放到作用域变量,并转发到页面
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;
		}
		Long result2 = 0L;
		result2 = FoodCatService.countByCatName(catName, storeId);
		System.out.println(result2);
		if (result2 > 0) {
			vMsg += "类目名称已经存在";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;
		}
		FoodCat bean = new FoodCat();

		bean.setCatName(catName);
		bean.setStoreId(storeId); // 设置为当前登录用户的id
		Long result = 0L;
		try {
			result = FoodCatService.insert(bean);
		} catch (Exception ex) {
			vMsg = "添加失败." + ex.getMessage();
		}
		if (result > 0) {
			// 如果添加成功，则回到列表页面
			out.println("<script>");
			out.println("alert('添加成功');");
			out.println("location.href='FoodCat?oper=list';");
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
		// 从response对象里获取out对象——response.getWriter()之前，要先设置页面的编码
		java.io.PrintWriter out = response.getWriter();
		// 取得主键，再根据主键，获取记录
		String vId = request.getParameter("id");
		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);
			FoodCat bean = FoodCatService.load(iId);
			if (bean != null) {
				// 使用对象来回显
				// request.setAttribute("bean", bean);
				// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
				request.setAttribute("catId", bean.getCatId());
				request.setAttribute("catName", bean.getCatName());
				// 数据存在才，转发到页面
				String toPage = "/WEB-INF/store/foodcat_update.jsp";
				request.getRequestDispatcher(toPage).forward(request, response);
				return;
			}
		}
		out.println("<script>");
		out.println("alert('数据不存在.');");
		out.println("location.href='FoodCat?oper=list';");
		out.println("</script>");
	}

	/**
	 * @see HttpServlet#updateDeal(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void updateDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.io.PrintWriter out = response.getWriter();
		javax.servlet.http.HttpSession session = request.getSession();
		Store loginUser = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		Long storeId = loginUser.getStoreId();
		String vId = request.getParameter("catId");
		String catName = request.getParameter("catName");
		System.out.println(catName);
		// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
		request.setAttribute("catId", vId);
		request.setAttribute("catName", catName);
		// (1) 服务端验证
		String vMsg = "";
		if (SysFun.isNullOrEmpty(vId)) {
			vMsg += "类目Id不能为空；";
		}
		// 如果验证失败,则将失败内容放到作用域变量,并转发到页面
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(catName)) {
			vMsg += "类目名称不能为空；";
		}
		// 如果验证失败,则将失败内容放到作用域变量,并转发到页面
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		Long result2 = 0L;
		result2 = FoodCatService.countByCatName(catName, storeId);
		if (result2 > 0) {
			vMsg += "类目名称已经存在";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;
		}

		// (2) 数据库验证
		Long iId = 0L;
		FoodCat bean = null;
		if (SysFun.isNullOrEmpty(vId)) {
			vMsg = "没有指定主键；";
		} else {
			iId = SysFun.parseLong(vId);
			bean = FoodCatService.load(iId);
			if (bean == null) {
				vMsg = "数据不存在；";
			}
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			System.out.println(vMsg);
			updateView(request, response);
			return;
		}

		// (3) 真正处理
		bean.setCatName(catName);
		bean.setStoreId(storeId);
		bean.setCatId(SysFun.parseLong(vId));// 设置为当前登录用户的id
		Long result = 0L;
		try {
			result = FoodCatService.update(bean);
		} catch (Exception ex) {
			vMsg = "修改失败." + ex.getMessage();
		}
		if (result > 0) {
			// 如果修改成功，则回到列表页面
			out.println("<script>");
			out.println("alert('修改成功');");
			out.println("location.href='FoodCat?oper=list';");
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
		// 从response对象里获取out对象——response.getWriter()之前，要先设置页面的编码
		java.io.PrintWriter out = response.getWriter();
		// 取得主键，再根据主键，获取记录
		String vId = request.getParameter("id");
		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);
			FoodCat bean = FoodCatService.load(iId);
			if (bean != null) {
				// 使用对象来回显
				request.setAttribute("bean", bean);
				// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
				// request.setAttribute("catId", bean.getCatId());
				// request.setAttribute("catName", bean.getCatName());
				// 数据存在才，转发到页面
				String toPage = "/WEB-INF/store/foodcat_detail.jsp";
				request.getRequestDispatcher(toPage).forward(request, response);
				return;
			}
		}
		out.println("<script>");
		out.println("alert('数据不存在.');");
		out.println("location.href='FoodCat?oper=list';");
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
			Long result = FoodCatService.delete(iId);
			if (result > 0) {
				out.print("ok");// 不要使用println()
				return;
			}
		}
		out.println("nook");

	}

}
