package model.service;

import java.sql.SQLException;
import java.util.List;

import model.UserInfo;
import model.dao.UserInfoDAO;

public class UserService {

   private static UserService userService = new UserService();
  
   private UserInfoDAO userInfoDAO;

   private UserService() {
      try {
         
         userInfoDAO = new UserInfoDAO();
      
      } catch (Exception e) {
         e.printStackTrace();
      }         
   }
   
   public static UserService getInstance() {
      return userService;
   }
   
   public int create(UserInfo user) throws SQLException, ExistingUserException {
      if (userInfoDAO.existingUser(user.getUserInfoId()) == true) {
         throw new ExistingUserException(user.getUserInfoId() + "는 존재하는 아이디입니다.");
      }
      return userInfoDAO.create(user);
   }

   public int update(UserInfo user) throws SQLException {
      return userInfoDAO.update(user);
   }   

   public int remove(String userId) throws SQLException {
      return userInfoDAO.remove(userId);
   }

   public UserInfo findUser(String userId) throws SQLException, UserNotFoundException {
      UserInfo user = userInfoDAO.findUser(userId);
      
      if (user == null) {
         throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
      }      
      return user;
   }

   public List<UserInfo> findUserList() throws SQLException {
         return userInfoDAO.findUserList();
   }
   
   public List<UserInfo> findUserList(int currentPage, int countPerPage)
      throws SQLException {
      return userInfoDAO.findUserList(currentPage, countPerPage);
   }

   public boolean login(String userId, String password)
      throws SQLException, UserNotFoundException, PasswordMismatchException {
      UserInfo user = findUser(userId);

      if (!user.matchPassword(password)) {
         throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
      }
      return true;
   }
}