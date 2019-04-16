package com.grit.company.model;

public class CompanyVO {
	private int compNo;
	private String compName;
	private String compCeo;
	private String compNum;
	private String compZipcode;
	private String compAddress;
	private String compAddressDetail;
	private int imgNo;
	private String compDeptName;
	private String compPhone;
	private String compHp;
	private String compFax;
	private String compEmail;
	private String compSort;
	private String compContent;
	private String compHomePage;
	private String compType;
	private String compCosdac;
	
	public CompanyVO() {
		super();
	}

	public CompanyVO(int compNo, String compName, String compCeo, String compNum, String compZipcode,
			String compAddress, String compAddressDetail, int imgNo, String compDeptName, String compPhone,
			String compHp, String compFax, String compEmail, String compSort, String compContent, String compHomePage,
			String compType, String compCosdac) {
		super();
		this.compNo = compNo;
		this.compName = compName;
		this.compCeo = compCeo;
		this.compNum = compNum;
		this.compZipcode = compZipcode;
		this.compAddress = compAddress;
		this.compAddressDetail = compAddressDetail;
		this.imgNo = imgNo;
		this.compDeptName = compDeptName;
		this.compPhone = compPhone;
		this.compHp = compHp;
		this.compFax = compFax;
		this.compEmail = compEmail;
		this.compSort = compSort;
		this.compContent = compContent;
		this.compHomePage = compHomePage;
		this.compType = compType;
		this.compCosdac = compCosdac;
	}

	public int getCompNo() {
		return compNo;
	}

	public void setCompNo(int compNo) {
		this.compNo = compNo;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompCeo() {
		return compCeo;
	}

	public void setCompCeo(String compCeo) {
		this.compCeo = compCeo;
	}

	public String getCompNum() {
		return compNum;
	}

	public void setCompNum(String compNum) {
		this.compNum = compNum;
	}

	public String getCompZipcode() {
		return compZipcode;
	}

	public void setCompZipcode(String compZipcode) {
		this.compZipcode = compZipcode;
	}

	public String getCompAddress() {
		return compAddress;
	}

	public void setCompAddress(String compAddress) {
		this.compAddress = compAddress;
	}

	public String getCompAddressDetail() {
		return compAddressDetail;
	}

	public void setCompAddressDetail(String compAddressDetail) {
		this.compAddressDetail = compAddressDetail;
	}

	public int getImgNo() {
		return imgNo;
	}

	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}

	public String getCompDeptName() {
		return compDeptName;
	}

	public void setCompDeptName(String compDeptName) {
		this.compDeptName = compDeptName;
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

	public String getCompSort() {
		return compSort;
	}

	public void setCompSort(String compSort) {
		this.compSort = compSort;
	}

	public String getCompContent() {
		return compContent;
	}

	public void setCompContent(String compContent) {
		this.compContent = compContent;
	}

	public String getCompHomePage() {
		return compHomePage;
	}

	public void setCompHomePage(String compHomePage) {
		this.compHomePage = compHomePage;
	}

	public String getCompType() {
		return compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}

	public String getCompCosdac() {
		return compCosdac;
	}

	public void setCompCosdac(String compCosdac) {
		this.compCosdac = compCosdac;
	}

	@Override
	public String toString() {
		return "CompanyVO [compNo=" + compNo + ", compName=" + compName + ", compCeo=" + compCeo + ", compNum="
				+ compNum + ", compZipcode=" + compZipcode + ", compAddress=" + compAddress + ", compAddressDetail="
				+ compAddressDetail + ", imgNo=" + imgNo + ", compDeptName=" + compDeptName + ", compPhone=" + compPhone
				+ ", compHp=" + compHp + ", compFax=" + compFax + ", compEmail=" + compEmail + ", compSort=" + compSort
				+ ", compContent=" + compContent + ", compHomePage=" + compHomePage + ", compType=" + compType
				+ ", compCosdac=" + compCosdac + "]";
	}
	
	
	
}
