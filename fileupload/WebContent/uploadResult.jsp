<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// file upload 요청이 있는지 확인하기
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	if(isMultipart){
		// 전송된 파일을 디스크에 저장하기 위한 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 업로드 가능 사이즈 지정
		upload.setSizeMax(2000*1024); // 작은 크기임
		
		// 사용자의 request 담기 / 구문분석
		List<FileItem> fileItems = upload.parseRequest(request);
		
		String fieldName = null, fileName = null, value = null;
		
		Iterator<FileItem> iter = fileItems.iterator();
		while(iter.hasNext()){
			FileItem item = iter.next();
			
			if(item.isFormField()){
				fieldName = item.getFieldName();
				value = item.getString("utf-8");
				out.print("<h3>일반 데이터</h3>");
				out.print(fieldName+" : "+value+"<br>");
			}else {
				fieldName = item.getFieldName();
				fileName = item.getName();
				long size = item.getSize();
				
				out.print("<h3>파일 데이터</h3>");
				out.print(fieldName+" : "+value+"<br>");
				out.print("파일 크기 : "+size);
				
				// 서버에 저장
				if(!fileName.isEmpty()){
					String path = "d:\\upload";
					// 동일한 파일명이 들어올 경우 처리하기
					// 중복되지 않는 고유한 키 값 설정 (범용 고유 식별자이기 때문에 다른 프로그램에도 존재)
					UUID uuid = UUID.randomUUID();
					
					File uploadFile = new File(path+"\\"+uuid.toString()+"_"+fileName);
					item.write(uploadFile); // 서버에 저장
					
					// 파일 다운로드를 위한 경로 설정
					out.print("<p>");
					out.print("<a href='download.jsp?fileName="+uploadFile.getName()+"'>"+fileName+"</a>");
					out.print("</p>");
				}
			}
		}
	}
%>