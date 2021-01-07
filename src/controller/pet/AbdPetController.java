package controller.pet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Area;
import model.Pet;
import model.service.AreaService;
import model.service.PetService;

public class AbdPetController implements Controller{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      PetService petService = PetService.getInstance();
      AreaService areaService = AreaService.getInstance();
      Area area = null;
      String kind = request.getParameter("kind");
      String variety = request.getParameter("variety");
      String city = request.getParameter("city");
      String gu = request.getParameter("gu");
      String gender = request.getParameter("gender");
  
      List<Pet> petList = null;
      
      try {
         if(city.equals("seoul") && gu.equals("강남구")) 
            area = areaService.findArea("서울특별시", "강남구");
           else if(city.equals("seoul") && gu.equals("구로구"))
              area = areaService.findArea("서울특별시", "구로구");
           else if(city.equals("seoul") && gu.equals("은평구"))
              area = areaService.findArea("서울특별시", "은평구");
           else if(city.equals("seoul") && gu.equals("마포구"))
              area = areaService.findArea("서울특별시", "마포구");
           else if(city.equals("seoul") && gu.equals("서대문구"))
              area = areaService.findArea("서울특별시", "서대문구");
           else if(city.equals("incheon") && gu.equals("중구"))
              area = areaService.findArea("인천광역시", "중구");
           else if(city.equals("incheon") && gu.equals("계양구"))
              area = areaService.findArea("인천광역시", "계양구");
           else if(city.equals("incheon") && gu.equals("강화군"))
              area = areaService.findArea("인천광역시", "강화군");
           else if(city.equals("incheon") && gu.equals("서구"))
              area = areaService.findArea("인천광역시", "서구");
           else if(city.equals("incheon") && gu.equals("동구"))
              area = areaService.findArea("인천광역시", "동구");
           else if(city.equals("daejeon") && gu.equals("중구"))
              area = areaService.findArea("대전광역시", "중구");
           else if(city.equals("daejeon") && gu.equals("대덕구"))
              area = areaService.findArea("대전광역시", "대덕구");
           else if(city.equals("daejeon") && gu.equals("동구"))
              area = areaService.findArea("대전광역시", "동구");
           else if(city.equals("daejeon") && gu.equals("서구"))
              area = areaService.findArea("대전광역시", "서구");
           else if(city.equals("daejeon") && gu.equals("유성구"))
              area = areaService.findArea("대전광역시", "유성구");
           else if(city.equals("gwangju") && gu.equals("동구"))
              area = areaService.findArea("광주광역시", "동구");
           else if(city.equals("gwangju") && gu.equals("남구"))
              area = areaService.findArea("광주광역시", "남구");
           else if(city.equals("gwangju") && gu.equals("광산구"))
              area = areaService.findArea("광주광역시", "광산구");
           else if(city.equals("gwangju") && gu.equals("서구"))
              area = areaService.findArea("광주광역시", "서구");
           else if(city.equals("gwangju") && gu.equals("북구"))
              area = areaService.findArea("광주광역시", "북구");
           else if(city.equals("daegu") && gu.equals("동구"))
              area = areaService.findArea("대구광역시", "동구");
           else if(city.equals("daegu") && gu.equals("중구"))
              area = areaService.findArea("대구광역시", "중구");
           else if(city.equals("daegu") && gu.equals("남구"))
              area = areaService.findArea("대구광역시", "남구");
           else if(city.equals("daegu") && gu.equals("북구"))
              area = areaService.findArea("대구광역시", "북구");
           else if(city.equals("daegu") && gu.equals("서구"))
              area = areaService.findArea("대구광역시", "서구");
           else if(city.equals("ulsan") && gu.equals("울주군"))
              area = areaService.findArea("울산광역시", "울주군");
           else if(city.equals("ulsan") && gu.equals("동구"))
              area = areaService.findArea("울산광역시", "동구");
           else if(city.equals("ulsan") && gu.equals("남구"))
              area = areaService.findArea("울산광역시", "남구");
           else if(city.equals("ulsan") && gu.equals("중구"))
              area = areaService.findArea("울산광역시", "중구");
           else if(city.equals("ulsan") && gu.equals("북구"))
              area = areaService.findArea("울산광역시", "북구");
           else if(city.equals("busan") && gu.equals("서구"))
              area = areaService.findArea("부산광역시", "서구");
           else if(city.equals("busan") && gu.equals("남구"))
              area = areaService.findArea("부산광역시", "남구");
           else if(city.equals("busan") && gu.equals("북구"))
              area = areaService.findArea("부산광역시", "북구");
           else if(city.equals("busan") && gu.equals("중구"))
              area = areaService.findArea("부산광역시", "중구");
           else if(city.equals("busan") && gu.equals("강서구"))
              area = areaService.findArea("부산광역시", "강서구");
           else if(city.equals("gyeonggi") && gu.equals("광명시"))
              area = areaService.findArea("경기도", "광명시");
           else if(city.equals("gyeonggi") && gu.equals("김포시"))
              area = areaService.findArea("경기도", "김포시");
           else if(city.equals("gyeonggi") && gu.equals("고양시"))
              area = areaService.findArea("경기도", "고양시");
           else if(city.equals("gyeonggi") && gu.equals("여주시"))
              area = areaService.findArea("경기도", "여주시");
           else if(city.equals("gyeonggi") && gu.equals("안양시"))
              area = areaService.findArea("경기도", "안양시");
           else if(city.equals("gangwon") && gu.equals("평창군"))
              area = areaService.findArea("강원도", "평창군");
           else if(city.equals("gangwon") && gu.equals("고성군"))
              area = areaService.findArea("강원도", "고성군");
           else if(city.equals("gangwon") && gu.equals("양양군"))
              area = areaService.findArea("강원도", "양양군");
           else if(city.equals("gangwon") && gu.equals("인제군"))
              area = areaService.findArea("강원도", "인제군");
           else if(city.equals("gangwon") && gu.equals("강릉시"))
              area = areaService.findArea("강원도", "강릉시");
           else if(city.equals("sejong") && gu.equals("세종특별자치시"))
              area = areaService.findArea("세종특별자치시", "세종특별자치시");
           else if(city.equals("chungnam") && gu.equals("아산시"))
              area = areaService.findArea("충청남도", "아산시");
           else if(city.equals("chungnam") && gu.equals("천안시"))
              area = areaService.findArea("충청남도", "천안시");
           else if(city.equals("chungnam") && gu.equals("당진시"))
              area = areaService.findArea("충청남도", "당진시");
           else if(city.equals("chungnam") && gu.equals("논산시"))
              area = areaService.findArea("충청남도", "논산시");
           else if(city.equals("chungnam") && gu.equals("보령시"))
              area = areaService.findArea("충청남도", "보령시");
           else if(city.equals("chungbuk") && gu.equals("충주시"))
              area = areaService.findArea("충청북도", "충주시");
           else if(city.equals("chungbuk") && gu.equals("청주시"))
              area = areaService.findArea("충청북도", "청주시");
           else if(city.equals("chungbuk") && gu.equals("영동군"))
              area = areaService.findArea("충청북도", "영동군");
           else if(city.equals("chungbuk") && gu.equals("단양군"))
               area = areaService.findArea("충청북도", "단양군");
           else if(city.equals("chungbuk") && gu.equals("제천시"))
              area = areaService.findArea("충청북도", "제천시");
           else if(city.equals("jeonnam") && gu.equals("나주시"))
              area = areaService.findArea("전라남도", "나주시");
           else if(city.equals("jeonnam") && gu.equals("강진군"))
              area = areaService.findArea("전라남도", "강진군");
           else if(city.equals("jeonnam") && gu.equals("순천시"))
              area = areaService.findArea("전라남도", "순천시");
           else if(city.equals("jeonnam") && gu.equals("완도군"))
              area = areaService.findArea("전라남도", "완도군");
           else if(city.equals("jeonnam") && gu.equals("해남군"))
              area = areaService.findArea("전라남도", "해남군");
           else if(city.equals("jeonbuk") && gu.equals("임실군"))
              area = areaService.findArea("전라북도", "임실군");
           else if(city.equals("jeonbuk") && gu.equals("전주시"))
              area = areaService.findArea("전라북도", "전주시");
           else if(city.equals("jeonbuk") && gu.equals("익산시"))
              area = areaService.findArea("전라북도", "익산시");
           else if(city.equals("jeonbuk") && gu.equals("군산시"))
              area = areaService.findArea("전라북도", "군산시");
           else if(city.equals("jeonbuk") && gu.equals("김제시"))
              area = areaService.findArea("전라북도", "김제시");
           else if(city.equals("gyeongnam") && gu.equals("통영시"))
              area = areaService.findArea("경상남도", "통영시");
           else if(city.equals("gyeongnam") && gu.equals("함양군"))
              area = areaService.findArea("경상남도", "함양군");
           else if(city.equals("gyeongnam") && gu.equals("합천군"))
              area = areaService.findArea("경상남도", "합천군");
           else if(city.equals("gyeongnam") && gu.equals("거제시"))
              area = areaService.findArea("경상남도", "거제시");
           else if(city.equals("gyeongnam") && gu.equals("밀양시"))
              area = areaService.findArea("경상남도", "밀양시");
           else if(city.equals("gyeongbuk") && gu.equals("포항시"))
              area = areaService.findArea("경상북도", "포항시");
           else if(city.equals("gyeongbuk") && gu.equals("의성군"))
              area = areaService.findArea("경상북도", "의성군");
           else if(city.equals("gyeongbuk") && gu.equals("안동시"))
              area = areaService.findArea("경상북도", "안동시");
           else if(city.equals("gyeongbuk") && gu.equals("영천시"))
              area = areaService.findArea("경상북도", "영천시");
           else if(city.equals("gyeongbuk") && gu.equals("울릉군"))
              area = areaService.findArea("경상북도", "울릉군");
           else if(city.equals("jeju") && gu.equals("제주특별자치도"))
              area = areaService.findArea("제주특별자치도", "제주특별자치도");
       
       System.out.println(area.getAreaId() + kind);
       
       if(kind.equals("dog")) 
          kind = "강아지";
       else if(kind.equals("cat"))
          kind = "고양이";
       else if(kind.equals("hedgehog"))
          kind = "고슴도치";
       else
          kind = "페럿";
       
       
       petList = petService.findPetList(kind, variety, area.getAreaId(), gender);
       
       request.setAttribute("petList", petList);   
       request.setAttribute("area", area);
       } catch(Exception e) {
             return "/pet/abdForm.jsp";
       }
               
      return "/pet/abdForm.jsp";   
      
   }

}