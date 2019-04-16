package com.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Properties props;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
		String configFile=config.getInitParameter("configFile");

		System.out.println("configFile= "+configFile);
		
	
		String realConfigFile=config.getServletContext().getRealPath(configFile);
		System.out.println("realConfigFile= "+realConfigFile);
		

		//realConfigFile="D:\\down\\lecture\\gritlocal\\gritproject\\grit\\WebContent\\grit\\config\\CommandPro.properties";
		//realConfigFile="D:\\down\\lecture\\gritlocal\\gritproject\\grit\\WebContent\\grit\\config\\CommandPro.properties"; //다운 학원경로
		realConfigFile="C:\\Users\\in440\\git\\gritproject\\grit\\WebContent\\grit\\config\\CommandPro.properties"; //강훈이 노트북 경로
		//realConfigFile="C:\\Users\\pjs3m\\git\\gritproject\\grit\\WebContent\\grit\\config\\CommandPro.properties"; //종석이 노트북경로
		//realConfigFile="C:\\Users\\in440\\git\\gritproject\\grit\\WebContent\\grit\\config\\CommandPro.properties"; //강훈이 노트북 경로
		//realConfigFile="C:\\Users\\user\\Desktop\\gritlocal\\gritproject\\grit\\WebContent\\grit\\config\\CommandPro.properties";
		//realConfigFile="C:\\Users\\jhkim\\grit\\gritproject\\grit\\WebContent\\grit\\config\\CommandPro.properties";
		//realConfigFile="D:\\lecture\\workspace_list\\jsp_ws\\gritproject\\grit\\WebContent\\grit\\config\\CommandPro.properties"; //선유
		System.out.println("realConfigFile="+realConfigFile+"\n\n");
		
	
		props=new Properties();
		
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(realConfigFile);
			props.load(fis);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	
	}


	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("charset=utf-8");

		request.setCharacterEncoding("utf-8");
		
		
		

		String uri=request.getRequestURI();	
		System.out.println("uri= "+uri);
		

		String contextPath=request.getContextPath();
		System.out.println("contextPath="+contextPath);
		System.out.println("uri.indexOf(contextPath)="+uri.indexOf(contextPath));
		
	
		String key="";
		if(uri.indexOf(contextPath)==0) {
			key=uri.substring(contextPath.length());
		}
		System.out.println("key="+key);
		
		String commandStr=props.getProperty(key);	
		
		System.out.println("commandStr="+commandStr+"\n");
		
		try {
			Class commandClass=Class.forName(commandStr);
			
			Controller controller=(Controller)commandClass.newInstance();
			String resultPage=controller.requestProcess(request, response);
			System.out.println("resultPage= "+resultPage+"\n\n");
			
			if(controller.isRedirect()) {
				response.sendRedirect(contextPath+resultPage);
			}else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(resultPage);
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}//
	
	
}
//서블릿 주석삭제완료