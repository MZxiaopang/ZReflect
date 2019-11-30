package com.zhiyou.interceptor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestIterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest mu = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> map = mu.getFileMap();
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String forkey = iterator.next();
				MultipartFile file = mu.getFile(forkey);
				String filename = file.getOriginalFilename();
				System.out.println(filename);
				if (!choseName(filename)) {
					request.setAttribute("msg", "文件类型不正确");
					request.getRequestDispatcher("Edit.jsp").forward(request, response);
					flag = false;
				}
			}
		}
		System.out.println(flag);
		return flag;
	}

	boolean choseName(String fileName) {
		String suffix[] = { "jpg", "png", "gif", "jpeg" };

		String string = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		if (Arrays.asList(suffix).contains(string.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
