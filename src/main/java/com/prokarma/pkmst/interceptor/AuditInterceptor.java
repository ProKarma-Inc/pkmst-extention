package com.prokarma.pkmst.interceptor;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * This a audit interceptor which extends the HandlerInterceptorAdapter to
 * calculate the time taken by searchbyids request
 * 
 * @author rkumar
 *
 */
public class AuditInterceptor extends HandlerInterceptorAdapter {
	private static final Logger LOG = Logger.getLogger(AuditInterceptor.class.getName());
	private static String TRACEABILITY_ID = "trace-id";
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#
	 * preHandle(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			request.setAttribute("STARTTIME", System.currentTimeMillis());
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#
	 * postHandle(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			request.setAttribute("ENDTIME", System.currentTimeMillis());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#
	 * afterCompletion(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String traceId = request.getHeader(TRACEABILITY_ID);
		String correlationId = request.getHeader(TRACEABILITY_ID);
		int status = response.getStatus();
		LOG.log(Level.INFO, "Status: "+status+", TraceId: "+traceId+", CorrelationId: "+correlationId+", RequestTime: "
				+ ((Long) request.getAttribute("ENDTIME") - (Long) request.getAttribute("STARTTIME")));

	}
}
