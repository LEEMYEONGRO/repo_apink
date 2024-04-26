package com.blackpink.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.blackpink.common.constants.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CheckLoginSessionInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (request.getSession().getAttribute("sessMbSeqXdm") != null) {
			// by pass
		} else {
			response.sendRedirect(Constants.URL_LOGINFORM);
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		
//		HttpSession session = request.getSession();
//		
//		if (session.getAttribute("sessMbSeqXdm") != null) {
//			// by pass
//		} else {
//			if (session.getAttribute("sessMbSeqXdm") != null) {
//				// by pass
//			}else {
//				if (request.getRequestURI().startsWith("/Xdm")) {
//					response.sendRedirect(Constants.URL_LOGINFORM);
//				} else {
//					response.sendRedirect(Constants.URL_LOGINUSER);
//					}
//					return HandlerInterceptor.super.preHandle(request, response, handler);
//			}
//		}
//		return HandlerInterceptor.super.preHandle(request, response, handler);
//	}
}
