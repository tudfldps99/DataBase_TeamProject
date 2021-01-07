package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserInfo;

public class UserInfoDAO {
private JDBCUtil jdbcUtil = null;
   
   public UserInfoDAO() {         
      jdbcUtil = new JDBCUtil();   
   }
   
   public int create(UserInfo user) throws SQLException {
      String sql = "INSERT INTO USERINFO (userInfoId, password, name, email, phone, birthday, gender) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?)";      
      Object[] param = new Object[] {user.getUserInfoId(), user.getPassword(), 
            user.getName(), user.getEmail(), user.getPhone(), user.getBirthday(), user.getGender()};            
      jdbcUtil.setSqlAndParameters(sql, param);   
                  
      try {            
         int result = jdbcUtil.executeUpdate();   
         return result;
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {      
         jdbcUtil.commit();
         jdbcUtil.close();   
      }      
      return 0;         
   }

   public int update(UserInfo user) throws SQLException {
      String sql = "UPDATE USERINFO "
               + "SET password=?, name=?, email=?, phone=?, birthday=?, gender=? "
               + "WHERE userInfoId=?";
      Object[] param = new Object[] {user.getPassword(), user.getName(), user.getEmail(),
                user.getPhone(), user.getBirthday(), user.getGender(), user.getUserInfoId()};            
      jdbcUtil.setSqlAndParameters(sql, param);   
         
      try {            
         int result = jdbcUtil.executeUpdate();   
         return result;
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      }
      finally {
         jdbcUtil.commit();
         jdbcUtil.close();   
      }      
      return 0;
   }

   public int remove(String userInfoId) throws SQLException {
      String sql = "DELETE FROM USERINFO WHERE userInfoId=? ";      
      jdbcUtil.setSqlAndParameters(sql, new Object[] {userInfoId});   

      try {            
         int result = jdbcUtil.executeUpdate();   
         return result;
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      }
      finally {
         jdbcUtil.commit();
         jdbcUtil.close();   
      }      
      return 0;
   }

   public UserInfo findUser(String userInfoId) throws SQLException {
        String sql = "SELECT password, name, email, phone, birthday, gender "
                 + "FROM USERINFO "
                 + "WHERE userinfoId=? ";              
      jdbcUtil.setSqlAndParameters(sql, new Object[] {userInfoId});   

      try {
         ResultSet rs = jdbcUtil.executeQuery();      
         if (rs.next()) {                  
            UserInfo user = new UserInfo(      
               userInfoId,
               rs.getString("password"),
               rs.getString("name"),
               rs.getString("email"),
               rs.getString("phone"),
               rs.getString("birthday"),
               rs.getString("gender"));
            return user;
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      
      }
      return null;
   }

   public List<UserInfo> findUserList() throws SQLException {
        String sql = "SELECT userInfoId, password, name, email, phone " 
                 + "FROM USERINFO "
                 + "ORDER BY userInfoId";
      jdbcUtil.setSqlAndParameters(sql, null);      
               
      try {
         ResultSet rs = jdbcUtil.executeQuery();                  
         List<UserInfo> userList = new ArrayList<UserInfo>();   
         while (rs.next()) {
            UserInfo user = new UserInfo(         
               rs.getString("userInfoId"),
               rs.getString("password"),
               rs.getString("name"),
               rs.getString("email"),
               rs.getString("phone"),
               rs.getString("birthday"),
               rs.getString("gender"));
            userList.add(user);            
         }      
         return userList;               
         
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      
      }
      return null;
   }
   
   public List<UserInfo> findUserList(int currentPage, int countPerPage) throws SQLException {
        String sql = "SELECT userInfoId, password, name, email, phone " 
                 + "FROM USERINFO "
                 + "ORDER BY userInfoId";
      jdbcUtil.setSqlAndParameters(sql, null);                                 
      
      try {
         ResultSet rs = jdbcUtil.executeQuery();                  
         int start = ((currentPage-1) * countPerPage) + 1;   
         if ((start >= 0) && rs.absolute(start)) {         
            List<UserInfo> userList = new ArrayList<UserInfo>();   
            do {
               UserInfo user = new UserInfo(      
                  rs.getString("userInfoId"),
                  rs.getString("password"),
                  rs.getString("name"),
                  rs.getString("email"),
                  rs.getString("phone"),
                  rs.getString("birthday"),
                  rs.getString("gender"));
               userList.add(user);                     
            } while ((rs.next()) && (--countPerPage > 0));      
            return userList;                     
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      
      }
      return null;
   }

   public boolean existingUser(String userInfoId) throws SQLException {
      String sql = "SELECT count(*) FROM USERINFO WHERE userInfoId=?";      
      jdbcUtil.setSqlAndParameters(sql, new Object[] {userInfoId});   

      try {
         ResultSet rs = jdbcUtil.executeQuery();      
         if (rs.next()) {
            int count = rs.getInt(1);
            return (count == 1 ? true : false);
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      
      }
      return false;
   }
}