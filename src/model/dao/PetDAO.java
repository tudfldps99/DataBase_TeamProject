package model.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Pet;

public class PetDAO {
private JDBCUtil jdbcUtil = null;
   
   public PetDAO() {
      jdbcUtil = new JDBCUtil();
   }   

   //pet 관리 테이블에서 새로운 pet 생성
   public int create(Pet pet) throws SQLException {
       String sql = "INSERT INTO PET (petId, pname, gender, variety, age, kind, pdate, explanation, weight, userInfoId, hospitalId, areaId, image, adopt, noAdopt, protect, lost) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       
       int petId = findPetList().size();
       pet.setPetId(++petId);
       
       Object[] param = new Object[] {
           pet.getPetId(),
             pet.getPname(),
             pet.getGender(),
             pet.getVariety(),
             pet.getAge(),
             pet.getKind(),
             pet.getPdate(),
             pet.getExplanation(),
             pet.getWeight(),
             pet.getUserInfoId(),
             pet.getHospitalId(),
             pet.getAreaId(),
             pet.getImage(),
             pet.getAdopt(),
             pet.getNoAdopt(),
             pet.getProtect(),
             pet.getLost() };        
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
  
    //주어진 pet ID에 해당하는 pet 정보를 DB에서 찾아 Pet 도메인 클래스에 저장하여 반환
    public Pet findPet(int petId) throws SQLException {

        String sql = "SELECT pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET "
                + "WHERE petid=? ";              
     jdbcUtil.setSqlAndParameters(sql, new Object[] {petId});
     try {
        ResultSet rs = jdbcUtil.executeQuery();      
        if (rs.next()) {
           Pet pet = new Pet(      
              petId,
              rs.getString("pname"),
              rs.getString("gender"),
              rs.getString("variety"),
              rs.getInt("age"),
              rs.getString("kind"),
              rs.getString("pdate"),
              rs.getString("explanation"),
              rs.getFloat("weight"),
              rs.getString("image"),
              rs.getInt("adopt"),
              rs.getInt("noAdopt"),
              rs.getInt("protect"),
              rs.getInt("lost"),
              rs.getString("userInfoId"),
              rs.getInt("hospitalId"),
              rs.getInt("areaId"));
           return pet;
        }
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       
       return null;   
    }
    

    //기본의 pet 정보를 수정

    public int updateApply (Pet pet,String userId) throws SQLException {

        String sql = "UPDATE PET "
                + "SET pname = ?, gender = ?, variety = ?, age = ?, kind = ?, pdate = ?, explanation = ?, weight = ?, image = ?, adopt = ?, noAdopt = ?, protect = ?, lost = ?, userInfoId = ?, hospitalId = ?, areaId = ? "
                + "WHERE petid=?";
       Object[] param = new Object[] {
             pet.getPname(),
             pet.getGender(),
             pet.getVariety(),
             pet.getAge(),
             pet.getKind(),
             pet.getPdate(),
             pet.getExplanation(),
             pet.getWeight(),
             pet.getImage(),
             0,
             1,
             pet.getProtect(),
             pet.getLost(), 
             userId,
             pet.getHospitalId(),
             pet.getAreaId(),
             pet.getPetId()};
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
    
    //주어진 pet ID에 해당하는 pet 정보를 DB에서 찾아 Pet 도메인 클래스에 저장하여 반환
    public Pet findPetByName(String pName) throws SQLException {

        String sql = "SELECT petId, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET "
                + "WHERE pname=? ";              
     jdbcUtil.setSqlAndParameters(sql, new Object[] {pName});
     try {
        ResultSet rs = jdbcUtil.executeQuery();      
        if (rs.next()) {
           Pet pet = new Pet(
              rs.getInt("petId"),
              pName,
              rs.getString("gender"),
              rs.getString("variety"),
              rs.getInt("age"),
              rs.getString("kind"),
              rs.getString("pdate"),
              rs.getString("explanation"),
              rs.getFloat("weight"),
              rs.getString("image"),
              rs.getInt("adopt"),
              rs.getInt("noAdopt"),
              rs.getInt("protect"),
              rs.getInt("lost"),
              rs.getString("userInfoId"),
              rs.getInt("hospitalId"),
              rs.getInt("areaId"));
           return pet;
        }
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       
       return null;   
    }
    
    //전체 Pet 정보를 검색하여 List에 저장 및 반환
    public List<Pet> findPetList() throws SQLException {
        String sql = "SELECT pname, gender, variety, age, kind, pdate, explanation, weight, userInfoId, hospitalId, areaId, image, adopt, noAdopt, protect, lost " 
                + "FROM PET "
                + "ORDER BY petId ";
     jdbcUtil.setSqlAndParameters(sql, null);      
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();                  
        List<Pet> petList = new ArrayList<Pet>();   
        while (rs.next()) {
           Pet pet = new Pet(         
                   rs.getString("pname"),
                   rs.getString("gender"),
                   rs.getString("variety"),
                   rs.getInt("age"),
                   rs.getString("kind"),
                   rs.getString("pdate"),
                   rs.getString("explanation"),
                   rs.getFloat("weight"),
                   rs.getString("userInfoId"),
                   rs.getInt("hospitalId"),
                   rs.getInt("areaId"),
                   rs.getString("image"),
                   rs.getInt("adopt"),
                   rs.getInt("noAdopt"),
                   rs.getInt("protect"),
                   rs.getInt("lost"));
           petList.add(pet);            
        }      
        return petList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
    
    //전체 pet 정보를 검색한 후 현재 페이지와 페이지당 출력할 pet수를 이용하여 해당하는 pet 정보만을 List에 저장하여 반환
//    public List<Pet> findPetList(int currentPage, int counterPage) throws SQLException {
//       String sql = "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
//                + "FROM PET "
//                + "ORDER BY petId";
//     jdbcUtil.setSqlAndParameters(sql, null);                                 
//     
//     try {
//        ResultSet rs = jdbcUtil.executeQuery();                  
//        int start = ((currentPage-1) * counterPage) + 1;   
//        if ((start >= 0) && rs.absolute(start)) {         
//           List<Pet> petList = new ArrayList<Pet>();   
//           do {
//              Pet pet = new Pet(      
//                      rs.getInt("petId"),
//                      rs.getString("pname"),
//                      rs.getString("gender"),
//                      rs.getString("variety"),
//                      rs.getInt("age"),
//                      rs.getString("kind"),
//                      rs.getString("pdate"),
//                      rs.getString("explanation"),
//                      rs.getFloat("weight"),
//                      rs.getString("image"),
//                      rs.getInt("adopt"),
//                      rs.getInt("noAdopt"),
//                      rs.getInt("protect"),
//                      rs.getInt("lost"),
//                      rs.getString("userInfoId"),
//                      rs.getInt("hospitalId"),
//                      rs.getInt("areaId"));;
//              petList.add(pet);                     
//           } while ((rs.next()) && (--counterPage > 0));      
//           return petList;                     
//        }
//     } catch (Exception ex) {
//        ex.printStackTrace();
//     } finally {
//        jdbcUtil.close();      
//     }
//       
//       return null;
//    }
     
    public boolean existingPet(int Id) throws SQLException {
        String sql = "SELECT count(*) FROM PET WHERE petid=?";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {Id});   

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
    public List<Pet> findProtect() throws SQLException {
       String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
              + "FROM PET " + "WHERE protect IS NOT NULL "
                + "ORDER BY petId ";
     jdbcUtil.setSqlAndParameters(sql, null);      
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();                  
        List<Pet> protectList = new ArrayList<Pet>();   
        while (rs.next()) {
            Pet pet = new Pet(      
                   rs.getInt("petId"),
                     rs.getString("pname"),
                     rs.getString("gender"),
                     rs.getString("variety"),
                     rs.getInt("age"),
                     rs.getString("kind"),
                     rs.getString("pdate"),
                     rs.getString("explanation"),
                     rs.getFloat("weight"),
                     rs.getString("image"),
                     rs.getInt("adopt"),
                     rs.getInt("noAdopt"),
                     rs.getInt("protect"),
                     rs.getInt("lost"),
                     rs.getString("userInfoId"),
                     rs.getInt("hospitalId"),
                     rs.getInt("areaId"));
            protectList.add(pet);              
        }      
        return protectList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
    
    public List<Pet> findProtectExc() throws SQLException {
       String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
              + "FROM PET " + "WHERE protect IS NOT NULL "
              + "AND kind NOT IN('강아지','고양이') "
              + "ORDER BY petId ";
     jdbcUtil.setSqlAndParameters(sql, null);      
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();                  
        List<Pet> protectList = new ArrayList<Pet>();   
        while (rs.next()) {
            Pet pet = new Pet(      
                   rs.getInt("petId"),
                     rs.getString("pname"),
                     rs.getString("gender"),
                     rs.getString("variety"),
                     rs.getInt("age"),
                     rs.getString("kind"),
                     rs.getString("pdate"),
                     rs.getString("explanation"),
                     rs.getFloat("weight"),
                     rs.getString("image"),
                     rs.getInt("adopt"),
                     rs.getInt("noAdopt"),
                     rs.getInt("protect"),
                     rs.getInt("lost"),
                     rs.getString("userInfoId"),
                     rs.getInt("hospitalId"),
                     rs.getInt("areaId"));
            protectList.add(pet);              
        }      
        return protectList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
    public List<Pet> findProtect(String kind) throws SQLException {
       String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
              + "FROM PET " + "WHERE protect IS NOT NULL "
              + "AND kind=? "
              + "ORDER BY petId ";
     jdbcUtil.setSqlAndParameters(sql, new Object[] {kind});      
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();                  
        List<Pet> protectList = new ArrayList<Pet>();   
        while (rs.next()) {
            Pet pet = new Pet(      
                   rs.getInt("petId"),
                     rs.getString("pname"),
                     rs.getString("gender"),
                     rs.getString("variety"),
                     rs.getInt("age"),
                     kind,
                     rs.getString("pdate"),
                     rs.getString("explanation"),
                     rs.getFloat("weight"),
                     rs.getString("image"),
                     rs.getInt("adopt"),
                     rs.getInt("noAdopt"),
                     rs.getInt("protect"),
                     rs.getInt("lost"),
                     rs.getString("userInfoId"),
                     rs.getInt("hospitalId"),
                     rs.getInt("areaId"));
            protectList.add(pet);              
        }      
        return protectList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }

    
    public List<Pet> findLost() throws SQLException {
        String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
              + "FROM PET " + "WHERE lost IS NOT NULL "
                + "ORDER BY petId";
     jdbcUtil.setSqlAndParameters(sql, null);      
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();        
        List<Pet> losttList = new ArrayList<Pet>();   
        while (rs.next()) {
            Pet pet = new Pet(      
                  rs.getInt("petId"),
                     rs.getString("pname"),
                     rs.getString("gender"),
                     rs.getString("variety"),
                     rs.getInt("age"),
                     rs.getString("kind"),
                     rs.getString("pdate"),
                     rs.getString("explanation"),
                     rs.getFloat("weight"),
                     rs.getString("image"),
                     rs.getInt("adopt"),
                     rs.getInt("noAdopt"),
                     rs.getInt("protect"),
                     rs.getInt("lost"),
                     rs.getString("userInfoId"),
                     rs.getInt("hospitalId"),
                     rs.getInt("areaId"));
            losttList.add(pet);              
        }      
        return losttList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
    
    public List<Pet> findLostExc() throws SQLException {
       String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
             + "FROM PET " + "WHERE lost IS NOT NULL "
          + "AND kind NOT IN('강아지','고양이') "   
             + "ORDER BY petId";
    jdbcUtil.setSqlAndParameters(sql, null);      
             
    try {
       ResultSet rs = jdbcUtil.executeQuery();        
       List<Pet> losttList = new ArrayList<Pet>();   
       while (rs.next()) {
           Pet pet = new Pet(      
                 rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    rs.getString("kind"),
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
           losttList.add(pet);              
       }      
       return losttList;               
       
    } catch (Exception ex) {
       ex.printStackTrace();
    } finally {
       jdbcUtil.close();      
    }
      return null;
   }
    public List<Pet> findLost(String kind) throws SQLException {
       String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
             + "FROM PET " + "WHERE lost IS NOT NULL "
          + "AND kind=? "   
             + "ORDER BY petId";
    jdbcUtil.setSqlAndParameters(sql, null);      
             
    try {
       ResultSet rs = jdbcUtil.executeQuery();        
       List<Pet> losttList = new ArrayList<Pet>();   
       while (rs.next()) {
           Pet pet = new Pet(      
                 rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    kind,
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
           losttList.add(pet);              
       }      
       return losttList;               
       
    } catch (Exception ex) {
       ex.printStackTrace();
    } finally {
       jdbcUtil.close();      
    }
      return null;
   }
   
    
    // 보호중인 pet 정보 검색하여 list에 저장 및 반환-> findProtectList
    public List<Pet> findProtectList() throws SQLException {
        String sql = "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET " + "WHERE protect IS NOT NULL "
                + "ORDER BY petId";
     jdbcUtil.setSqlAndParameters(sql, null);      
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();                  
        List<Pet> protectList = new ArrayList<Pet>();   
        while (rs.next()) {
            Pet pet = new Pet(      
                    rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    rs.getString("kind"),
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
            protectList.add(pet);              
        }      
        return protectList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
    
    
    
    
   // 보호중인 pet 정보 검색하여 list에 저장 및 반환-> findProtectList
//    public List<Pet> findProtectList(int currentPage, int counterPage) throws SQLException {
//       String sql = "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
//                + "FROM PET " + "WHERE protect IS NOT NULL "
//                + "ORDER BY petId";
//     jdbcUtil.setSqlAndParameters(sql, null);                                 
//     
//     try {
//        ResultSet rs = jdbcUtil.executeQuery();                  
//        int start = ((currentPage-1) * counterPage) + 1;   
//        if ((start >= 0) && rs.absolute(start)) {         
//           List<Pet> protectList = new ArrayList<Pet>();   
//           do {
//              Pet pet = new Pet(      
//                      rs.getInt("petId"),
//                      rs.getString("pname"),
//                      rs.getString("gender"),
//                      rs.getString("variety"),
//                      rs.getInt("age"),
//                      rs.getString("kind"),
//                      rs.getString("pdate"),
//                      rs.getString("explanation"),
//                      rs.getFloat("weight"),
//                      rs.getString("image"),
//                      rs.getInt("adopt"),
//                      rs.getInt("noAdopt"),
//                      rs.getInt("protect"),
//                      rs.getInt("lost"),
//                      rs.getString("userInfoId"),
//                      rs.getInt("hospitalId"),
//                      rs.getInt("areaId"));
//              protectList.add(pet);                     
//           } while ((rs.next()) && (--counterPage > 0));      
//           return protectList;                     
//        }
//     } catch (Exception ex) {
//        ex.printStackTrace();
//     } finally {
//        jdbcUtil.close();      
//     }
//       
//       return null;
//    }
    
    

    // 실종된 pet 정보 검색하여 list에 저장 및 반환 -> findLostList 
    public List<Pet> findLostList() throws SQLException {
        String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET " + "WHERE lost IS NOT NULL "
                + "ORDER BY petId";
     jdbcUtil.setSqlAndParameters(sql, null);      
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();        
        List<Pet> losttList = new ArrayList<Pet>();   
        while (rs.next()) {
            Pet pet = new Pet(      
                    rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    rs.getString("kind"),
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
            losttList.add(pet);              
        }      
        return losttList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
    
   // 실종된 pet 정보 검색하여 list에 저장 및 반환 -> findLostList  
//    public List<Pet> findLostList(int currentPage, int counterPage) throws SQLException {
//       String sql = "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
//                + "FROM PET " + "WHERE lost IS NOT NULL "
//                + "ORDER BY petId";
//     jdbcUtil.setSqlAndParameters(sql, null);                                 
//     
//     try {
//        ResultSet rs = jdbcUtil.executeQuery();                  
//        int start = ((currentPage-1) * counterPage) + 1;   
//        if ((start >= 0) && rs.absolute(start)) {       
//           List<Pet> losttList = new ArrayList<Pet>();   
//           do {
//              Pet pet = new Pet(      
//                      rs.getInt("petId"),
//                      rs.getString("pname"),
//                      rs.getString("gender"),
//                      rs.getString("variety"),
//                      rs.getInt("age"),
//                      rs.getString("kind"),
//                      rs.getString("pdate"),
//                      rs.getString("explanation"),
//                      rs.getFloat("weight"),
//                      rs.getString("image"),
//                      rs.getInt("adopt"),
//                      rs.getInt("noAdopt"),
//                      rs.getInt("protect"),
//                      rs.getInt("lost"),
//                      rs.getString("userInfoId"),
//                      rs.getInt("hospitalId"),
//                      rs.getInt("areaId"));
//              losttList.add(pet);                     
//           } while ((rs.next()) && (--counterPage > 0));      
//           return losttList;                     
//        }
//     } catch (Exception ex) {
//        ex.printStackTrace();
//     } finally {
//        jdbcUtil.close();      
//     }
//       
//       return null;
//    }
   
    // 입양 중, 혹은 입양 완료인 pet 정보 검색하여 list에 저장 및 반환-> findAdoptList
    public List<Pet> findAdoptList() throws SQLException {
        String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET " + "WHERE adopt = 1 OR noAdopt = 1 "
                + "ORDER BY petId";
     jdbcUtil.setSqlAndParameters(sql, null);      
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();          
        List<Pet> adoptList = new ArrayList<Pet>();
        while (rs.next()) {
            Pet pet = new Pet(      
                    rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    rs.getString("kind"),
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
            adoptList.add(pet);              
        }      
        return adoptList;      
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
   

    // 입양 중, 혹은 입양 완료인 pet 정보 검색하여 list에 저장 및 반환-> findAdoptList
    public List<Pet> findAdoptListExc() throws SQLException {
        String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET " + "WHERE (adopt = 1 OR noAdopt = 1) "
              + "AND kind NOT IN('강아지','고양이') "
                + "ORDER BY petId";
     jdbcUtil.setSqlAndParameters(sql, null);
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();          
        List<Pet> adoptList = new ArrayList<Pet>();
        while (rs.next()) {
            Pet pet = new Pet(      
                    rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    rs.getString("kind"),
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
            adoptList.add(pet);              
        }      
        return adoptList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
   

    // 입양 중, 혹은 입양 완료인 pet 정보 검색하여 list에 저장 및 반환-> findAdoptList
    public List<Pet> findAdoptList(String kind) throws SQLException {
        String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET " + "WHERE (adopt = 1 OR noAdopt = 1) "
              + "AND kind=? "
                + "ORDER BY petId";
     jdbcUtil.setSqlAndParameters(sql,  new Object[] {kind});      
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();          
        List<Pet> adoptList = new ArrayList<Pet>();
        while (rs.next()) {
            Pet pet = new Pet(      
                    rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    kind,
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
            adoptList.add(pet);              
        }      
        return adoptList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }

    // 입양 중, 혹은 입양 완료인 pet 정보 검색하여 list에 저장 및 반환-> findAdoptList
    public List<Pet> findOnlyAdoptList() throws SQLException {
        String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET " + "WHERE adopt = 1 "
                + "ORDER BY petId";
        jdbcUtil.setSqlAndParameters(sql, null);       

     try {
        ResultSet rs = jdbcUtil.executeQuery();          
        List<Pet> onlyAdoptList = new ArrayList<Pet>();
        while (rs.next()) {
            Pet pet = new Pet(      
                    rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    rs.getString("kind"),
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
            onlyAdoptList.add(pet);              
        }      
        return onlyAdoptList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }


    // 입양 중, 혹은 입양 완료인 pet 정보 검색하여 list에 저장 및 반환-> findAdoptList
    public List<Pet> findOnlyAdoptListExc() throws SQLException {
        String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET " + "WHERE adopt = 1 "
              + "AND kind NOT IN('강아지','고양이') "
                + "ORDER BY petId";
        jdbcUtil.setSqlAndParameters(sql, null);       

     try {
        ResultSet rs = jdbcUtil.executeQuery();          
        List<Pet> onlyAdoptList = new ArrayList<Pet>();
        while (rs.next()) {
            Pet pet = new Pet(      
                    rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    rs.getString("kind"),
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
            onlyAdoptList.add(pet);              
        }      
        return onlyAdoptList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }

    // 입양 중, 혹은 입양 완료인 pet 정보 검색하여 list에 저장 및 반환-> findAdoptList
    public List<Pet> findOnlyAdoptList(String kind) throws SQLException {
        String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET " + "WHERE adopt=1 "
              + "AND kind=? "
                + "ORDER BY petId";
        jdbcUtil.setSqlAndParameters(sql,  new Object[] {kind});       

     try {
        ResultSet rs = jdbcUtil.executeQuery();          
        List<Pet> onlyAdoptList = new ArrayList<Pet>();
        while (rs.next()) {
            Pet pet = new Pet(      
                    rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    kind,
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
            onlyAdoptList.add(pet);              
        }      
        return onlyAdoptList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
    
    // 입양 중, 혹은 입양 완료인 pet 정보 검색하여 list에 저장 및 반환-> findAdoptList
    public List<Pet> findOnlyNoAdoptListExc() throws SQLException {
        String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET " + "WHERE noAdopt = 1 "
              + "AND kind NOT IN('강아지','고양이') "
                + "ORDER BY petId";
        jdbcUtil.setSqlAndParameters(sql, null);    
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();          
        List<Pet> noAdoptList = new ArrayList<Pet>();
        while (rs.next()) {
            Pet pet = new Pet(      
                    rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    rs.getString("kind"),
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
            noAdoptList.add(pet);              
        }      
        return noAdoptList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
    

    // 입양 중, 혹은 입양 완료인 pet 정보 검색하여 list에 저장 및 반환-> findAdoptList
    public List<Pet> findOnlyNoAdoptList() throws SQLException {
        String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                + "FROM PET " + "WHERE noAdopt = 1 "
                + "ORDER BY petId";
        jdbcUtil.setSqlAndParameters(sql, null);    
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();          
        List<Pet> noAdoptList = new ArrayList<Pet>();
        while (rs.next()) {
            Pet pet = new Pet(      
                    rs.getInt("petId"),
                    rs.getString("pname"),
                    rs.getString("gender"),
                    rs.getString("variety"),
                    rs.getInt("age"),
                    rs.getString("kind"),
                    rs.getString("pdate"),
                    rs.getString("explanation"),
                    rs.getFloat("weight"),
                    rs.getString("image"),
                    rs.getInt("adopt"),
                    rs.getInt("noAdopt"),
                    rs.getInt("protect"),
                    rs.getInt("lost"),
                    rs.getString("userInfoId"),
                    rs.getInt("hospitalId"),
                    rs.getInt("areaId"));
            noAdoptList.add(pet);              
        }      
        return noAdoptList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
       return null;
    }
      

      // 입양 중, 혹은 입양 완료인 pet 정보 검색하여 list에 저장 및 반환-> findAdoptList
      public List<Pet> findOnlyNoAdoptList(String kind) throws SQLException {
          String sql =  "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
                  + "FROM PET " + "WHERE noAdopt = 1 "
                + "AND kind = ? "
                  + "ORDER BY petId";
          jdbcUtil.setSqlAndParameters(sql,  new Object[] {kind});    
                
       try {
          ResultSet rs = jdbcUtil.executeQuery();          
          List<Pet> noAdoptList = new ArrayList<Pet>();
          while (rs.next()) {
              Pet pet = new Pet(      
                      rs.getInt("petId"),
                      rs.getString("pname"),
                      rs.getString("gender"),
                      rs.getString("variety"),
                      rs.getInt("age"),
                      kind,
                      rs.getString("pdate"),
                      rs.getString("explanation"),
                      rs.getFloat("weight"),
                      rs.getString("image"),
                      rs.getInt("adopt"),
                      rs.getInt("noAdopt"),
                      rs.getInt("protect"),
                      rs.getInt("lost"),
                      rs.getString("userInfoId"),
                      rs.getInt("hospitalId"),
                      rs.getInt("areaId"));
              noAdoptList.add(pet);              
          }      
          return noAdoptList;               
          
       } catch (Exception ex) {
          ex.printStackTrace();
       } finally {
          jdbcUtil.close();      
       }
         return null;
      }
      // 보호중인 pet 정보 검색하여 list에 저장 및 반환-> findProtectList
//       public List<Pet> findOnlyNoAdoptList(int currentPage, int counterPage) throws SQLException {
//          String sql = "SELECT petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, userInfoId, hospitalId, areaId "
//                   + "FROM PET " + "WHERE noAdopt IS NOT NULL "
//                   + "ORDER BY petId";
//        jdbcUtil.setSqlAndParameters(sql, null);                                 
//        
//        try {
//           ResultSet rs = jdbcUtil.executeQuery();                  
//           int start = ((currentPage-1) * counterPage) + 1;   
//           if ((start >= 0) && rs.absolute(start)) {         
//              List<Pet> protectList = new ArrayList<Pet>();   
//              do {
//                 Pet pet = new Pet(      
//                         rs.getInt("petId"),
//                         rs.getString("pname"),
//                         rs.getString("gender"),
//                         rs.getString("variety"),
//                         rs.getInt("age"),
//                         rs.getString("kind"),
//                         rs.getString("pdate"),
//                         rs.getString("explanation"),
//                         rs.getFloat("weight"),
//                         rs.getString("image"),
//                         rs.getInt("adopt"),
//                         rs.getInt("noAdopt"),
//                         rs.getInt("protect"),
//                         rs.getInt("lost"),
//                         rs.getString("userInfoId"),
//                         rs.getInt("hospitalId"),
//                         rs.getInt("areaId"));
//                 protectList.add(pet);                     
//              } while ((rs.next()) && (--counterPage > 0));      
//              return protectList;                     
//           }
//        } catch (Exception ex) {
//           ex.printStackTrace();
//        } finally {
//           jdbcUtil.close();      
//        }
//          
//          return null;
//       }
    // 동물 검색 기능
    // 1. 동물 선택 / 품종선택 / 지역선택 / 성별선택
    // 2. 동물, 품종 선택
    // 3. 동물, 지역 선택
    // 4. 동물, 성별 선택
    // 5. 품종, 지역 선택
    // 6. 품종, 성별 선택
    // 7. 지역, 성별 선택
    // 8. 동물, 품종, 지역 선택
    // 9. 동물, 품종, 성별 선택
    // 10. 품종, 지역, 성별 선택
    // 11. 동물, 품종, 지역, 성별 선택
 // 동물 검색 기능
    // 1. 동물 선택
    public List<Pet> findPetList(String kind) throws SQLException {
       String sql = "SELECT image, kind, variety, explanation, gender, city, pdate " 
               + "FROM pet p JOIN area a USING (areaId) "
               + "WHERE kind = ? ";
    jdbcUtil.setSqlAndParameters(sql, new Object[] {kind});      
             
    try {
       ResultSet rs = jdbcUtil.executeQuery();                  
       List<Pet> petList = new ArrayList<Pet>();   
       while (rs.next()) {
          Pet pet = new Pet(kind);
          petList.add(pet);
       }
       return petList;
    } catch (Exception ex) {
       ex.printStackTrace();
    } finally {
       jdbcUtil.close();      
    }
    return null;
    }
    
    
    // 2. 동물, 품종 선택
    public List<Pet> findPetList(String kind, String variety) throws SQLException {
       String sql = "SELECT image, kind, variety, explanation, gender, city, pdate " 
               + "FROM pet p JOIN area a USING (areaId) "
               + "WHERE kind = ? and variety = ? ";
    jdbcUtil.setSqlAndParameters(sql, new Object[] {kind, variety});      
             
    try {
       ResultSet rs = jdbcUtil.executeQuery();                  
       List<Pet> petList = new ArrayList<Pet>();   
       while (rs.next()) {
          Pet pet = new Pet(kind);
          petList.add(pet);            
       }      
       return petList;               
       
    } catch (Exception ex) {
       ex.printStackTrace();
    } finally {
       jdbcUtil.close();      
    }
    return null;
    }
    
    // 3. 동물, 품종, 지역 선택 (findArea 이용해서 areaId 값 받아와야함)
    public List<Pet> findPetList(String kind, String variety, int areaId) throws SQLException {
       String sql = "SELECT image, kind, variety, explanation, gender, city, pdate " 
               + "FROM pet p JOIN area a USING (areaId) "
               + "WHERE kind = ? and variety = ? and areaId = ? ";
    jdbcUtil.setSqlAndParameters(sql, new Object[] {kind, variety, areaId});      
             
    try {
       ResultSet rs = jdbcUtil.executeQuery();                  
       List<Pet> petList = new ArrayList<Pet>();   
       while (rs.next()) {
          Pet pet = new Pet(kind);
          petList.add(pet);            
       }      
       return petList;               
       
    } catch (Exception ex) {
       ex.printStackTrace();
    } finally {
       jdbcUtil.close();      
    }
    return null;
    }
    
    // 4. 동물, 품종, 지역, 성별 선택
    public List<Pet> findPetList(String kind, String variety, int areaId, String gender) throws SQLException {
        String sql = "SELECT kind, variety, explanation, gender, city, pdate, image " 
                + "FROM pet p JOIN area a USING (areaId) "
                + "WHERE kind = ? and variety = ? and areaId = ? and gender = ? ";
     jdbcUtil.setSqlAndParameters(sql, new Object[] {kind, variety, areaId, gender});      
              
     try {
        ResultSet rs = jdbcUtil.executeQuery();                  
        List<Pet> petList = new ArrayList<Pet>();   
        while (rs.next()) {
           Pet pet = new Pet(kind, variety, rs.getString("explanation"), gender, rs.getString("pdate"), rs.getString("image"));
           petList.add(pet);            
        }      
        return petList;               
        
     } catch (Exception ex) {
        ex.printStackTrace();
     } finally {
        jdbcUtil.close();      
     }
     return null;
     }
}