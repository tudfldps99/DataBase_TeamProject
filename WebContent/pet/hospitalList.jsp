<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.service.*" %> 
<%@page import="model.*" %>      
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<title>병원 정보</title>
<script>
   var d = seoul;
   var city = "seoul";
   var seoul = ["강남구", "구로구", "은평구", "마포구", "서대문구"];
   var incheon = ["중구", "계양구", "강화군", "서구", "동구"];
   var daejeon = ["중구", "대덕구", "동구", "서구", "유성구"];
   var gwangju = ["동구", "남구", "광산구", "서구", "북구"];
   var daegu = ["동구", "중구", "남구", "북구", "서구"];
   var ulsan = ["울주군", "동구", "남구", "중구", "북구"];
   var busan = ["서구", "남구", "북구", "중구", "강서구"];
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
   
   function cityChange(e) {
      var target = document.getElementById("gu");
      
      if(e.value == "seoul") {
         var d = seoul;
         city = "seoul";
      }
      else if(e.value == "incheon") {
         var d = incheon;
         city = "incheon";
      }
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
   
   function detail(targetUri) {
       f3.action = targetUri;
        f3.submit();
   }
   
</script>
</head>
<body>
<body leftmargin=100>
<form name="f3" method="POST">
   <table>
      <tr>
         <td align="center" width="150"><img src = "<c:url value='/images/somsom.jpg' />" width = "120" height = "120"></td>
         <td width="500"><h1><b>병원 상세 정보</b></h1></td>
      </tr>
   </table> 
   <b>병원 검색하기</b><br>
   <table style="border : 2px solid lightpink">
      <tr>
         <td width="100" align="center" bgcolor="FFEBFE" height = "50"><img src = "<c:url value='/images/hospital.jpg' />" height = "40" width ="100"></td>
         <td width="150"  bgcolor="ffffff" style="padding-left: 10"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <select name = "city" id="city" onchange="cityChange(this)">
               <option value="ci">시</option>
               <option value="seoul" id="seoul">서울시</option>
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
         </td>
         <td width="120" bgcolor="ffffff" style="padding-left: 10"> 
            <select id = "gu" name = "gu">
               <option>구</option>
            </select>
         </td>
         <td align="center" width ="70"> <input type="button" value="검색" onClick="detail('<c:url value='/pet/hospitalSearch' />')"></td> 
      </tr>
   </table>
    
   <br>
   <b>병원 상세 정보</b>
   <table class = "detailC" style="border : 2px solid lightpink">
      <tr>
         <td id="details" width="455" height="300">
         병원명:  ${hospital.name} <br>
         전화번호:  ${hospital.phone} <br>
         주소:  ${hospital.address} <br>
         운영시간:  ${hospital.hour} <br>
         
         </td>
      </tr>
   </table>
</form>
</body>
</html>