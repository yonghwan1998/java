<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");

	//비로그인 상태의 사용자이거나 로그인 상태의 사용자가 관리자가 아닌 경우 에러메세지를 
	//출력하기 위한 JSP 문서로 이동하도록 URL 주소를 전달하여 응답
	if(loginMember==null || loginMember.getMemberStatus()!=9) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;
	}
--%>
<%@include file="/security/admin_check.jspf"%>
<h1>관리자 메인페이지</h1>