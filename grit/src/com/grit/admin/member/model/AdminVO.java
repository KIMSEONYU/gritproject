package com.grit.admin.member.model;

import java.sql.Timestamp;

public class AdminVO {
	private String adminId;
	private int mgNo;
	private String adminPwd;
	private String adminName;
	private String adminHp;
	private Timestamp adminJoindate;
	private Timestamp adminOutdate;
	
	public AdminVO() {
		super();
	}
	public AdminVO(String adminId, int mgNo, String adminPwd, String adminName, String adminHp, Timestamp adminJoindate,
			Timestamp adminOutdate) {
		super();
		this.adminId = adminId;
		this.mgNo = mgNo;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
		this.adminHp = adminHp;
		this.adminJoindate = adminJoindate;
		this.adminOutdate = adminOutdate;
	}
	
	
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public int getMgNo() {
		return mgNo;
	}
	public void setMgNo(int mgNo) {
		this.mgNo = mgNo;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminHp() {
		return adminHp;
	}
	public void setAdminHp(String adminHp) {
		this.adminHp = adminHp;
	}
	public Timestamp getAdminJoindate() {
		return adminJoindate;
	}
	public void setAdminJoindate(Timestamp adminJoindate) {
		this.adminJoindate = adminJoindate;
	}
	public Timestamp getAdminOutdate() {
		return adminOutdate;
	}
	public void setAdminOutdate(Timestamp adminOutdate) {
		this.adminOutdate = adminOutdate;
	}
	
	
	@Override
	public String toString() {
		return "AdminVO [adminId=" + adminId + ", mgNo=" + mgNo + ", adminPwd=" + adminPwd + ", adminName=" + adminName
				+ ", adminHp=" + adminHp + ", adminJoindate=" + adminJoindate + ", adminOutdate=" + adminOutdate + "]";
	}
	
	
	

}
