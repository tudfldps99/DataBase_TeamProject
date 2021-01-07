package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Pet;
import model.UserInfo;
import model.service.PetService;
import model.service.UserService;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String userId = request.getParameter("userId");
       String password = request.getParameter("password");
      
      try {
    	  	UserService manager = UserService.getInstance();
         	manager.login(userId, password);
   
         	HttpSession session = request.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
            
            UserInfo user = manager.findUser(userId);
            request.setAttribute("user", user);
            request.setAttribute("userId", userId);
            
            PetService petService = PetService.getInstance();
            List<Pet> petList = null;
            petList = petService.findAdoptList();
            request.setAttribute("petList", petList);
            
            List<Pet> petList2 = null;
            petList2 = petService.findPetList();
            request.setAttribute("petList2", petList2);
            
            return "/pet/mainPage.jsp";         
      } catch (Exception e) {
            request.setAttribute("loginFailed", true);
         request.setAttribute("exception", e);
            return "/user/loginForm.jsp";         
      }   
    }
}