package edu.tos.ui.ctrl.storeregist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * Servlet implementation class memberStoreRegistServlet
 */
@WebServlet("/memberStoreRegist")
public class memberStoreRegistServlet extends HttpServlet {
	private StoreService storeService = new StoreServiceImpl();
	private StoreCatService storeCatService = new StoreCatServiceImpl();

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberStoreRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			
				case "insert":
					insertView(request, response); // 添加页面
					break;
				case "insertdeal":
					insertDeal(request, response); // 添加处理
					break;
				default:
					insertView(request, response); // 列表页面 : 默认
					System.out.println("oper不存在1。");
					break;
				}
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
		String announce = (String) request.getAttribute("announce");
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
		request.setAttribute("announce", announce);

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
		if(announce == null) {
			announce = "本店暂无公告";
		}
		bean.setAnnounce(announce);
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
			// 如果添加成功，则回到列表页面
			out.println("<script>");
			out.println("alert('添加成功');");
			out.println("location.href='store/Login';");
			out.println("</script>");
		} else {


			insertView(request, response);
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
