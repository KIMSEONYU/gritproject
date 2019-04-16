package com.grit.admin.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.admin.member.model.AdminService;
import com.grit.admin.member.model.AdminVO;

public class AdminRegisterOkController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String adminId=request.getParameter("adminId");
		String adminPwd=request.getParameter("adminPwd");
		String adminName=request.getParameter("adminName");
		String hp1=request.getParameter("hp1");
		String hp2=request.getParameter("hp2");
		String hp3=request.getParameter("hp3");

		//hp
		String adminHp="";
		if(hp2!=null && !hp2.isEmpty() && hp3!=null && !hp3.isEmpty()){
			adminHp=hp1+"-"+hp2+"-"+hp3;
		} 

		AdminService service=new AdminService();
		AdminVO vo=new AdminVO();
		vo.setAdminId(adminId);
		vo.setAdminName(adminName);
		vo.setAdminPwd(adminPwd);
		vo.setAdminHp(adminHp);

		String msg="회원등록에 실패하셨습니다.", url=""; //어드민 인덱스페이지 설정
		try {
			int cnt=service.insertAdmin(vo);
			if(cnt>0) {
				msg="회원등록에 성공하셨습니다.";
				url="/grit/grit/index.do";
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//3.
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		//4.

		return "/grit/common/message.jsp";
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

}
