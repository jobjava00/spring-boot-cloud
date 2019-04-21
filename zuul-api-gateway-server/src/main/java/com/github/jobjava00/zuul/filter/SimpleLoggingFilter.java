package com.github.jobjava00.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jobjava00
 */
@Component
@Slf4j
public class SimpleLoggingFilter extends ZuulFilter {
	@Override public String filterType() {
		return "pre";
	}

	@Override public int filterOrder() {
		return 1;
	}

	@Override public boolean shouldFilter() {
		return true;
	}

	@Override public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest httpServletRequest = context.getRequest();
		log.info(String.format("Request Method: %s n URL: %s", httpServletRequest.getMethod(), httpServletRequest.getRequestURL().toString()));
		return null;
	}
}
