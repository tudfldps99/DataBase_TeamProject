package model;

public class Hospital {
   
   private int hospitalId;
   private String name;
   private String phone;
   private String address;
   private String hour;
   private int areaId;
   
   public int getHospitalId() {
      return hospitalId;
   }
   public void setHospitalId(int hospitalId) {
      this.hospitalId = hospitalId;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getHour() {
      return hour;
   }
   public void setHour(String hour) {
      this.hour = hour;
   }
   public int getAreaId() {
      return areaId;
   }
   public void setAreaId(int areaId) {
      this.areaId = areaId;
   }
   public Hospital(int hospitalId, String name, String phone, String address, String hour, int areaId) {
      super();
      this.hospitalId = hospitalId;
      this.name = name;
      this.phone = phone;
      this.address = address;
      this.hour = hour;
      this.areaId = areaId;
   }
   
   public Hospital(String name, String phone, String address, String hour) {
      super();
      this.name = name;
      this.phone = phone;
      this.address = address;
      this.hour = hour;
   }
   public Hospital() {}
   @Override
   public String toString() {
      return "Hospital [hospitalId=" + hospitalId + ", name=" + name + ", phone=" + phone + ", address=" + address
            + ", hour=" + hour + ", areaId=" + areaId + "]";
   }
   
}