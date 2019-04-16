package com.grit.admin.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.admin.member.model.AdminService;
import com.grit.admin.member.model.AdminVO;

public class AdminEditOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String adminId=(String) request.getSession().getAttribute("adminId");
		//로그인된 경우만 처리되도록
		if(adminId==null || adminId.isEmpty()) {
			request.setAttribute("msg", "먼저 로그인하세요");
			request.setAttribute("url", "/adminPage/adminLogin.do");
			
			return "/common/message.jsp";
		}
		
		String adminPwd=request.getParameter("adminPwd");
		String adminName=request.getParameter("adminName");
		String hp1=request.getParameter("hp1");
		String hp2=request.getParameter("hp2");
		String hp3=request.getParameter("hp3");
		
		String adminHp="";
		if(hp2!=null && !hp2.isEmpty() && hp3!=null && !hp3.isEmpty()){
			adminHp=hp1+"-"+hp2+"-"+hp3;
		}
		
		
		
		//2.
		AdminService service = new AdminService();
		String msg="회원정보 수정 실패", url="/adminPage/adminEdit.do";
		try {
			int result=service.procALogin(adminId, adminPwd);
			if(result==AdminService.LOGIN_OK) {
				AdminVO vo = new AdminVO();
				vo.setAdminHp(adminHp);
				vo.setAdminName(adminName);
				vo.setAdminPwd(adminPwd);
				int cnt=service.editAdmin(vo);
				if(cnt>0) {
					msg="회원정보가 수정되었습니다.";					
				}
			}else if(result==AdminService.DISAGREE_PWD) {
				msg="비밀번호가 일치하지 않습니다.";
			}else {
				msg="비밀번호가 체크 실패";
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
