package edu.tos.ui.ctrl.member;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.liuvei.common.SysFun;

import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.util.UIConst;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/member/StoreMain")
public class StoreMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FoodsService foodsService = new FoodsServiceImpl();
	private StoreService storeService = new StoreServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	private FoodCatService foodCatService = new FoodCatServiceImpl();
	private MessageService messageService = new MessageServiceImpl();
	private OrderItemService orderItemService = new OrderItemServiceImpl();
	private FavoriteService favoriteService = new FavoriteServiceImpl();

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
		case "order":
			orderView(request, response);
			break;
		case "orderdeal":
			orderDeal(request, response);
			break;
		case "message":
			messageView(request, response);
			break;
		case "message_insert":
			messageInsertView(request, response);
			break;
		case "message_insertdeal":
			messageInsertDeal(request, response);
			break;
		case "optionlist":
			optionView(request, response);
			break;
		case "alllist":
			allView(request, response);
			break;
		case "gooddeal":
			goodDeal(request, response);
			break;
		default:
			toPage = "../index.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			break;
		}
	}

	private void messageInsertDeal(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		if (user == null) {
			String toPage = "/WEB-INF/member/main_nologin.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}

		String orderId = request.getParameter("orderId");
		String storeId = request.getParameter("storeId");
		String content = request.getParameter("content");
		String foodName = request.getParameter("foodName");

		Message message = new Message();
		message.setOrderId(Long.parseLong(orderId));
		message.setStoreId(Long.parseLong(storeId));
		message.setFoodName(foodName);
		message.setContent(content);
		message.setUserId(user.getUserId());

		Long result = messageService.insert(message);

		if (result > 0) {
			out.println("<script>");
			out.println("alert('评论成功');");
			out.println("location.href='StoreMain?oper=order'");
			out.println("</script>");

		} else {
			out.println("<script>");
			out.println("alert('评论失败');");
			out.println("location.href='StoreMain?oper=order'");
			out.println("</script>");
		}
//		String toPage = "StoreMain?oper=order";
//		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void messageInsertView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		if (user == null) {
			String toPage = "/WEB-INF/member/main_nologin.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		String foodName = request.getParameter("foodName");
		String orderId = request.getParameter("orderId");
		Long oId = Long.parseLong(orderId);
		Long storeId = orderItemService.loadBySearch(oId, null, null).getStoreId();

		request.setAttribute("foodName", foodName);
		request.setAttribute("orderId", oId);
		request.setAttribute("storeId", storeId);

		String toPage = "/WEB-INF/member/message_insert.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);

	}

	private void orderDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String orderId = request.getParameter("orderId");

		Order bean = new Order();
		bean = orderService.load(Long.parseLong(orderId));

		Long result = orderService.updateStatus(bean.getPayId(), 1L);

		if (result > 0) {
			out.println("<script>");
			out.println("alert('收货成功');");
			out.println("location.href='StoreMain?oper=order'");
			out.println("</script>");

		} else {
			out.println("<script>");
			out.println("alert('收货失败');");
			out.println("location.href='StoreMain?oper=order'");
			out.println("</script>");

		}

	}

	protected void allView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		if (user == null) {
			String toPage = "/WEB-INF/member/main_nologin.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		Long userId = user.getUserId();
		String storeId = request.getParameter("storeId");
		request.setAttribute("storeId", storeId);
		List<FoodCat> CatDataList = foodCatService.listByStoreId(Long.parseLong(storeId));
		request.setAttribute("CatDataList", CatDataList);
		List<Foods> FoodDataList = foodsService.listById(SysFun.parseLong(storeId));
		request.setAttribute("FoodDataList", FoodDataList);
		Store bean = storeService.load(Long.parseLong(storeId));
		// 判断是否已收藏
		Favorite FavoriteResult = favoriteService.loadBySearch(null, SysFun.parseLong(storeId), userId);
		request.setAttribute("FavoriteResult", FavoriteResult);
		String toPage = "";

		if (user == null) {
			toPage = "/WEB-INF/member/main_nologin.jsp";
		} else {
			toPage = "/WEB-INF/member/store_alllist.jsp";
			request.setAttribute("user", user);
		}
		request.setAttribute("bean", bean);
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	protected void optionView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		if (user == null) {
			String toPage = "/WEB-INF/member/main_nologin.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		Long userId = user.getUserId();
		String storeId = request.getParameter("storeId");
		request.setAttribute("storeId", storeId);
		List<FoodCat> CatDataList = foodCatService.listByStoreId(Long.parseLong(storeId));
		request.setAttribute("CatDataList", CatDataList);
		List<Foods> FoodDataList = foodsService.listById(SysFun.parseLong(storeId));
		request.setAttribute("FoodDataList", FoodDataList);
		Store bean = storeService.load(Long.parseLong(storeId));
		// 判断是否已收藏
		Favorite FavoriteResult = favoriteService.loadBySearch(null, SysFun.parseLong(storeId), userId);
		request.setAttribute("FavoriteResult", FavoriteResult);
		String toPage = "";
		if (user == null) {
			toPage = "/WEB-INF/member/main_nologin.jsp";
		} else {
			toPage = "/WEB-INF/member/store_optionlist.jsp";
			request.setAttribute("user", user);
		}

		request.setAttribute("bean", bean);
		request.getRequestDispatcher(toPage).forward(request, response);

	}

	private void listView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		if (user == null) {
			String toPage = "/WEB-INF/member/main_nologin.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		Long userId = user.getUserId();
		request.setAttribute("userId", userId);
		String storeId = request.getParameter("storeId");
		request.setAttribute("storeId", storeId);

		List<FoodCat> CatDataList = foodCatService.listByStoreId(Long.parseLong(storeId));

		request.setAttribute("CatDataList", CatDataList);
		List<Foods> FoodDataList = foodsService.listById(SysFun.parseLong(storeId));
		request.setAttribute("FoodDataList", FoodDataList);
		Store bean = storeService.load(Long.parseLong(storeId));

		// 判断是否已收藏
		Favorite FavoriteResult = favoriteService.loadBySearch(null, SysFun.parseLong(storeId), userId);
		request.setAttribute("FavoriteResult", FavoriteResult);

		String toPage = "";

		if (user == null) {
			toPage = "/WEB-INF/member/main_nologin.jsp";
		} else {
			toPage = "/WEB-INF/member/store_optionlist.jsp";
			request.setAttribute("user", user);
		}
		request.setAttribute("storeId", storeId);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void orderView(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);

		if (user == null) {
			String toPage = "/WEB-INF/member/main_nologin.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}

		List<Order> orderList = orderService.listByUserId(user.getUserId());// 查出所有订单
		
		List<Order> userOrderList = new ArrayList<>();// 当前用户订单集合
		List<OrderItem> orderItem = new ArrayList<>();// 订单项集合
		List<String> foodNameList = new ArrayList<>();// 菜名集合
		List<String> storeNameList = new ArrayList<>();// 店名集合
		List<Long> storeIdList = new ArrayList<>();// 店名集合
		List<Long> messaged = new ArrayList<>();// 是否评论

		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getUserId() == user.getUserId()) {// 判断是否为当前用户订单
				Foods foods = new Foods();
				String foodName = "";
				orderItem = orderItemService.listBySearch(orderList.get(i).getOrderId(), null, null);

				for (int j = 0; j < orderItem.size(); j++) {
					foods = foodsService.loadBySearch(orderItem.get(j).getStoreId(), orderItem.get(j).getFoodName());
					foodName += orderItem.get(j).getFoodName() + "*" + orderItem.get(j).getQuantity() + "+";

					if (orderItem.get(j).getOrderId() == orderList.get(i).getOrderId()) {
						storeIdList.add(orderItem.get(j).getStoreId());
					}
				}
				Message message = new Message();
				message = messageService.loadBySearch(null, orderList.get(i).getOrderId(), null);
				if (message != null) {
					messaged.add(1L);
				} else {
					messaged.add(0L);
				}
				if (foodName != "") {
					foodName = foodName.substring(0, foodName.length() - 1);
					userOrderList.add(orderList.get(i));
					foodNameList.add(foodName);
					storeNameList.add(storeService.loadById(foods.getStoreId()).getStoreName());
				}
			}
		}
		request.setAttribute("messaged", messaged);
		request.setAttribute("user", user);
		request.setAttribute("storeIdList", storeIdList);
		request.setAttribute("userOrderList", userOrderList);
		request.setAttribute("storeNameList", storeNameList);
		request.setAttribute("foodNameList", foodNameList);

		String toPage = "/WEB-INF/member/order.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
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

	private void messageView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		if (user == null) {
			String toPage = "/WEB-INF/member/main_nologin.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			return;
		}
		String storeId = request.getParameter("storeId");
		Store bean = storeService.load(Long.parseLong(storeId));

		List<Message> DataList = messageService.listBySearch(SysFun.parseLong(storeId), null, null);
		Long num = messageService.countBySearch(Long.parseLong(storeId), null, null);

		request.setAttribute("num", num);// 总评论数
		request.setAttribute("bean", bean);
		request.setAttribute("DataList", DataList);
		request.setAttribute("user", user);
		request.setAttribute("storeId", storeId);
		String toPage = null;
		toPage = "/WEB-INF/member/message.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	protected void goodDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
