package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Area;
import model.dao.AreaDAO;


public class AreaService {
   private static AreaService areaService = new AreaService();
   private AreaDAO areaDAO;
   
   private AreaService() {
      try {
         areaDAO = new AreaDAO();
      } catch (Exception e) {
         e.printStackTrace();
      }   
   }
   
   public static AreaService getInstance() {
      return areaService;
   }
   
   public Area findArea(String city) throws SQLException {
         Area user = areaDAO.findArea(city);   
         return user;
   }
   
   public List<Area> findAreaList(String city) throws SQLException {   
         return areaDAO.findAreaList(city);
   }
   
   public Area findArea(String city, String gu) throws SQLException {
      Area user = areaDAO.findArea(city, gu);   
      return user;
   }

}