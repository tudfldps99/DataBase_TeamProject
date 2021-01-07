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
<title>유기동물 검색(리스트)</title>
<style>
   table {
      border-collapse: collapse;
   }
   #href {
      position: relative;
      left: 330px;
   }
</style>
<script>
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
      var cat = ["러시안 블루", "샴", "노르웨이 숲", "뱅갈", "코리안숏헤어"];
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
   
   function detail(targetUri) {
       f2.action = targetUri;
        f2.submit();
   }
</script>
   
</head>
<body leftmargin=100>
<form name="f2" method="POST" action="<c:url value='/pet/abdPet' />">
   <table>
      <tr>
         <td align="center" width="200"><img src = "<c:url value='/images/somsom.jpg' />" width = "140" height = "130"></td>
         <td width="500"><h1><b>#사지말고 입양하세요</b></h1></td>
      </tr>
   </table> 
   <b>유기동물 검색하기</b><br>
   <table style="border : 2px solid pink">
      <tr>
         <td width = "200" align="center" bgcolor="FFEBFE" height = "50"><img src = "<c:url value='/images/search.jpg' />" height = "40" width ="80"></td>
         <td width = "200" bgcolor="ffffff" style="padding-left: 10"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;동물선택&nbsp;
            <select name = "kind" id="kind" onchange="kindChange(this)">
               <option value="o">동물선택</option>
               <option value="dog" id = "dog">강아지</option>
               <option value="cat" id = "cat">고양이</option>
               <option value="hedgehog" id = "hedgehog">고슴도치</option>
               <option value="peleos" id = "peleos">페럿</option>
               <option value="etc" id = "etc">기타</option>
            </select>
         </td>
         <td width="200" bgcolor="ffffff" style="padding-left: 10"> 품종선택&nbsp;
            <select id = "variety" name = "variety">
               <option>품종선택</option>
            </select>
         </td>
         <td></td>
         <td rowspan = "2" align="center" width ="70"> <input type="button" value="검색" style="height:60pt" onClick="detail('<c:url value='/pet/abdpet' />')"></td> 
      </tr>
      <tr>
         <td width="200" align="center" bgcolor="FFEBFE" height = "50"><b>검색조건</b></td>
         <td width="300" bgcolor="ffffff" style="padding-left: 10"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;성별선택 &nbsp;
            <select name="gender" id="gender">
               <option value="g">성별</option>
               <option value="F" selected>여 </option>
               <option value="M"> 남</option>
            </select>
         </td>
         <td width="200" bgcolor="ffffff" style="padding-left: 10"> 지역선택 &nbsp;
            <select name = "city" id="city" onchange="cityChange(this)">
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
         </td>
         
         <td width = "100" bgcolor="ffffff" style="padding-left: 10"> 
            <select id = "gu" name = "gu">
               <option>구</option>
            </select>
         </td>
   </table>
   
   <br><br>
   <table style="width: 50%">
      <tr>
         <td width="70"><img src = "<c:url value='/images/animal.jpg' />" height = "40" width="70"></td>
         <td><h3><b>&nbsp;&nbsp;유기동물 무료분양 리스트</b></h3></td>
      </tr>
   </table> 
   
   <table style="border : 2px solid pink">
      <tr>
         <td width="120" align="center"><b>사진</b></td>
         <td width="120" align="center"><b>동물</b></td>
         <td width="120" align="center"><b>품종</b></td>
         <td width="120" align="center"><b>상세설명</b></td> 
         <td width="120" align="center"><b>성별</b></td>
         <td width="120" align="center"><b>지역</b></td>
         <td width="120" align="center"><b>등록일</b></td>
      </tr>
      <tr> 
         <c:if test="${petList.size() == 0}">
         	<td colspan ="7" width="120" align="center"><b>검색 결과가 없습니다. 다시 검색해주세요.</b></td>
         </c:if>
         <td colspan="7">
         	<c:forEach var="pet" items="${petList}">
         		<tr>
			         <td width="120" align="center"><b><img width = "30%" src = "<c:url value='${pet.image}' />"></b></td>
			         <td width="120" align="center"><b>${pet.kind}</b></td>
			         <td width="120" align="center"><b>${pet.variety}</b></td>
			         <td width="120" align="center"><b>${pet.explanation}</b></td> 
			         <td width="120" align="center"><b>${pet.gender}</b></td>
			         <td width="120" align="center"><b>${area.city}</b></td>
			         <td width="120" align="center"><b>${pet.pdate}</b></td>
	        	 </tr>
	         </c:forEach>
	     </td>
      </tr>
   </table>
   <br>
</form>
</body>
</html>