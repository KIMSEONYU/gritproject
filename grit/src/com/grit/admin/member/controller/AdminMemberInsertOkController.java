package com.grit.admin.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.member.model.MemberService;
import com.grit.member.model.MemberVO;

public class AdminMemberInsertOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String memUserid=request.getParameter("memUserid");
		String memPwd=request.getParameter("memPwd");
		String memName=request.getParameter("memName");
		String memHp=request.getParameter("memHp");
		
		MemberService service=new MemberService();
		MemberVO vo=new MemberVO();
		
		vo.setMemName(memName);
		vo.setMemUserid(memUserid);
		vo.setMemPwd(memPwd);
		vo.setMemHp(memHp);
		
		String msg="회원등록에 실패하셨습니다.", url="/grit/grit/index.do";
		try {
			int cnt=service.insertMember(vo);
			if(cnt>0) {
				msg="회원등록에 성공하셨습니다.";
				url="/adminPage/adminIndex.do";
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
		return false;
	}

}
