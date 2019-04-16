package com.grit.admin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class AdminRegisterController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		return "";//관리자페이지 입력
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
	
}
