package com.grit.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;
import com.grit.lecture.model.LectureService;
import com.grit.lecture.model.LectureVO;
import com.grit.member.model.MemberService;
import com.grit.member.model.MemberVO;
import com.grit.notice.model.NoticeService;
import com.grit.notice.model.NoticeVO;

public class IndexController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String memUserid=(String) request.getSession().getAttribute("memUserid");
		System.out.println("index session memUserid="+memUserid);
		LectureService lectureService=new LectureService();
		LectureVO cntvo=null;
		List<LectureVO> recommandList=null;
		List<LectureVO> regdateList=null;
		
		try {
			cntvo=lectureService.selectReadCnt();
			recommandList=lectureService.selectRecommand();
			regdateList=lectureService.selectRegdate();
		    
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("cntvo="+cntvo);
		request.setAttribute("cntvo", cntvo);
		
		System.out.println("recommandList="+recommandList);
		request.setAttribute("recommandList", recommandList);
		
		System.out.println("regdateList="+regdateList);
		request.setAttribute("regdateList", regdateList);
		
		//로그인된 경우만 프로필 클릭이 되도록, 공지사항 버튼 클릭되도록
		if(memUserid!=null&&!memUserid.isEmpty()) {
			MemberService memService=new MemberService();
			MemberVO memVo=memService.selectMember(memUserid);
			System.out.println("memVo="+memVo);
			request.setAttribute("memVo", memVo);
			
			NoticeService notiService=new NoticeService();
			List<NoticeVO> notiList=notiService.selectAllNotice();
			System.out.println("notiList="+notiList);
			request.setAttribute("notiList", notiList);
			
			return "/grit/index.jsp";
		}
		
		return "/grit/index.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}

}
