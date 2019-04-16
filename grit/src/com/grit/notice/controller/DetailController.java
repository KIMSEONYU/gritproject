package com.grit.notice.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.notice.model.NoticeService;
import com.grit.notice.model.NoticeVO;

public class DetailController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*/grit/admin/notice/detail.do=>DetailController=>detail.jsp로 포워드*/
		
		//1.
		String notiNo = request.getParameter("notiNo");
		System.out.println(notiNo);
		if(notiNo==null||notiNo.isEmpty()) {
			request.setAttribute("msg", "잘못된 url입니다.");
			request.setAttribute("url", "/grit/grit/notice/list.do");
			
			return "/grit/common/message.jsp";
		}
		
		//2.
		NoticeService service = new NoticeService();
		NoticeVO vo = null;
		try {
			vo=service.selectByNoNotice(Integer.parseInt(notiNo));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println(vo);
		//3.
		request.setAttribute("vo", vo);
		
		//4.
		return "/grit/admin/notice/detail.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
