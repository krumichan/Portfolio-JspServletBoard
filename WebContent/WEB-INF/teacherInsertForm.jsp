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
<b><font class="custom">[교수 등록]</font></b>
<hr/>

<form action="teacherInsert.do" method="post">
	<center>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"/></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw"/></td>
			</tr>
			
			<tr>
				<th>이 름</th>
				<td><input type="text" name="name"/></td>
			</tr>
			
			<tr>
				<th>학 과</th>
				<td>
					<select name="deptCode">
					<c:forEach items="${ departmentList }" var="dept" >
						<option value="${ dept.deptCode }">${ dept.deptName }</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<th>주 소</th>
				<td><input type="text" name="address"></td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input type="submit" value="가입"/>
					<input type="reset" value="초기화"/>
				</th>
			</tr>
		</table>
		<p/>

		<a href="welcome.html">메인으로</a>
	</center>
</form>

</body>
</html>