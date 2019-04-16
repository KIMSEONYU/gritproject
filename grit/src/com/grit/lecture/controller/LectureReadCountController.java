package com.grit.lecture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.lecture.model.LectureService;

public class LectureReadCountController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String cNo=request.getParameter("cNo");
		
		if(cNo==null||cNo.isEmpty()) {
			request.setAttribute("msg", "잘못된 url");
			request.setAttribute("url", "/grit/grit/index.do");
			return "/grit/common/message.jsp";
		}
		LectureService service=new LectureService();
		int cnt=0;
		String msg="조회수 증가 실패",url="/grit/grit/index.do";
		try {
			cnt=service.updateReadCount(Integer.parseInt(cNo));
			System.out.println("조회수 증가 결과cnt="+cnt);
			if(cnt>0) {
				url="/grit/grit/lecture/lectureDetail.do?cNo="+cNo;
			}else {
				msg="조회수 증가 실패";
				url="/grit/grit/index.do";
			}
		}catch (Exception e) {
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
