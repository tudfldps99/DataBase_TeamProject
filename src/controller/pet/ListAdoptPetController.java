package controller.pet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Pet;
import model.service.PetService;

public class ListAdoptPetController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub

       String userId = request.getParameter("userId");
       //userId = (String) request.getAttribute("userId");
       //kind = (String) request.getAttribute("kind");
       String selectView = request.getParameter("view");
       String kind = request.getParameter("kind");
      List<Pet> petList = null;
       
       try {
           
          PetService petService = PetService.getInstance();
         if(selectView.equals("전체보기")) {
            if(kind.equals("전체보기"))
               petList = petService.findAdoptList();
            else if(kind.equals("기타"))
               petList = petService.findAdoptListExc();
            else
               petList = petService.findAdoptList(kind);
         }
         else if(selectView.equals("입양 가능 동물만 보기")) {
            if(kind.equals("전체보기"))
               petList = petService.findOnlyAdoptList();
            else if(kind.equals("기타"))
               petList = petService.findOnlyAdoptListExc();
            else
               petList = petService.findOnlyAdoptList(kind);
         }
         else if(selectView.equals("입양 완료인 동물만 보기")) {
            if(kind.equals("전체보기"))
               petList = petService.findOnlyNoAdoptList();
            else if(kind.equals("기타"))
               petList = petService.findOnlyNoAdoptListExc();
            else
               petList = petService.findOnlyNoAdoptList(kind);
         }
         
         request.setAttribute("kind", kind);
         request.setAttribute("selectView", selectView);
         request.setAttribute("petList", petList);
          request.setAttribute("userId", userId);
          
       } catch(Exception e) {
          e.printStackTrace();
       }
      return "/pet/adoptForm.jsp";
   }

}