package model;

public class UserInfo {
   private String userInfoId;
   private String password;
   private String name;
   private String email;
   private String phone;
   private String birthday;
   private String gender;

   public UserInfo() { }      
   
   public UserInfo(String userInfoId, String password, String name, String email, String phone, String birthday, String gender) {
      this.userInfoId = userInfoId;
      this.password = password;
      this.name = name;
      this.email = email;
      this.phone = phone;
      this.birthday = birthday;
      this.gender = gender;
   }

   public void update(UserInfo updateUser) {
        this.password = updateUser.password;
        this.name = updateUser.name;
        this.email = updateUser.email;
        this.phone = updateUser.phone;
        this.birthday = updateUser.birthday;
        this.gender = updateUser.birthday;
    }
   
   public String getUserInfoId() {
      return userInfoId;
   }

   public void setUserInfoId(String userInfoId) {
      this.userInfoId = userInfoId;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }
   
   public String getBirthday() {
      return birthday;
   }
   
   public void setBirthday(String birthday) {
      this.birthday = birthday;
   }
   
   public String getGender() {
      return gender;
   }
   
   public void setGender(String gender) {
      this.gender = gender;
   }

   
   /*   й ȣ  ˻  */
   public boolean matchPassword(String password) {
      if (password == null) {
         return false;
      }
      return this.password.equals(password);
   }
   
   public boolean isSameUser(String userInfoId) {
        return this.userInfoId.equals(userInfoId);
    }
   
   public boolean matchPhone(String phone) {
      if(phone == null) {
         return false;
      }
      return this.phone.equals(phone);
   }
   
   public boolean matchEmail(String email) {
      if(email == null || email.contains("@")) {
         return false;
      }
      return this.email.equals(email);
   }

   @Override
   public String toString() {
      return "User [userInfoId=" + userInfoId + ", password=" + password + ", name=" + name + ", email=" + email + ", phone="
            + phone + ", birthday=" + birthday + ", gender=" + gender + "]";
   }   

}