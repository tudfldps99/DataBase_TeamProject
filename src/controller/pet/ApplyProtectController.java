package controller.pet;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.*;
import model.service.AreaService;
import model.service.PetService;

public class ApplyProtectController implements Controller{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
       PetService petService = PetService.getInstance();
       AreaService areaService = AreaService.getInstance();
        Area area = null;
        List<Pet> petList = null;
        petList = petService.findAdoptList();
        List<Pet> petList2 = null;
        petList2 = petService.findPetList();
        
        int hospitalId;
       int areaId = 0;
       
       
       String age = request.getParameter("age");
       String gen = request.getParameter("gen");
       String img = request.getParameter("img");
       String weight = request.getParameter("weight");
       String kind = request.getParameter("kind");
       String variety = request.getParameter("variety");
       String pdate = request.getParameter("pdate");
       String memo = request.getParameter("memo"); 
       
       String city = request.getParameter("city");
       String gu = request.getParameter("gu");
       
       String userId = request.getParameter("userId");
       
       try {
            if(city.equals("seoul") && gu.equals("강남구")) {
               area = areaService.findArea("서울특별시", "강남구");
               areaId = 1;
            }
              else if(city.equals("seoul") && gu.equals("구로구")){
                 area = areaService.findArea("서울특별시", "구로구");
                 areaId = 2;
                                                     }
              else if(city.equals("seoul") && gu.equals("은평구")){
                 area = areaService.findArea("서울특별시", "은평구");
                 areaId = 3;
                }
              else if(city.equals("seoul") && gu.equals("마포구")){
                 area = areaService.findArea("서울특별시", "마포구");
                 areaId = 4;}
              else if(city.equals("seoul") && gu.equals("서대문구")) {
                 area = areaService.findArea("서울특별시", "서대문구");
                 areaId = 5;}
              else if(city.equals("incheon") && gu.equals("중구")) {
                 area = areaService.findArea("인천광역시", "중구");
                 areaId = 10;}
              else if(city.equals("incheon") && gu.equals("계양구")) {
                 area = areaService.findArea("인천광역시", "계양구");
                 areaId = 7;}
              else if(city.equals("incheon") && gu.equals("강화군")) {
                 area = areaService.findArea("인천광역시", "강화군");
                 areaId = 6;}
              else if(city.equals("incheon") && gu.equals("서구")) {
                 area = areaService.findArea("인천광역시", "서구");
                 areaId = 9;}
              else if(city.equals("incheon") && gu.equals("동구")) {
                 area = areaService.findArea("인천광역시", "동구");
                 areaId = 8;}
              else if(city.equals("daejeon") && gu.equals("중구")) {
                 area = areaService.findArea("대전광역시", "중구");
                 areaId = 16;}
              else if(city.equals("daejeon") && gu.equals("대덕구")) {
                 area = areaService.findArea("대전광역시", "대덕구");
                 areaId = 17;}
              else if(city.equals("daejeon") && gu.equals("동구")) {
                 area = areaService.findArea("대전광역시", "동구");
                 areaId = 18;}
              else if(city.equals("daejeon") && gu.equals("서구")) {
                 area = areaService.findArea("대전광역시", "서구");
                 areaId = 19;}
              else if(city.equals("daejeon") && gu.equals("유성구")) {
                 area = areaService.findArea("대전광역시", "유성구");
                 areaId = 20;}
              else if(city.equals("gwangju") && gu.equals("동구")) {
                 area = areaService.findArea("광주광역시", "동구");
                 areaId = 11;}
              else if(city.equals("gwangju") && gu.equals("남구")) {
                 area = areaService.findArea("광주광역시", "남구");
                 areaId = 12;}
              else if(city.equals("gwangju") && gu.equals("광산구")) {
                 area = areaService.findArea("광주광역시", "광산구");
                 areaId = 13;}
              else if(city.equals("gwangju") && gu.equals("서구")) {
                 area = areaService.findArea("광주광역시", "서구");
                 areaId = 14;}
              else if(city.equals("gwangju") && gu.equals("북구")) {
                 area = areaService.findArea("광주광역시", "북구");
                 areaId = 15;}
              else if(city.equals("daegu") && gu.equals("동구")) {
                 area = areaService.findArea("대구광역시", "동구");
                 areaId = 21;}
              else if(city.equals("daegu") && gu.equals("중구")) {
                 area = areaService.findArea("대구광역시", "중구");
                 areaId = 22;}
              else if(city.equals("daegu") && gu.equals("남구")) {
                 area = areaService.findArea("대구광역시", "남구");
                 areaId = 23;}
              else if(city.equals("daegu") && gu.equals("북구")) {
                 area = areaService.findArea("대구광역시", "북구");
                 areaId = 24;}
              else if(city.equals("daegu") && gu.equals("서구")) {
                 area = areaService.findArea("대구광역시", "서구");
                 areaId = 25;}
              else if(city.equals("ulsan") && gu.equals("울주군")) {
                 area = areaService.findArea("울산광역시", "울주군");
                 areaId = 31;}
              else if(city.equals("ulsan") && gu.equals("동구")) {
                 area = areaService.findArea("울산광역시", "동구");
                 areaId = 32;}
              else if(city.equals("ulsan") && gu.equals("남구")) {
                 area = areaService.findArea("울산광역시", "남구");
                 areaId = 33;}
              else if(city.equals("ulsan") && gu.equals("중구")) {
                 area = areaService.findArea("울산광역시", "중구");
                 areaId = 34;}
              else if(city.equals("ulsan") && gu.equals("북구")) {
                 area = areaService.findArea("울산광역시", "북구");
                 areaId = 35;}
              else if(city.equals("busan") && gu.equals("서구")) {
                 area = areaService.findArea("부산광역시", "서구");
                 areaId = 26;}
              else if(city.equals("busan") && gu.equals("남구")) {
                 area = areaService.findArea("부산광역시", "남구");
                 areaId = 27;}
              else if(city.equals("busan") && gu.equals("북구")) {
                 area = areaService.findArea("부산광역시", "북구");
                 areaId = 28;}
              else if(city.equals("busan") && gu.equals("중구")) {
                 area = areaService.findArea("부산광역시", "중구");
                 areaId = 29;}
              else if(city.equals("busan") && gu.equals("강서구")) {
                 area = areaService.findArea("부산광역시", "강서구");
                 areaId = 30;}
              else if(city.equals("gyeonggi") && gu.equals("광명시")) {
                 area = areaService.findArea("경기도", "광명시");
                 areaId = 46;}
              else if(city.equals("gyeonggi") && gu.equals("김포시")) {
                 area = areaService.findArea("경기도", "김포시");
                 areaId = 47;}
              else if(city.equals("gyeonggi") && gu.equals("고양시")) {
                 area = areaService.findArea("경기도", "고양시");
                 areaId = 48;}
            
              else if(city.equals("gyeonggi") && gu.equals("여주시")) {
                 area = areaService.findArea("경기도", "여주시");
                 areaId = 49;}
              else if(city.equals("gyeonggi") && gu.equals("안양시")) {
                 area = areaService.findArea("경기도", "안양시");
                 areaId = 50;}
              else if(city.equals("gangwon") && gu.equals("평창군")) {
                 area = areaService.findArea("강원도", "평창군");
                 areaId = 66;}
              else if(city.equals("gangwon") && gu.equals("고성군")) {
                 area = areaService.findArea("강원도", "고성군");
                 areaId = 67;}
              else if(city.equals("gangwon") && gu.equals("양양군")) {
                 area = areaService.findArea("강원도", "양양군");
                 areaId = 68;}
              else if(city.equals("gangwon") && gu.equals("인제군")) {
                 area = areaService.findArea("강원도", "인제군");
                 areaId = 69;}
              else if(city.equals("gangwon") && gu.equals("강릉시")) {
                 area = areaService.findArea("강원도", "강릉시");
                 areaId = 70;}
              else if(city.equals("sejong") && gu.equals("세종특별자치시")) {
                 area = areaService.findArea("세종특별자치시", "세종특별자치시");
                 areaId = 71;}
              else if(city.equals("chungnam") && gu.equals("아산시")) {
                 area = areaService.findArea("충청남도", "아산시");
                 areaId = 56;}
              else if(city.equals("chungnam") && gu.equals("천안시")) {
                 area = areaService.findArea("충청남도", "천안시");
                 areaId = 57;}
              else if(city.equals("chungnam") && gu.equals("당진시")) {
                 area = areaService.findArea("충청남도", "당진시");
                 areaId = 58;}
              else if(city.equals("chungnam") && gu.equals("논산시")) {
                 area = areaService.findArea("충청남도", "논산시");
                 areaId = 59;}
              else if(city.equals("chungnam") && gu.equals("보령시")) {
                 area = areaService.findArea("충청남도", "보령시");
                 areaId = 60;}
              else if(city.equals("chungbuk") && gu.equals("충주시")) {
                 area = areaService.findArea("충청북도", "충주시");
                 areaId = 61;}
              else if(city.equals("chungbuk") && gu.equals("청주시")) {
                 area = areaService.findArea("충청북도", "청주시");
                 areaId = 62;}
              else if(city.equals("chungbuk") && gu.equals("영동군")) {
                 area = areaService.findArea("충청북도", "영동군");
                 areaId = 65;}
              else if(city.equals("chungbuk") && gu.equals("단양군")) {
                  area = areaService.findArea("충청북도", "단양군");
                  areaId = 63;}
              else if(city.equals("chungbuk") && gu.equals("제천시")) {
                 area = areaService.findArea("충청북도", "제천시");
                 areaId = 64;}
              else if(city.equals("jeonnam") && gu.equals("나주시")) {
                 area = areaService.findArea("전라남도", "나주시");
                 areaId = 72;}
              else if(city.equals("jeonnam") && gu.equals("강진군")){
                 area = areaService.findArea("전라남도", "강진군");
                 areaId = 73;}
              else if(city.equals("jeonnam") && gu.equals("순천시")) {
                 area = areaService.findArea("전라남도", "순천시");
                 areaId = 74;}
              else if(city.equals("jeonnam") && gu.equals("완도군")) {
                 area = areaService.findArea("전라남도", "완도군");
                 areaId = 75;}
              else if(city.equals("jeonnam") && gu.equals("해남군")) {
                 area = areaService.findArea("전라남도", "해남군");
                 areaId = 76;}
              else if(city.equals("jeonbuk") && gu.equals("임실군")) {
                 area = areaService.findArea("전라북도", "임실군");
                 areaId = 51;}
              else if(city.equals("jeonbuk") && gu.equals("전주시")) {
                 area = areaService.findArea("전라북도", "전주시");
                 areaId = 52;}
              else if(city.equals("jeonbuk") && gu.equals("익산시")) {
                 area = areaService.findArea("전라북도", "익산시");
                 areaId = 53;}
              else if(city.equals("jeonbuk") && gu.equals("군산시")) {
                 area = areaService.findArea("전라북도", "군산시");
                 areaId = 54;}
              else if(city.equals("jeonbuk") && gu.equals("김제시")) {
                 area = areaService.findArea("전라북도", "김제시");
                 areaId = 55;}
              else if(city.equals("gyeongnam") && gu.equals("통영시")) {
                 area = areaService.findArea("경상남도", "통영시");
                 areaId = 41;}
              else if(city.equals("gyeongnam") && gu.equals("함양군")) {
                 area = areaService.findArea("경상남도", "함양군");
                 areaId = 42;}
              else if(city.equals("gyeongnam") && gu.equals("합천군")) {
                 area = areaService.findArea("경상남도", "합천군");
                 areaId = 43;}
              else if(city.equals("gyeongnam") && gu.equals("거제시")) {
                 area = areaService.findArea("경상남도", "거제시");
                 areaId = 44;}
              else if(city.equals("gyeongnam") && gu.equals("밀양시")) {
                 area = areaService.findArea("경상남도", "밀양시");
                 areaId = 45;}
              else if(city.equals("gyeongbuk") && gu.equals("포항시")) {
                 area = areaService.findArea("경상북도", "포항시");
                 areaId = 36;}
              else if(city.equals("gyeongbuk") && gu.equals("의성군")) {
                 area = areaService.findArea("경상북도", "의성군");
                 areaId = 37;}
              else if(city.equals("gyeongbuk") && gu.equals("안동시")) {
                 area = areaService.findArea("경상북도", "안동시");
                 areaId = 38;}
              else if(city.equals("gyeongbuk") && gu.equals("영천시")) {
                 area = areaService.findArea("경상북도", "영천시");
                 areaId = 39;}
              else if(city.equals("gyeongbuk") && gu.equals("울릉군")) {
                 area = areaService.findArea("경상북도", "울릉군");
                 areaId = 40;}
              else if(city.equals("jeju") && gu.equals("제주특별자치도")) {
                 area = areaService.findArea("제주특별자치도", "제주특별자치도");
                 areaId = 77;}
          
          System.out.println(area.getAreaId() + kind);
          
          if(kind.equals("dog")) 
             kind = "강아지";
          else if(kind.equals("cat"))
             kind = "고양이";
          else if(kind.equals("hedgehog"))
             kind = "고슴도치";
          else
             kind = "페럿";
          
       
       hospitalId = areaId;
       Pet pet = new Pet("모름", gen, variety, Integer.parseInt(age), kind, pdate, memo, Float.parseFloat(weight), "00000000" , hospitalId, areaId, img, 1, 0, 1, 0);
 
       petService.create(pet);
   
       request.setAttribute("pet", pet);
       request.setAttribute("area", area);   
       request.setAttribute("userId", userId);
      
       petList = petService.findAdoptList();
       request.setAttribute("petList", petList);
       petList2 = petService.findPetList();
       request.setAttribute("petList2", petList2);
       
       
       } catch(Exception e) {
          return "/pet/protect_apply_form.jsp";
       }
       
       return "/pet/information_form.jsp";
    }
}