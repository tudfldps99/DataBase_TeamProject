package controller.pet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Pet;
import model.service.PetService;

public class ApplyController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub

      String userId = request.getParameter("userId");
      String petId = request.getParameter("petId");

         
      PetService petService = PetService.getInstance();
         
      try {
         Pet pet = petService.findPet(Integer.parseInt(petId));
         request.setAttribute("pet", pet);
          request.setAttribute("userId", userId);
         request.setAttribute("pname", pet.getPname());
         return "/pet/applyForm.jsp";
      } catch(Exception e) {
         e.printStackTrace();
         List<Pet> petList = petService.findAdoptList();

         request.setAttribute("petList", petList);
         request.setAttribute("userId", userId);
         request.setAttribute("kind", "전체보기");
         request.setAttribute("selectView", "전체보기");
         
         return "/pet/adoptForm.jsp";
      }
   }
}