<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="java.util.*" %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목격/실종 페이지</title>

<script>
   function search(targetUri) {
         form.action = targetUri;
         form.submit();
      }
</script>
<style type = "text/css">
   .sc {align:center; margin-left:10px; margin-right:10px; height:65%;
   border-color: lightPink; border-style:solid; border-width:medium;}
</style>
</head>
<body>
<table style="width:99%; height:100px; border:0; cellpadding:0; cellspacing:0; font-size:30px; margin-right:0; margin-right:2%; overflow: scroll;">
   <tr>
      <td rowspan="3" style="width:13%; height:100px;"><img src="<c:url value='/images/somsom.jpg' />" style="max-width: 100%; height:auto; align:left"/></td>
      <th colspan="2" width="90%" bgcolor="lightpink" height="50px">&nbsp;&nbsp;<b>실종 / 목격 신고 페이지</b></th>
   </tr>
</table>
<br>

<div class="sc">
<form name = "form" method = "post">
<table border = 1>
   <c:forEach var="pet" items="${petList}">
      <tr style="height:45%; width:90%">
         <td width="30%" height="90%" style="text-align:center"><img src= "<c:url value='${pet.image}' />" style="max-width: 90%; max-height:90%;" /></td>
         <td width="50%">
       나이 : ${pet.age}살   <br>
      성별 : ${pet.gender}  <br>
      몸무게: ${pet.weight}kg <br>
      품종: ${pet.kind}     <br> 
      날짜: ${pet.pdate} <br>
      특이사항: ${pet.explanation} 
                    
         </td>
          
          <c:if test="${pet.lost == 1 }">
                <td width="100%" style="align:right; text-align:center;"><div style="background-color:LightPink;">실종</div></td>
            </c:if>
          <c:if test="${pet.protect == 1 }">
                <td width="100%" style="align:right; text-align:center;"><div style="background-color:LightBlue;">보호</div></td>
             </c:if>
         
      </tr>
   </c:forEach>
</table>
</form>
</div>
</body>
</html>