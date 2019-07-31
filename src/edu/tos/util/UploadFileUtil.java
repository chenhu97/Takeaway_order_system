package edu.tos.util;

import java.io.File;
import java.util.*;

import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;


public class UploadFileUtil {

	/**
	 * 服务端保存的上传文件的最大限制
	 */
	private static int UploadMaxFileSize = 1024 * 1024 * 5; // MB

	/**
	 * 服务端保存的上传文件的根目录
	 */
	private static String UploadRootName = "upload";

	/**
	 * 处理服务端保存上传文件的根目录
	 * 
	 * @param request
	 * @return
	 */
	private static String dealRootDir(HttpServletRequest request) {

		// 上传文件的存储路径（服务器文件系统上的绝对文件路径）
		String uploadFilePath = request.getServletContext().getRealPath(UploadRootName);
		
		File vRootDir = new File(uploadFilePath);
		// 判断上传文件的保存目录是否存在
		if (!vRootDir.exists() && !vRootDir.isDirectory()) {
			// System.out.println(uploadFilePath + "目录不存在，需要创建");
			// 创建目录
			vRootDir.mkdir();
		}
		System.out.println(vRootDir+"+"+uploadFilePath);
		return uploadFilePath;
	}

	/**
	 * 上传文件的扩展名列表
	 */
	private static List<String> fileExtList = Arrays.asList("png", "gif", "jpg", "jpeg");

	/**
	 * 获得上传文件的扩展名列表
	 * 
	 * @return
	 */
	public static List<String> getFileExtList() {
		return fileExtList;
	}

	public static UploadFileResult uploadFile(HttpServletRequest request) {
		UploadFileResult result = new UploadFileResult();

		String uploadFilePath = dealRootDir(request);
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			upload.setSizeMax(UploadMaxFileSize); // 上传文件的最大限制是
			// 解析form表单中所有文件
			try {

				// 上传的Servlet，分析请求对象，解析成列表对象List<FileItem>
				List<FileItem> items = upload.parseRequest(request);

				File saveFile = null; // 上传并保存的文件
				boolean isUnallowedType = false; // 是否为不允许的类型
				for (FileItem item : items) {
					isUnallowedType = false;
					if (item.isFormField()) { // 普通表单字段
						// fieldName = item.getFieldName(); //表单字段的name属性值
						String name = item.getFieldName();
						String value = item.getString("UTF-8");

						// 将parameter的内容，放到地attribute里
						request.setAttribute(name, value);

					} else { // 文件表单字段
						String fileName = item.getName();
						if (fileName.length() > 0) {
							int index = fileName.lastIndexOf(".");// 查找.字符的下标
							// 取扩展名
							String extName = index == -1 ? "" : fileName.substring(index + 1).toLowerCase();

							if (getFileExtList().contains(extName)) { // 判断文件扩展名类型是否在允许范围内
								File fullFile = new File(item.getName());

								String oldName = fullFile.getName();// 原名称
								String newName = oldName;// 新名称，一开始先默认是旧名称
								//使用UUID来随机生成一个唯一的名称（去掉-）
								String uuid = UUID.randomUUID().toString().replace("-", "");

								newName = uuid; // 在这里用UUID来生成新的文件夹名字，这样就不会导致重名

								newName = newName + "." + extName;
								saveFile = new File(uploadFilePath, newName);
								item.write(saveFile);

								// news.setNpicpath(uploadFilePath +
								// File.pathSeparator + fullFile.getName());

								// 上传成功
								result.setCode(0);
								//result.setDesc(newName);
								result.setDesc(String.format("/%s/%s" , UploadRootName, newName));

							} else {
								isUnallowedType = true;// 扩展名对应的文件不允许上传
							}
						}
					}

					if (isUnallowedType) {
						result.setCode(-2);
						result.setDesc("图片上传失败，文件类型只能是（" + 
								getFileExtList().toString() + "）。");

					}

				}

			} catch (FileUploadBase.SizeLimitExceededException ex) {
				result.setCode(-99);
				result.setDesc("图片上传失败，文件的最大限制是。(" + 1.0 * UploadMaxFileSize / 1024 + "KB)");

			} catch (Exception ex) {
				result.setCode(-99);
				result.setDesc("图片上传失败:" + ex.getMessage() + "。");
			}
		}

		return result;
	}

}