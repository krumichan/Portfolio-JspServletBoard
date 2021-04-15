<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학사관리 시스템</title>
</head>
<body>

<%@ include file="fontForm.jsp" %>

<b><font class="custom">[개설가능 과목]</font></b>
<hr/>

<center>
	<table border="1">
		<tr>
			<th>과목아이디</th>
			<th>과목명</th>
			<th>학과</th>
		</tr>
		
		<c:forEach items="${ subjectList }" var="subject">
			<tr>
				<td>${ subject.subId }</td>
				<td>
					<a href="subjectDetail.do?subId=${ subject.subId }&deptName=${ deptName }">${ subject.subName }</a>
				</td>
				<td>${ deptName }</td>
			</tr>
		</c:forEach>
	</table>
	<p/>
	
	<a href="main.do">[교수 메인으로]</a>
	<a href="lectureList.do">[내 강의과목]</a>
</center>

</body>
</html>