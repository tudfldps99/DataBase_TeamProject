package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Hospital;

public class HospitalDAO {
   // 병원 찾기 -> Area의 gu와 city로 전화번호, 주소, 운영시간 가져오기
   
   private JDBCUtil jdbcUtil = null;
  
   public HospitalDAO() {
         jdbcUtil = new JDBCUtil();
   }

   
   public List<Hospital> findAllHospital() throws SQLException {
       
       String sql = "SELECT name, phone, address, hour "
             + "FROM hospital";
       jdbcUtil.setSqlAndParameters(sql, null);      
       
        try {
            ResultSet rs = jdbcUtil.executeQuery();                     
            List<Hospital> hospitalList = new ArrayList<Hospital>();  
            while (rs.next()) {
               Hospital hospital = new Hospital(
                     rs.getString("name"),
                     rs.getString("phone"),
                     rs.getString("address"),
                     rs.getString("hour")
                     );
               hospitalList.add(hospital);
            }
            return hospitalList;
         } catch (Exception ex) {
            ex.printStackTrace();
         } finally {
            jdbcUtil.close();      
         }
        return null;
   }
      
   public Hospital findHospital(String city, String gu) throws SQLException {
       
       String sql = "SELECT name, phone, address, hour "
             + "FROM hospital h JOIN area a USING (areaId) "
             + "WHERE city = ? and gu = ?";
             
       jdbcUtil.setSqlAndParameters(sql, new Object[] {city, gu});
       
        try {
            ResultSet rs = jdbcUtil.executeQuery();      
            if (rs.next()) {
               Hospital hospital = new Hospital(
                     rs.getString("name"),
                     rs.getString("phone"),
                     rs.getString("address"),
                     rs.getString("hour")
                     );
               
               return hospital;
            }
            
         } catch (Exception ex) {
            ex.printStackTrace();
         } finally {
            jdbcUtil.close();      
         }
        return null;
   }
   
   public List<Hospital> findHospitalSimple(String city) throws SQLException {
       
       String sql = "SELECT name, phone, address, hour "
             + "FROM hospital h JOIN area a USING (areaId) "
             + "WHERE city = ?";
             
       jdbcUtil.setSqlAndParameters(sql, new Object[] {city});
       
        try {
            ResultSet rs = jdbcUtil.executeQuery();                     
            List<Hospital> hospitalList = new ArrayList<Hospital>();  
            while (rs.next()) {
               Hospital hospital = new Hospital(
                     rs.getString("name"),
                     rs.getString("phone"),
                     rs.getString("address"),
                     rs.getString("hour")
                     );
               hospitalList.add(hospital);
            }
            return hospitalList;
            
         } catch (Exception ex) {
            ex.printStackTrace();
         } finally {
            jdbcUtil.close();      
         }
        return null;
   }
}