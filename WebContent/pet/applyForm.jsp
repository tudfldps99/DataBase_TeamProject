<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입양 신청 페이지</title>
<script>
//15번~18번 동의에 체크하지 않을 시 입양 못하는 alert 띄우기
function applyCheck() {
   var n = document.getElementById("Name").value;
   var t = document.getElementById("Tel").value;
   var e = document.getElementById("Email").value;
   
   if(n.length == 0) {
      alert("이름을 입력하십시오.");
      return false;
   }

   if(t.length!=11) {
      if(t.length == 0)
         alert("전화번호를 입력하십시오.");
      else
         alert("전화번호 형식이 올바르지 않습니다.");
      return false;
   }
   
   var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
   if(emailExp.test(e)==false){
      if(! e)
         alert("이메일을 입력하십시오.");
      else
         alert("이메일 형식이 올바르지 않습니다.");
      return false;
   }
   
   if(emailExp.test(e)==true && t.length == 11 && n.length != 0) {
      form.action='<c:url value='/pet/update' />'
      form.submit();
   }
}

function sendURI(targetUri) {
   form.action = targetUri;
   form.submit();
}
</script>
<style type = "text/css">
   .sc {align:center; margin-left:10px; margin-right:10%}
   .agree {align:center; margin-left:10px; margin-right:10px; height:200px; overflow: scroll;
   border-color: lightPink; border-style:solid; border-width:medium;}
</style>
</head>
<body>
<form name="form" method="POST">
<table>
<tr>
<td>
<table style="width:100%; border:0; cellpadding:0; cellspacing:0; text-align:center;">
   <tr>
      <td>
         <table style="width:100%; border:0; cellpadding:0; cellspacing:0; font-size:30px">
            <tr>
                 <th bgcolor="lightpink" height="50"><b><c:out value="${pet.pname}"></c:out>의 입양 신청서 작성</b></th>
            </tr>
           </table>
        </td>
     </tr>
</table>
<br>
<div style="font-weight:bold; margin-left:10px;">개인정보 취급방침</div>
<div class="agree">
<table>
   <tr>
      <td>
        ■ 개인정보 수집에 대한 동의<br><br>
        1) "단체"는 이용자의 개인정보를 수집하는 경우에는 [위의 개인정보취급방침에 동의합니다]의 체크박스에 체크하는 절차를 마련하고 있으며, [위의 개인정보취급방침에 동의합니다]의 체크박스에 체크하였을 경우 개인정보 수집에 대하여 동의한 것으로 봅니다.<br>
        2) "단체"는 다음 사항에 해당하는 경우에 이용자의 별도 동의 없이 개인정보를 수집.이용할 수 있습니다.<br>
        - 서비스의 제공에 관한 계약의 이행을 위하여 필요한 개인정보로서 경제적.기술적인 사유로 통상의 동의를 받는 것이 현저히 곤란한 경우<br>
        - 서비스의 제공에 따른 요금정산을 위하여 필요한 경우<br>
        - 이 법 또는 다른 법률에 특별한 규정이 있는 경우<br><br>
        ■ 수집하는 개인정보 항목<br><br>
        단체는 회원가입, 상담, 서비스 신청 등등을 위해 아래와 같은 개인정보를 수집하고 있습니다.<br><br>
        ο 수집항목 : 이름, 생년월일, 로그인ID, 비밀번호, 자택 전화번호, 자택 주소, 휴대전화번호, 이메일, 직업, 단체명, 단체전화번호, 주민등록번호, 은행계좌 정보, 접속 로그, 쿠키, 후원회비, 자동이체날짜, 봉사희망분야, 단체주소, 자기소개, 자기정보공개여부<br>
        ο 개인정보 수집방법 : 홈페이지(회원가입,후원하기)<br><br>
        ■ 개인정보의 수집 및 이용목적<br><br>
        단체는 수집한 개인정보를 다음의 목적을 위해 활용합니다..<br><br>
        ο 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산<br>
        - 콘텐츠 제공<br>
        ο 회원 관리<br>
        - 회원제 서비스 이용에 따른 본인확인 , 개인 식별 , 불만처리 등 민원처리 , 고지사항 전달<br>
        ο 마케팅 및 광고에 활용<br>
        - 이벤트 등 광고성 정보 전달<br><br>
        ■ 개인정보의 보유 및 이용기간<br><br>
        원칙적으로, 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 단, 관계법령의 규정에 의하여 보존할 필요가 있는 경우 단체는 아래와 같이 관계법령에서 정한 일정한 기간 동안 회원정보를 보관합니다.<br><br>
        - 보존 항목 : 이름, 휴대전화번호, 이메일, 은행계좌 정보, 후원회비, 자동이체날짜, 봉사희망분야, 단체주소, 자기소개, 자기정보공개여부<br>
        - 보존 근거 : 전자상거래등에서의 소비자보호에 관한 법률<br>
        - 보존 기간 : 5년
      </td>
   </tr>
</table>
</div>
<input id="adoptCheckbox1" type="checkbox" value="agree" style="margin-left:10px;">위 개인정보취급방침에 동의합니다.(선택하지 않을 시 입양 불가)
<br>
<br>
<br>
<div style="font-weight:bold; margin-left:10px; background-color:LightPink; text-align:center;">* 다음 양식을 채워주세요 (필수 입력 사항) *</div>
<br>
<div class="sc">
<table style="width:100%; border:0; cellpadding:0; cellspacing:0; text-align:left;">
   <tr>
      <td style="width:20%"><strong style="width:100%">1. 신청인 성명 (필수)</strong></td>
      <td style="width:80%"><input id="Name" type="text" style="width:100%" required></td>
    </tr>
    
   <tr>
      <td>&nbsp;</td>
   </tr>
    
   <tr>
      <td style="width:20%"><strong style="width:100%">2. 성별 (필수)</strong></td>
      <td style="width:80%">
         <input type = "radio" name = "gender" value = "M" checked> 남
            <input type = "radio" name = "gender" value = "F"> 여
      </td>
    </tr>
    
   <tr>
      <td>&nbsp;</td>
   </tr>
    
   <tr>
      <td style="width:20%"><strong style="width:100%">3. 연령 (필수)</strong></td>
      <td style="width:80%"><input name = "Age" id="Age" type="number" placeholder="숫자만 입력해주세요. (만 나이)" style="width:100%" required></td>
    </tr>
    
   <tr>
      <td>&nbsp;</td>
   </tr>
    
   <tr>
      <td style="width:20%"><strong style="width:100%">4. 전화번호 (필수)</strong></td>
      <td style="width:80%"><input name = "Tel" id="Tel" type="number" placeholder="숫자만 기재하는 '###########' 형식을 지켜 작성해주세요."
         style="width:100%" pattern = "[0-9]{11}" required></td>
         <!--pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"or /^\d{2,3}-\d{3,4}-\d{4}$/ -->
    </tr>
    
   <tr>
      <td>&nbsp;</td>
   </tr>
   
   <tr>
      <td style="width:20%"><strong style="width:100%">5. 이메일</strong></td>
      <td style="width:80%"><input name = "" id="Email" type="email" placeholder="올바른 형식의 이메일 주소를 입력해주세요." style="width:100%" required></td>
         <!--"/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/" -->
    </tr>
    
   <tr>
      <td>&nbsp;</td>
   </tr>
    
   <tr>
      <td style="width:20%"><strong style="width:100%">6. 통화하기 편한 시간</strong></td>
      <td style="width:80%"><input name="Atime" type="text" placeholder="" style="width:100%"></td>
    </tr>
    
   <tr>
      <td>&nbsp;</td>
   </tr>
    
   <tr>
      <td style="width:20%"><strong style="width:100%">7. 거주 지역</strong></td>
      <td style="width:80%"><input name="Address" type="text" placeholder="(예 : 서울, 경기, 강원... 등)" style="width:100%"></td>
    </tr>
    
   <tr>
      <td>&nbsp;</td>
   </tr>
    
   <tr>
      <td style="width:20%"><strong style="width:100%">8. 결혼여부</strong></td>
      <td style="width:80%">
         <input name="Wedding" value="기혼" type="radio" checked />기혼
         <input name="Wedding" value="미혼" type="radio" />미혼
      </td>
    </tr>
    
   <tr>
      <td>&nbsp;</td>
   </tr>
    
   <tr>
      <td style="width:20%"><strong style="width:100%">9. 신청인 직업</strong></td>
      <td style="width:80%"><input name="Job" type="text" placeholder="선택 입력 사항으로 구체적으로 기재하지 않으셔도 됩니다." style="width:100%"></td>
    </tr>
 </table>
 </div>
    
<br>
<br>
<div style="font-weight:bold; margin-left:10px; background-color:LightPink; text-align:center;">* 지금부터 설문을 시작하겠습니다 *</div>
<br>

<div class="sc">
<table style="width:100%; border:0; cellpadding:0; cellspacing:0; text-align:left;">
   <tr>
      <td style="width:100%"><strong style="width:100%">1. 예전에 반려동물을 키우신 적이 있으신가요?</strong></td>
    </tr>
   <tr>
      <td style="width:100%">
         <input name="Q1" value="예" type="radio">예
            <input name="Q1" value="아니오" type="radio">아니오
        </td>
    </tr>
    <tr>
       <td colspan="2" style="width:100%">(만일 있으시다면 어떤 종류의 동물인지, 얼마나 오래 키우셨는지, 지금은 어떻게 되었는지 적어주세요.)</td>
    </tr>
    <tr>
       <td colspan="2" style="width:100%">
          <textarea name="Q2" style="width:100%; resize: none;" rows="7"></textarea></td>
    </tr>
    
    <tr>
       <td>&nbsp;</td>
    </tr>
    
    <tr>
      <td style="width:100%"><strong style="width:100%">2. 현재 집에서 다른 동물을 키우고 계십니까?</strong></td>
    </tr>
   <tr>
      <td style="width:100%"><input name="Q3" value="예" type="radio">예
            <input name="Q3" value="아니오" type="radio">아니오</td>
    </tr>
    <tr>
       <td colspan="2" style="width:100%">(만일 있으시다면 다음 사항에 체크해 주세요.)</td>
    </tr>
    <tr>
      <td colspan="2"><strong style="width:100%">종류</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><input name="Q4" type="text" placeholder=""></td>
    </tr>
    <tr>
      <td colspan="2"><strong style="width:100%">나이</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><input name="Q5" type="text" placeholder=""></td>
    </tr>
    <tr>
      <td colspan="2"><strong style="width:100%">성별</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><input name="Q6" type="text" placeholder=""></td>
    </tr>
    <tr>
      <td colspan="2"><strong style="width:100%">중성화 여부</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><input name="Q7" value="예" type="radio">예<input name="Q7" value="아니오" type="radio">아니오</td>
    </tr>
    
    <tr>
       <td>&nbsp;</td>
    </tr>
    
    <tr>
      <td style="width:100%"><strong style="width:100%">3. 귀하의 가족은 모두 몇 명인가요?</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><strong style="width:100%">어른</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><input name="Q8" type="number" placeholder="숫자를 입력해주세요." style="width:50%">명</td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><strong style="width:100%">아이</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><input name="Q9" type="number" placeholder="숫자를 입력해주세요." style="width:50%">명</td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><strong style="width:100%">아이의 나이</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><input name="Q10" type="number" placeholder="여러 명일 경우 가장 어린 아이의 나이를 입력해주세요." style="width:50%">세</td>
    </tr>
    
    <tr>
       <td>&nbsp;</td>
    </tr>
    
   <tr>
      <td style="width:100%"><strong style="width:100%">4. 거주하고 계신 주택 형태에 표시해 주세요.</strong></td>
    </tr>
   <tr>
      <td style="width:100%">
         <input name="Q11" value="아파트" type="radio" checked>아파트
            <input name="Q11" value="단독주택" type="radio">단독주택
            <input name="Q11" value="빌라/다세대" type="radio">빌라/다세대
            <input name="Q11" value="원룸" type="radio">원룸
            <input name="Q11" value="기타" type="radio">기타 <input name="Q12" type="text" placeholder="직접 입력해주세요.">
        </td>
    </tr>
    
    <tr>
       <td>&nbsp;</td>
    </tr>
    
   <tr>
      <td style="width:100%"><strong style="width:100%">5. 가족들은 입양에 대해서 모두 찬성하시나요?</strong></td>
    </tr>
   <tr>
      <td style="width:100%">
         <input name="Q13" value="모두 찬성" type="radio" checked>모두 찬성
            <input name="Q13" value="부분 찬성" type="radio">부분 찬성
            <input name="Q13" value="본인 제외 모두 반대" type="radio">본인 제외 모두 반대
        </td>
    </tr>
    
    <tr>
       <td>&nbsp;</td>
    </tr>
    
   <tr>
      <td style="width:100%"><strong style="width:100%">6. 입양을 원하시는 이유는 무엇인가요?</strong></td>
    </tr>
    <tr>
       <td colspan="2" style="width:100%">
          <textarea name="Q14" style="width:100%; resize: none;" rows="7"></textarea></td>
    </tr>
    
    <tr>
       <td>&nbsp;</td>
    </tr>
    
    <tr>
      <td style="width:100%"><strong style="width:100%">7. 만약 댁에서 새로운 아기가 출생할 경우 입양된 동물을 계속 키우실 수 있겠습니까?</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><input name="Q15" value="예" type="radio" checked>예<input name="Q15" value="아니오" type="radio">아니오</td>
    </tr>
    
    <tr>
       <td>&nbsp;</td>
    </tr>
    
   <tr>
      <td style="width:100%"><strong style="width:100%">8. 귀하와 가족의 부재시(여행,명절,휴가 등) 반려동물을 어떻게 관리하실 예정이신가요??</strong></td>
    </tr>
    <tr>
       <td colspan="2" style="width:100%">
          <textarea name="Q16" style="width:100%; resize: none;" rows="7"></textarea></td>
    </tr>
    
    <tr>
       <td>&nbsp;</td>
    </tr>
    
   <tr>
      <td style="width:100%"><strong style="width:100%">12. 반려동물의 수명은 15년이상 됩니다. 10년이상 키울 수 있으십니까? 만약의 경우 입양 동물을 키우다가 더이상 양육할 여건이 되지 못할 시,
                제3자에게 양도하지 않고 본 단체로 돌려보내 주실 것에 동의하십니까?</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><input name="Q17" value="예" type="radio" checked>예<input name="Q17" value="아니오" type="radio">아니오</td>
    </tr>
    
    <tr>
       <td>&nbsp;</td>
    </tr>
    
   <tr>
      <td style="width:100%"><strong style="width:100%">13. 반려동물을 입양하시려면, 입양비(유기견의 구조와 치료, 구제비로 사용됩니다)를 납부하셔야 하며 중성화 수술 시행에도 동의하셔야 합니다. 동의하십니까?</strong></td>
    </tr>
    <tr>
      <td colspan="2" style="width:100%"><input name="Q18" value="예" type="radio" checked>예<input name="Q18" value="아니오" type="radio">아니오</td>
    </tr>
    
    <tr>
       <td>&nbsp;</td>
    </tr>
    
    <tr>
      <td style="width:20%"><strong style="width:100%"></strong></td>
      <td style="width:80%">
    </tr>
    <tr>
      <td style="width:20%"><strong style="width:100%"></strong></td>
      <td style="width:80%">
    </tr>
    <tr>
      <td style="width:20%"><strong style="width:100%"></strong></td>
      <td style="width:80%">
    </tr>
</table>
</div>
</td>
</tr>
</table>
<input type="text" id = "petId" name="petId" value='${pet.petId}' style="position:absolute; opacity:0;"/>         
<input type="text" id = "userId" name="userId" value='${userId}' style="position:absolute; opacity:0;"/>
<div align="center">
    <input type="submit" value="신청" onclick="applyCheck()" style="background-color:LightPink;">
    <input type="submit" value="취소" onclick="sendURI('<c:url value='/pet/listAdoptFirst'>
       <c:param name="userId" value='${userId}' /></c:url>')" style="background-color:LightPink;">
</div>
</form>
</body>
</html>