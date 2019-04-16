package com.grit.admin.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.admin.member.model.AdminService;
import com.grit.admin.member.model.AdminVO;

public class AdminEditController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String adminId=(String) request.getSession().getAttribute("adminId");
		//로그인된 경우만 처리되도록
		if(adminId==null || adminId.isEmpty()) {
			request.setAttribute("msg", "먼저 로그인하세요");
			request.setAttribute("url", "/login/login.do");
			
			return "/common/message.jsp";
		}
		
		//2.
		AdminService service=new AdminService();
		AdminVO vo=null;
		try {
			vo=service.selectMember(adminId);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//3.
		request.setAttribute("vo", vo);
		
		//4.		
		return "";//adminEdit.do
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

}
