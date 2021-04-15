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

<b><font class="custom">[내 강의과목]</font></b>
<hr/>

<center>
	<table border="1">
		<tr>
			<th>강의등록번호</th>
			<th>과목명</th>
			<th>강의</th>
		</tr>
		

			<c:if test="${ lectureList.size() > 0 }">
				<c:forEach begin="0" end="${ lectureList.size() - 1 }" var="num">
					<tr>
						<td>${ lectureList[num].lecNum }</td>
						<td>${ subjectList[num].subName }</td>
						<td><a href="lectureDelete.do?lecNum=${ lectureList[num].lecNum }">폐강</a>
					</tr>
				</c:forEach>
			</c:if>

	</table>
	<p/>
	
	<a href="main.do">[교수 메인으로]</a>
	<a href="subjectList.do">[개설가능 과목]</a>
</center>

</body>
</html>