package com.grit.member.model;

import java.sql.SQLException;

public class MemberService {
	private MemberDAO memberDao;
	
	//아이디 중복확인시 사용하는 fianl 변수
	public static final int AVAILABLE_USERID=1;//중복확인시 사용가능한 아이디
	public static final int NOT_AVAILABLE_USERID=2;//중복확인시 사용 불가능한 아이디
	
	//로그인 처리시 사용하는 final 변수
	public static final int LOGIN_OK=1;//로그인 성공	
	public static final int DISAGREE_PWD=2;//비밀번호 불일치
	public static final int NONE_ID=3;//아이디가 존재하지 않음
	
	public MemberService() {
		memberDao=new MemberDAO();
	}
	public int insertMember(MemberVO vo) throws SQLException {
		return memberDao.insertMember(vo);
	}
	public int duplicateMUseid(String memUserid) throws SQLException {
		return memberDao.duplicateMUseid(memUserid);
	}
	public int procMLogin(String memUserid, String memPwd) throws SQLException {
		return memberDao.procMLogin(memUserid, memPwd);
	}
	public MemberVO selectMember(String memUserid) throws SQLException {
		return memberDao.selectMember(memUserid);
	}
	public int editMember(MemberVO vo) throws SQLException {
		return memberDao.editMember(vo);
	}
	public int withdrawMember(String memUserid) throws SQLException {
		return memberDao.withdrawMember(memUserid);
	}
	public int changePwdMember(String memUserid, String newPwd) throws SQLException {
		return memberDao.changePwdMember(memUserid, newPwd);
	}
}
