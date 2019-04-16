package com.grit.lecture.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.lecture.model.LectureService;
import com.grit.lecture.model.LectureVO;
import com.grit.member.model.MemberService;
import com.grit.member.model.MemberVO;

public class LectureDetailController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String cNo=request.getParameter("cNo");
		if(cNo==null||cNo.isEmpty()) {
			request.setAttribute("msg", "잘못된 url");
			request.setAttribute("url", "/grit/grit/index.do");
			
			return "/grit/common/message.jsp";
		}
		
		LectureVO vo=null;
		MemberVO memvo=null;
		LectureService service=new LectureService();
		MemberService memberService=new MemberService();
		try {
			vo=service.selectClassByNo(Integer.parseInt(cNo));
			try {
				memvo=memberService.selectMember(vo.getMemUserid());
				if(memvo.getMemNickname()==null||memvo.getMemNickname().isEmpty()) {
					memvo.setMemNickname(memvo.getMemName());
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("vo",vo);
		request.setAttribute("memvo", memvo);
		System.out.println("vo="+vo);
		
		return "/grit/lecture/lectureDetail.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
