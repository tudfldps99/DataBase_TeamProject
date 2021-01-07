package model;

public class Pet {
   private int petId;
   private String pname;
   private String gender;
   private String variety;
   private int age;
   private String kind;
   private String pdate;
   private String explanation;
   private float weight;
   private String image;
   private int adopt;
   private int noAdopt;
   private int protect;
   private int lost;
   private String userInfoId;
   private int hospitalId;
   private int areaId;
   
   public Pet(String kind) {
      super();
      this.kind = kind;
   }

   public Pet(String kind, String variety) {
      super();
      this.variety = variety;
      this.kind = kind;
   }

   public Pet(String kind, String variety, int areaId) {
      super();
      this.variety = variety;
      this.kind = kind;
      this.areaId = areaId;
   }
   
   public Pet(String kind, String variety, int areaId, String gender) {
      super();
      this.gender = gender;
      this.variety = variety;
      this.kind = kind;
      this.areaId = areaId;
   }

   public Pet(int petId, String pname, String gender, String variety, int age, String kind, String pdate,
         String explanation, float weight, String image, int adopt, int noAdopt, int protect, int lost, String userInfoId,
         int hospitalId, int areaId) {
      super();
      this.petId = petId;
      this.pname = pname;
      this.gender = gender;
      this.variety = variety;
      this.age = age;
      this.kind = kind;
      this.pdate = pdate;
      this.explanation = explanation;
      this.weight = weight;
      this.image = image;
      this.adopt = adopt;
      this.noAdopt = noAdopt;
      this.protect = protect;
      this.lost = lost;
      this.userInfoId = userInfoId;
      this.hospitalId = hospitalId;
      this.areaId = areaId;
   }

   public Pet(String pname, String gender, String variety, int age, String kind, String pdate,
           String explanation, float weight, String image, int adopt, int noAdopt, int protect, int lost, String userInfoId,
           int hospitalId, int areaId) {
        super();
        this.pname = pname;
        this.gender = gender;
        this.variety = variety;
        this.age = age;
        this.kind = kind;
        this.pdate = pdate;
        this.explanation = explanation;
        this.weight = weight;
        this.image = image;
        this.adopt = adopt;
        this.noAdopt = noAdopt;
        this.protect = protect;
        this.lost = lost;
        this.userInfoId = userInfoId;
        this.hospitalId = hospitalId;
        this.areaId = areaId;
     }
   
   public Pet(String pname, String gender, String variety, int age, String kind, String pdate,
           String explanation, float weight, String userInfoId, int hospitalId, int areaId, String image, int adopt, int noAdopt, int protect, int lost) {
        super();
        this.pname = pname;
        this.gender = gender;
        this.variety = variety;
        this.age = age;
        this.kind = kind;
        this.pdate = pdate;
        this.explanation = explanation;
        this.weight = weight;
        this.image = image;
        this.adopt = adopt;
        this.noAdopt = noAdopt;
        this.protect = protect;
        this.lost = lost;
        this.userInfoId = userInfoId;
        this.hospitalId = hospitalId;
        this.areaId = areaId;
     }
   
   public Pet(String kind, String variety, String explanation, String gender, String pdate, String image) {
	   super();
	   this.gender = gender;
	   this.variety = variety;
	   this.kind = kind;
	   this.pdate = pdate;
	   this.explanation = explanation;
	   this.image = image;
	}
   
   public Pet(String pname, String gender, String variety, int age, String kind, String pdate,
           String explanation, float weight, String image) {
        super();
        this.pname = pname;
        this.gender = gender;
        this.variety = variety;
        this.age = age;
        this.kind = kind;
        this.pdate = pdate;
        this.explanation = explanation;
        this.weight = weight;
        this.image = image;
     }
  
   public String getUserInfoId() {
      return userInfoId;
   }

   public void setUserInfoId(String userInfoId) {
      this.userInfoId = userInfoId;
   }

   public int getHospitalId() {
      return hospitalId;
   }

   public void setHospitalId(int hospitalId) {
      this.hospitalId = hospitalId;
   }

   public int getAreaId() {
      return areaId;
   }

   public void setAreaId(int areaId) {
      this.areaId = areaId;
   }

   public int getPetId() {
      return petId;
   }
   
   public Pet() {}

   public Pet(String gender, String variety, int age, String kind, String pdate, String explanation, float weight,
            String image) {
     super();
     this.gender = gender;
     this.variety = variety;
     this.age = age;
     this.kind = kind;
     this.pdate = pdate;
     this.explanation = explanation;
     this.weight = weight;
     this.image = image;
   }
     
     public Pet(String gender, String variety, int age, String kind, String pdate, String explanation, float weight,
           String image, int protect) {
        super();
        this.gender = gender;
        this.variety = variety;
        this.age = age;
        this.kind = kind;
        this.pdate = pdate;
        this.explanation = explanation;
        this.weight = weight;
        this.image = image;
        this.protect = protect;
     }
   
   public Pet(int petId, String pname, String gender, String variety, int age, String kind, String pdate,
         String explanation, float weight, String image, int adopt, int noAdopt, int protect, int lost) {
      super();
      this.petId = petId;
      this.pname = pname;
      this.gender = gender;
      this.variety = variety;
      this.age = age;
      this.kind = kind;
      this.pdate = pdate;
      this.explanation = explanation;
      this.weight = weight;
      this.image = image;
      this.adopt = adopt;
      this.noAdopt = noAdopt;
      this.protect = protect;
      this.lost = lost;
   }
   
   public int getAdopt() {
      return adopt;
   }
   public void setAdopt(int adopt) {
      this.adopt = adopt;
   }
   public int getNoAdopt() {
      return noAdopt;
   }
   public void setNoAdopt(int noAdopt) {
      this.noAdopt = noAdopt;
   }
   public int getProtect() {
      return protect;
   }
   public void setProtect(int protect) {
      this.protect = protect;
   }
   public int getLost() {
      return lost;
   }
   public void setLost(int lost) {
      this.lost = lost;
   }
   public void setPetId(int petId) {
      this.petId = petId;
   }
   public String getPname() {
      return pname;
   }
   public void setPname(String pname) {
      this.pname = pname;
   }
   public String getGender() {
      return gender;
   }
   public void setGender(String gender) {
      this.gender = gender;
   }
   public String getVariety() {
      return variety;
   }
   public void setVariety(String variety) {
      this.variety = variety;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public String getKind() {
      return kind;
   }
   public void setKind(String kind) {
      this.kind = kind;
   }
   public String getPdate() {
      return pdate;
   }
   public void setPdate(String pdate) {
      this.pdate = pdate;
   }
   public String getExplanation() {
      return explanation;
   }
   public void setExplanation(String explanation) {
      this.explanation = explanation;
   }
   public float getWeight() {
      return weight;
   }
   public void setWeight(float weight) {
      this.weight = weight;
   }
   public String getImage() {
      return image;
   }
   public void setImage(String image) {
      this.image = image;
   }
   
   @Override
   public String toString() {
      return "Pet [petId=" + petId + ", name=" + pname + ", gender=" + gender + ", variety=" + variety + ", age=" + age
            + ", kind=" + kind + ", date=" + pdate + ", explanation=" + explanation + ", weight=" + weight
            + ", image=" + image + ", adopt=" + adopt + ", noAdopt=" + noAdopt + ", protect=" + protect + ", lost="
            + lost + ", userInfoId=" + userInfoId + ", hospitalId=" + hospitalId + ", areaId=" + areaId + "]";
   }
   
   public boolean isSamePet(int petId) {
      return this.petId == petId;
   }
}