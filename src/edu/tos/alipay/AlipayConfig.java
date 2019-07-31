package edu.tos.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092400584593";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCh8VlT7cNB3sVin/yK3fqTqDXMbcF6zGFnSngTHA13Xxk6Vdt0ixVgU5yVvsecVJR7L2Os8byRp+TOVmP+UDpDQe98fNi20rFOgWHy2J8suV0Usremzaq1THU4ie11fqeJY+BXzgUbYBugIDkKM1jVd9n9x1SSPjRqOZLngAAEs3QVevO1ZJ03/ttZvfoiDO3UKLAwclTAMMXEaduoZWpG/YNZX5N8noGBKRlg4GNnfMO7v2hL9M5uVEiiMAlOgJSwlYrl9QJ9c/eX47pEiy8qwb+DIXfSiXxDfWz9K1AVfY50SJqtwnMH5XC8BSFP8tn3JNIhcPYgE/E/4T+1S9lRAgMBAAECggEAdIIdEELozYUmYTRVDttxIbZNLkxwfJZ6JUPwa18tWQp0LgIDJy/BK1I8P4fIOHKpeI65mX05e1ldRg3lVtwFbsoLMHbpu26N3bs76ulqa1TY4MFLW5hwDot5cjnZO0Tp5/CRQNqZ1f4pIeTM5MfYS4w0q14zPBvAvgO56w+t87K5Pv3hTdVpwAmIO1nizfMAZDJGW2SQLXjBUUOddQGfQZu3DU4bByYBKp+z4M7dpzhRmCDZdf/CTNxbHkWqKwslv7Ia8OFtmFTO9WIuXw++2953TKp5xfK+QTKodshAmNDrU68eslJEZzoo5wOimU7U3lYuLVygq6xHNncQTFXDgQKBgQDjMBDS2Vo0crcvHQvWnyQvBU1MDGBTXESUBb4trDHoJYn+HXIKCK/AoHJCZGEgX4if9dtW9bI+mzEFm7XsMX8lKH+cf8nz3iAmHx/WRY7EpHTfVZ6WNqZVoMWtqulCmjj5Ofh41ajMjmvM5CjQ3cloQRB6mplnMBcT9G10Eidf6QKBgQC2ewXxJZWiXpn+PTowliFtYYwNd2sxQaWNcBGC1An15DDJ3jg5GcEUNL87JYdybhJNL8j6Eow6NZel9TfGIRIROlCImhJv8RJMlCf6no7LmxaH9tv8zu628M953A3pSy0a5fgTJ64nTA9XR/n438lD8fuPGDIZpe9y5QSr6+h1KQKBgQCAJQ54P80XpFUbKAETb/RS6WSuLpTusC6mZ47b6DLGRNZPFYDLlBa+SkHonQID5p8DywOLS07c7WB7T1cQAOM8rFk+hv38ph/wIMIudFGRLUoW5w5qoCy2Q9b8nFiyDpdwTHiQf8OUjgjUKyWymkcOnRSUcztv7ro1sTtDqzG2cQKBgQCz8xWk/J9XA1twsAhWKXbFWtC15vG6HTaZB8786QT5ixHhwFZJWPBicLG0Lgon+gvqOhlDIk9Oh9MIQY3CwJIEkzEfxHAyG9Uj12alav7+Ie5SHkpKP/aASXEQhsThLtVIFUhR+2tuLT9jnwMPPgBIFLUyI3YkfNJoxxeYQod2IQKBgQCwj96QVh0H3xStblcVINxYLpKnQCg5sNvC5m+hzm7iSPvGzmQy/Ia+vAec04CVEAcInsDwELWlZYojzytaaYKBMkHy6jWQ+AakSe6CoHCFWuDa3CyKlQI6tbUz/iRTraTvv27b/PitruLr7KriWEQxqriBLYrXjmnj9jqKFixjlQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45n8c1WlH0vf0RA2WhaNFOpTXxjOU4sUVAM4tYHXWd+tCZesXbNheIyBeZ2ZqVvEbb4cLNPjmR2wphvkWIQkujF233m05EwpAIXO2ber8ck5PkDLOPpeJjU5jwgX5lqH1EUdhwzCIiSdpDgElDeJXXWdT16S4zc9sT0yZGB5xn8jzcwH833HIDvAOjLe9PKey1THNNDbJnwrrHRu7mEMo/nD9UdBDOpPBeA6rnekKg9Y0gXLwlke8IHwVRPHCplwiLTfzOtWHkQ3mYGQBBfOiY1CrvdofAln/NpMM93GHBeWS60ckGnROAkKEx5/eosxUHa309sdPCfFJdQifUJ4eQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/Takeaway_order_system/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/Takeaway_order_system/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

