<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
<script>
	function login() {
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
	   form.submit();
	}
</script>
</head>
<body>
<br>
<!-- write Form  -->
<form name="form" method="POST" action = "<c:url value='/user/login' />">
  <table style="width:100%">
   <tr>
     <td width="20"></td>
     <td>
      <!--contents-->
     <table>
        <tr>
           <td><img src = "<c:url value='/images/somsom.jpg' />" height = "120"></td>
         <td><h1><b>&nbsp;#사지말고 입양하세요</b></h1></td>
        </tr>
     </table>  
     <br>
      <c:if test="${loginFailed}">
         <br><font color="red"><c:out value="${exception.getMessage()}" /></font><br>
      </c:if>
     <table style="background-color: #FFB2D9">
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFEBFE">사용자 아이디</td>
         <td width="250" bgcolor="white" style="padding-left:10">
            &nbsp;<input type="text" style="width:240" name="userId">
         </td>
         <td rowspan = "2" ><input type="button" value="로그인" onClick="login()" style="height: 60pt"></td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFEBFE">비밀번호</td>
         <td width="250" bgcolor="ffffff" style="padding-left:10">
            &nbsp;<input type="password" style="width:240" name="password">
         </td>
        </tr>
     </table>
     <br>
     <table>
        <tr height="40"><td><a href="<c:url value='/user/register/form' />">회원가입하기</a></td></tr>        
     </table>
     </td>
   </tr>
  </table>  
</form>
</body>
</html>