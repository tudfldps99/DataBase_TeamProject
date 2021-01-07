package controller.pet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class GoSupportFormController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      
         String userId = request.getParameter("userId");
         
          request.setAttribute("userId", userId);
      return "/pet/support_form.jsp";
   }

}