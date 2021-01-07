package controller.pet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Hospital;
import model.service.HospitalService;

public class HospitalSimpleController  implements Controller {
      public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HospitalService hospitalService = HospitalService.getInstance();

        List<Hospital> hospitalList;
        String city = null;

        if(request.getParameter("city") != null)
            city = request.getParameter("city");
        else {
           hospitalList = hospitalService.findAllHospital();
            return "/pet/support_hospital_form.jsp";
        }

        try {
          
          if(city.equals("전체보기"))
             hospitalList = hospitalService.findAllHospital();
          else
             hospitalList = hospitalService.findHospitalSimple(city);
          
          request.setAttribute("city", city);
          request.setAttribute("hospitalList", hospitalList);
         
      } catch(Exception e) {
         return "/pet/support_hospital_form.jsp";
      }
     return "/pet/support_hospital_form.jsp";
  }
}