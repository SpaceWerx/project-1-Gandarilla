package com.revature;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;

import models.Reimbursement;
import models.User;
import repositories.ReimbursementDAO;
import services.ReimbursementService;
import services.UserService;

public class ReimbursementServiceTest {


private static ReimbursementService reimbursementService;
private static UserService userService;
private static ReimbursementDAO reimbursetDAO;
	

private Reimbursement REIMBURSEMENT_TO_PROCESS;
private List<Reimbursement> mockPendingReimbursements;
private List<Reimbursement> mockApprovedReimbursements;
private List<Reimbursement> mockDeniedReimbursements;
private User GENERIC_EMPLOYEE_1;
private User GENERIC_MANAGER_1;


@BeforeClass
public static void setUpBeforeClass() throws Exception {
	
	reimbursementService = new ReimbursementService();
	
}
@Before
public void setUp() throws Exception {
	
	
}

}
