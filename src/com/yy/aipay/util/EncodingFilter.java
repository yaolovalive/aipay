package com.yy.aipay.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encode;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if(null == request.getCharacterEncoding()){
			request.setCharacterEncoding(this.encode);
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if(this.encode == null)
			this.encode = filterConfig.getInitParameter("encode");
	}
	
	@Override
	public void destroy() {
		this.encode = null;
	}
}
