package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Pet;
import model.UserInfo;
import model.service.PetService;
import model.service.UserService;

public class PetMainController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String userId = request.getParameter("userId");
      UserService userService = UserService.getInstance();
      PetService petService = PetService.getInstance();
      
      List<Pet> petList = null;
      petList = petService.findAdoptList();
      
      request.setAttribute("petList", petList);
      UserInfo userInfo = userService.findUser(userId);

      request.setAttribute("userInfo", userInfo);
      request.setAttribute("userId", userId);
      return "/pet/mainPage";
   }
   
   
}