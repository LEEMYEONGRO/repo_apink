package com.blackpink.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.blackpink.common.constants.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckLoginSessionInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (request.getSession().getAttribute("sessEmailXdm") != null) {
			// by pass
		} else {
			response.sendRedirect(Constants.URL_LOGINFORM);
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
