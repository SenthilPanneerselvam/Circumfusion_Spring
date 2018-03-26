package com.circumfusion.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.circumfusion.entity.User;
import com.circumfusion.exception.NotAuthenticatedException;
import com.circumfusion.service.LoginCookieService;

@WebFilter( urlPatterns = {"/*"} )
public class AuthenticationFilter implements Filter 
{
	@Autowired
	LoginCookieService loginCookieService;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest requestObj = (HttpServletRequest)request;
		boolean authReq = isAuthRequired(requestObj.getRequestURI());
		if(authReq)
		{
			boolean isAuthenticated = isAuthenticated(requestObj);
			if(!isAuthenticated)
			{
				throw new NotAuthenticatedException();
			}
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public static boolean isAuthRequired(String requestUri)
	{
		boolean authReq = true;
		if(requestUri != null && (requestUri.contains("/login") || requestUri.contains("/register")))
		{
			authReq = false;
		}
		return authReq;
	}
	
	public boolean isAuthenticated(HttpServletRequest requestObj)
	{
		boolean isAuthenticated = false;
		String loginCookieValue = requestObj.getHeader("login-cookie-value");
		if(StringUtils.isNotEmpty(loginCookieValue))
		{
			User user = loginCookieService.getUser(loginCookieValue);
			if(user != null && user.getId() != null)
			{
				isAuthenticated = true;
				requestObj.setAttribute("currentUser", user);
			}
		}
		return isAuthenticated;
	}
}
