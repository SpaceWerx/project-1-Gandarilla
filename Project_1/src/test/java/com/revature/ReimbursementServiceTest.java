package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;		
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mockdata.MockReimbursementData;
import models.Reimbursement;
import models.ReimbursementType;
import models.Role;
import models.Status;
import models.User;
import repositories.ReimbursementDAO;
import services.ReimbursementService;
import services.UserService;

public class ReimbursementServiceTest {


private static ReimbursementService reimbursementService;
private static UserService userService;
private static ReimbursementDAO reimbursementDAO;


private Reimbursement REIMBURSEMENT_TO_PROCESS;
private List<Reimbursement> mockPendingReimbursements;
private List<Reimbursement> mockApprovedReimbursements;
private List<Reimbursement> mockDeniedReimbursements;
private User GENERIC_EMPLOYEE_1;
private User GENERIC_MANAGER_1;


@BeforeAll
public static void setUpBeforeClass() throws Exception {
	
	reimbursementService = new ReimbursementService();
	
}
@BeforeAll
public void setUp() throws Exception {
	
	userService = mock(UserService.class);
	reimbursementDAO = mock(ReimbursementDAO.class);
	
	MockReimbursementData mockReimbursementData = new MockReimbursementData();
	
	reimbursementService.reimbursementDAO = reimbursementDAO;
	reimbursementService.rService = userService;
	
	GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Role.Employee);
	GENERIC_MANAGER_1 = new User(1, "genericManager1", "genericPassword", Role.Manager);
	
	
	REIMBURSEMENT_TO_PROCESS = new Reimbursement(2, GENERIC_EMPLOYEE_1.getId(), 1, "Oracle Certification", ReimbursementType.Other, Status.Pending, 150.00);

	List<Reimbursement> mockReimbursements = mockReimbursementData.getReimbursements();	
	mockPendingReimbursements = new ArrayList<>();
	mockApprovedReimbursements = new ArrayList<>();
	mockDeniedReimbursements = new ArrayList<>();
	
	
	for(Reimbursement reimbursement : mockReimbursements) {
		if(reimbursement.getStatus() == Status.Pending) {
			mockPendingReimbursements.add(reimbursement);
		}else if (reimbursement.getStatus() == Status.Approved) {
			mockApprovedReimbursements.add(reimbursement);
		}else {
			mockDeniedReimbursements.add(reimbursement);
		}
	}
}


/////////////////////////////////////////////////////////////////////////////////////////////////
@Test
public void testGetResolvedReimbursementsReturnsOnlyApprovedAndDenied() {
	
	when(reimbursementDAO.getByStatus(Status.Approved)).thenReturn(mockApprovedReimbursements);
	when(reimbursementDAO.getByStatus(Status.Denied)).thenReturn(mockDeniedReimbursements);
	
	List<Reimbursement> resolvedReimbursements = new ArrayList<>();
	resolvedReimbursements.addAll(mockApprovedReimbursements);
	resolvedReimbursements.addAll(mockDeniedReimbursements);
	
	assertEquals(resolvedReimbursements, reimbursementService.getResolvedReimbursements());

	verify(reimbursementDAO).getByStatus(Status.Approved);
	verify(reimbursementDAO).getByStatus(Status.Denied);

}

@Test
public void testGetPendingReimbursementsReturnsOnlyPending() {
	
	when(reimbursementDAO.getByStatus(any(Status.class))).thenReturn(mockPendingReimbursements);
	
	assertEquals(mockPendingReimbursements, reimbursementService.getPendingReimbursements());
	
	verify(reimbursementDAO).getByStatus(Status.Pending);
	
	
}
@Test
public void testSubmitReimbursementThrowsIllegalArgumentExceptionWhenSubmittedByManager() {
	
	when(userService.getUserById(anyInt())).thenReturn(GENERIC_MANAGER_1);
	
	assertThrows(IllegalArgumentException.class,
			() -> reimbursementService.submitReimbursement(REIMBURSEMENT_TO_PROCESS)
			
	);
	
	verify(reimbursementDAO, never()).create(REIMBURSEMENT_TO_PROCESS);
	
	verify(reimbursementDAO, never()).create(REIMBURSEMENT_TO_PROCESS);
	verify(userService);
	userService.getUserById(GENERIC_MANAGER_1.getId());

}

@Test
public void testUpdateThrowsIllegalArgumentExceptionWhenResolverIsNotManager() {
	
	when(userService.getUserById(anyInt())).thenReturn(GENERIC_EMPLOYEE_1);
	
	assertThrows(IllegalArgumentException.class,
						() -> reimbursementService.update(REIMBURSEMENT_TO_PROCESS, GENERIC_EMPLOYEE_1.getId(), Status.Approved)
	);
	
    verify(reimbursementDAO, never()).update(REIMBURSEMENT_TO_PROCESS);
	verify(userService);
	userService.getUserById(GENERIC_EMPLOYEE_1.getId());
}

@Test
public void testReimbursementStatusIsChangedAfterUpdate() {
	
	when(userService.getUserById(anyInt())).thenReturn(GENERIC_MANAGER_1);
	
	assertEquals(Status.Approved, reimbursementService.update(REIMBURSEMENT_TO_PROCESS, GENERIC_MANAGER_1.getId(),Status.Approved));
	
	verify(userService).getUserById(GENERIC_EMPLOYEE_1.getId());
	verify(reimbursementDAO).update(REIMBURSEMENT_TO_PROCESS);
}



@Test
public void testResolverIsAssignedAfterReimbursementUpdate() {
	
	when(userService.getUserById(anyInt())).thenReturn(GENERIC_MANAGER_1);
	
	assertEquals(GENERIC_MANAGER_1.getId(), reimbursementService.update(REIMBURSEMENT_TO_PROCESS, GENERIC_MANAGER_1.getId(),Status.Approved).getResolver());


	verify(userService).getUserById(GENERIC_MANAGER_1.getId());
	verify(reimbursementDAO).update(REIMBURSEMENT_TO_PROCESS);
}



	}


