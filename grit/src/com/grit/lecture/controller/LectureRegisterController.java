package com.grit.lecture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class LectureRegisterController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//registe.jsp로 포워드
		return "/grit/lecture/lectureRegister.jsp";
	}

	@Override
	public boolean isRedirect() {
		
		return false;
	}

}
