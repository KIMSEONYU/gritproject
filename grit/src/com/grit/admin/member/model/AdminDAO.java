package com.grit.admin.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.grit.company.member.model.CMemberVO;
import com.grit.db.ConnectionPoolMgr2;
import com.grit.member.model.MemberVO;

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

			String sql="insert into admin(admin_id,admin_pwd,admin_name,admin_hp)" + 
					" values(?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getAdminId());
			ps.setString(2, vo.getAdminPwd());
			ps.setString(3, vo.getAdminName());
			ps.setString(4, vo.getAdminHp());

			int cnt =ps.executeUpdate();
			System.out.println("관리자 계정 입력 vo : "+vo+ "입력 결과 cnt : "+cnt);
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

			String sql="update admin" + 
					" set admin_pwd=?,admin_name=?,admin_hp=?" + 
					" where admin_id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getAdminPwd());
			ps.setString(2, vo.getAdminName());
			ps.setString(3, vo.getAdminHp());

			int cnt=ps.executeUpdate();
			System.out.println("관리자계정 수정 vo : "+vo+ "입력 결과 cnt : "+cnt);

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

	public int insertMember(MemberVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;


		try {
			con=pool.getConnection();
			String sql="insert" + 
					" into member(mem_userid,mem_no,mem_pwd,mem_name,mem_hp)" + 
					" values(?,member_seq.nextval,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getMemUserid());
			ps.setString(2, vo.getMemPwd());
			ps.setString(3, vo.getMemName());
			ps.setString(4, vo.getMemHp());
		
			int cnt=ps.executeUpdate();
			System.out.println("cnt="+cnt);
			return cnt;

		} finally {
			pool.dbClose(ps, con);
		}
	}
	
	public List<MemberVO> selectMemberList() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ArrayList<MemberVO> list=new ArrayList<>();
		
		try {
			con=pool.getConnection();
			
			String sql="select * from member";
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String memUserid=rs.getString("mem_userid");
				String mgCode=  rs.getString("mg_code");
	            int memNo=rs.getInt("mem_no");
	            String memPwd=rs.getString("mem_pwd");
	            String memName=rs.getString("mem_name");
	            String memNickname= rs.getString("mem_nickname");
	            String memEmail=rs.getString("mem_email");
	            Timestamp memJoindate=rs.getTimestamp("mem_joindate");
	            Timestamp memOutdate=rs.getTimestamp("mem_outdate");
	            String memHp=rs.getString("mem_hp");
	            String memPicture=rs.getString("mem_picture");
	            int cgNo=rs.getInt("cg_no");
	            String memIntro=rs.getString("mem_intro");
	           
	            MemberVO vo=new MemberVO(memUserid, mgCode, memNo, memPwd, memName, memNickname, memEmail, memJoindate, memOutdate, memHp, memPicture, cgNo, memIntro);
	            list.add(vo);
	            
	            System.out.println("vo="+vo+"list.size()="+list.size());
			}
			
			return list;
			
		} finally {
			pool.dbClose(rs, ps, con);
		}
		
	}
	
	public List<CMemberVO> selectComMemberList() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ArrayList<CMemberVO> list=new ArrayList<>();
		
		try {
			con=pool.getConnection();
			
			String sql="select * from Company";
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String compUserid=rs.getString("USER_ID");
				int mgNo=rs.getInt("MG_CODE");
				String compNickname=rs.getString("COMP_NICKNAME");
				String compPassword=rs.getString("COMP_PASSWORD");
				String compUsername=rs.getString("COMP_USERNAME");
				String compPhone=rs.getString("COMP_PHONE");
				String compHp=rs.getString("COMP_HP");
				String compFax=rs.getString("COMP_FAX");
				String compEmail=rs.getString("COMP_EMAIL");
				int compNo=rs.getInt("COMP_NO");
				Timestamp compJoindate=rs.getTimestamp("COMP_JOINDATE");
				Timestamp compOutdate=rs.getTimestamp("COMP_OUTDATE");
	           
				CMemberVO vo=new CMemberVO(compUserid, mgNo, compNickname, compPassword, compUsername, compPhone, compHp, compFax, compEmail, compNo, compJoindate, compOutdate);
				list.add(vo);
	            
	            System.out.println("vo="+vo+"list.size()="+list.size());
			}
			
			return list;
			
		} finally {
			pool.dbClose(rs, ps, con);
		}
		
	}

}
