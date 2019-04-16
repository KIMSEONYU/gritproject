package com.grit.notice.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.common.PagingVO;
import com.grit.notice.model.NoticeService;
import com.grit.notice.model.NoticeVO;

public class ListController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		NoticeService service=new NoticeService();
		List<NoticeVO> list=null;
		try {
			list=service.selectAllNotice();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		//3.
		request.setAttribute("list", list);

		//4.		
		return "/grit/admin/notice/list.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
