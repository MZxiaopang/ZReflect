package com.zhiyou.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.zhiyou.util.SessionKey;

public class LoginFilter implements Filter {

	private String[] uris = { "/WebCRUD/login" };

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁了filter对象");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println(req.getRequestURI());
		if (Arrays.asList(uris).contains(req.getRequestURI())) {
			chain.doFilter(req, response);
			return;
		}
		Object o = req.getSession().getAttribute(SessionKey.USER_LOGIN);
		if (o == null) {
			req.getRequestDispatcher("login.jsp").forward(req, response);
		} else {
			// 放行
			chain.doFilter(req, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("创建了filter对象");
	}

}
