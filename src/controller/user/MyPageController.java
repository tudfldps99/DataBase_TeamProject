package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.UserInfo;
import model.service.UserNotFoundException;
import model.service.UserService;

public class MyPageController implements Controller{
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
		UserService manager = UserService.getInstance();
		String userId = request.getParameter("userId");

    	UserInfo user = null;
    	try {
    		user = manager.findUser(userId);	// 사용자 정보 검색
            
		} catch (UserNotFoundException e) {				
	        return "/user/loginForm.jsp";
		}	
		
    	request.setAttribute("user", user);		// 사용자 정보 저장				
		return "/user/myPage.jsp";				// 사용자 보기 화면으로 이동
    }
}
