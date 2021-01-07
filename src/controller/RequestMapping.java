package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.pet.*;
import controller.user.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
       // 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/update/form", new UpdateUserController());
        
        mappings.put("/user/myPage", new MyPageController());
        mappings.put("/user/petmain", new PetMainController());
        mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/user/register", new RegisterUserController());
        
        mappings.put("/pet/introduce", new ForwardController("/pet/introduce.jsp"));
        mappings.put("/pet/notice", new ForwardController("/pet/notice.jsp"));
        
        mappings.put("/pet/abdpet", new AbdPetController());
        mappings.put("/pet/apply", new ApplyController());
        mappings.put("/pet/applylost", new ApplyLostController());
        mappings.put("/pet/applyprotect", new ApplyProtectController());
        mappings.put("/pet/listAdopt", new ListAdoptPetController());
        mappings.put("/pet/listAdoptFirst", new ListAdoptFController());
        mappings.put("/pet/applyprotectbutton", new ForwardController("/pet/protect_apply_form.jsp"));
        mappings.put("/pet/applylostbutton", new ForwardController("/pet/lost_apply_form.jsp"));
        mappings.put("/pet/information", new ForwardController("/pet/information_form.jsp"));
        mappings.put("/pet/update", new UpdatePetController());
        mappings.put("/pet/support/form", new GoSupportFormController());
        mappings.put("/pet/support_hospital/form", new ForwardController("/pet/support_hospital_form.jsp"));
        mappings.put("/pet/lost_protect_form", new GoLostProtectController());
        
        mappings.put("/pet/hospitalSearch", new HospitalController());
        mappings.put("/pet/hospitalSimple", new HospitalSimpleController());
        mappings.put("/pet/hospitallist", new ForwardController("/pet/hospitalList.jsp"));
               
        
        // 사용자 정보 수정 폼 요청과 수정 요청 처리 병합
//      mappings.put("/user/update/form", new UpdateUserFormController());
//        mappings.put("/user/update", new UpdateUserController());
//        mappings.put("/user/delete", new DeleteUserController());
        
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {   
       // 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}