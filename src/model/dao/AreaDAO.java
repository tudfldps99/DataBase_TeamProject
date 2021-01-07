package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Area;

public class AreaDAO {
   
   
   private JDBCUtil jdbcUtil = null;
      
   public AreaDAO() {
         jdbcUtil = new JDBCUtil();
   }

   //  city, gu 다 받아와야할 것 같음.
   public Area findArea(String city) throws SQLException {
        String sql = "SELECT areaId "
                 + "FROM area "
                 + "WHERE city=? ";              
      jdbcUtil.setSqlAndParameters(sql, new Object[] {city});   

      try {
         ResultSet rs = jdbcUtil.executeQuery();      
         if (rs.next()) {         
            Area area = new Area(city);
            
            return area;
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      
      }
      return null;
   }
   
   public List<Area> findArea(int areaId) throws SQLException {
       String sql = "SELECT city, gu " 
               + "FROM area "
               + "WHERE areaId = ? ";
       jdbcUtil.setSqlAndParameters(sql, new Object[] {areaId});        
       List<Area> areaList = new ArrayList<Area>();

       try {
          ResultSet rs = jdbcUtil.executeQuery();      
          if (rs.next()) {         
             Area area = new Area(areaId);
             areaList.add(area);
          }
          return areaList;
       } catch (Exception ex) {
          ex.printStackTrace();
       } finally {
          jdbcUtil.close();      
       }
       return null;
    }

   //  city, gu 다 받아와야할 것 같음.
   public List<Area> findAreaList(String city) throws SQLException {
        String sql = "SELECT areaId "
                 + "FROM area "
                 + "WHERE city=? ";              
      jdbcUtil.setSqlAndParameters(sql, new Object[] {city});        
      List<Area> areaList = new ArrayList<Area>();

      try {
         ResultSet rs = jdbcUtil.executeQuery();      
         if (rs.next()) {         
            Area area = new Area(city);
            areaList.add(area);
         }
         return areaList;
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      
      }
      return null;
   }
   
   public Area findArea(String city, String gu) throws SQLException {
       String sql = "SELECT areaId "
                + "FROM area "
                + "WHERE city=? and gu=? ";              
     jdbcUtil.setSqlAndParameters(sql, new Object[] {city, gu});   

     try {
        ResultSet rs = jdbcUtil.executeQuery();      
        if (rs.next()) {         
           Area area = new Area(rs.getInt("areaId"),city, gu);
           
           return area;
        }
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
     return null;
  }
}