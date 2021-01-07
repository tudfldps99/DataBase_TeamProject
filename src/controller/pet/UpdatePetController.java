package controller.pet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Pet;
import model.service.PetService;

public class UpdatePetController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub

      String userId = request.getParameter("userId");
      String petId = request.getParameter("petId");
      
      PetService petService = PetService.getInstance();
      List<Pet> petList;
      Pet pet = petService.findPet(Integer.parseInt(petId));

//      pet.setAdopt(1);
//      pet.setNoAdopt(0);
      
      int rslt = petService.updateApply(pet, userId);
      
      if(rslt > 0) {
         petList = petService.findAdoptList();
         request.setAttribute("petList", petList);
         request.setAttribute("userId", userId);
         request.setAttribute("kind", "전체보기");
         request.setAttribute("selectView", "전체보기");
          request.setAttribute("userId", userId);
         return "/pet/listAdoptFirst";
      }
      else {
         petList = petService.findAdoptList();
         request.setAttribute("petList", petList);
         request.setAttribute("userId", userId);
         request.setAttribute("kind", "전체보기");
         request.setAttribute("selectView", "전체보기");
          request.setAttribute("userId", userId);
         return "/pet/listAdoptFirst";
      }
   }



//     String userId = request.getParameter("userId");
//     
//   PetService petService = PetService.getInstance();
//   List<Pet> petList;
//     Pet pet;
//   int petId = Integer.parseInt(request.getParameter("petId"));
//   
//   try {
//      pet = petService.findPet(petId);
//      petService.updateApply(pet, userId);
//   } catch(Exception e) {
//      e.printStackTrace();
//      petList = petService.findAdoptList();
//
//      request.setAttribute("petList", petList);
//      request.setAttribute("userId", userId);
//      request.setAttribute("kind", "전체보기");
//      request.setAttribute("selectView", "전체보기");
//      return "/pet/adoptForm.jsp";
//   }
//   petList = petService.findAdoptList();
//   request.setAttribute("petList", petList);
//   request.setAttribute("userId", userId);
//   request.setAttribute("kind", "전체보기");
//   request.setAttribute("selectView", "전체보기");
//    request.setAttribute("userId", userId);
//   return "/pet/applyForm.jsp";
}