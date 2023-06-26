<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if (request.getMethod().equals("GET")) {
	response.sendRedirect("displayStudent.jsp");
	return;
}

request.setCharacterEncoding("utf-8");

int no = Integer.parseInt(request.getParameter("no"));
String name = request.getParameter("name");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String birthday = request.getParameter("birthday");


StudentDTO student = new StudentDTO();
student.setNo(no);
student.setName(name);
student.setPhone(phone);
student.setAddress(address);
student.setBirthday(birthday);

StudentDAO.getDAO().updateStudent(student);

response.sendRedirect("displayStudent.jsp");

%>