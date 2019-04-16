package com.grit.membergroup.model;

public class MemberGroupVO {
	private String mgCode;
	private String mgName;
	
	public MemberGroupVO() {
		super();
	}

	public MemberGroupVO(String mgCode, String mgName) {
		super();
		this.mgCode = mgCode;
		this.mgName = mgName;
	}

	public String getMgCode() {
		return mgCode;
	}

	public void setMgCode(String mgCode) {
		this.mgCode = mgCode;
	}

	public String getMgName() {
		return mgName;
	}

	public void setMgName(String mgName) {
		this.mgName = mgName;
	}

	@Override
	public String toString() {
		return "MemberGroupVO [mgCode=" + mgCode + ", mgName=" + mgName + "]";
	}
	
}
