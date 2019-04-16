package com.grit.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String memUserid=(String) request.getSession().getAttribute("memUserid");
		System.out.println("memUserid="+memUserid);
		//로그인된 경우만 처리되도록
		if(memUserid==null||memUserid.isEmpty()) {
			request.setAttribute("msg", "먼저 로그인하세요");
			request.setAttribute("url", "/grit/grit/index.do");
			return "/grit/common/message.jsp";
		}
		
		
		request.getSession().removeAttribute("memUserid");//각각개별적으로 removeAttribute로 날려버린다
		request.getSession().removeAttribute("memName");
		//4.
		return "/grit/index.do";
	}

	@Override
	public boolean isRedirect() {
		return true;
	}

}
