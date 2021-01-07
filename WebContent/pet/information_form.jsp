<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유기동물에 관한 정보 알리는 페이지</title>
<style>
*{
   margin-left:auto;
   margin-right:auto;
}
input.imageAlign {
   vertical-align : middle;
}
td {
   font-size : 13px;
   
}
</style>
<script>
function search(targetUri) {
    form.action = targetUri;
    form.submit();
 }
 </script>
</head>
<body>
<form name = "form">
 <table>
      <tr>
         <td align="center" width="200"><img src = "<c:url value='/images/somsom.jpg' />" width = "140" height = "130"></td>
         <td width="500"><h1><b>Q 유기동물이 처음이라면?</b></h1></td>
      </tr>
   </table> 

<table>
   <tr><td><br></td></tr>
   <tr>
      <td align = "center" style="background:#FFB2D9" height = "30"><b>유기동물 입양 전 고려 사항</b></td>
   </tr>
   <tr>
      <td><textarea rows = "5" cols = "80" readonly>
유기동물 입양을 고려하고 있다면 아래와 같은 질문에 답을 해보자.인내심을 갖고 우리집에 적응할 때까지 기다릴 준비가 되었는가? 적응기간은 며칠, 수 주가 아니라 수개월이 될 수 있다.모든 가족이 같은 마음인가?입양 후 일어나는 건강, 행동 문제를 내가 책임져야 한다. 전 주인 잘못이라고 남 탓하면서 방치해서는 안 된다.동물이 우리 집에 적응하듯, 나도 동물에게 적응하고 가족으로 거듭나겠다는 믿음이 있어야 한다.

    </textarea></td>
   </tr>
   <tr><td><br></td></tr>
   <tr>
      <td align = "center" style="background:#FFB2D9" height = "30"><b>유기동물 훈련 시 고려 사항</b></td>
   </tr>
   <tr>
      <td><textarea rows = "5" cols = "80" readonly>
사실 유기동물이든 아니든 사람과 함께 살아가는 사회에서 기본적인 훈련은 필수적이다. 다만, 유기동물 훈련 시 고려해야 하는 사항이 있다.유기동물 훈련, 교육뿐 아니라 유대감 형성에도 필요해 경험이 많은 경우에는 스스로 훈련 시키는 것도 좋다. 
유기동물 훈련, 인내심이 핵심. 동물이 배우는 만큼 우리도 배워야한다. 동물이 새로운 언어를 배우는 것처럼, 우리도 훈련을 통해 동물과 소통하는 방법을 배우게 된다.훈련에는 모든 가족 구성원이 적극적이면 이상적이다. 그 과정에서 유대감을 쌓을 수 있기 때문이다.유기동물 훈련 시에는 인내심이 핵심이다. 인내심은 어떤 동물을 훈련하든 중요하다. 
  </textarea></td>
   </tr>
    <tr><td><br></td></tr>
   <tr>
      <td align = "center" style="background:#FFB2D9" height = "30"><b>유기동물 훈련 시 흔하게 저지르는 실수</b></td>
   </tr>
   <tr>
      <td><textarea rows = "5" cols = "80" readonly>
새롭게 유기동물을 입양하며 가장 흔히 저지르는 실수는 동물의 과거에 대해서 너무 많이 혹은 조금 신경 쓰는 것이다.우리는 동물을 대할 때, 백지에서 함께 훈련한다고 생각하자.유기동물이라고 모두 트라우마가 있는 것은 아니다.훈련에 적응을 잘 못 할 수 있다. 그것은 유기동물 때문이어서는 아니다. 시간과 노력이 필요한 부분이다.유기동물을 데려온 보호소나 보호하던 개인에게 구조 경위, 성격, 행동적 특성을 상세히 물어보는 것이 필요하다. 그렇다고 정보를 그대로 받아들이지 말자.특히, 보호소의 경우 제한된 정보를 가지고 있다. 보호소라는 장소의 특성상 산책 시간이나 다른 사람 및 동물들과의 교류 시간이 적다. 따라서, 잠재되어 있는 적응력, 사회성을 발휘하지 못하고 긴장된 상태일 수 있다.
    </textarea></td>
   </tr>
    <tr><td><br></td></tr>
   <tr>
      <td align = "center">
      <input type = "button" value = "내 지역 근처 병원 알아보기" onClick="search('<c:url value='/pet/hospitallist' />')">
      </td>
   </tr>
</table>
</form>
</body>
</html>