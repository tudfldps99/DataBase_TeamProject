package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pet;

public class RegisterDAO {
	    private JDBCUtil jdbcUtil = null;
	      
	    public RegisterDAO() {
	          jdbcUtil = new JDBCUtil();
	    }
	    
	   // 입양 신청 -> Pet에 userId 넣기 : update "adoptionProposal"
	    public int adoptionProposal(Pet pet) {
	          String sql = "UPDATE PET "
	                     + "SET userinfoId=? "
	                + "WHERE petId=? ";
	            Object[] param = new Object[] {pet.getUserInfoId()};            
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

	    
	   // 실종 신고 -> Pet 객체 insert lost에 값 넣기 "missingReport"
		public int missingReport(Pet pet) throws SQLException {
			int recordCount = 0;

			String sql = "INSERT INTO pet(petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, areaId) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			Object[] param = new Object[] { pet.getPetId(), pet.getPname(), pet.getGender(),pet.getVariety(), pet.getAge(), pet.getKind(), pet.getPdate(), pet.getExplanation(),
									 pet.getWeight(), pet.getImage(), pet.getAdopt(), pet.getNoAdopt(), pet.getProtect(), pet.getLost(), pet.getAreaId()
			};
		   
			jdbcUtil.setSqlAndParameters(sql, param);    
			
			try {
				recordCount = jdbcUtil.executeUpdate(); 
				
				if (recordCount == 1) {
					System.out.println("실종신고");
				} 
			}catch (Exception ex) {
		          ex.printStackTrace();
	        } finally {
	          jdbcUtil.close();      
	        }
			return 0;
		}
		
	   // 보호 신고 -> Pet 객체 insert protect에 값 넣기 "protectionReport"		
		public int protectionReport(Pet pet) throws SQLException {
			int recordCount = 0;
			
			String sql = "INSERT INTO pet(petId, pname, gender, variety, age, kind, pdate, explanation, weight, image, adopt, noAdopt, protect, lost, areaId) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			Object[] param = new Object[] { pet.getPetId(), pet.getPname(), pet.getGender(),pet.getVariety(), pet.getAge(), pet.getKind(), pet.getPdate(), pet.getExplanation(),
									 pet.getWeight(), pet.getImage(), pet.getAdopt(), pet.getNoAdopt(), pet.getProtect(), pet.getLost(), pet.getAreaId()
			};
		   
			jdbcUtil.setSqlAndParameters(sql, param);      
			
			try {
				recordCount = jdbcUtil.executeUpdate(); 
				
				if (recordCount == 1) {
					System.out.println("실종신고");
				} 
			}catch (Exception ex) {
		          ex.printStackTrace();
	        } finally {
	          jdbcUtil.close();      
	        }
			return 0;
		}
	
		 // 입양 목록 -> 동물 선택, 입양 가능 Pet list 보여주기 "findAdoptList1"
		   
	      public List<Pet> findAdoptList1(String kind, int noAdopt) throws SQLException {
	           String sql = "SELECT pname, age, gender, image " 
	                       + "FROM pet "
	                       + "WHERE kind = ? and noAdopt = ? ";
	            jdbcUtil.setSqlAndParameters(sql, new Object[] {kind, noAdopt});      
	                     
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
	      
	      
	      // 입양 목록 -> 동물 선택, 입양 완료 Pet list 보여주기 "findAdoptList2"
	      
	      public List<Pet> findAdoptList2(String kind, int adopt) throws SQLException {
	           String sql = "SELECT pname, age, gender, image " 
	                       + "FROM pet "
	                       + "WHERE kind = ? and adopt = ? ";
	            jdbcUtil.setSqlAndParameters(sql, new Object[] {kind, adopt});      
	                     
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

	}