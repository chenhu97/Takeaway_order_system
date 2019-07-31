package edu.tos.alipay;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.liuvei.common.SysFun;

import edu.tos.bean.*;
import edu.tos.service.*;
import edu.tos.service.impl.*;

@WebServlet("/order/confirm")
public class OrderServlet extends HttpServlet {

	private OrderService orderService = new OrderServiceImpl();
	private OrderItemService orderItemService = new OrderItemServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("开始处理OrderServlet的服务");

		String namelist = request.getParameter("namelist");
		String foodName = namelist;
		System.out.println(namelist + "545454");
		String[] nameList = namelist.split(",");

		String money = request.getParameter("total");
		String message = "未付款";

		String userId = request.getParameter("userId");

		request.setAttribute("userId", userId);
		System.out.println(userId + "1235");
		System.out.println(money + "66666");
		// 生成订单号

		String storeId = request.getParameter("storeId");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderSn = simpleDateFormat.format(Calendar.getInstance().getTime());
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		String out_trade_no = orderSn;
		String total_amount = money;

		// 付款金额，必填
		// 订单名称，必填
		String subject = foodName;

		// 商品描述，可空
		String body = message;
		Order bean = new Order();
		bean.setCreateOn(new Date());
		bean.setUpdateOn(new Date());
		bean.setPayId(SysFun.parseLong(out_trade_no));
		// bean.setStoreId(SysFun.parseLong(body));
		bean.setMoney(Double.parseDouble(money));
		bean.setStatus(-2L);
		// bean.setStoreId(SysFun.parseLong(storeId));
		bean.setUserId(SysFun.parseLong(userId));
		Long result = 0L;
		if (bean != null) {
			result = orderService.insert(bean);
		}

		Long orderId = orderService.searchOrderId(SysFun.parseLong(userId));
		OrderItem orderItem = new OrderItem();
		for (int i = 0; i < nameList.length; i++) {
			System.out.println("nameList["+i+"]="+nameList[i]);
		}
		for (int i = 0; i < nameList.length; i++) {
			orderItem.setOrderId(orderId);
			orderItem.setQuantity(1L);
			orderItem.setStoreId(SysFun.parseLong(storeId));
			orderItem.setFoodName(nameList[i]);
			Long result1 = 0L;
			if (bean != null) {
				result1 = orderItemService.insert(orderItem);
			}
		}

		// 向支付宝发送请求
		// 获得初始化的AlipayClient

		// 商户订单号，商户网站订单系统中唯一订单号，必填

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		// 若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
		// alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
		// + "\"total_amount\":\""+ total_amount +"\","
		// + "\"subject\":\""+ subject +"\","
		// + "\"body\":\""+ body +"\","
		// + "\"timeout_express\":\"10m\","
		// + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		// 请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
		AlipayTradePagePayResponse alipayResponse = null;
		try {
			alipayResponse = alipayClient.pageExecute(alipayRequest);
			System.out.println(alipayResponse.getBody());
			System.out.println(alipayResponse.getMsg());
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(alipayResponse.getBody());
	}

}