package com.grit.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.member.model.MemberService;
import com.grit.member.model.MemberVO;

public class RegisterController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1.
		String memName=request.getParameter("memName");
		String memNickname=request.getParameter("memNickname");
		String memUserid=request.getParameter("memUserid");
		String memPwd=request.getParameter("memPwd");
		String memEmail=request.getParameter("memUserid");
		String memHp=request.getParameter("memHp");
		String memIntro=request.getParameter("memIntro");
		if(memNickname==null||memNickname.isEmpty()) {
			memNickname="손님";
		}
		if(memIntro==null||memIntro.isEmpty()) {
			memIntro="안녕하세요.";
		}
		//2.
		MemberService service=new MemberService();
		MemberVO vo=new MemberVO();
		vo.setMemName(memName);
		vo.setMemUserid(memUserid);
		vo.setMemPwd(memPwd);
		vo.setMemEmail(memEmail);
		vo.setMemHp(memHp);
		vo.setMemIntro(memIntro);
		vo.setMemNickname(memNickname);
		
		String msg="회원등록에 실패하셨습니다.", url="/grit/grit/index.do";
		try {
			int cnt=service.insertMember(vo);
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
		return false;
	}

}
