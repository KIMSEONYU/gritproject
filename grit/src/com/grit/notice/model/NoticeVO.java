package com.grit.notice.model;

import java.sql.Timestamp;

public class NoticeVO {
	int notiNo;	//공지사항게시글번호
	String notiTitle; //글제목
	String adminId; //관리자아이디
	String notiContent; //글내용
	Timestamp notiRegdate; //등록일
	String notiFileName; //업로드파일명
	int notiFileSize; //파일사이즈
	String notiOFileName; //변경전 업로드 파일명
	int notiDownCnt; //다운수
	int notiReadCnt; //조회수
	String notiCategory; //분야
	String notiDelfalg; //삭제구분 //DB에서는 NOTI_DELFALG로 되어있음 참고.
	
	//new이미지를 위한 변수
	int newImgTerm;
	
	public NoticeVO() {
		super();
	}
	
	public NoticeVO(int notiNo, String notiTitle, String adminId, String notiContent, Timestamp notiRegdate,
			String notiFileName, int notiFileSize, String notiOFileName, int notiDownCnt, int notiReadCnt,
			String notiCategory, String notiDelfalg) {
		super();
		this.notiNo = notiNo;
		this.notiTitle = notiTitle;
		this.adminId = adminId;
		this.notiContent = notiContent;
		this.notiRegdate = notiRegdate;
		this.notiFileName = notiFileName;
		this.notiFileSize = notiFileSize;
		this.notiOFileName = notiOFileName;
		this.notiDownCnt = notiDownCnt;
		this.notiReadCnt = notiReadCnt;
		this.notiCategory = notiCategory;
		this.notiDelfalg = notiDelfalg;
	}
	
	
	public NoticeVO(int notiNo, String notiTitle, String adminId, String notiContent, Timestamp notiRegdate,
			String notiFileName, int notiFileSize, String notiOFileName, int notiDownCnt, int notiReadCnt,
			String notiCategory, String notiDelfalg, int newImgTerm) {
		super();
		this.notiNo = notiNo;
		this.notiTitle = notiTitle;
		this.adminId = adminId;
		this.notiContent = notiContent;
		this.notiRegdate = notiRegdate;
		this.notiFileName = notiFileName;
		this.notiFileSize = notiFileSize;
		this.notiOFileName = notiOFileName;
		this.notiDownCnt = notiDownCnt;
		this.notiReadCnt = notiReadCnt;
		this.notiCategory = notiCategory;
		this.notiDelfalg = notiDelfalg;
		this.newImgTerm = newImgTerm;
	}
	
	public int getNewImgTerm() {
		return newImgTerm;
	}

	public void setNewImgTerm(int newImgTerm) {
		this.newImgTerm = newImgTerm;
	}

	public int getNotiNo() {
		return notiNo;
	}
	public void setNotiNo(int notiNo) {
		this.notiNo = notiNo;
	}
	public String getNotiTitle() {
		return notiTitle;
	}
	public void setNotiTitle(String notiTitle) {
		this.notiTitle = notiTitle;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getNotiContent() {
		return notiContent;
	}
	public void setNotiContent(String notiContent) {
		this.notiContent = notiContent;
	}
	public Timestamp getNotiRegdate() {
		return notiRegdate;
	}
	public void setNotiRegdate(Timestamp notiRegdate) {
		this.notiRegdate = notiRegdate;
	}
	public String getNotiFileName() {
		return notiFileName;
	}
	public void setNotiFileName(String notiFileName) {
		this.notiFileName = notiFileName;
	}
	public int getNotiFileSize() {
		return notiFileSize;
	}
	public void setNotiFileSize(int notiFileSize) {
		this.notiFileSize = notiFileSize;
	}
	public String getNotiOFileName() {
		return notiOFileName;
	}
	public void setNotiOFileName(String notiOFileName) {
		this.notiOFileName = notiOFileName;
	}
	public int getNotiDownCnt() {
		return notiDownCnt;
	}
	public void setNotiDownCnt(int notiDownCnt) {
		this.notiDownCnt = notiDownCnt;
	}
	public int getNotiReadCnt() {
		return notiReadCnt;
	}
	public void setNotiReadCnt(int notiReadCnt) {
		this.notiReadCnt = notiReadCnt;
	}
	public String getNotiCategory() {
		return notiCategory;
	}
	public void setNotiCategory(String notiCategory) {
		this.notiCategory = notiCategory;
	}
	public String getNotiDelfalg() {
		return notiDelfalg;
	}
	public void setNotiDelfalg(String notiDelfalg) {
		this.notiDelfalg = notiDelfalg;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [notiNo=" + notiNo + ", notiTitle=" + notiTitle + ", adminId=" + adminId + ", notiContent="
				+ notiContent + ", notiRegdate=" + notiRegdate + ", notiFileName=" + notiFileName + ", notiFileSize="
				+ notiFileSize + ", notiOFileName=" + notiOFileName + ", notiDownCnt=" + notiDownCnt + ", notiReadCnt="
				+ notiReadCnt + ", notiCategory=" + notiCategory + ", notiDelflag=" + notiDelfalg + ", newImgTerm="
				+ newImgTerm + "]";
	}
}
