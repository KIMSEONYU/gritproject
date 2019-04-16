package com.grit.notice.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.notice.model.NoticeService;
import com.grit.notice.model.NoticeVO;

public class RegisterOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		/*글쓰기 처리 페이지
		/grit/admin/notice/register_ok.do=RegisterOkController => message.jsp로 포워드*/
		
		//1.
		String notiTitle = request.getParameter("noti_title");
		String adminId ="admin";
		//String adminId = request.getParameter("adminId");
		String notiContent = request.getParameter("noti_content");
		String notiCategory = request.getParameter("noti_category");
		System.out.println("noti_title="+notiTitle);
		
		//2.
		NoticeService service = new NoticeService();
		NoticeVO vo = new NoticeVO();
		vo.setAdminId(adminId);
		vo.setNotiCategory(notiCategory);
		vo.setNotiTitle(notiTitle);
		vo.setNotiContent(notiContent);
		
		String msg="공지사항 등록 실패", url="/grit/grit/admin/notice/register.do";
		try {
			int cnt=service.insertNotice(vo);
			if(cnt>0) {
				msg="공지사항 등록이 되었습니다.";
				url="/grit/grit/admin/notice/list.do";
			}
		}catch(SQLException e){
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
