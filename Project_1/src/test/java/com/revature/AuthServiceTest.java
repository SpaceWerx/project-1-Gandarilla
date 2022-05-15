package com.revature;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.anyInt;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import services.AuthService;

public class AuthServiceTest {	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
@Test
	public void testLoginFailsWhenPasswordIncorrect() {
		
		Mockito.when(AuthService.login(anyInt())).thenReturn("Login Failed, Wrong Password");
		
		assertThrows(IllegalArgumentException.class,
							() -> AuthService.update("Login Failed, Wrong Password or Input")
		);
		
	
	}

}
