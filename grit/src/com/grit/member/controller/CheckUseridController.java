package com.grit.member.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.member.model.MemberService;

public class CheckUseridController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		response.setContentType("text/plain;charset=utf-8");
		
		String memUserid=request.getParameter("memUserid");
		MemberService service=new MemberService();
		int result=0;
		try {
			//기업회원 userid 중복체크 추가해야함
			result=service.duplicateMUseid(memUserid);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		out.println(result);
		
		return null;
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
	
}
