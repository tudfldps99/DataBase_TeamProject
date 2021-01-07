<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>혜택 지원 동물병원 리스트</title>
<script>
   function searchHospital() {
      var sH = document.getElementById("area");
      var valueH = sH.options[sH.selectedIndex].value;
      alert(valueH);
   }
   function search(targetUri) {
         form.action = targetUri;
         form.submit();
      }
</script>
<style type = "text/css">
   .sc {margin-left:5px; margin-right:5px; height:70%; width:100%;
   border-color: lightPink; border-style:solid; border-width:medium; border-spacing:15px; border-collapse:separate;
   }
</style>
</head>
<body>
<table style="width:100%; border:0; cellpadding:0; cellspacing:0;">
   <tr>
      <td>
         <table style="width:100%; border:0; cellpadding:0; cellspacing:0; font-size:30px">
            <tr>
                 <th bgcolor="lightpink" height="50">&nbsp;&nbsp;<b>혜택 지원 동물병원 리스트</b>&nbsp;</th>
            </tr>
           </table>  
           <br>    
           <br>
         <form name = "form" method = "post">
           <table style="width:100%; border:0; cellpadding:0; cellspacing:0;">
              <tr align="left">
               <td height="30">시/도 선택&nbsp;
                  <select id="city" name="city">
                     <option value="전체보기">전체보기</option>
                     <option value="서울특별시">서울특별시</option>
                     <option value="인천광역시">인천광역시</option>
                     <option value="광주광역시">광주광역시</option>
                     <option value="대전광역시">대전광역시</option>
                     <option value="대구광역시">대구광역시</option>
                     <option value="부산광역시">부산광역시</option>
                     <option value="울산광역시">울산광역시</option>
                     <option value="경기도">경기도</option>
                     <option value="강원도">강원도</option>
                     <option value="충청북도">충청북도</option>
                     <option value="충청남도">충청남도</option>
                     <option value="전라북도">전라북도</option>
                     <option value="전라남도">전라남도</option>
                     <option value="경상북도">경상북도</option>
                     <option value="경상남도">경상남도</option>
                     <option value="세종특별자치시">세종특별자치시</option>
                     <option value="제주특별자치도">제주특별자치도</option>
                  </select>
                  &nbsp; &nbsp;
               <input type="button" value="검색" onclick="search('<c:url value='/pet/hospitalSimple' />')" />
               </td>
            </tr>
         </table>
        </form>
     </tr>
 </table>
 <br>
 <c:if test="${city ne null}">
 <c:out value="${city}"></c:out>의 검색 결과입니다.
 </c:if>
<div class="sc">
<table>
   <tr style="width:100%;">
      <th style="text-align:center;">병원이름</th>
      <th style="text-align:center;">전화번호</th>
      <th style="text-align:center;">주소</th>
      <th style="text-align:center;">운영시간</th>
   </tr>
   <c:forEach var="hospital" items="${hospitalList}">
      <tr>
         <td style="text-align:left">${hospital.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
         <td style="text-align:left">${hospital.phone}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
         <td style="text-align:left">${hospital.address}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
         <td style="text-align:left">${hospital.hour}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
      </tr>
   </c:forEach>
</table>
<br>
</div>
  <h3>병원에 관련된 자세한 정보를 보고싶다면 <a href="<c:url value="/pet/hospitalList.jsp" />">여기를</a> 클릭하세요.</h3>
</body>
</html>