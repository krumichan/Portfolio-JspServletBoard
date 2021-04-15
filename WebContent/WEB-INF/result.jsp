<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학사관리 시스템</title>
</head>

<script>
	function goLoginForm() {
		var form = document.loginForm;
		form.submit();
	}

	function goTeacherInsertForm() {
		var form = document.teacherInsertForm;
		form.submit();
	}
</script>

<body>

<%@ include file="fontForm.jsp" %>

<b><font class="custom">실행 결과</font></b>
<hr/>

<form name="teacherInsertForm" action="teacherInsertForm.do" method="post"></form>
<form name="loginForm" action="loginForm.do" method="post"></form>

<center>
	<c:choose>
		<c:when test="${ code == '10' }">
			가입을 완료했습니다.<br/>
			로그인 하세요.<p/>
			<a href="javascript:goLoginForm()">로그인</a>
		</c:when>
		
		<c:when test="${ code == '11' }">
			가입 중 오류가 발생했습니다.<br/>
			다시 시도하세요.<p/>
			<a href="javascript:goTeacherInsertForm()">교수 등록</a>
		</c:when>
		
		<c:when test="${ code == '00' }" >
			아이디 또는 비밀번호가 틀립니다.<br/>
			다시 시도하세요. <p/>
			<a href="javascript:goLoginForm()">로그인</a>
		</c:when>
		
		<c:when test="${ code == '20' }">
			교수 정보 수정 중 오류가 발생했습니다.<br/>
			다시 시도하세요.<p/>
			<a href="teacherUpdateForm.do">교수 정보수정</a>
		</c:when>
		
		<c:when test="${ code == '21' }">
			교수 정보를 수정하였습니다.<p/>
			<a href="main.do">메인으로</a>
		</c:when>
		
		<c:when test="${ code == '32' }" >
			선택한 과목은 이미 개설중입니다.<br/>
			다시 시도하세요.<p/>
			<a href="lectureList.do">내 강의목록</a>
		</c:when>
		
		<c:when test="${ code == '31' }" >
			강의 개설 중 오류가 발생했습니다.<br/>
			다시 시도하세요.<p/>
			<a href="subjectList.do">개설 가능과목</a>
		</c:when>
		
		<c:when test="${ code == '30' }" >
			강의를 개설하였습니다.<p/>
			<a href="lectureList.do">내 강의목록</a>
		</c:when>
		
		<c:when test="${ code == '41' }" >
			폐강 처리 중 오류가 발생했습니다.<br/>
			다시 시도하세요.<p/>
			<a href="lectureList.do">내 강의목록</a>
		</c:when>
		
		<c:when test="${ code == '40' }" >
			폐강 처리 완료하였습니다.<p/>
			<a href="lectureList.do">내 강의목록</a>
		</c:when>
		
		<c:otherwise>
			유효하지 않은 코드값 : ${ code }
		</c:otherwise>
	</c:choose>
</center>

</body>
</html>