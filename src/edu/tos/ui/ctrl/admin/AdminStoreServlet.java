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

import edu.tos.bean.Store;
import edu.tos.bean.StoreCat;
import edu.tos.service.StoreCatService;
import edu.tos.service.StoreService;
import edu.tos.service.impl.StoreCatServiceImpl;
import edu.tos.service.impl.StoreServiceImpl;
import edu.tos.util.UploadFileResult;
import edu.tos.util.UploadFileUtil;

/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/admin/Store")
public class AdminStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreService storeService = new StoreServiceImpl();
	private StoreCatService storeCatService = new StoreCatServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminStoreServlet() {
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
		String oper = (String) request.getParameter("oper");
		System.out.println(oper);
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
//		 case "update":
//		 updateView(request, response); // 修改页面
//		 break;
//		 case "updatedeal":
//		 updateDeal(request, response); // 修改处理
//		 break;
		case "deletedeal":
			deleteDeal(request, response); // 删除处理
			break;
		case "detail":
			detailView(request, response); // 查看页面
			break;
		case "checklist":
			checkView(request, response); // 店铺审核
			break;
		case "checkdeal":
			checkDeal(request, response); // 店铺审核
			break;
		default:
			listView(request, response); // 列表页面 : 默认
			System.out.println("oper不存在1。");
			break;
		}
	}

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

		List<Store> vDataList = null;
		// ------------------------------------------------------------------------
		// 分页步骤1. 创建PagerIter对象, 处理url传过来的pagesize和pageindex
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));
		String name = null;
		// 分页步骤2.1. 定义记录数变量
		Long rowCount = 0L;
		// 分页步骤2.2. 根据条件，查找符合条件的所有记录数 ***** count()要根据实际换成其它方法
		rowCount = storeService.countBySearch(null, null, null, 1L);

		System.out.println(rowCount);
		// 分页步骤2.3. 将记录数赋给pagerItem，以便进行分页的各类计算
		pagerItem.changeRowCount(rowCount);
		// 分页步骤2.4. 从数据库取指定分页的数据 ***** pager()要根据实际换成其它方法
		vDataList = storeService.pager(1L, pagerItem.getPageNum(), pagerItem.getPageSize());

		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
		// 分页步骤3. 将分页对象和数据列表,放到作用域,以便页面可以访问

		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);
		// ------------------------------------------------------------------------

		// 转发到页面
		String toPage = "/WEB-INF/admin/store_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#listDeal(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void listDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String search = request.getParameter("search");

		System.out.println(search);

		// 将搜索内容写到作用域，以便页面读取

		request.setAttribute("search", search);

		List<Store> vDataList = null;
		// ------------------------------------------------------------------------
		// 分页步骤1. 创建PagerIter对象, 处理url传过来的pagesize和pageindex
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));

		// 分页步骤2.1. 定义记录数变量
		Long rowCount = 0L;
		// 分页步骤2.2. 根据条件，查找符合条件的所有记录数 ***** count()要根据实际换成其它方法
		rowCount = storeService.countBySearch(search, null, null, 1L);
		System.out.println(rowCount + "查询得到的条数");
		// 分页步骤2.3. 将记录数赋给pagerItem，以便进行分页的各类计算
		pagerItem.changeRowCount(rowCount);
		// 分页步骤2.4. 从数据库取指定分页的数据 ***** pager()要根据实际换成其它方法
		vDataList = storeService.pagerBySearch(search, 1L, null, null, pagerItem.getPageNum(),
				pagerItem.getPageSize());
		// vDataList=storeService.pagerByName(storeName, pagerItem.getPageNum(),
		// pagerItem.getPageSize());
		// 分页步骤2.5. 设置页面的跳转url
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
		// 分页步骤3. 将分页对象和数据列表,放到作用域,以便页面可以访问
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);
		// ------------------------------------------------------------------------
		// 转发到页面
		String toPage = "/WEB-INF/admin/store_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#insertView(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void insertView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<StoreCat> DataList = storeCatService.list();
		request.setAttribute("DataList", DataList);
		String toPage = "/WEB-INF/store/storeregist.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);

	}

	/**
	 * @see HttpServlet#insertDeal(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void insertDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.io.PrintWriter out = response.getWriter();
		javax.servlet.http.HttpSession session = request.getSession();

		List<StoreCat> DataList = storeCatService.list();
		request.setAttribute("DataList", DataList);
		UploadFileResult uploadFileResult = UploadFileUtil.uploadFile(request);
		String storeName = (String) request.getAttribute("storeName");
		String phone = (String) request.getAttribute("phone");
		// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
		// String status = (String)request.getAttribute("status");
		String address = (String) request.getAttribute("address");
		String storeCatId = (String) request.getAttribute("storeCatId");

		System.out.println(storeCatId + "123");
		String storeBoss = (String) request.getAttribute("storeBoss");
		String storeLogName = (String) request.getAttribute("storeLogName");
		String storePass = (String) request.getAttribute("storePass");
		String storePass2 = (String) request.getAttribute("storePass2");

		request.setAttribute("storeName", storeName);
		// 服务端验证
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
		// request.setAttribute("status", status);
		request.setAttribute("storeCatId", storeCatId);
		request.setAttribute("storePass", storePass);
		request.setAttribute("storePass2", storePass2);

		request.setAttribute("storeBoss", storeBoss);
		request.setAttribute("storeLogName", storeLogName);
		request.setAttribute("storePass", storePass);

		String msg = "";
		String toPage = "/WEB-INF/store/storeregist.jsp";
		if (SysFun.isNullOrEmpty(storeLogName)) {
			msg = "登入账号不能为空。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		Long result2 = storeService.searchByLogName(storeLogName);
		System.out.println(result2);
		if (result2 > 0) {
			msg = "账号已经存在。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(storePass)) {
			msg = "登入密码不能为空。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (storePass.length() < 6) {
			msg = "密码长度至少为6。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(storePass2)) {
			msg = "确认登入密码不能为空。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (!storePass.equals(storePass2)) {

			msg = "两次密码不一致，请重新输入";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);

			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(storeName)) {
			msg = "店名不能为空。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		Long result1 = storeService.searchByName(storeName);
		if (result1 > 0) {
			msg = "店名已经被占用。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(address)) {
			msg = "地址不能为空。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(phone)) {
			msg = "联系方式不能为空。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}

		if (SysFun.isNullOrEmpty(storeBoss)) {
			msg = "经营者不能为空。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(storeCatId)) {
			msg = "店铺类别不能为空。";
		}
		if (!SysFun.isNullOrEmpty(msg)) {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}

		Store bean = new Store();
		bean.setStoreName(storeName);
		bean.setPhone(SysFun.parseLong(phone));
		bean.setAddress(address);
		bean.setCreateOn(new java.util.Date());
		bean.setStatus(0L);
		bean.setStoreCatId(SysFun.parseLong(storeCatId));
		bean.setStoreBoss(storeBoss);
		bean.setStoreLogName(storeLogName);
		bean.setStorePass(storePass);
		bean.setAnnounce(null);
		if (uploadFileResult.getCode() == 0) {
			bean.setStorePic(uploadFileResult.getDesc());
		}
		// 设置为当前登录用户的id
		Long result = 0L;
		try {
			result = storeService.insert(bean);
		} catch (Exception ex) {

		}
		if (result > 0) {
			// 如果添加成功，则转到店家登入页面
			out.println("<script>");
			out.println("alert('添加成功');");
			out.println("location.href='/Tos/store/StoreLogin';");
			out.println("</script>");
		} else {

			insertView(request, response);
		}
	}

	/**
	 * @see HttpServlet#updateView(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// protected void updateView(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// // 从response对象里获取out对象——response.getWriter()之前，要先设置页面的编码
	// java.io.PrintWriter out = response.getWriter();
	// // 取得主键，再根据主键，获取记录
	// String vId = request.getParameter("id");
	// if (!SysFun.isNullOrEmpty(vId)) {
	// Long iId = SysFun.parseLong(vId);
	// ArticleCat bean = articleCatService.load(iId);
	// if (bean != null) {
	// // 使用对象来回显
	// // request.setAttribute("bean", bean);
	// // 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
	// request.setAttribute("catId", bean.getCatId());
	// request.setAttribute("catName", bean.getCatName());
	// // 数据存在才，转发到页面
	// String toPage = "/WEB-INF/member/ArticleCat_update.jsp";
	// request.getRequestDispatcher(toPage).forward(request, response);
	// return;
	// }
	// }
	// out.println("<script>");
	// out.println("alert('数据不存在.');");
	// out.println("location.href='ArticleCat?oper=list';");
	// out.println("</script>");
	// }
	//
	// /**
	// * @see HttpServlet#updateDeal(HttpServletRequest request, HttpServletResponse
	// * response)
	// */
	// protected void updateDeal(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// java.io.PrintWriter out = response.getWriter();
	// javax.servlet.http.HttpSession session = request.getSession();
	// Member loginUser = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
	// Long memberId = loginUser.getUserId();
	// String vId = request.getParameter("catId");
	// String catName = request.getParameter("catName");
	// // 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
	// request.setAttribute("catId", vId);
	// request.setAttribute("catName", catName);
	// // (1) 服务端验证
	// String vMsg = "";
	// if (SysFun.isNullOrEmpty(vId)) {
	// vMsg += "类目Id不能为空；";
	// }
	// // 如果验证失败,则将失败内容放到作用域变量,并转发到页面
	// if (!SysFun.isNullOrEmpty(vMsg)) {
	// request.setAttribute("msg", vMsg);
	// insertView(request, response);
	// return;
	// }
	// if (SysFun.isNullOrEmpty(catName)) {
	// vMsg += "类目名称不能为空；";
	// }
	// // 如果验证失败,则将失败内容放到作用域变量,并转发到页面
	// if (!SysFun.isNullOrEmpty(vMsg)) {
	// request.setAttribute("msg", vMsg);
	// updateView(request, response);
	// return;
	// }
	//
	// // (2) 数据库验证
	// Long iId = 0L;
	// ArticleCat bean = null;
	// if (SysFun.isNullOrEmpty(vId)) {
	// vMsg = "没有指定主键；";
	// } else {
	// iId = SysFun.parseLong(vId);
	// bean = articleCatService.load(iId);
	// if (bean == null) {
	// vMsg = "数据不存在；";
	// }
	// }
	// if (!SysFun.isNullOrEmpty(vMsg)) {
	// request.setAttribute("msg", vMsg);
	// System.out.println(vMsg);
	// updateView(request, response);
	// return;
	// }
	//
	// // (3) 真正处理
	// bean.setCatName(catName);
	// bean.setMemberId(memberId); // 设置为当前登录用户的id
	// Long result = 0L;
	// try {
	// result = articleCatService.update(bean);
	// } catch (Exception ex) {
	// vMsg = "修改失败." + ex.getMessage();
	// }
	// if (result > 0) {
	// // 如果修改成功，则回到列表页面
	// out.println("<script>");
	// out.println("alert('修改成功');");
	// out.println("location.href='ArticleCat?oper=list';");
	// out.println("</script>");
	// } else {
	// request.setAttribute("msg", vMsg);
	// updateView(request, response);
	// }
	//
	// }
	//
	// /**
	// * @see HttpServlet#detailView(HttpServletRequest request, HttpServletResponse
	// * response)
	// */
	protected void detailView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从response对象里获取out对象——response.getWriter()之前，要先设置页面的编码
		java.io.PrintWriter out = response.getWriter();
		// 取得主键，再根据主键，获取记录
		String vId = request.getParameter("id");
		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);
			Store bean = storeService.load(iId);
			if (bean != null) {
				// 使用对象来回显
				request.setAttribute("bean", bean);
				// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
				// request.setAttribute("catId", bean.getCatId());
				// request.setAttribute("catName", bean.getCatName());
				// 数据存在才，转发到页面
				String toPage = "/WEB-INF/admin/store_detail.jsp";
				request.getRequestDispatcher(toPage).forward(request, response);
				return;
			}
		}
		out.println("<script>");
		out.println("alert('数据不存在.');");
		out.println("location.href='Store?oper=list';");
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
			Long result = storeService.delete(iId);
			if (result > 0) {
				out.print("ok");// 不要使用println()
				return;
			}
		}
		out.println("nook");

	}

	/**
	 * @see HttpServlet#deleteDeal(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void checkDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 从response对象里获取out对象——response.getWriter()之前，要先设置页面的编码
		java.io.PrintWriter out = response.getWriter();
		// 取得主键，再根据主键，获取记录
		String vId = request.getParameter("id");
		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);
			Store bean = storeService.load(iId);
			bean.setStatus(1L);
			Long result = storeService.update(bean);
			if (result > 0) {
				out.println("<script>");
				out.println("alert('审核成功');");
				out.println("location.href='Store?oper=list';");
				out.println("</script>");
				return;
			} else {
				out.println("<script>");
				out.println("alert('审核失败');");
				out.println("location.href='Store?oper=list';");
				out.println("</script>");
				checkView(request, response);
			}
		}
	}

	protected void checkView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Store> vDataList = null;
		// ------------------------------------------------------------------------
		// 分页步骤1. 创建PagerIter对象, 处理url传过来的pagesize和pageindex
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));
		String search = request.getParameter("search");
		if (SysFun.isNullOrEmpty(search)) {
			// 分页步骤2.1. 定义记录数变量
			Long rowCount = 0L;
			// 分页步骤2.2. 根据条件，查找符合条件的所有记录数 ***** count()要根据实际换成其它方法
			rowCount = storeService.countBySearch(null, null, null, 0L);
			// 分页步骤2.3. 将记录数赋给pagerItem，以便进行分页的各类计算
			pagerItem.changeRowCount(rowCount);
			// 分页步骤2.4. 从数据库取指定分页的数据 ***** pager()要根据实际换成其它方法

			vDataList = storeService.pager(0L, pagerItem.getPageNum(), pagerItem.getPageSize());

			pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
			// 分页步骤3. 将分页对象和数据列表,放到作用域,以便页面可以访问
			request.setAttribute("pagerItem", pagerItem);
			request.setAttribute("DataList", vDataList);
			// ------------------------------------------------------------------------

			// 转发到页面
			String toPage = "/WEB-INF/admin/store_check.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
		} else {
			// 将搜索内容写到作用域，以便页面读取

			request.setAttribute("search", search);
			// ------------------------------------------------------------------------
			// 分页步骤2.1. 定义记录数变量
			Long rowCount = 0L;
			// 分页步骤2.2. 根据条件，查找符合条件的所有记录数 ***** count()要根据实际换成其它方法
			rowCount = storeService.countBySearch(search, null, null, 0L);
			System.out.println(rowCount + "查询得到的条数");
			// 分页步骤2.3. 将记录数赋给pagerItem，以便进行分页的各类计算
			pagerItem.changeRowCount(rowCount);
			// 分页步骤2.4. 从数据库取指定分页的数据 ***** pager()要根据实际换成其它方法
			vDataList = storeService.pagerBySearch(search, 0L, null, null, pagerItem.getPageNum(),
					pagerItem.getPageSize());
			// vDataList=storeService.pagerByName(storeName, pagerItem.getPageNum(),
			// pagerItem.getPageSize());
			// 分页步骤2.5. 设置页面的跳转url
			pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
			// 分页步骤3. 将分页对象和数据列表,放到作用域,以便页面可以访问
			request.setAttribute("pagerItem", pagerItem);
			request.setAttribute("DataList", vDataList);
			// ------------------------------------------------------------------------
			// 转发到页面
			String toPage = "/WEB-INF/admin/store_check.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
		}

	}
}
