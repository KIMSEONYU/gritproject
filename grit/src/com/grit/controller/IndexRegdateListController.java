package com.grit.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.lecture.model.LectureService;
import com.grit.lecture.model.LectureVO;

public class IndexRegdateListController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		LectureService lectureService=new LectureService();
		List<LectureVO> list=null;
		try {
			list=lectureService.selectRegdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/grit/index.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
	
}
