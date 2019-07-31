package edu.tos.ui.ctrl.member;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


import com.liuvei.common.PagerItem;
import com.liuvei.common.SysFun;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;
import edu.tos.util.UIConst;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/member/MemberMain")
public class MemberMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();
	private StoreService storeService = new StoreServiceImpl();
	private StoreCatService storeCatService = new StoreCatServiceImpl();
	private AnnounceService announceService = new AnnounceServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberMainServlet() {
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
		default:
			toPage = "../index.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
			break;
		}

	}

	private void listView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		javax.servlet.ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		if (member == null) {// 判断登录
			String address = request.getParameter("address");
			session.setAttribute("indexAddress", address);
			String toPage = "/WEB-INF/member/main_nologin.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
		} else {
			String address =(String)session.getAttribute("indexAddress");
			//System.out.println(address+"jiangjiang");
			String name = member.getNickName();
			String storeCatId = request.getParameter("id");// 店铺分类进来的
			String storeName = request.getParameter("search");// 搜索进来的

			Long catId = null;
			if (storeCatId != null) {
				catId = Long.parseLong(storeCatId);
				if (catId < 1) {
					catId = null;
				}
			}

			List<Store> list = storeService.listBySearch(null, address, catId, null);
			List<Store> passList = new ArrayList<Store>();

			for (int i = 0; i < list.size(); i++) {// 筛选状态为通过(1)的店铺
				if (list.get(i).getStatus() == 1) {
					passList.add(list.get(i));
				}
			}
			List<StoreCat> storeCatList = storeCatService.list();
			List<Announce> annouceList = announceService.list();
			String news = annouceList.get(annouceList.size() - 1).getTitle();
			
			request.setAttribute("news", news);
			request.setAttribute("name", name);
			request.setAttribute("StoreCatList", storeCatList);
			session.setAttribute("indexAddress", address);
			request.setAttribute("DataList", passList);
			request.setAttribute("userPass", member.getUserPass());
			String toPage = "/WEB-INF/member/main.jsp";
			request.getRequestDispatcher(toPage).forward(request, response);
		}
	}

	private void listDeal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		javax.servlet.http.HttpSession session = request.getSession();
		List<StoreCat> storeCatList = storeCatService.list();
		String address = (String) session.getAttribute("indexAddress");// index.jsp进来的地址
		System.out.println(address+"jiangjiang");
		String storeCatId = request.getParameter("id");// 店铺分类进来的
		Long catId = null;
		if (storeCatId != null) {
			catId = Long.parseLong(storeCatId);
			if (catId < 1) {
				catId = null;
			}
		}
		String search = request.getParameter("search");

		System.out.println("search:" + search);
		System.out.println("address:" + address);
		System.out.println("storeCatId:" + catId);

		List<Store> vDataList = null;
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
		pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));

		Long rowCount = 0L;
		rowCount = storeService.countBySearch(search, address, catId, 1L);
		pagerItem.changeRowCount(rowCount);
		System.out.println("rowCount:" + rowCount);
		vDataList = storeService.pagerBySearch(search, 1L, address, catId, pagerItem.getPageNum(),
				pagerItem.getPageSize());

		request.setAttribute("pagerItem", pagerItem);
		request.setAttribute("DataList", vDataList);
		request.setAttribute("StoreCatList", storeCatList);
		String toPage = "/WEB-INF/member/main.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);

	}

	private void insertView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String toPage = "/WEB-INF/member/regist.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void insertDeal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		// HttpSession session = request.getSession();
		// ServletContext application = request.getServletContext();
		// ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String nickName = request.getParameter("nickName");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");

		request.setAttribute("userName", userName);
		request.setAttribute("nickName", nickName);
		request.setAttribute("sex", sex);
		request.setAttribute("phone", phone);

		Long check = memberService.countByName(userName);
		String vMsg = "";
		if (check > 0) {
			vMsg += "账号已经存在了";
			request.setAttribute("msg", vMsg);
			return;
		}

		Member bean = new Member();

		bean.setUserName(userName);
		bean.setUserPass(userPass);
		bean.setNickName(nickName);
		bean.setSex(sex);
		bean.setPhone(Long.parseLong(phone));

		Long result = 0L;

		try {
			result = memberService.insert(bean);
		} catch (Exception e) {
			// TODO: handle exception
			vMsg += "注册失败，详情请联系管理员";
			request.setAttribute("msg", vMsg);
			return;
		}

		if (result > 0) {
			out.println("<script>");
			out.println("alert('注册成功');");
			out.println("location.href='MemberMain';");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('注册失败');");
			out.println("location.href='MemberMain';");
			out.println("</script>");
		}
	}

	private void updateView(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		if (member == null) {// 判断登录
			response.sendRedirect("MemberMain");
			return;
		}
		request.setAttribute("bean", member);
		String toPage = "/WEB-INF/member/info.jsp";
		request.getRequestDispatcher(toPage).forward(request, response);
	}

	private void updateDeal(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		java.io.PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(UIConst.FG_LOGINUSER_KEY);
		String vId = request.getParameter("id");
		String nickName = request.getParameter("nickName");
		String userPass = request.getParameter("userPass");
		String userPass2 = request.getParameter("userPass2");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");

		// 服务端验证
		String vMsg = "";
		if (SysFun.isNullOrEmpty(nickName)) {
			vMsg += "用户名不能为空";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(phone)) {
			vMsg += "联系方式不能为空";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (SysFun.isNullOrEmpty(address)) {
			vMsg += "地址不能为空";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		// if(!SysFun.isNullOrEmpty(userPass)&&SysFun.isNullOrEmpty(userPass2)) {
		// vMsg +="请再次输入密码";
		// }
		// if (!SysFun.isNullOrEmpty(vMsg)) {
		// request.setAttribute("msg", vMsg);
		// updateView(request, response);
		// return;
		// }
		// if(SysFun.isNullOrEmpty(userPass)&&!SysFun.isNullOrEmpty(userPass2)) {
		// vMsg +="请再次输入密码";
		// }
		// if (!SysFun.isNullOrEmpty(vMsg)) {
		// request.setAttribute("msg", vMsg);
		// updateView(request, response);
		// return;
		// }
		if (!SysFun.isNullOrEmpty(userPass) && !SysFun.isNullOrEmpty(userPass2)) {
			if (!userPass.equals(userPass2)) {
				vMsg += "两次输入的密码不一致";
			}
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		if (!SysFun.isNullOrEmpty(userPass) && !userPass.equals(userPass2)) {
			vMsg += "如需修改密码,请再次输入密码";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		// 执行业务
		Member bean = null;
		Long iId = null;
		if (SysFun.isNullOrEmpty(vId)) {
			vMsg += "没有指定主键";
		} else {
			iId = SysFun.parseLong(vId);
			bean = memberService.load(iId);
			if (bean == null) {
				vMsg += "数据不存在";
			} else {
				if (bean.getUserId() != member.getUserId()) {
					out.print("<script>");
					out.print("alert('请遵守系统使用规范!');");
					out.print("location.href='MemberMain?oper=list';");
					out.print("</script>");
					return;
				}
			}
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.setAttribute("msg", vMsg);
			updateView(request, response);
			return;
		}
		Long result = 0L;
		bean.setNickName(nickName);
		bean.setPhone(SysFun.parseLong(phone));
		if (!SysFun.isNullOrEmpty(userPass)) {
			bean.setUserPass(userPass);
		}
		bean.setAddress(address);
		bean.setCreateOn(bean.getCreateOn());
		bean.setSex(sex);
		try {
			result = memberService.update(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vMsg += "修改失败" + e.getMessage();
		}
		if (result > 0) {
			session.setAttribute(UIConst.FG_LOGINUSER_KEY, bean);
			out.print("<script>");
			out.print("alert('修改成功!');");
			out.print("location.href='MemberMain?oper=list';");
			out.print("</script>");
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
