package com.grit.member.model;

import java.sql.Timestamp;

public class MemberVO {
	private String memUserid;//개인회원아이디
	private String mgCode;//멤버구분코드
	private int memNo;//회원번호
	private String memPwd;//비밀번호
	private String memName;//이름
	private String memNickname;//닉네임
	private String memEmail;//이메일
	private Timestamp memJoindate;//가입일
	private Timestamp memOutdate;//탈퇴일
	private String memHp;//휴대폰번호
	private String memPicture;//회원사진
	private int cgNo;//카테고리번호
	private String memIntro;//자기소개

	public MemberVO() {
		super();
	}

	public MemberVO(String memUserid, String mgCode, int memNo, String memPwd, String memName, String memNickname,
			String memEmail, Timestamp memJoindate, Timestamp memOutdate, String memHp, String memPicture, int cgNo,
			String memIntro) {
		super();
		this.memUserid = memUserid;
		this.mgCode = mgCode;
		this.memNo = memNo;
		this.memPwd = memPwd;
		this.memName = memName;
		this.memNickname = memNickname;
		this.memEmail = memEmail;
		this.memJoindate = memJoindate;
		this.memOutdate = memOutdate;
		this.memHp = memHp;
		this.memPicture = memPicture;
		this.cgNo = cgNo;
		this.memIntro = memIntro;
	}

	public String getMemUserid() {
		return memUserid;
	}

	public void setMemUserid(String memUserid) {
		this.memUserid = memUserid;
	}

	public String getMgCode() {
		return mgCode;
	}

	public void setMgCode(String mgCode) {
		this.mgCode = mgCode;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public Timestamp getMemJoindate() {
		return memJoindate;
	}

	public void setMemJoindate(Timestamp memJoindate) {
		this.memJoindate = memJoindate;
	}

	public Timestamp getMemOutdate() {
		return memOutdate;
	}

	public void setMemOutdate(Timestamp memOutdate) {
		this.memOutdate = memOutdate;
	}

	public String getMemHp() {
		return memHp;
	}

	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}

	public String getMemPicture() {
		return memPicture;
	}

	public void setMemPicture(String memPicture) {
		this.memPicture = memPicture;
	}

	public int getCgNo() {
		return cgNo;
	}

	public void setCgNo(int cgNo) {
		this.cgNo = cgNo;
	}

	public String getMemIntro() {
		return memIntro;
	}

	public void setMemIntro(String memIntro) {
		this.memIntro = memIntro;
	}

	@Override
	public String toString() {
		return "MemberVO [memUserid=" + memUserid + ", mgCode=" + mgCode + ", memNo=" + memNo + ", memPwd=" + memPwd
				+ ", memName=" + memName + ", memNickname=" + memNickname + ", memEmail=" + memEmail + ", memJoindate="
				+ memJoindate + ", memOutdate=" + memOutdate + ", memHp=" + memHp + ", memPicture=" + memPicture
				+ ", cgNo=" + cgNo + ", memIntro=" + memIntro + "]";
	}
	
}
