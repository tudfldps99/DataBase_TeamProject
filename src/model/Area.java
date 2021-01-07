package model;

public class Area {
   private int areaId;
   private String city;
   private String gu;
   
   public Area(String city) {
      this.city = city;
   }

   public Area(int areaId) {
       this.areaId = areaId;
   }
   
   public Area(String city, String gu) {
      this.city = city;
      this.gu = gu;
   }
   
   public Area(int areaId, String city, String gu) {
         super();
         this.areaId = areaId;
         this.city = city;
         this.gu = gu;
   }
   
   public int getAreaId() {
      return areaId;
   }
   public void setAreaId(int areaId) {
      this.areaId = areaId;
   }
   public String getCity() {
      return city;
   }
   public void setCity(String city) {
      this.city = city;
   }
   public String getGu() {
      return gu;
   }
   public void setGu(String gu) {
      this.gu = gu;
   }

   @Override
   public String toString() {
      return "Area [areaId=" + areaId + ", city=" + city + ", gu=" + gu + "]";
   }
   
}