package com.grit.lecture.controller;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.lecture.model.LectureService;
import com.grit.lecture.model.LectureVO;

public class LectureRegisterOkController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String memUserid=(String) request.getSession().getAttribute("memUserid");
		System.out.println("memUserid="+memUserid);
		//로그인된 경우만 처리되도록
		if(memUserid==null||memUserid.isEmpty()) {
			request.setAttribute("msg", "먼저 로그인하세요");
			request.setAttribute("url", "/grit/grit/index.do");
			return "/grit/common/message.jsp";
		}
		String cName=request.getParameter("cName");
		String cTeacherIntro=request.getParameter("cTeacherIntro");
		String cSummary=request.getParameter("cSummary");
		String cDetail=request.getParameter("cDetail");
		String cDate=request.getParameter("cDate");
		String cLine=request.getParameter("cLine");
		int cTime=Integer.parseInt(request.getParameter("cTime")); //시간 int 로 변환해서 문자열 사이에 넣을생각
		String cLocation=request.getParameter("cLocation");
		String cMaxPerson=request.getParameter("cMaxPerson");
		String cPay=request.getParameter("cPay");
		String cMoney=request.getParameter("cMoney");
		String cAccount=request.getParameter("cAccount");
		String cBank=request.getParameter("cBank");
		if(cLine.equals("오후")) {
			cTime+=12;
			if(cTime==24) {
				cTime=0;
			}
		}
		String ctime="";
		if(cTime<10) {
			ctime="0"+cTime;
		}else {
			ctime=" "+cTime;
		}
		cDate+=" "+ctime+":00:00";
		
		String msg="등록 실패", url="/grit/grit/lecture/lectureRegister.do";
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d=sdf.parse(cDate);
			Timestamp totalCdate=new Timestamp(d.getTime()); //최종 db에 들어갈 날짜,시간
			
			LectureVO vo=new LectureVO();
			vo.setcName(cName);
			vo.setcTeacherIntro(cTeacherIntro);
			vo.setcSummary(cSummary);
			vo.setcDetail(cDetail);
			vo.setcDate(totalCdate);
			vo.setcLocation(cLocation);
			vo.setcMaxPerson(Integer.parseInt(cMaxPerson));
			vo.setcPay(cPay);
			vo.setcMoney(Integer.parseInt(cMoney));
			vo.setcAccount(cAccount);
			vo.setcBank(cBank);
			vo.setMemUserid(memUserid);
			vo.setcCategory("강의");
			LectureService service=new LectureService();
			System.out.println(vo);
			try {
				int cnt=service.insertClass(vo);
				if(cnt>0) {
					msg="등록 성공";
					url="/grit/grit/index.do";
				}
			}catch (SQLException e) {
				e.printStackTrace();
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
