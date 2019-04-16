package com.grit.company.member.model;

import java.sql.Timestamp;

public class CMemberVO {
	private String compUserid;
	private int mgNo;
	private String compNickname;
	private String compPassword;
	private String compUsername;
	private String compPhone;
	private String compHp;
	private String compFax;
	private String compEmail;
	private int compNo;
	private Timestamp compJoindate;
	private Timestamp compOutdate;
	
	public CMemberVO() {
		super();
	}

	public CMemberVO(String compUserid, int mgNo, String compNickname, String compPassword, String compUsername,
			String compPhone, String compHp, String compFax, String compEmail, int compNo, Timestamp compJoindate,
			Timestamp compOutdate) {
		super();
		this.compUserid = compUserid;
		this.mgNo = mgNo;
		this.compNickname = compNickname;
		this.compPassword = compPassword;
		this.compUsername = compUsername;
		this.compPhone = compPhone;
		this.compHp = compHp;
		this.compFax = compFax;
		this.compEmail = compEmail;
		this.compNo = compNo;
		this.compJoindate = compJoindate;
		this.compOutdate = compOutdate;
	}

	public String getCompUserid() {
		return compUserid;
	}

	public void setCompUserid(String compUserid) {
		this.compUserid = compUserid;
	}

	public int getMgNo() {
		return mgNo;
	}

	public void setMgNo(int mgNo) {
		this.mgNo = mgNo;
	}

	public String getCompNickname() {
		return compNickname;
	}

	public void setCompNickname(String compNickname) {
		this.compNickname = compNickname;
	}

	public String getCompPassword() {
		return compPassword;
	}

	public void setCompPassword(String compPassword) {
		this.compPassword = compPassword;
	}

	public String getCompUsername() {
		return compUsername;
	}

	public void setCompUsername(String compUsername) {
		this.compUsername = compUsername;
	}

	public String getCompPhone() {
		return compPhone;
	}

	public void setCompPhone(String compPhone) {
		this.compPhone = compPhone;
	}

	public String getCompHp() {
		return compHp;
	}

	public void setCompHp(String compHp) {
		this.compHp = compHp;
	}

	public String getCompFax() {
		return compFax;
	}

	public void setCompFax(String compFax) {
		this.compFax = compFax;
	}

	public String getCompEmail() {
		return compEmail;
	}

	public void setCompEmail(String compEmail) {
		this.compEmail = compEmail;
	}

	public int getCompNo() {
		return compNo;
	}

	public void setCompNo(int compNo) {
		this.compNo = compNo;
	}

	public Timestamp getCompJoindate() {
		return compJoindate;
	}

	public void setCompJoindate(Timestamp compJoindate) {
		this.compJoindate = compJoindate;
	}

	public Timestamp getCompOutdate() {
		return compOutdate;
	}

	public void setCompOutdate(Timestamp compOutdate) {
		this.compOutdate = compOutdate;
	}

	@Override
	public String toString() {
		return "CMemberVO [compUserid=" + compUserid + ", mgNo=" + mgNo + ", compNickname=" + compNickname + ", compPassword="
				+ compPassword + ", compUsername=" + compUsername + ", compPhone=" + compPhone + ", compHp=" + compHp
				+ ", compFax=" + compFax + ", compEmail=" + compEmail + ", compNo=" + compNo + ", compJoindate="
				+ compJoindate + ", compOutdate=" + compOutdate + "]";
	}
}
