package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Pet;
import model.dao.PetDAO;

public class PetService {
   private static PetService petService = new PetService();
   private PetDAO petDAO;
   
   private PetService() {
      try {
         petDAO = new PetDAO();
      } catch (Exception e) {
         e.printStackTrace();
      }   
   }
   
   public static PetService getInstance() {
      return petService;
   }
   
   public int create(Pet pet) throws SQLException {
         return petDAO.create(pet);
   }

   public int updateApply(Pet pet, String userId) throws SQLException {
      return petDAO.updateApply(pet, userId);
   }
   
   public List<Pet> findProtectExc() throws SQLException {
       return petDAO.findProtectExc();
   }
   public List<Pet> findProtect(String kind) throws SQLException {
       return petDAO.findProtect(kind);
   }
   
   public List<Pet> findLost() throws SQLException {
       return petDAO.findLost();
   }
   public List<Pet> findLostExc() throws SQLException {
       return petDAO.findLostExc();
   }
   public List<Pet> findLost(String kind) throws SQLException {
       return petDAO.findLost(kind);
   }
      
   public Pet findPet(int petId) throws SQLException {
      return petDAO.findPet(petId);   
   }
   
   public Pet findPetByName(String pname) throws SQLException {
      return petDAO.findPetByName(pname);   
   }
   
   public List<Pet> findPetList() throws SQLException {
      return petDAO.findPetList();
   }
   
   public boolean existingPet(int Id) throws SQLException {
       return petDAO.existingPet(Id);
   }   
   
   public List<Pet> findProtectList() throws SQLException {
       return petDAO.findProtectList();
   }
   
   public List<Pet> findLostList() throws SQLException {
      return petDAO.findLostList();
   }

   public List<Pet> findAdoptList() throws SQLException {
         return petDAO.findAdoptList();
      }

   public List<Pet> findOnlyAdoptList() throws SQLException {
         return petDAO.findOnlyAdoptList();
      }

   public List<Pet> findOnlyNoAdoptList() throws SQLException {
         return petDAO.findOnlyNoAdoptList();
      }

   public List<Pet> findAdoptListExc() throws SQLException {
         return petDAO.findAdoptListExc();
      }
   
   public List<Pet> findOnlyAdoptListExc() throws SQLException {
         return petDAO.findOnlyAdoptListExc();
      }
   
   public List<Pet> findOnlyNoAdoptListExc() throws SQLException {
         return petDAO.findOnlyNoAdoptListExc();
      }


   public List<Pet> findAdoptList(String kind) throws SQLException {
         return petDAO.findAdoptList(kind);
      }

   public List<Pet> findOnlyAdoptList(String kind) throws SQLException {
         return petDAO.findOnlyAdoptList(kind);
      }

   public List<Pet> findOnlyNoAdoptList(String kind) throws SQLException {
         return petDAO.findOnlyNoAdoptList(kind);
      }
   public List<Pet> findPetList(String kind) throws SQLException {
      return petDAO.findPetList(kind);
   }
   
   public List<Pet> findPetList(String kind, String variety) throws SQLException {
      return petDAO.findPetList(kind, variety);
   }

   public List<Pet> findPetList(String kind, String variety, int areaId) throws SQLException {
      return petDAO.findPetList(kind, variety, areaId);
   }

   public List<Pet> findPetList(String kind, String variety, int areaId, String gender) throws SQLException {
      return petDAO.findPetList(kind, variety, areaId, gender);
   }
   
   public List<Pet> findProtect() throws SQLException {
       return petDAO.findProtect();
   }
   

}