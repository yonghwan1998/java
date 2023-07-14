<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Formatter - 날짜와 시간 변환 태그</h1>
	<hr>
	<%-- 서버 시스템의 현재 날짜와 시간이 저장된 Date 객체를 생성하여 스코프 객체의 속성값으로 저장 --%>
	<c:set var="now" value="<%=new Date()%>" />
	<%-- EL를 이용하여 Date 객체를 제공받아 출력 처리할 경우 toString() 메소드 자동 호출  --%>
	<p>now = ${now }</p>

	<%-- formatDate 태그 : Date 객체에 저장된 날짜와 시간을 원하는 패턴의 문자열로 변환하여 제공하는 태그 --%>
	<%-- => SimpleDateFormat 클래스와 유사한 기능 제공 --%>
	<%-- value 속성 : Date 객체를 속성값으로 설정 - EL를 사용하여 Date 객체를 제공받아 속성값으로 사용 --%>
	<%-- type 속성 : date(날짜), time(시간), both(날짜와 시간) 중 하나를 속성값으로 설정 --%>
	<%-- => type 속성값을 [date]로 설정한 경우 기본적으로 [yyyy.M.d.] 패턴의 문자열로 변환되어 제공 --%>
	<p>
		now(날짜) =
		<fmt:formatDate value="${now }" type="date" />

		<%-- dateStyle 속성 : full 또는 short 중에 하나를 속성값으로 설정 --%>
		<%-- => dateStyle 속성값이 [full]인 경우 [yyyy년 M월 d일 E요일]  패턴의 문자열로 변환되어 제공 --%>
		<%-- => dateStyle 속성값이 [short]인 경우 [yy.M.d.]  패턴의 문자열로 변환되어 제공 --%>
	<p>
		now(날짜) =
		<fmt:formatDate value="${now }" type="date" dateStyle="full" />
	<p>
		now(날짜) =
		<fmt:formatDate value="${now }" type="date" dateStyle="short" />

		<%-- type 속성 : date(날짜), time(시간), both(날짜와 시간) 중 하나를 속성값으로 설정 --%>
		<%-- => type 속성값을 [time]로 설정한 경우 기본적으로 [a h:mm:ss] 패턴의 문자열로 변환되어 제공 --%>
	<p>
		now(시간) =
		<fmt:formatDate value="${now }" type="time" />

		<%-- timeStyle 속성 : full 또는 short 중에 하나를 속성값으로 설정 --%>
		<%-- => timeStyle 속성값이 [full]인 경우 [a h시 mm분 ss초 z]  패턴의 문자열로 변환되어 제공 --%>
		<%-- => timeStyle 속성값이 [short]인 경우 [a h:mm]  패턴의 문자열로 변환되어 제공 --%>
	<p>
		now(시간) =
		<fmt:formatDate value="${now }" type="time" timeStyle="full" />
	<p>
		now(시간) =
		<fmt:formatDate value="${now }" type="time" timeStyle="short" />

		<%-- type 속성 : date(날짜), time(시간), both(날짜와 시간) 중 하나를 속성값으로 설정 --%>
		<%-- => type 속성값을 [both]로 설정한 경우 기본적으로 [yyyy.M.d. a h:mm:ss] 패턴의 문자열로 변환되어 제공 --%>
	<p>
		now(날짜와 시간) =
		<fmt:formatDate value="${now }" type="both" />
	<p>
		now(날짜와 시간) =
		<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" />
	<p>
		now(날짜와 시간) =
		<fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short" />
	<p>
		now(패턴) =
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" />
	</p>

	<%-- timeZone 태그 : 타임존(TimeZone)을 변경하는 태그 --%>
	<%-- value 속성 : 변경할 타임존(대륙/도시)을 속성값으로 설정 --%>
	<fmt:timeZone value="Asia/Hong_Kong">
		<p>
			홍콩의 현재 날짜와 시간 =
			<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" />
		</p>
	</fmt:timeZone>
</body>
</html>