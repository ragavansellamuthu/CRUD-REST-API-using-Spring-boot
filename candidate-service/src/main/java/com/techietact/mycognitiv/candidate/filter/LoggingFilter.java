package com.techietact.mycognitiv.candidate.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class LoggingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request ;
		
		log.info("Request URI : {}" , httpServletRequest.getRequestURI());
		log.info("Request Method : {}",httpServletRequest.getMethod());
		
		chain.doFilter(request, response);
	}

}
