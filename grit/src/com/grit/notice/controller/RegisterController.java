package com.grit.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class RegisterController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/grit/admin/notice/register.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
