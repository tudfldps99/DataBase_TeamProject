<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>마이페이지-수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function userModify(targetUri) {
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
   form.action = targetUri;
   form.submit();
}

function userList(targetUri) {
   form.action = targetUri;
   form.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<!-- Update form  -->
<form name="form" method="POST" action="<c:url value='/user/update' />">
  <input type="hidden" name="userId" value="${user.userInfoId}"/>
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
       <br>     
       <table style="background-color: FFB2D9">
          <tr height="40">
         <td width="150" align="center" bgcolor="FFEBFE">사용자 아이디</td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
           ${user.userInfoId}
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="FFEBFE">비밀번호</td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="password" style="width: 240" name="password" value="${user.password}">
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="FFEBFE">비밀번호 확인</td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="password" style="width: 240" name="password2" value="${user.password}">
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="FFEBFE">이름</td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="text" style="width: 240" name="name" value="${user.name}"> 
         </td>
        </tr>
        <tr height="40">
           <td width="150" align="center" bgcolor="FFEBFE">성별</td>
           <td width="250" bgcolor="ffffff" style="padding-left: 10">
               <input type = "text" name = "gender" value = "${user.gender}"> 
           </td>
        </tr>     
        <tr height="40">
            <td width="150" align="center" bgcolor="FFEBFE">생일</td>
            <td width="250" bgcolor="ffffff" style="padding-left: 10">
               <input type = "text" size = 22 name = "birthday" value="${user.birthday}">
            </td>
         </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="FFEBFE">이메일 주소</td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="text" style="width: 240" name="email" value="${user.email}">
         </td>
        </tr>   
          <tr height="40">
         <td width="150" align="center" bgcolor="FFEBFE">전화번호</td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="text" style="width: 240" name="phone" value="${user.phone}"> 
         </td>
        </tr>   
       </table>
       <br>     
       <table style="width: 100%">
        <tr>
         <td align="left">
            <input type="button" value="수정하기" onClick="userModify('<c:url value='/user/update' />') " style="background-color:FFEBFE;"> &nbsp;
         <input type="button" value="취소하기" onClick="userList('<c:url value='/user/myPage' />')" style="background-color:FFEBFE;"> &nbsp;
        </td>
      </tr>
       </table>
     </td>
    </tr>
  </table>  
</form>
</body>
</html>