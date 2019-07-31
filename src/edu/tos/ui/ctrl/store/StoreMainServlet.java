package edu.tos.ui.ctrl.store;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.liuvei.common.SysFun;

import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.util.UIConst;
import edu.tos.util.UploadFileResult;
import edu.tos.util.UploadFileUtil;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/store/Main")
public class StoreMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreService storeService = new StoreServiceImpl();
	private StoreCatService storeCatService = new StoreCatServiceImpl();
	private OrderService orderService = new OrderServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreMainServlet() {
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
		// HttpSession session = request.getSession();
		// ServletContext application = request.getServletContext();
		// ServletConfig config = getServletConfig();
		// PrintWriter out = response.getWriter();

		String oper = request.getParameter("oper");
		if (oper == null) {
			oper = "";
		} else {
			oper = oper.trim().toLowerCase();
		}
		String toPage = "";
		switch (oper) {
		case "detail":
			listView(request, response);
			break;
		case "update":
			updateView(request, response);
			break;
		case "updatedeal":
			updateDeal(request, response);
			break;
		case "order":
			orderView(request, response);
			break;
		case "orderdeal":
			orderDeal(request, response);
			break;
		default:
			toPage = "/WEB-INF/store/storemain.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			break;
		}
	}

	private void orderView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Order> orderIndexList =  orderService.list();

		String toPage = "/WEB-INF/store/order_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void orderDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String toPage = "/WEB-INF/store/order_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void listView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// ServletContext application = request.getServletContext();
		// ServletConfig config = getServletConfig();
		// PrintWriter out = response.getWriter();

		Store bean = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		request.setAttribute("bean", bean);
		String toPage = "/WEB-INF/store/store_detail.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void updateView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		javax.servlet.http.HttpSession session = request.getSession();
		// javax.servlet.ServletContext application = request.getServletContext();
		// javax.servlet.ServletConfig config = getServletConfig();
		// java.io.PrintWriter out = response.getWriter();

		Store loginUser = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		// List<StoreCat> storeCatNameList = storeService.listBySearch(null, null, null,
		// loginUser.getStoreId());
		List<StoreCat> storeCatNameList = storeCatService.list();

		// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
		request.setAttribute("storeName", loginUser.getStoreName());
		request.setAttribute("storeBoss", loginUser.getStoreBoss());
		request.setAttribute("address", loginUser.getAddress());
		request.setAttribute("phone", loginUser.getPhone());
		request.setAttribute("storeId", loginUser.getStoreId());
		// request.setAttribute("StoreCatNameList", storeCatNameList);
		request.setAttribute("storeCatId", loginUser.getStoreCatId());
		request.setAttribute("StoreCatNameList", storeCatNameList);
		request.setAttribute("announce", loginUser.getAnnounce());
		request.setAttribute("picPath", loginUser.getStorePic());

		String toPage = "/WEB-INF/store/store_update.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void updateDeal(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// ServletContext application = request.getServletContext();
		// ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();

		Store loginUser = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);

		UploadFileResult uploadFileResult = UploadFileUtil.uploadFile(request);

		Long storeId = loginUser.getStoreId();
		String storeCatId = (String) request.getAttribute("storeCatId");
		String storeName = (String) request.getAttribute("storeName");
		String storeBoss = (String) request.getAttribute("storeBoss");
		String address = (String) request.getAttribute("address");
		String phone = (String) request.getAttribute("phone");
		String announce = (String) request.getAttribute("announce");

		// 为了在输入页面回显原来的旧值,需要将旧值放到作用域,页面中进行获取
		request.setAttribute("storeName", storeName);
		request.setAttribute("storeBoss", storeBoss);
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
		request.setAttribute("storeCatId", storeCatId);
		request.setAttribute("storeId", storeId);
		request.setAttribute("announce", announce);

		// (1) 服务端验证
		String vMsg = "";
		if (SysFun.isNullOrEmpty(storeName)) {
			vMsg += "店铺名称不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(storeBoss)) {
			vMsg += "经营者不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(address)) {
			vMsg += "店铺地址不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(phone)) {
			vMsg += "联系电话不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}

		Store bean = null;

		if (storeId == null) {
			vMsg = "没有指定主键；";
		} else {
			bean = storeService.load(storeId);
			if (bean == null) {
				vMsg = "数据不存在；";
			}
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}

		bean.setStoreName(storeName);
		bean.setStoreBoss(storeBoss);
		bean.setAddress(address);
		bean.setPhone(Long.parseLong(phone));
		bean.setStoreCatId(Long.parseLong(storeCatId));
		bean.setStoreId(storeId);
		bean.setAnnounce(announce);
		if (uploadFileResult.getCode() == 0) {
			bean.setStorePic(uploadFileResult.getDesc());
		}

		// 设置为当前登录用户的id
		Long result = 0L;
		try {
			result = storeService.update(bean);
		} catch (Exception ex) {
			vMsg = "修改失败." + ex.getMessage();
		}

		if (result > 0) {
			// 如果修改成功，则回到列表页面
			out.println("<script>");
			out.println("alert('修改成功');");
			out.println("location.href='Main?oper=detail';");
			out.println("</script>");
			bean = storeService.load(storeId);
			session.setAttribute(UIConst.BG_LOGINUSER_KEY, bean);
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
