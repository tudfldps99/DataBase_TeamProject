<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="java.util.*" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//주의: 아래와 같은  scriptlet은 생략하고 EL로 구현하는 것이 바람직함 (list2.jsp 참조)
   @SuppressWarnings("unchecked") 
   List<Pet> petList = (List<Pet>)request.getAttribute("petList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입양 목록 페이지</title>

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
<form name = "form" method = "post" action="<c:url value='/pet/listAdopt' />">
<table style="width:99%; height:100px; border:0; cellpadding:0; cellspacing:0; font-size:30px; margin-right:0; margin-right:2%; overflow: scroll;">
   <tr>
      <td rowspan="3" style="width:13%; height:100px;"><img src="<c:url value='/images/somsom.jpg' />" style="max-width: 100%; height:auto; align:left"/></td>
      <th colspan="2" width="90%" bgcolor="lightpink" height="50px">&nbsp;&nbsp;<b>아이들이 입양을 기다리고 있어요.</b></th>
   </tr>
   <tr align="right">
       <td width="100%" height="20px">
         <div style = "font-size:10px">보여질 동물의 종을 선택하세요  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
         <select name="kind" id="kind">
         <c:if test="${kind eq '전체보기'}">
               <option value="전체보기" selected>전체보기</option>
               <option value="강아지">강아지</option>
               <option value="고양이">고양이</option>
               <option value="기타">기타</option>
         </c:if>
         <c:if test="${kind eq '강아지'}">
               <option value="전체보기">전체보기</option>
               <option value="강아지" selected>강아지</option>
               <option value="고양이">고양이</option>
               <option value="기타">기타</option>
         </c:if>
         <c:if test="${kind eq '고양이'}">
               <option value="전체보기">전체보기</option>
               <option value="강아지">강아지</option>
               <option value="고양이" selected>고양이</option>
               <option value="기타">기타</option>
         </c:if>
         <c:if test="${kind eq '기타'}">
               <option value="전체보기">전체보기</option>
               <option value="강아지">강아지</option>
               <option value="고양이">고양이</option>
               <option value="기타" selected>기타</option>
         </c:if>
         </select>
         &nbsp;&nbsp;&nbsp;
       </td>
       <td align="right" rowspan="2">
          <input type = "submit" value = "검색" onClick = "search('<c:url value='/pet/listAdopt'><c:param name='userId' value='${userId}'/></c:url>')" />
            <!-- <input type = "button" value = "검색" onClick = "search('<c:url value='/pet/listAdopt' />')" /> -->
       </td>
      </tr>
    <tr align="right">
       <td width="100%" height="30px">
          <div style = "font-size:10px">보여질 입양 여부를 선택하세요 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
         <select name="view" id="view">
         <c:if test="${selectView eq '전체보기'}">
               <option value="전체보기" selected>전체보기</option>
               <option value="입양 가능 동물만 보기">입양 가능</option>
               <option value="입양 완료인 동물만 보기">입양 완료</option>
         </c:if>
         <c:if test="${selectView eq '입양 가능 동물만 보기'}">
               <option value="전체보기">전체보기</option>
               <option value="입양 가능 동물만 보기" selected>입양 가능</option>
               <option value="입양 완료인 동물만 보기">입양 완료</option>
         </c:if>
         <c:if test="${selectView eq '입양 완료인 동물만 보기'}">
               <option value="전체보기">전체보기</option>
               <option value="입양 가능 동물만 보기">입양 가능</option>
               <option value="입양 완료인 동물만 보기" selected>입양 완료</option>
         </c:if>
         </select>
         &nbsp;&nbsp;&nbsp;
       </td>
   </tr>
</table>
</form>
<br>

<div class="sc">
<table>
   <c:forEach var="pet" items="${petList}">
      <tr style="height:45%; width:90%">
            <form name = "form" method = "post" action="<c:url value='/pet/apply'/>">
         <td width="30%" height="90%" style="text-align:center"><img width = "30%" src = "<c:url value='${pet.image}' />" style="max-width: 90%; max-height:90%;" /></td>
         <td width="50%">이름: ${pet.pname}<br>나이: ${pet.age}<br>성별: ${pet.gender}<br>소개: ${pet.explanation}
            <input type="text" id = "petId" name="petId" value='${pet.petId}' style="position:absolute; opacity:0;"/>         
            <input type="text" id = "userId" name="userId" value='${userId}' style="position:absolute; opacity:0;"/>
         </td>
             <c:if test="${pet.adopt == 1 }">
                <td width="20%" style="align:right; text-align:center;">  
                <input type = "submit" value = "입양하기" style="background-color:LightPink;" onClick = "search('<c:url value='/pet/apply'></c:url>')" />
                </td>
            </c:if>
            <c:if test="${pet.noAdopt == 1}">
               <td width="100%" style="align:right; text-align:center;"><div style="background-color:LightBlue;">입양 완료</div></td>
            </c:if>
                </form>
      </tr>
   </c:forEach>
</table>
</div>
</body>
</html>