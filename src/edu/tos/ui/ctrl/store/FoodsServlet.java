package edu.tos.ui.ctrl.store;

import java.io.*;
import java.util.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.liuvei.common.PagerItem;
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
@WebServlet("/store/Foods")
public class FoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FoodsService foodsService = new FoodsServiceImpl();
	private FoodCatService foodCatService = new FoodCatServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FoodsServlet() {
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
		case "delete":
			deleteDeal(request, response);
			break;
		default:
			toPage = "/WEB-INF/store/foods_list.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			break;
		}
	}

	private void listView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		Store store = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		Long storeId = store.getStoreId();
		List<Foods> foodsList = null;

		// 分页步骤1. 创建PagerIter对象, 处理url传过来的pagesize和pageindex
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));

		Long rowCount = 0L;
		rowCount = foodsService.countBySearch(storeId, null);
		pagerItem.changeRowCount(rowCount);
		foodsList = foodsService.pagerBySearch(storeId, null, pagerItem.getPageNum(), pagerItem.getPageSize());
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));

		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", foodsList);

		String toPage = "/WEB-INF/store/foods_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);

	}

	private void listDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		javax.servlet.http.HttpSession session = request.getSession();
		Store bean = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		Long storeId = bean.getStoreId();
		String search = request.getParameter("search");
		request.setAttribute("search", search);
		List<Foods> vDataList = null;
		// 搜索分页
		// 分页步骤1. 创建PagerIter对象, 处理url传过来的pagesize和pageindex
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));

		Long rowCount = 0L;
		rowCount = foodsService.countBySearch(storeId, search);
		pagerItem.changeRowCount(rowCount);
		vDataList = foodsService.pagerBySearch(storeId, search, pagerItem.getPageNum(), pagerItem.getPageSize());
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));
		// 分页步骤3. 将分页对象和数据列表,放到作用域,以便页面可以访问
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);
		String toPage = "/WEB-INF/store/foods_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void insertView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		Store store = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		Long storeId = store.getStoreId();

		List<FoodCat> foodCat = foodCatService.listByStoreId(storeId);
		request.setAttribute("DataList", foodCat);
		request.setAttribute("storeId", storeId);

		String toPage = "/WEB-INF/store/foods_insert.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void insertDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		UploadFileResult uploadFileResult = UploadFileUtil.uploadFile(request);

		String storeId = (String) request.getAttribute("storeId");
		String catId = (String) request.getAttribute("catId");

		String foodName = (String) request.getAttribute("foodName");
		String remark = (String) request.getAttribute("remark");
		String price = (String) request.getAttribute("price");
		String picPath = (String) request.getAttribute("picpath");
		request.setAttribute("catId", catId);
		request.setAttribute("foodName", foodName);
		request.setAttribute("remark", remark);
		request.setAttribute("price", price);
		request.setAttribute("picpath", picPath);

		String vMsg = "";
		if (SysFun.isNullOrEmpty(foodName)) {
			vMsg += "菜品名不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(remark)) {
			vMsg += "注释不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(price)) {
			vMsg += "价格不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;
		}

		Foods bean = new Foods();

		Long vId = SysFun.parseLong(storeId);
		if (storeId == null) {
			vMsg = "没有指定主键；";

		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;

		}

		Long check = foodsService.countBySearch(vId, foodName);
		if (check > 0) {
			vMsg += "已经存在该菜品";
			request.setAttribute("msg", vMsg);
			insertView(request, response);
			return;
		}

		bean.setStoreId(vId);
		bean.setCatId(Long.parseLong(catId));
		bean.setFoodName(foodName);
		bean.setRemark(remark);

		bean.setPrice(Long.parseLong(price));
		bean.setCreateOn(new Date());
		if (uploadFileResult.getCode() == 0) {
			bean.setPicPath(uploadFileResult.getDesc());
		}
		Long result = 0L;
		try {
			result = foodsService.insert(bean);
		} catch (Exception ex) {
			vMsg = "添加失败." + ex.getMessage();
		}
		if (result > 0) {
			// 如果修改成功，则回到列表页面
			out.println("<script>");
			out.println("alert('添加成功');");
			out.println("location.href='Foods?oper=list';");
			out.println("</script>");
			return;
		} else {
			request.setAttribute("msg", vMsg);
			insertView(request, response);
		}

	}

	private void updateView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		Store store = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);

		List<FoodCat> foodCat = foodCatService.listByStoreId(store.getStoreId());

		String foodId = request.getParameter("id");

		Foods bean = foodsService.load(Long.parseLong(foodId));

		request.setAttribute("price", bean.getPrice());
		request.setAttribute("remark", bean.getRemark());
		request.setAttribute("foodName", bean.getFoodName());
		request.setAttribute("storeId", store.getStoreId());
		request.setAttribute("foodId", foodId);
		request.setAttribute("DataList", foodCat);

		String toPage = "/WEB-INF/store/foods_update.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void updateDeal(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UploadFileResult uploadFileResult = UploadFileUtil.uploadFile(request);

		String foodId = request.getParameter("foodId");
		String storeId = (String) request.getAttribute("storeId");
		String catId = (String) request.getAttribute("catId");
		String foodName = (String) request.getAttribute("foodName");
		String remark = (String) request.getAttribute("remark");
		String price = (String) request.getAttribute("price");

		request.setAttribute("foodId", foodId);
		request.setAttribute("catId", catId);
		request.setAttribute("foodName", foodName);
		request.setAttribute("remark", remark);
		request.setAttribute("price", price);

		String vMsg = "";
		if (SysFun.isNullOrEmpty(foodName)) {
			vMsg += "菜品名不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(remark)) {
			vMsg += "注释不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(price)) {
			vMsg += "价格不能为空；";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}

		Foods bean = new Foods();

		Long vId = SysFun.parseLong(storeId);
		if (storeId == null) {
			vMsg = "没有指定主键；";
		} else {

		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}

//		Long check = foodsService.countBySearch(vId, foodName);
//		if (check > 0) {
//			vMsg += "已经存在该菜品";
//			request.setAttribute("msg", vMsg);
//			updateView(request, response);
//			return;
//		}

		bean.setFoodId(Long.parseLong(foodId));
		bean.setStoreId(vId);
		bean.setCatId(Long.parseLong(catId));
		bean.setFoodName(foodName);
		bean.setRemark(remark);
		bean.setPrice(Long.parseLong(price));

		if (uploadFileResult.getCode() == 0) {
			bean.setPicPath(uploadFileResult.getDesc());
		}
		Long result = 0L;
		try {
			result = foodsService.update(bean);
		} catch (Exception ex) {
			vMsg = "添加失败." + ex.getMessage();
		}

		if (result > 0) {
			// 如果修改成功，则回到列表页面
			out.println("<script>");
			out.println("alert('修改成功');");
			out.println("location.href='Foods?oper=list';");
			out.println("</script>");
			return;
		} else {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
		}
	}

	private void deleteDeal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		// HttpSession session = request.getSession();
		// ServletContext application = request.getServletContext();
		// ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();

		String vId = request.getParameter("id");

		if (!SysFun.isNullOrEmpty(vId)) {
			Long iId = SysFun.parseLong(vId);

			Long result = foodsService.delete(iId);

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
