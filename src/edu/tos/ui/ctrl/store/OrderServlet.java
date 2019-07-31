package edu.tos.ui.ctrl.store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuvei.common.PagerItem;
import com.liuvei.common.SysFun;

import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.util.UIConst;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/store/Order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StoreService storeService = new StoreServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	private OrderItemService orderItemService = new OrderItemServiceImpl();

	public Store getLoginStore(HttpServletRequest request) {
		javax.servlet.http.HttpSession session = request.getSession();
		Store bean = (Store) session.getAttribute(UIConst.BG_LOGINUSER_KEY);
		return bean;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String oper = request.getParameter("oper");
		if (oper == null) {
			oper = "";
		} else {
			oper = oper.trim().toLowerCase();
		}
		String toPage = "";// 与default配合
		switch (oper) {
		case "list":
			listView(request, response);
			break;
		case "receivedeal":
			receiveDeal(request, response);
			break;
		case "refusedeal":
			refuseDeal(request, response);
			break;
		case "done":
			doneView(request, response);
			break;

		}

	}

	private void listView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Store bean = getLoginStore(request);
		List<Order> vDataList = null;
		javax.servlet.http.HttpSession session = request.getSession();
		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);

		// 分页
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));

		Long rowCount = 0L;
		rowCount = orderService.countBySearch(bean.getStoreId(), null, -1L);
		System.out.println("rowCount:" + rowCount);
		pagerItem.changeRowCount(rowCount);
		vDataList = orderService.pagerBySearchEx(null, -1L, pagerItem.getPageNum(), pagerItem.getPageSize());
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));

		List<OrderItem> orderItem = new ArrayList<>();// 订单项集合
		List<String> foodNameList = new ArrayList<>();// 菜名集合

		for (int i = 0; i < vDataList.size(); i++) {
			orderItem = orderItemService.listBySearch(vDataList.get(i).getOrderId(), null, null);
			String foodName = "";
			for (int j = 0; j < orderItem.size(); j++) {
				foodName += orderItem.get(j).getFoodName() + "*" + orderItem.get(j).getQuantity() + "+";
			}

			if (foodName != "") {
				foodName = foodName.substring(0, foodName.length() - 1);
				System.out.println(foodName);
				foodNameList.add(foodName);
			}
		}
		
		request.setAttribute("foodNameList", foodNameList);
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("OrderList", vDataList);
		
		String toPage = "/WEB-INF/store/order_list.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void receiveDeal(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		java.io.PrintWriter out = response.getWriter();
		// response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String vId = request.getParameter("id");
		Long id = 0L;
		if (!SysFun.isNullOrEmpty(vId)) {
			id = SysFun.parseLong(vId);
		}

		Order bean = orderService.load(id);
		if (bean == null) {
			out.print("<script>");
			out.print("alert('数据不存在');");
			out.print("history.back()';");
			out.print("</script>");
			return;
		}

		bean.setStatus(0L);

		Long num = orderService.update(bean);
		if (num > 0) {
			out.print("<script>");
			out.print("alert('接单成功!');");
			out.print("location.href='Order?oper=list'");
			out.print("</script>");
			// out.flush();
		} else {
			out.print("<script>");
			out.print("alert('操作失败！ ');");
			out.print("location.href='Order?oper=list'");
			out.print("</script>");
			out.flush();
		}

	}

	private void doneView(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		Store bean = getLoginStore(request);
		List<Order> vDataList = null;

		// 分页
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));

		Long rowCount = 0L;
		rowCount = orderService.countBySearch(bean.getStoreId(), null, 1L);
		pagerItem.changeRowCount(rowCount);
		vDataList = orderService.pagerBySearchEx(null, 1L, pagerItem.getPageNum(),
				pagerItem.getPageSize());
		pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(), request.getQueryString()));


		List<OrderItem> orderItem = new ArrayList<>();// 订单项集合
		List<String> foodNameList = new ArrayList<>();// 菜名集合

		for (int i = 0; i < vDataList.size(); i++) {
			orderItem = orderItemService.listBySearch(vDataList.get(i).getOrderId(), null, null);
			String foodName = "";
			for (int j = 0; j < orderItem.size(); j++) {
				foodName += orderItem.get(j).getFoodName() + "*" + orderItem.get(j).getQuantity() + "+";
			}

			if (foodName != "") {
				foodName = foodName.substring(0, foodName.length() - 1);
				System.out.println(foodName);
				foodNameList.add(foodName);
			}
		}
		
		request.setAttribute("foodNameList", foodNameList);
		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("OrderList", vDataList);

		String toPage = "/WEB-INF/store/order_doneList.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);

	}

	private void refuseDeal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		java.io.PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String vId = request.getParameter("id");
		Long id = 0L;
		if (!SysFun.isNullOrEmpty(vId)) {
			id = SysFun.parseLong(vId);
		}

		Order bean = orderService.load(id);
		if (bean == null) {
			out.print("<script>");
			out.print("alert('数据不存在');");
			out.print("history.back()';");
			out.print("</script>");
			return;
		}

		bean.setStatus(-3L);

		Long num = orderService.update(bean);

		if (num > 0) {
			out.print("<script>");
			out.print("alert('拒接成功!');");
			out.print("location.href='Order?oper=list'");
			out.print("</script>");
			out.flush();
		} else {
			out.print("<script>");
			out.print("alert('Undone :(');");
			out.print("location.href='Order?oper=list'");
			out.print("</script>");
			out.flush();
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
