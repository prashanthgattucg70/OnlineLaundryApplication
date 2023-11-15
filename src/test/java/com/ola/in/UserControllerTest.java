package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.ola.in.controller.UserController;
import com.ola.in.entity.User;
import com.ola.in.exceptions.UserNotFoundException;

@SpringBootTest
public class UserControllerTest {
	@Autowired
	private UserController userController;
	
	User user=null;
	
	
	/*@Test
	public void signInTest01() throws UserNotFoundException{
		user=new User("7","xyz");
		try {
		assertEquals(userController.signIn(user).getStatusCode(),HttpStatus.ACCEPTED);
		}
		catch(UserNotFoundException ex) {
			assertEquals("UserId or Password is not correct",ex.getMessage());
		}
	}*/
	
	@Test
	public void signOutTest01() {
		user=new User("7","xyz");
		assertEquals(userController.signOut(user).getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void changePasswordTest01() throws UserNotFoundException{
		user=new User("7","xyz");
		try {
		assertEquals(userController.changePassword("7", user).getStatusCode(),HttpStatus.ACCEPTED);
		}
		catch(UserNotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
		
	}
}
