package com.plantflashcards.interceptor;

import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Log time in and out of web requests to our application.
 * @author ucint
 *
 */
@Component("stopwatchInterceptor")
public class StopwatchInterceptor implements HandlerInterceptor {
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		logger.info("Completed request and rendered page at: " + new GregorianCalendar().toString());

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		logger.info("Executed Method: " + new GregorianCalendar().toString());

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		logger.info("Started request at: " + new GregorianCalendar().toString());
		return true;
	}

}
