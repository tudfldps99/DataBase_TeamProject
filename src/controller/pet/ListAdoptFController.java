package controller.pet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Pet;
import model.service.PetService;

public class ListAdoptFController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      
      PetService petService = PetService.getInstance();
      String userId = request.getParameter("userId");
       
      List<Pet> petList = petService.findAdoptList();
      
      request.setAttribute("petList", petList);
      request.setAttribute("userId", userId);
      request.setAttribute("kind", "전체보기");
      request.setAttribute("selectView", "전체보기");
      return "/pet/adoptForm.jsp";
   }

}