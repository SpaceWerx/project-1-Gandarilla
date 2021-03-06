package services;

import models.Status;			
import models.User;
import repositories.ReimbursementDAO;
import repositories.UserDAO;

import java.util.ArrayList;
import java.util.List;

import mockdata.MockReimbursementData;
import models.Reimbursement;
import models.Role;

public class ReimbursementService {

		public static ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
		public static UserService rService = new UserService();
		public static ArrayList<Reimbursement> reimbursements = new ArrayList<>();	
		public static void clearData() {	
			reimbursements.clear();
		}


public Reimbursement update(Reimbursement unprocessedReimbursement) {	
		
			reimbursementDAO.update(unprocessedReimbursement);

			return unprocessedReimbursement;

	
	
}

			
		
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		public static List<Reimbursement> getPendingReimbursements() { 

			return reimbursementDAO.getByStatus(Status.Pending);
}
////////////////////////////////////////////////////////////////////
	
		public List<Reimbursement> getResolvedReimbursements(){
			
			List<Reimbursement> resolvedReimbursements = new ArrayList<>();
			

			resolvedReimbursements.addAll(reimbursementDAO.getByStatus(Status.Approved));
			resolvedReimbursements.addAll(reimbursementDAO.getByStatus(Status.Denied));
			return resolvedReimbursements;
			
			
		}
	
/////////////////////////////////////////////////////////////////////////////		
		
	public int submitReimbursement (Reimbursement reimbursementToBeSubmitted) {
		

	
		User employee = rService.getUserById(reimbursementToBeSubmitted.getAuthor());
	
		
		
			reimbursementToBeSubmitted.setStatus(Status.Pending);
			
	
			return reimbursementDAO.create(reimbursementToBeSubmitted);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public List<Reimbursement> getReimbursementsByAuthor(int userId) {
		
		List<Reimbursement> userReimbursements = new ArrayList<>();
		
			for(Reimbursement r : reimbursements) {
				if (r.getAuthor() == userId || r.getResolver() == userId) {
				}
			}
			return userReimbursements;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Reimbursement updateManager(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) {
	
		getUserService();//DELETE IF NECESSARY
		User manager = rService.getUserById(resolverId);
		
		if(manager.getRole() != Role.Manager) {
			
			throw new IllegalArgumentException("An Employee cannot process reimbursement requests.");
		}else {
			unprocessedReimbursement.setResolver(resolverId);
			unprocessedReimbursement.setStatus(updatedStatus);
			
			reimbursementDAO.update(unprocessedReimbursement);
			
			return unprocessedReimbursement;
		}
}
////////////////////////////////////////
public static Reimbursement getReimbursementById(int id) {
	return ReimbursementDAO.getReimbursementById(id);
	}
	
public static List<Reimbursement> getReimbursementByAuthor(int userId) {
	return reimbursementDAO.getReimbursementsByUser(userId);
}


public UserService getUserService() {
	return rService;
}


public void setUserService(UserService userService) {
	this.rService = userService;
}


public List<Reimbursement> getReimbursementByStatus(Status status){
		return reimbursementDAO.getByStatus(status);
} 

}


