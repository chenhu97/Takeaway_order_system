package edu.tos.ui.ctrl.member;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liuvei.common.SysFun;
import java.util.*;
import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.util.UIConst;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/member/Favorite")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteService favoriteService = new FavoriteServiceImpl();
	private StoreService storeService = new StoreServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				case "insertdeal":
					insertDeal(request, response); // 添加处理
					break;
				case "deletedeal":
					deleteDeal(request, response); // 删除处理
					break;
				case "deletedeal2":
					deleteDeal2(request, response); // 删除处理
					break;
				default:
					// listView(request, response); // 列表页面 : 默认
					System.out.println("oper不存在。");
					break;
				}
	}

	private void listView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		Long userId = user.getUserId();
		List<Favorite> favoriteList = favoriteService.listBySearch(userId);
		request.setAttribute("favoriteList", favoriteList);
		
		String toPage = "/WEB-INF/member/favorite.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void deleteDeal(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		Long userId = user.getUserId();
		String storeId = request.getParameter("storeId");
		//2服务端验证:主键值得为空性判断
		if(storeId == null || storeId.isEmpty()) {
			String toPage = "/WEB-INF/member/store_optionlist.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			}
		Favorite resultBean = favoriteService.loadBySearch(null, SysFun.parseLong(storeId), userId);
		if(resultBean == null) {
			out.print("notok");
			return;
		}
		Long result = favoriteService.delete(resultBean.getFavoriteId());
		if(result > 0) {
			//成功：提示后返回
			out.print("ok");
		}else {
			//失败：提示后返回
			out.print("notok");
		}
	}
	private void deleteDeal2(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		Long userId = user.getUserId();
		String storeId = request.getParameter("storeId");
		//2服务端验证:主键值得为空性判断
		if(storeId == null || storeId.isEmpty()) {
			String toPage = "/WEB-INF/member/store_optionlist.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			}
		Favorite resultBean = favoriteService.loadBySearch(null, SysFun.parseLong(storeId), userId);
		if(resultBean == null) {
			out.print("notok");
			return;
		}
		Long result = favoriteService.delete(resultBean.getFavoriteId());
		if(result > 0) {
			//成功：提示后返回
			out.print("<script> alert('取消成功。'); location.href='Favorite?oper=list';</script>");
		}else {
			//失败：提示后返回
			out.print("<script> alert('取消失败。'); location.href='Favorite?oper=list';</script>");
		}
	}

	private void insertDeal(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Member user = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		Long userId = user.getUserId();
		String storeId = request.getParameter("storeId");
		//2服务端验证:主键值得为空性判断
		if(storeId == null || storeId.isEmpty()) {
			String toPage = "/WEB-INF/member/store_optionlist.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			}
		Favorite bean = new Favorite();
		bean.setStoreId(SysFun.parseLong(storeId));
		bean.setUserId(userId);
		Long result = favoriteService.insert(bean);
		if(result > 0) {
			//成功：提示后返回
			out.print("ok");
		}else {
			//失败：提示后返回
			out.print("notok");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
