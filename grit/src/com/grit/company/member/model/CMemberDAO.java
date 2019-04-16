package com.grit.company.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grit.company.model.CompanyVO;
import com.grit.db.ConnectionPoolMgr2;

public class CMemberDAO {
	private ConnectionPoolMgr2 pool;
	
	public CMemberDAO() {
		pool=new ConnectionPoolMgr2();
	}
	
	//===회원가입(insert)메서드
	public int insertCMember(CMemberVO Cvo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=pool.getConnection();
			
			String sql="";
			ps=con.prepareStatement(sql);
			
			
			
			
			int cnt=ps.executeUpdate();
			
			return cnt;
			
		}finally {
			pool.dbClose(ps, con);
		}
	}
	//===회원정보 수정(Edit)메서드
	public int editCMember(CMemberVO Cvo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=pool.getConnection();
			
			String sql="";
			ps=con.prepareStatement(sql);
			
			int cnt=ps.executeUpdate();
			
			return cnt;
			
		}finally {
			pool.dbClose(ps, con);
		}
	}
	
	//===회원 리스트 조회(select)메서드
	public List<CMemberVO> cMemberList() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<CMemberVO> list=new ArrayList<>();
		try {
			con=pool.getConnection();
			
			String sql="";
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				CMemberVO Cvo=new CMemberVO();

				list.add(Cvo);
			}
			
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
	
	
	public List<Object> selectCMember(String compUserid) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		CMemberVO Cvo= null;
		CompanyVO ComVo=null;
		List<Object> list=new ArrayList<>();
		try {
			con=pool.getConnection();
			
			String sql="select cm.*,c.* "
					+ " from COMP_MEMBER cm,COMPANY c "
					+ " where cm.comp_no=c.comp_no and cm.user_id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, compUserid);
			
			
			rs=ps.executeQuery();
			if(rs.next()) {
				
				Cvo=new CMemberVO();
				
				Cvo.setCompUserid(rs.getString(1));
				Cvo.setCompNo(rs.getInt(2));
				Cvo.setCompNickname(rs.getString(3));
				Cvo.setCompPassword(rs.getString(4));
				Cvo.setCompUsername(rs.getString(5));
				Cvo.setCompPhone(rs.getString(6));
				Cvo.setCompHp(rs.getString(7));
				Cvo.setCompFax(rs.getString(8));
				Cvo.setCompEmail(rs.getString(9));
				Cvo.setCompNo(rs.getInt(10));
				Cvo.setCompJoindate(rs.getTimestamp(11));
				Cvo.setCompOutdate(rs.getTimestamp(12));
				
				ComVo=new CompanyVO();
				
				ComVo.setCompNo(rs.getInt(13));
				ComVo.setCompName(rs.getString(14));
				ComVo.setCompCeo(rs.getString(15));
				ComVo.setCompNum(rs.getString(16));
				ComVo.setCompZipcode(rs.getString(17));
				ComVo.setCompAddress(rs.getString(18));
				ComVo.setCompAddressDetail(rs.getString(19));
				ComVo.setImgNo(rs.getInt(20));
				ComVo.setCompDeptName(rs.getString(21));
				ComVo.setCompPhone(rs.getString(22));
				ComVo.setCompHp(rs.getString(23));
				ComVo.setCompFax(rs.getString(24));
				ComVo.setCompEmail(rs.getString(25));
				ComVo.setCompSort(rs.getString(26));
				ComVo.setCompContent(rs.getString(27));
				ComVo.setCompHomePage(rs.getString(28));
				ComVo.setCompType(rs.getString(29));
				ComVo.setCompCosdac(rs.getString(30));
				
				list.add(Cvo);
				list.add(ComVo);
				
			}
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
		
	}
	
	//로그인 처리 메서드
	public int duplicateCUserid(String compUserid) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		try {
			con=pool.getConnection();
			
			String sql="select count(*) from comp_member where comp_userid=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, compUserid);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				int cnt=rs.getInt(1);
				if(cnt>0) {
					result=CMemberService.NOT_AVAILABLE_USERID; //사용불가
				}else{
					result=CMemberService.AVAILABLE_USERID; //사용가능
				}
			}
			System.out.println("아이디 중복 확인 결과 result="+result+", 입력값 userid="+compUserid);
			return result;
		}finally {
			pool.dbClose(ps, con);
		}
	}
	
	// 비밀번호 확인 메서드
	public int procLogin(String compUserid, String compPassword) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		
		try {
			con=pool.getConnection();
			
			String sql="select comp_password from comp_member where comp_userid=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, compUserid);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				String dbPwd=rs.getString(1);
				if(dbPwd.equals(compPassword)) {
					result=CMemberService.LOGIN_OK; //로그인 성공
				}else{
					result=CMemberService.DISAGREE_PWD; //비밀번호 불일치
				}
			}else {
				result=CMemberService.NONE_ID; //해당하는 아이디도 없으면
			}
			
			System.out.println("로그인 처리 결과 result="
						+result+", 입력값 userid="+compUserid+", pwd="+compPassword);
			return result;
			
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}
}
