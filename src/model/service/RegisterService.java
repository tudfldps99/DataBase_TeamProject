package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Pet;
import model.dao.RegisterDAO;

public class RegisterService {
	private static RegisterService registerService = new RegisterService();
	private RegisterDAO registerDAO;
	
	private RegisterService() {
		try {
			registerDAO = new RegisterDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public static RegisterService getInstance() {
	      return registerService;
	   }
	 
	 public int adoptionProposal(Pet pet) {
		  return registerDAO.adoptionProposal(pet);
	 }
	   
	 public int missingReport(Pet pet) throws SQLException {
		 return registerDAO.missingReport(pet);		 
	 }
	 
	public int protectionReport(Pet pet) throws SQLException {
		return registerDAO.protectionReport(pet);
	}
	
    public List<Pet> findAdoptList1(String kind, int noAdopt) throws SQLException { 
	     List<Pet> pet = registerDAO.findAdoptList1(kind, noAdopt);
	     return pet;
	}
	   
	public List<Pet> findAdoptList2(String kind, int adopt) throws SQLException { 
	     List<Pet> pet = registerDAO.findAdoptList2(kind, adopt);
	     return pet;
	 }

}
