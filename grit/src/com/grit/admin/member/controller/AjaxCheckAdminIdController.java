package com.grit.admin.member.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.admin.member.model.AdminService;

public class AjaxCheckAdminIdController  implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		response.setContentType("text/plain;charset=utf-8");
		String adminId=request.getParameter("adminId");
		
		AdminService service=new AdminService();
		
		int result=0;
		try {
			result=service.duplicateAdminId(adminId);
		} catch (SQLException e) {
			
		}
		
		PrintWriter out=response.getWriter();
		out.println(result);
		
		return null;
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

}
