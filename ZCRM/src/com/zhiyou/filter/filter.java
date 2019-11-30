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

/**
 * Servlet Filter implementation class filter
 */
public class filter implements Filter {

	public void destroy() {

	}

	private String[] URI = { "/ZCRM/", "/ZCRM/login", "/ZCRM/Css/logincss.css", "/ZCRM/img/login.png" };

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println(req.getRequestURI());
		if (Arrays.asList(URI).contains(req.getRequestURI())) {
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

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
