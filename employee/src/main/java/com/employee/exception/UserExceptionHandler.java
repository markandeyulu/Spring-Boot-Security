package com.employee.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class UserExceptionHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.addHeader("WWW-Authenticate", "Basic realm\"" + "MYREALM" + "\"" );
		
		response.sendRedirect("/WEB-INF/jsp/error.jsp");
		/*
		 * PrintWriter out = response.getWriter();
		 * 
		 * out.println("Http Status 403:" + accessDeniedException.getMessage() +
		 * "NOT AUTHERISED");
		 */
	}

}
