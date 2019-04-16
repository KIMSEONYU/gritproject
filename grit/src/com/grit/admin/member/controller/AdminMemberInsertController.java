package com.grit.admin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class AdminMemberInsertController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/adminPage/registerMem.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

	
}
