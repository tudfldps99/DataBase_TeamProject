package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Hospital;
import model.dao.HospitalDAO;


public class HospitalService {
   private static HospitalService hospitalService = new HospitalService();
   private HospitalDAO hospitalDAO;
   
   private HospitalService() {
      try {
         hospitalDAO = new HospitalDAO();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
    public static HospitalService getInstance() {
         return hospitalService;
      }
    
    public List<Hospital> findAllHospital() throws SQLException {
       return hospitalDAO.findAllHospital();
    }
    
    public Hospital findHospital(String city, String gu) throws SQLException {
       Hospital hospital = hospitalDAO.findHospital(city, gu);
       return hospital;
    }
    
    public List<Hospital> findHospitalSimple(String city) throws SQLException {
       return hospitalDAO.findHospitalSimple(city);
    }   
}