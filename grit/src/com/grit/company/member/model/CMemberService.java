package com.grit.company.member.model;

public class CMemberService {
	private CMemberDAO cmemberDao;
	
	//아이디 중복확인시 사용하는 final변수
    public static final int AVAILABLE_USERID=1; //중복확인시 사용가능한 아이디
    public static final int NOT_AVAILABLE_USERID=2; //중복확인시 사용불가능한 아이디
   
    //로그인 처리시 사용하는 final변수
    public static final int LOGIN_OK=1; //로그인 성공
    public static final int   DISAGREE_PWD=2; //비밀번호 불일치
    public static final int NONE_ID=3; //아이디가 존재하지 않음

	public void CMemberVO() {
		cmemberDao=new CMemberDAO();
	}
	
}
