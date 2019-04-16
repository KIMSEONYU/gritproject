package com.grit.admin.member.controller;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.grit.admin.member.model.AdminService;
import com.grit.admin.member.model.AdminVO;

public class AdminLoginOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String adminId=request.getParameter("adminId");
		String adminPwd=request.getParameter("adminPwd");
		String chkSaveId=request.getParameter("chkSaveId");
		
		//2.
		AdminService service = new AdminService();
		String msg="로그인 처리 실패", url="/adminPage/adminLogin.do";
		try {
			int result=service.procALogin(adminId, adminPwd);
			if(result==AdminService.LOGIN_OK) {
				AdminVO vo=service.selectMember(adminId);
				HttpSession session = request.getSession();
				
				//세션에 저장
				session.setAttribute("adminId", adminId);
				session.setAttribute("adminName", vo.getAdminName());
				
				//쿠키에 저장
				Cookie ck = new Cookie("ck_adminId", adminId);						
				if(chkSaveId!=null) {
					ck.setMaxAge(1000*24*60*60);
					ck.setPath("/");
					response.addCookie(ck);
				}else {
					ck.setMaxAge(0);
					ck.setPath("/");
					response.addCookie(ck);					
				}
				
				msg=vo.getAdminName()+ "님 로그인되었습니다.";
				url="/adminIndex.do";
			}else if(result==AdminService.DISAGREE_PWD) {
				msg="비밀번호가 일치하지 않습니다.";
			}else if(result==AdminService.NONE_ID) {
				msg="해당 아이디가 존재하지 않습니다.";			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		//3.
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		//4.		
		return "/common/message.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
	
}
