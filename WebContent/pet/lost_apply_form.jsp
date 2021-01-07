<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<!--  
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
-->
<title>실종 신고 페이지</title>
<style>
*{
   margin-left:auto;
   margin-right:auto;
}
input.imageAlign {
   vertical-align : middle;
}
table {
   border-collapse:collapse;
}
td {
   font-size : 16px;
   font-family : 굴림;
   align: center;
}
</style>
<script>

function cancel() {
   alert("이전 화면으로 돌아갑니다.");
   history.back();
}


function display() {
   alert("등록이 완료되었습니다.");
    }

   function cityChange(e) {
         var seoul = ["강남구", "구로구", "은평구", "마포구", "서대문구"];
         var incheon = ["중구", "계양구", "강화군", "서구", "동구"];
         var daejeon = ["중구", "대덕구", "동구", "서구", "유성구"];
         var gwangju = ["동구", "남구", "광산구", "서구", "북구"];
         var daegu = ["동구", "중구", "남구", "북구", "서구"];
         var ulsan = ["울주군", "동구", "남구", "중구", "북구"];
         var busan = ["서구", "남구", "북구", "중구", "강서구", "동구"];
         var gyeonggi = ["광명시", "김포시", "고양시", "여주시", "안양시"];
         var gangwon = ["평창군", "고성군", "양양군", "인제군", "강릉시"];
         var sejong = ["세종특별자치시"];
         var chungnam = ["아산시", "천안시", "당진시", "논산시", "보령시"];
         var chungbuk = ["충주시", "청주시", "영동군", "단양군", "제천시"];
         var jeonnam = ["나주시", "강진군", "순천시", "완도군", "해남군"];
         var jeonbuk = ["임실군", "전주시", "익산시", "군산시", "김제시"];
         var gyeongnam = ["통영시", "함양군", "합천군", "거제시", "밀양시"];
         var gyeongbuk = ["포항시", "의성군", "안동시", "영천시", "울릉군"];
         var jeju = ["제주특별자치도"];
         var opt = ["구"];
         var target = document.getElementById("gu");
         
         if(e.value == "seoul")
            var d = seoul;
         else if(e.value == "incheon")
            var d = incheon;
         else if(e.value == "daejeon")
            var d = daejeon;
         else if(e.value == "gwangju")
            var d = gwangju;
         else if(e.value == "daegu")
            var d = daegu;
         else if(e.value == "ulsan")
            var d = ulsan;      
         else if(e.value == "busan")
            var d = busan;      
         else if(e.value == "gyeonggi")
            var d = gyeonggi;      
         else if(e.value == "gangwon")
            var d = gangwon;      
         else if(e.value == "sejong")
            var d = sejong;      
         else if(e.value == "chungnam")
            var d = chungnam;      
         else if(e.value == "chungbuk")
            var d = chungbuk;      
         else if(e.value == "jeonnam")
            var d = jeonnam;
         else if(e.value == "jeonbuk")
            var d = jeonbuk;
         else if(e.value == "gyeongnam")
            var d = gyeongnam;
         else if(e.value == "gyeongbuk")
            var d = gyeongbuk;
         else if(e.value == "jeju")
            var d = jeju;
         else if(e.value == "ci") 
            var d = opt;
            
         target.options.length = 1;
         
         for(x in d) {
            var opt = document.createElement("option");
            opt.value = d[x];
            opt.innerHTML = d[x];
            target.appendChild(opt);
         }
      }

   function kindChange(e) {
         var dog = ["말티즈", "푸들", "비숑", "치와와", "포메라니안"];
         var cat = ["러시안블루", "샴", "노르웨이숲", "뱅갈", "코리안숏헤어"];
         var hedgehog = ["스탠다드", "시나몬", "실버챠콜", "알비노", "초콜릿"];
         var peleos = ["다크실버미트", "라이트세이블", "라이트실버미트", "마크드화이트", "버터스카치"];
         var opt = ["품종선택"];
         var etc = ["기타"];
         var target = document.getElementById("variety");
         
         if(e.value == "dog")
            var d = dog;
         else if(e.value == "cat")
            var d = cat;
         else if(e.value == "hedgehog")
            var d = hedgehog;
         else if(e.value == "peleos")
            var d = peleos;
         else if(e.value == "o")
            var d = opt;
         else if(e.value == "etc")
            var d = etc;                                                
         
         target.options.length = 1;
         
         for(x in d) {
            var opt = document.createElement("option");
            opt.value = d[x];
            opt.innerHTML = d[x];
            target.appendChild(opt);
         }
      }
      function petCreate(targetUri) {
            form.action = targetUri;
            form.submit();
         }
  
   
</script>
</head>
<body>
<form name = "form" name="textbox" id="textbox" method="POST" action="<c:url value='/pet/applylost' />">
<div align = "center">
</div>
<table border = "1">
<tr>
   <td align = "center" colspan = "2" style="background:#FFB2D9" height=50><strong> 실종 신고 </strong></td>
</tr>

<tr>
   <td align = "center" style="background:#FFB2D9"><strong>나이 </strong></td>
   <td><input type = "text" size = "5" name="age"></td>
</tr>
<tr>
   <td align = "center" style="background:#FFB2D9"><strong>성별 </strong></td>
   <td><input type = "radio" name = "gen" value = "M">수컷 <input type = "radio" name = "gen" value = "F" checked>암컷</td>
</tr>
<tr>
   <td align = "center" style="background:#FFB2D9"><strong>이미지</strong></td>
   <td><input type="text" size = "40" name="img"></td>
</tr>
<tr>
   <td align = "center" style="background:#FFB2D9"><strong>몸무게 </strong></td>
   <td><input type = "text" size = "5" name="weight"> kg</td>
</tr>
<tr>
   <td align = "center" style="background:#FFB2D9"><strong>품종</strong></td>
   <td>
    <select name = "kind" id="kind" onchange="kindChange(this)">
               <option value="o">동물선택</option>
               <option value="dog" id = "dog">강아지</option>
               <option value="cat" id = "cat">고양이</option>
               <option value="hedgehog" id = "hedgehog">고슴도치</option>
               <option value="peleos" id = "peleos">페럿</option>
               <option value="etc" id = "etc">기타</option>
            </select>
              <select id = "variety" name = "variety">
               <option>품종선택</option>
            </select>
         </td>
</tr>
<tr>
   <td align = "center" style="background:#FFB2D9"><strong>실종지역</strong></td>
    <td><select name = "city" id="city" onchange="cityChange(this)">
               <option value="ci">시</option>
               <option value="seoul">서울시</option>
               <option value="incheon">인천시</option>
               <option value="daejeon">대전시</option>
               <option value="gwangju">광주시</option>
               <option value="daegu">대구시</option>
               <option value="ulsan">울산시</option>
               <option value="busan">부산시</option>
               <option value="gyeonggi">경기도</option>
               <option value="gangwon">강원도</option>
               <option value="sejong">세종시</option>
               <option value="chungnam">충청남도</option>
               <option value="chungbuk">충청북도</option>
               <option value="jeonnam">전라남도</option>
               <option value="jeonbuk">전라북도</option>
               <option value="gyeongnam">경상남도</option>
               <option value="gyeongbuk">경상북도</option>
               <option value="jeju">제주도</option>
            </select>
    <select id = "gu" name = "gu">
               <option>구</option>
   </select>
</tr>
<tr>
   <td align = "center" style="background:#FFB2D9"><strong>실종날짜</strong></td>
   <td><input type = "text" placeholder = "MMDD" name = "pdate"></td>
</tr>
<tr>
   <td align = "center" style="background:#FFB2D9"><strong>특이사항</strong></td>
   <td><textarea rows = "5" cols = "60" name="memo"></textarea></td>
</tr>
<tr>
   <td align = "center" colspan = "2" style="background:#FFB2D9">
   <input type = "reset" value = "다시작성">
   <input type = "button" value = "취소" onClick="cancel();" />
   <input type = "submit" value = "등록" onclick="display();"/></td>
</tr>
</table>
</form>
</body>
</html>