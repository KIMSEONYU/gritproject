package com.grit.login.controller;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.grit.member.model.MemberService;
import com.grit.member.model.MemberVO;

public class LoginController implements Controller{

   @Override
   public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
      //modal창은 index.jsp로 보내야함 대신 controller들을 전부 별개로 만들어줄것!
      //login 처리
      String memUserid=request.getParameter("memUserid");
      String memPwd=request.getParameter("memPwd");
      System.out.println("memUserid="+memUserid+", memPwd="+memPwd);
      
      MemberService service=new MemberService();
      String msg="로그인 처리 실패", url="/grit/grit/index.do";
      try {
         int result=service.procMLogin(memUserid, memPwd);
         if(result==MemberService.LOGIN_OK) {
            MemberVO vo=service.selectMember(memUserid);
            HttpSession session=request.getSession();//세션객체를 request에서 가져오자
            
            //세션에 저장
            session.setAttribute("memUserid", memUserid);
            session.setAttribute("memName", vo.getMemName());
            
            //쿠키에 저장
            Cookie ck=new Cookie("ck_userid", memUserid);
            if(memUserid!=null) {
               ck.setMaxAge(1000*24*60*60);
               ck.setPath("/");
               response.addCookie(ck);
            }else {
               ck.setMaxAge(0);
               ck.setPath("/");
               response.addCookie(ck);
            }
            msg=vo.getMemName()+"님 로그인 되었습니다.";
         }else if(result==MemberService.DISAGREE_PWD) {
            msg="비밀번호가 일치하지 않습니다.";
         }else if(result==MemberService.NONE_ID) {
            msg="해당 아디가 존재하지 않습니다.";
         }
      }catch (SQLException e) {
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