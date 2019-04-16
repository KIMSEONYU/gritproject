package com.grit.notice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.grit.db.ConnectionPoolMgr2;

public class NoticeDAO {
	ConnectionPoolMgr2 pool;

	public NoticeDAO() {
		pool = new ConnectionPoolMgr2();
	}


	public int insertNotice(NoticeVO vo) throws SQLException{
		//글쓰기
		Connection con = null;
		PreparedStatement ps = null;

		try {
			//[1][2] 드라이버 로딩, db서버에 연결하기 위한 Connection객체 생성
			con = pool.getConnection();
			
			//[3]sql문장을 처리할 PreparedStatement객체 생성
			String sql="insert into notice(NOTI_NO, NOTI_TITLE, ADMIN_ID, NOTI_CONTENT, NOTI_CATEGORY)" + 
					" values(NOTICE_seq.nextval,?,?,?,?)";
			ps=con.prepareStatement(sql);
			//in parameter setting
			ps.setString(1, vo.getNotiTitle());
			ps.setString(2, vo.getAdminId());
			ps.setString(3, vo.getNotiContent());
			ps.setString(4, vo.getNotiCategory());
			//[4]
			int cnt = ps.executeUpdate();
			System.out.println("글쓰기 결과 cnt="+cnt+", 입력값 vo=" +vo);

			return cnt;

		}finally{
			pool.dbClose(ps, con);
		}

	}

	public List<NoticeVO> selectAllNotice() throws SQLException {
		//keyword와 condition 작업
		//newimgterm 작업
		//readcount 작업
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<NoticeVO> list = new ArrayList<>();
		try {
			//[1][2]con
			con=pool.getConnection();

			//[3]ps
			String sql="select noti_no,noti_title,admin_id,noti_content,noti_regdate,noti_filename," + 
					" noti_filesize,noti_ofilename,noti_downcnt,noti_readcnt,noti_category,noti_delfalg," + 
					" (sysdate-noti_regdate)*24 as newImgTerm from notice"
					+ " order by noti_no desc";
			ps=con.prepareStatement(sql);
			//[4]exec
			rs=ps.executeQuery();
			while(rs.next()) {
				int notiNo=rs.getInt("noti_No");
				String notiTitle=rs.getString("noti_Title");
				String adminId=rs.getString("admin_Id");
				String notiContent=rs.getString("noti_Content");
				String notiCategory=rs.getString("noti_Category");
				Timestamp notiRegdate=rs.getTimestamp("noti_Regdate");
				String notiFileName=rs.getString("noti_fileName");
				int notiFileSize=rs.getInt("noti_filesize");
				String notiOFileName=rs.getString("noti_ofilename");
				int notiDownCnt=rs.getInt("noti_downcnt");
				int notiReadCnt=rs.getInt("noti_readcnt");
				String notiDelflag=rs.getString("noti_delfalg");

				int newImgTerm=rs.getInt("newImgTerm");
				
				NoticeVO vo=new NoticeVO(notiNo, notiTitle, adminId, notiContent, notiRegdate, 
						notiFileName, notiFileSize, notiOFileName, notiDownCnt, notiReadCnt, 
						notiCategory, notiDelflag, newImgTerm);

				list.add(vo);

			}
			System.out.println("전체 글 조회 결과 list.size="+list.size());
			return list;

		}finally {
			pool.dbClose(rs, ps, con);
		}
	}

	public NoticeVO selectByNoNotice(int notiNo) throws SQLException{
		//no에 해당하는 글 조회
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		NoticeVO vo = new NoticeVO();

		try {
			//[1][2]con
			con=pool.getConnection();

			//[3] ps
			String sql="select * from notice where noti_No=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, notiNo);

			//[4] exec
			rs=ps.executeQuery();
			if(rs.next()) {
				vo.setNotiNo(rs.getInt("noti_no"));
				vo.setNotiTitle(rs.getString("noti_Title"));
				vo.setAdminId(rs.getString("admin_Id"));
				vo.setNotiContent(rs.getString("noti_content"));
				vo.setNotiRegdate(rs.getTimestamp("noti_Regdate"));
				vo.setNotiFileName(rs.getString("noti_filename"));
				vo.setNotiFileSize(rs.getInt("noti_filesize"));
				vo.setNotiOFileName(rs.getString("noti_ofilename"));
				vo.setNotiDownCnt(rs.getInt("noti_downcnt"));
				vo.setNotiReadCnt(rs.getInt("noti_readcnt"));
				vo.setNotiCategory(rs.getString("noti_category"));
				vo.setNotiDelfalg(rs.getString("noti_Delfalg"));
			}
			System.out.println("상세글 조회 결과 vo="+vo+", 입력값 no="+notiNo);
			return vo;
		}finally{
			pool.dbClose(rs, ps, con);
		}
	}
}