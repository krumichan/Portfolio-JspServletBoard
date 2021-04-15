<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학사관리 시스템</title>
</head>
<body>

<b><font color="blue" size="5">[교수 메인 페이지]</font></b>
<hr/>

<center>
	<b><font color="blue" size="5">${ teacher.name }교수님 환영합니다.</font></b>
	<br/>
	
	<font color="blue" size="5"><a href="teacherUpdateForm.do">[교수 정보수정]</a></font>
	<font color="blue" size="5"><a href="lectureList.do">[내 강의과목]</a></font>
	<font color="blue" size="5"><a href="logout.do">[로그아웃]</a></font>
</center>

</body>
</html>