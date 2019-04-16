package com.grit.admin.member.model;

import java.sql.SQLException;
import java.util.List;

import com.grit.company.member.model.CMemberVO;
import com.grit.member.model.MemberVO;

public class AdminService {
	private AdminDAO adminDao;
   
	//아이디 중복확인시 사용하는 final변수
   public static final int AVAILABLE_USERID=1; //중복확인시 사용가능한 아이디
   public static final int NOT_AVAILABLE_USERID=2; //중복확인시 사용불가능한 아이디
   
   //로그인 처리시 사용하는 final변수
   public static final int LOGIN_OK=1; //로그인 성공
   public static final int   DISAGREE_PWD=2; //비밀번호 불일치
   public static final int NONE_ID=3; //아이디가 존재하지 않음

	public AdminService() {
		adminDao = new AdminDAO();
	}
	
	public int insertAdmin(AdminVO vo) throws SQLException {//관리자 계정 생성
		return adminDao.insertAdmin(vo);
	}
	
	public int editAdmin(AdminVO vo) throws SQLException {//관리자 계정 수정
		return adminDao.editAdmin(vo);
	}
	
	public int duplicateAdminId(String adminId) throws SQLException {//아이디 중복확인
		return adminDao.duplicateAdminId(adminId);
	}
	
	public int procALogin(String adminId, String adminPwd) throws SQLException {
		return adminDao.procALogin(adminId, adminPwd);
	}
	
	public int withdrawAdmin(String adminId) throws SQLException {
		return adminDao.withdrawAdmin(adminId);
	}
	
	public AdminVO selectMember(String adminId) throws SQLException {
		return adminDao.selectMember(adminId);
	}
	
	public int insertMember(MemberVO vo) throws SQLException {
		return adminDao.insertMember(vo);
	}
	
	public List<MemberVO> selectMemberList() throws SQLException{
		return adminDao.selectMemberList();
	}
	
	public List<CMemberVO> selectComMemberList() throws SQLException{
		return adminDao.selectComMemberList();
	}
	
}
