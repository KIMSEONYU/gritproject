package com.grit.notice.model;

import java.sql.SQLException;
import java.util.List;

public class NoticeService {
	
	private NoticeDAO  noticeDao;

	public NoticeService() {
		noticeDao = new NoticeDAO();
	}
	public int insertNotice(NoticeVO vo) throws SQLException{
		return noticeDao.insertNotice(vo);
	}
	public List<NoticeVO> selectAllNotice() throws SQLException {
		return noticeDao.selectAllNotice();
	}
	public NoticeVO selectByNoNotice(int notiNo) throws SQLException{
		return noticeDao.selectByNoNotice(notiNo);
	}
	
	
	
}
