package com.grit.admin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class AdminLogOutController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//request.getSession().invalidate();
		request.getSession().removeAttribute("adminId");
		request.getSession().removeAttribute("adminName");
		
		return "/adminIndex.do";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
