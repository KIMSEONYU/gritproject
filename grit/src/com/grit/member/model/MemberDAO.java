package com.grit.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.grit.db.ConnectionPoolMgr2;

public class MemberDAO {
	private ConnectionPoolMgr2 pool;
	public MemberDAO() {
		pool=new ConnectionPoolMgr2();
	}
	public int insertMember(MemberVO vo) throws SQLException {
		//회원 가입 처리
		//수정해야함
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=pool.getConnection();
			String sql="insert" + 
					" into member(mem_userid,mem_no,mem_pwd,mem_name,mem_nickname,mem_email,mem_hp,mem_intro)" + 
					" values(?,member_seq.nextval,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getMemUserid());
			ps.setString(2, vo.getMemPwd());
			ps.setString(3, vo.getMemName());
			ps.setString(4, vo.getMemNickname());
			ps.setString(5, vo.getMemEmail());
			ps.setString(6, vo.getMemHp());
			ps.setString(7, vo.getMemIntro());

			int cnt=ps.executeUpdate();
			System.out.println("cnt="+cnt);
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}//
	public int duplicateMUseid(String memUserid) throws SQLException {
		//아이디 중복확인
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		try {
			//[1][2] con
			con=pool.getConnection();
			//[3] ps
			String sql="select count(*) from member where mem_userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, memUserid);
			//[4] exec
			rs=ps.executeQuery();

			if(rs.next()) {
				int count=rs.getInt(1);
				if(count>0) {
					//해당 아이디가 이미 존재하는 경우
					result=MemberService.NOT_AVAILABLE_USERID;//사용불가
				}
				else {
					//존재하지 않는 경우
					result=MemberService.AVAILABLE_USERID;//사용가능
				}
			}
			System.out.println("아이디 중복확인 결과 result="+result+", 입력값 memUserid="+memUserid);
			return result;
		}
		finally {
			pool.dbClose(rs, ps, con);
		}
	}//

	public int procMLogin(String memUserid, String memPwd) throws SQLException {
		//로그인 처리
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;      
		try {
			con=pool.getConnection();
			String sql="select mem_pwd from member where mem_userid=? and mem_outdate is null";
			ps=con.prepareStatement(sql);
			ps.setString(1, memUserid);

			rs=ps.executeQuery();
			if(rs.next()) {
				String dbPwd=rs.getString(1);
				if(dbPwd.equals(memPwd)) {
					result=MemberService.LOGIN_OK;   //로그인 성공            
				}
				else {
					result=MemberService.DISAGREE_PWD;   //비밀번호가 다름         
				}
			}
			else {
				result=MemberService.NONE_ID;   //mem_userid 없음
			}
			System.out.println("로그인 처리 결과 result="+result+", 입력값 userid="+memUserid+", pwd="+memPwd);
			return result;
		}
		finally {
			pool.dbClose(rs, ps, con);
		}
	}//

	public MemberVO selectMember(String memUserid) throws SQLException {
		//아이디에 해당하는 회원 (레코드) 조회하기 - 멤버구분코드 넣어야할지 확인해야함.
		//수정해야함
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=pool.getConnection();
			String sql="select * from member where mem_userid=? and mem_outdate is null";
			ps=con.prepareStatement(sql);
			ps.setString(1, memUserid);
			rs=ps.executeQuery();

			MemberVO vo=new MemberVO();
			System.out.println("selectMember메서드 입력값(memUserid):"+memUserid);
			if(rs.next()) {
				vo.setMemUserid(rs.getString("mem_userid"));
				vo.setMgCode(rs.getString("mg_code"));
				vo.setMemNo(rs.getInt("mem_no"));
				vo.setMemPwd(rs.getString("mem_pwd"));
				vo.setMemName(rs.getString("mem_name"));
				vo.setMemNickname(rs.getString("mem_nickname"));
				vo.setMemEmail(rs.getString("mem_email"));
				vo.setMemJoindate(rs.getTimestamp("mem_joindate"));
				vo.setMemOutdate(rs.getTimestamp("mem_outdate"));
				vo.setMemHp(rs.getString("mem_hp"));
				vo.setMemPicture(rs.getString("mem_picture"));
				vo.setCgNo(rs.getInt("cg_no"));
				vo.setMemIntro(rs.getString("mem_intro"));
			}
			System.out.println("vo="+vo+", userid="+memUserid);
			return vo;
		}
		finally {
			pool.dbClose(rs, ps, con);
		}
	}//

	public int editMember(MemberVO vo) throws SQLException {
		//회원 수정하기
		//수정해야함
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=pool.getConnection();
			String sql="";
			ps=con.prepareStatement(sql);

			int cnt=ps.executeUpdate();
			System.out.println("cnt="+cnt+", vo="+vo);

			return cnt;
		}
		finally {
			pool.dbClose(ps, con);
		}
	}

	public int withdrawMember(String memUserid) throws SQLException {
		//회원 탈퇴 처리
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=pool.getConnection();

			String sql="update member"
					+ " set mem_outdate=sysdate"
					+ " where mem_userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, memUserid);
			int cnt=ps.executeUpdate();
			System.out.println("cnt="+cnt+"userid"+memUserid);
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}//
	public int changePwdMember(String memUserid, String newPwd) throws SQLException {
		//비밀번호 업데이트
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;     
		try {
			con=pool.getConnection();
			String sql="update member"
					+ " set mem_pwd=?"
					+ " where mem_userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, newPwd);
			ps.setString(2, memUserid);

			int cnt=ps.executeUpdate();
			System.out.println("비밀번호 변경 처리 결과 result="+cnt+", 입력값 userid="+memUserid+", pwd="+newPwd);
			return cnt;
		}
		finally {
			pool.dbClose(rs, ps, con);
		}
	}
}