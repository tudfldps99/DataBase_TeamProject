<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.UserInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>마이페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
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
           <td width="150" align="center" bgcolor="FFEBFE">이름</td>
           <td width="250" bgcolor="ffffff" style="padding-left: 10">
                 ${user.name}
            </td>
        </tr>
        <tr height="40">
           <td width="150" align="center" bgcolor="FFEBFE">성별</td>
           <td width="250" bgcolor="ffffff" style="padding-left: 10">
                ${user.gender}
           </td>
        </tr>     
        <tr height="40">
            <td width="150" align="center" bgcolor="FFEBFE">생일</td>
            <td width="250" bgcolor="ffffff" style="padding-left: 10">
                ${user.birthday}
            </td>
         </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="FFEBFE">이메일 주소</td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
                 ${user.email}
         </td>
        </tr>   
          <tr height="40">
         <td width="150" align="center" bgcolor="FFEBFE">전화번호</td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
               ${user.phone}
         </td>
        </tr>   
       </table>
       <br>     
       <table style="width: 100%">
        <tr>
         <td align="left">
          <a href="<c:url value='/user/update/form'>
                   <c:param name='userId' value= '${user.userInfoId}'/> 
                  </c:url>">수정
          </a>
            <!-- 수정이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
             <c:if test="${updateFailed}">
               <font color="red"><c:out value="${exception.getMessage()}" /></font>
           </c:if>
        </td>
      </tr>
       </table>
     </td>
    </tr>
  </table>  
</body>
</html>