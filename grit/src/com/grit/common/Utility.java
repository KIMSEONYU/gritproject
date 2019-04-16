package com.grit.common;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContext;

public class Utility {
	//자료실 - 파일 업로드 경로
	public static final String SAVE_DIR="pds_upload";
	public static final String TEST_DIR
	="D:\\down\\lecture\\workspace_list\\jsp_ws\\herbmall\\WebContent\\pds_upload";
	
	//관리자 페이지 - 상품이미지 파일 경로
	public static final String IMAGE_DIR="pd_images";
	public static final String IMAGE_TEST_DIR
	="D:\\down\\lecture\\workspace_list\\jsp_ws\\mymvc\\WebContent\\pd_images";
	
	public static String displayRe(int step) {
		//답변글인 경우 단계별로 re 이미지 보여주기
		String result="";
		if(step>0){
			for(int j=0;j<step;j++){
				result+="&nbsp;";
			}	
			result+="<img alt='답변에 대한 이미지' src='../images/re.gif'>";
		}//if	
		return result;
	}//
	public static String cutString(String title, int len) {
		//제목이 긴 경우 일부만 보여주기
		String result=title;
		if(title.length()>len) {
			result=title.substring(0,len)+"...";	
		}
		return result;
	}//
	
	public static String displayNew(Timestamp regdate) {
		Date d=new Date();
		long term=(d.getTime()-regdate.getTime())/(1000*60*60);
		String result="";
		if(term<24) {
			result="&nbsp;<img src='../images/new.gif'";
		}
		return result;	
	}//

	public static String displayFile(String fileName) {
		String result="";
		if(fileName!=null&&!fileName.isEmpty()) {
			result="<img src='../images/file.gif' alt='파일 이미지'>&nbsp;";
		}
		return result;
	}//
	
	public static String displayFileInfo(String fileName, long fileSize) {
		String result="";
		if(fileName!=null&&!fileName.isEmpty()) {
			fileSize=fileSize/1024;	//kb로 변환
			result="<img src='../images/file.gif' alt='파일 이미지'>&nbsp;";
			result+=fileName+" ("+fileSize+"KB)";
		}
		return result;
	}//
}
