<%@page import="xyz.itwill.dao.MyCommentDAO"%>
<%@page import="xyz.itwill.dto.MyComment1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
MyComment1 comment3 = new MyComment1();
comment3.setCommentId("abc");
comment3.setCommentContent("첫번째 게시글입니다.");
MyCommentDAO.getDAO().insertComment2(comment3);

MyComment1 comment4 = new MyComment1();
comment4.setCommentId("xyz");
comment4.setCommentContent("두번째 게시글입니다.");
MyCommentDAO.getDAO().insertComment2(comment4);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<hr>
	<h3>게시글이 성공적으로 삽입 되었습니다.</h3>
</body>
</html>