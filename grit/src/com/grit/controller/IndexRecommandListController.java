package com.grit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class IndexRecommandListController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/grit/index.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
