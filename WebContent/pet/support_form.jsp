<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%
   UserInfo user = (UserInfo)request.getAttribute("userInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입양 시 지원 및 혜택</title>
<script>
   function primaryInoculation() {
      alert('입양 시 누릴 수 있는 혜택 첫번째' + '\n' + '\n' + '1차부터 5차 예방접종까지 무료로 서비스를 제공하고 있습니다.');
      return false;
   }
   function antirabiesSerumInjection() {
      alert('입양 시 누릴 수 있는 혜택 두번째' + '\n' + '\n' + '사람과 동물 간에 교상 등을 통해 전파되는 인수공통전염병인 광견병을 예방하는 주사를 횟수 제한 없이 무료로 서비스를 제공하고 있습니다.');
      return false;
   }
   function neutralization() {
      alert('입양 시 누릴 수 있는 혜택 세번째' + '\n' + '\n' + '반려견의 질병을 예방하기 위한 중성화 수술을 무료로 받으실 수 있습니다.');
      return false;
   }
   function supportHospital(targetUri) {
      form.action = targetUri;
      form.submit();
   }
   function search(targetUri) {
         form.action = targetUri;
         form.submit();
      }
</script>
</head>
<body>

<form name = "form" method = "post">
<table style="width:100%; border:0; cellpadding:0; cellspacing:0;">
   <tr>
      <td>
         <table style="width:100%; border:0; cellpadding:0; cellspacing:0; font-size:30px">
            <tr>
                 <th bgcolor="lightpink" height="50">&nbsp;&nbsp;<b>입양 시 지원 및 혜택</b>&nbsp;&nbsp;</th>
            </tr>
           </table>  
           <br>    
           <br>        
           <table style="width:100%; border:0; cellpadding:0; cellspacing:0;">
              <tr align="center">
               <td height="30">
                  <input type="button" value="예방 접종 무료" onClick="primaryInoculation()" style="background-color: LightPink" />
               </td>
               <td height="30">
                  <input type="button" value="광견병 주사 무료" onClick="antirabiesSerumInjection()" style="background-color: LightPink" />
               </td>
               <td height="30">
                  <input type="button" value="중성화 수술 무료" onClick="neutralization()" style="background-color: LightPink" />
               </td>
              </tr>
         </table>         
           <br>   
           <br>
           <table>
               <tr>
                 <td style="height:30; colspan:3; font-size:20px">유기동물이 처음이라면?&nbsp;&nbsp;
                    <a href="<c:url value='/pet/information' />">바로가기</a>
               </td>
              </tr>
              <tr>
                 <td style="height:30; colspan:3; font-size:20px">지원병원 찾기&nbsp;&nbsp;
                    <a href="<c:url value='/pet/support_hospital/form' />">바로가기</a>
               </td>
            </tr>
              <tr>
                 <td style="height:30; colspan:3; font-size:20px">입양 목록 및 입양 신청 페이지&nbsp;&nbsp;
                   <input type="button" value="바로가기" onClick ="search('<c:url value='/pet/listAdoptFirst'> <c:param name='userId' value='${userId}'/></c:url>')" style="background-color:LightPink;">
               </td>
            </tr>
         </table>
      </td>
     </tr>
</table>
</form>
</body>
</html>