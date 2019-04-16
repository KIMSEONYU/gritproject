package com.grit.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.member.model.MemberService;

public class ChangePwdController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) {
		//받아온 비밀번호를 통해 비밀번호 변경작업
		//1. 받아온 비밀번호가 맞는지 확인
		String memUserid=(String) request.getSession().getAttribute("memUserid");
		String currentPwd=request.getParameter("currentPwd");
		String newPwd=request.getParameter("newPwd");
		System.out.println("memUserid="+memUserid);
		//로그인된 경우만 처리되도록
		
		if(memUserid==null||memUserid.isEmpty()) {
			request.setAttribute("msg", "먼저 로그인하세요");
			request.setAttribute("url", "/grit/grit/index.do");
			return "/grit/common/message.jsp";
		}
		
		String msg="", url="/grit/grit/index.do";
		MemberService service=new MemberService();
		try {
			int result=service.procMLogin(memUserid, currentPwd);
			if(result==1) {
				//비밀번호가 일치한 경우
				//새로 입력받은 비밀번호로 update
				int cnt=service.changePwdMember(memUserid, newPwd);
				if(cnt>0) {
					msg="비밀번호가 성공적으로 변경되었습니다.";
				}else {
					msg="비밀번호 변경에 실패하셨습니다.";
				}
			}else if(result==2) {
				//비밀번호가 불일치 한경우
				msg="현재 비밀번호가 일치하지 않습니다.";
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/grit/common/message.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
