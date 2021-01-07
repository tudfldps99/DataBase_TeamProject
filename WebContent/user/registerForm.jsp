<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>회원가입</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function userCreate() {
	if (form.userId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}
	if (form.password.value != form.password2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.password.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("이메일 형식이 올바르지 않습니다.");
		form.email.focus();
		return false;
	}
	var phoneExp = /^\d{2,3}\d{3,4}\d{4}$/;
	if(phoneExp.test(form.phone.value)==false) {
		alert("전화번호 형식이 올바르지 않습니다.");
		form.phone.focus();
		return false;
	}
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<!-- registration form  -->
<form name="form" method="POST" action="<c:url value='/user/register' />">
  <table style="width: 100%">
    <tr>
      <td width="20"></td>
	  <td>
	    <table>
		  <tr>
		  	<td><img src="<c:url value='/images/somsom.jpg' />" width = "150" height = "150"/></td>
		    <td><h1>&nbsp;&nbsp;#사지말고 입양하세요&nbsp;&nbsp;</h1></td>
		  </tr>
	    </table>  	 
	    <!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${registerFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>
	    <br>	  
	    <table style="background-color: FFB2D9">
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="FFEBFE">사용자 아이디</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240;" name="userId">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="FFEBFE">비밀번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="password" style="width: 240" name="password">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="FFEBFE">비밀번호 확인</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="password" style="width: 240" name="password2">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="FFEBFE">이름</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="name" 
				 	<c:if test="${registerFailed}">value="${user.name}"</c:if>>
			</td>
		  </tr>
		  <tr height="40">
		  	<td width="150" align="center" bgcolor="FFEBFE">성별</td>
		  	<td width="250" bgcolor="ffffff" style="padding-left: 10">
		  			<input type = "radio" name = "gender" value = "M"> 남
					<input type = "radio" name = "gender" value = "F" checked> 여
		  	</td>
		  </tr>	  
		  <tr height="40">
				<td width="150" align="center" bgcolor="FFEBFE">생일</td>
				<td width="250" bgcolor="ffffff" style="padding-left: 10">
					<input type = "text" placeholder = "YYMMDD" size = 22 name = "birthday" value="${user.birthday}">
				</td>
			</tr>
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="FFEBFE">이메일 주소</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="email" 
					<c:if test="${registerFailed}">value="${user.email}"</c:if>>
			</td>
		  </tr>	
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="FFEBFE">전화번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" placeholder ="ex)01000000000" style="width: 240" name="phone" 
					<c:if test="${registerFailed}">value="${user.phone}"</c:if>>
			</td>
		  </tr>	
	    </table>
	    <br>	  
	    <table style="width: 100%">
		  <tr>
			<td align="left">
			<input type="submit" value="회원 가입" onClick= "userCreate()"> &nbsp;
			</td>
		  </tr>
	    </table>
	  </td>
    </tr>
  </table>  
</form>
</body>
</html>