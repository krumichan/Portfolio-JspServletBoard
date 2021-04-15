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

<b><font class="custom">[교수 정보 수정]</font></b>
<hr/>

<center>
	<form action="teacherUpdate.do" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>${ teacher.id }</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" value="${ teacher.pw }" /></td>
			</tr>
			
			<tr>
				<th>이 름</th>
				<td><input type="text" name="name" value="${ teacher.name }" /></td>
			</tr>
			
			<tr>
				<th>학 과</th>
				<td>
					<select name="deptCode">
						<c:forEach items="${ departmentList }" var="dept">
							<option value="${ dept.deptCode }">${ dept.deptName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
				
			<tr>
				<th>주 소</th>
				<td><input type="text" name="address" value="${ teacher.address }" /></td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input type="submit" value="수정"/>
					<input type="reset" value="초기화"/>
				</th>
			</tr>
		</table>
	</form>
	<p/>
	
	<a href="main.do">교수 메인으로</a>
</center>

</body>
</html>