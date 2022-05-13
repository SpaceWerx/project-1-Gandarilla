package services;

import models.Status;
import models.User;
import repositories.ReimbursementDAO;

import java.util.ArrayList;
import java.util.List;

import models.Reimbursement;
import models.Role;

public class ReimbursementService {

		public ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
		public UserService userService = new UserService();
		
		
		public List<Reimbursement> getPendingReimbursements() { return reimbursementDAO.getByStatus(Status.Pending);}
	
	
		public List<Reimbursement> getResolvedReimbursements(){
			
			List<Reimbursement> resolvedReimbursements = new ArrayList<>();
			
			resolvedReimbursements.addAll(reimbursementDAO.getByStatus(Status.Aproved));
			resolvedReimbursements.addAll(reimbursementDAO.getByStatus(Status.Denied));
			
			
			return resolvedReimbursements;
		}
	
		
		
	public int submitReimbursement (Reimbursement reimbursementToBeSubmitted) {
		
		User employee = getUserService().getUserById(reimbursementToBeSubmitted.getAuthor());
		
		if(employee.getRole() != Role.Employee) {
			
			throw new IllegalArgumentException("Managers cannot submit reimbursement requests.");
		} else {
			reimbursementToBeSubmitted.setStatus(Status.Pending);
			
			return reimbursementDAO.create(reimbursementToBeSubmitted);
		}
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static List<Reimbursement> reimbursements = new ArrayList<>();
	
/////////////////////////////////////////////////////////////////////////////////////
	
//public List<Reimbursement> getResolvedReimbursements() {
//	List<Reimbursement> resolvedReimbursements = new ArrayList<Reimbursement>();
//	
//	for (Reimbursement reimbursement : reimbursements) {
//		if(reimbursement.getStatus() == Status.Aproved || reimbursement.getStatus() == Status.Denied) {
//			resolvedReimbursements.add(reimbursement);
//		}
//	}
//	return resolvedReimbursements;
//}
//	
//	
////////////////////////////////////////////////////////////////////////////////////////////
//public void submitReimbursement(Reimbursement reimbursementToBeSubmitted) {
//		Reimbursement latestReimbursement = reimbursements.get(reimbursements.size() -1);
//		int id = latestReimbursement.getId() + 1;
//		
//		reimbursementToBeSubmitted.setId(id);
//		reimbursementToBeSubmitted.setStatus(Status.Pending);
//		reimbursements.add(reimbursementToBeSubmitted);
//		
//	}
////////////////////////////////////////////////////////////////////////////////////////////////////
//
//public List<Reimbursement> getPendingReimbursements() {
//	List<Reimbursement> pendingReimbursements = new ArrayList<>();
//	
//		for (Reimbursement reimbursement : reimbursements) {
//			if (reimbursement.getStatus() == Status.Pending) {
//				pendingReimbursements.add(reimbursement);			}
//		}
//		return pendingReimbursements;
//}
///////////////////////////////////////////////////////////////////////////////////////////////
	
//	public Reimbursement getReimbursementById(int selection) {
//		return null;}
//	
	public List<Reimbursement> getAllPendingReimbursements(List<Reimbursement> Pending) {
	return Pending;
	}
	
	public List<Reimbursement> getAllResolvedReimbursements(List<Reimbursement> Resolved) {
		return Resolved;
	}
	public List<Reimbursement> getAllReimbursements(List<Reimbursement> reimbursement){
		return reimbursement;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Reimbursement> getReimbursementsByAuthor(int userId) {
		
		List<Reimbursement> userReimbursements = new ArrayList<>();
		
			for(Reimbursement r : reimbursements) {
				if (r.getAuthor() == userId || r.getResolver() == userId) {
				}
			}
			return userReimbursements;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public void update(Reimbursement unprocessedReimbursement, int resolvedId, Status updatedStatus) {
//	
//		for(Reimbursement reimbursement : reimbursements) {
//			if(reimbursement.getId()== unprocessedReimbursement.getId()) {
//				reimbursement.setResolver(resolvedId);
//				reimbursement.setStatus(updatedStatus);
//				return;
//			}
//		}
//		throw new RuntimeException("There was an error processing this reimbursement, please try again.");
//	}	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Reimbursement update(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) {
	
		User manager = getUserService().getUserById(resolverId);
		
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
public Reimbursement getReimbursementById(int id) {return ReimbursementDAO.getReimbursementById(id);}
	
public List<Reimbursement> getReimbursementByAuthor(int userId) {
	return reimbursementDAO.getReimbursementsByUser(userId);
}


public UserService getUserService() {
	return userService;
}


public void setUserService(UserService userService) {
	this.userService = userService;
}
	
	}
