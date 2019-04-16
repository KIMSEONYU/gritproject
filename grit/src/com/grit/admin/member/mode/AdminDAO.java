package com.grit.admin.member.mode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.grit.db.ConnectionPoolMgr2;

public class AdminDAO {
	private ConnectionPoolMgr2 pool;
	
	public AdminDAO() {
		pool=new ConnectionPoolMgr2();
	}
	
	public int insertAdmin(AdminVO vo) throws SQLException {
		//관리자 계정 생성
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=pool.getConnection();
			
			String sql="";
			ps=con.prepareStatement(sql);
			
			int cnt =ps.executeUpdate();
			System.out.println("회원정보 입력 vo : "+vo+ "입력 결과 cnt : "+cnt);
			return cnt;
		} finally {
			pool.dbClose(ps, con);
		}
	}
	
	
	public int editAdmin(AdminVO vo) throws SQLException {
		//관리자 계정 수정
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=pool.getConnection();
			
			String sql="";
			ps=con.prepareStatement(sql);
			
			
			int cnt=ps.executeUpdate();
			System.out.println("회원수정 입력 vo : "+vo+ "입력 결과 cnt : "+cnt);
			return cnt;
			
		} finally {
			pool.dbClose(ps, con);
		}
	}
	
	
	public int duplicateAdminId(String adminId) throws SQLException {
		//아이디 중복확인
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		try {
			//[1][2] con
			con=pool.getConnection();
			
			//[3] ps
			String sql="select count(*) from admin" + 
					" where admin_Id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, adminId);
			
			//[4] exec
			rs=ps.executeQuery();
			if(rs.next()) {
				int count=rs.getInt(1);
				if(count>0) {
					//해당 아이디가 이미 존재하는 경우
					result=AdminService.NOT_AVAILABLE_USERID; //사용불가
				}else {
					//존재하지 않는 경우
					result=AdminService.AVAILABLE_USERID; //사용가능
				}
			}
			System.out.println("아이디 중복확인 결과 result="+result
					+", 입력값 userid="+adminId);
			
			return result;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}//
	
	
	public int procALogin(String adminId, String adminPwd) throws SQLException {
		//로그인 처리
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		try {
			//[1][2] con
			con=pool.getConnection();
			
			//[3] ps
			String sql="select admin_Pwd from admin "
					+ " where admin_Id=? and admin_Outdate is null";
			ps=con.prepareStatement(sql);
			ps.setString(1, adminId);
			
			//[4] exec
			rs=ps.executeQuery();
			if(rs.next()) {
				String dbPwd=rs.getString(1);
				if(dbPwd.equals(adminPwd)) {
					result=AdminService.LOGIN_OK; //로그인 성공
				}else {
					result=AdminService.DISAGREE_PWD; //비밀번호 불일치
				}
			}else {
				result=AdminService.NONE_ID; //해당 아이디가 존재하지 않음
			}
			
			System.out.println("로그인 처리 결과 result="+result+", 입력값 adminId="
					+adminId+", adminPwd="+adminPwd);
			
			return result;
		}finally {
			pool.dbClose(rs, ps, con);
		}
		
	}//
	
	
	public int withdrawAdmin(String adminId) throws SQLException {
		//회원탈퇴 처리
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=pool.getConnection();
			
			String sql="update admin" + 
					" set admin_Outdate=sysdate" + 
					" where admin_Id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, adminId);
			
			int cnt=ps.executeUpdate();
			System.out.println("회원탈퇴 결과 cnt="+cnt+", 입력값 userid="+adminId);
			
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}//
	
	public AdminVO selectMember(String adminId) throws SQLException {
		//아이디에 해당하는 회원(레코드) 조회하기
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		AdminVO vo=new AdminVO();
		try {
			//[1][2] con
			con=pool.getConnection();
			
			
			//[3] ps
			String sql="select * from admin "
					+ " where admin_Id=? and admin_Outdate is null";
			ps=con.prepareStatement(sql);
			ps.setString(1, adminId);
			
			//[4] exec
			rs=ps.executeQuery();
			if(rs.next()) {
				
			}
			
			System.out.println("회원조회 결과 vo="+vo+", 입력값 userid="+adminId);
			
			return vo;
		}finally {
			pool.dbClose(rs, ps, con);
		}
		
	}
	
	
	
}
