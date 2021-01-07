package controller.pet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.*;
import model.service.*;

public class GoLostProtectController implements Controller{

   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
       PetService petService = PetService.getInstance();
       List<Pet> petList = petService.findProtect();
     
       request.setAttribute("petList", petList);
           
      return "/pet/lost_protect_form.jsp";
   }
}