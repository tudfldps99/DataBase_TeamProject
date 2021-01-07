<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<html>
<head>
<title>메인페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
   tr:nth-child(5) td { border-bottom: none; }
   tr:nth-child(7) td { border-bottom: none; }
   tr:nth-child(10) td { border-bottom: none; }
   
   .table {
         width:100%; 
         border:0; 
         cellpadding:0; 
         cellspacing:0; 
         text-align:center;
   }
   
   .center {
         text-align:center;
   }
   
   .tb {
         float:left;
         width:25%;
          cellspacing=5;
          cellpadding=0;
      }
   
   .input_bg {
         width: 100%; 
         background-color: #FFB2D9;
      }

   .bgColor {
      background-color: #FFB2D9;
   }
   
   .bgColor2 {
      background-color: #FFEBFE;
   }
   
   .div {
      height:70%; 
      width:100%; 
      border: 1px solid black;
   }
   .textarea {
      width:100%; 
      text-align:left; 
      resize:none;
   }
</style>

<script>
   function user(targetUri) {
      form.action = targetUri;
      form.submit();
   }
</script>
</head>
<body>
<form name="form" method="POST">
<table class="table">
      <tr>
      <td colspan="3" height = "10"></td>   <!-- 로그인/회원가입 버튼 위로 공백 -->
   </tr>
   <tr>
         <td colspan="3">
         <span style="float:right;">
          <input type = "button" value = "로그아웃" onClick ="user('<c:url value='/user/logout' />')" class="bgColor">
            <input type = "button" value = "내 정보 (마이페이지)" onClick ="user('<c:url value='/user/myPage'> <c:param name='userId' value='${user.userInfoId}'/></c:url>')" class="bgColor">
         </span>
         </td>
    </tr>
      <tr>
       <td><img src="<c:url value='/images/somsom.jpg' />" style="max-width: 200px; height:auto;"/></td>
        <td colspan="2" class="center"><div style="height:100%; width:95%; border: 1px solid black;"><h1>#사지말고 입양하세요</h1></div></td>
    </tr>
    <tr>
        <td rowspan="8" width="35%" height="500">
           <div style="height:88%; width:90%; border: 1px solid black;">
              <input type = "button" value = "유기동물리스트" onClick ="user('<c:url value='/pet/abdpet' />')" class="input_bg">
              <br><br><br><br><br><br><br><br><br><br><br><br>
              <input type = "button" value = "유기동물 보호&실종신고" onClick ="user('<c:url value='/pet/lost_protect_form' />')" class="input_bg">
              <br><br><br><br><br><br><br><br><br><br>
              <input type = "button" value = "입양시 지원&혜택" onClick ="user('<c:url value='/pet/support/form'><c:param name='userId' value='${user.userInfoId}'/></c:url>')" class="input_bg">
           </div>
        </td>
        <td>
           <input type = "button" value = "공지사항" onClick ="user('<c:url value= '/pet/introduce' />')" style="width: 95%;" class="bgColor"> 
        </td>
         <td>
            <input type = "button" value = "소개" onClick ="user('<c:url value= '/pet/notice' />')"  style="width: 93%;" class="bgColor">
        </td>
    </tr>
    <tr>
        <td colspan="2" style = "width:65%;">
          <div class="div">
             <input type = "button" value = "유기동물리스트" onClick ="user('<c:url value='/pet/abdpet' />')" class="bgColor2"><br>
                <c:forEach var="pet" items="${petList2}" end="3">
                  <table border="1" class="tb">
                    <tr>
                         <td width="30%" height="160px" style="text-align:center"><img src= "<c:url value='${pet.image}' />" style="max-width: 80%; max-height:80%;" /></td>
                    </tr>
                    <tr>
                       <td> 나이 : ${pet.age}살 <br> 성별 : ${pet.gender} <br> 품종: ${pet.kind} <br></td>
                    </tr>
                 </table>
              </c:forEach>
           </div>
        </td>  
    </tr>
    <tr>
        <td colspan="2"></td>
    </tr>
    <tr>
        <td colspan="2" style = "width:65%;"> 
        <div class="div">
                <div style="width:60%; float:left;">
                  <span style="float:right;">
                    <input type = "button" value = "유기동물 보호&실종신고" onClick ="user('<c:url value='/pet/lost_protect_form' />')" class="bgColor2">
                    </span>
                  </div>
                  <div style="width:40%; float:right;">
                  <span style="float:right;">
                     <input type = "button" value = "실종 글쓰기" onClick ="user('<c:url value='/pet/applylostbutton' />')" class="bgColor2">
                     <input type = "button" value = "보호 글쓰기" onClick ="user('<c:url value='/pet/applyprotectbutton' />')" class="bgColor2">
                     </span>
                </div>
           
           <c:forEach var="pet" items="${petList}" end="3">
                  <table border="1" class="tb">
                    <tr>
                         <td width="30%" height="160px" style="text-align:center"><img src= "<c:url value='${pet.image}' />" style="max-width: 80%; max-height:80%;" /></td>
                    </tr>
                    <tr>
                        <c:if test="${pet.lost == 1 }">
                          <td class="center"><strong style="color:red">실종</strong></td>
                       </c:if>
                        <c:if test="${pet.protect == 1 }">
                          <td class="center"><strong style="color:blue">보호</strong></td>
                      </c:if>
                    </tr>
                 </table>
              </c:forEach>
           </div>
        </td>
    </tr>
    <tr>
        <td colspan="2"><br><br></td>
    </tr>
    <tr>
        <td colspan="2"> 
                 <h2>유기동물 한마리를 데리고온다고 세상이 바뀌진 않겠지만, <br> 그 동물에게는 세상이 바뀌는 일이다.</h2>
        </td>
    </tr>
</table>
</form>
</body>
</html>