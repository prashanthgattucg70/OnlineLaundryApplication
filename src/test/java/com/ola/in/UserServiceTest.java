package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ola.in.entity.User;
import com.ola.in.exceptions.UserNotFoundException;
import com.ola.in.service.IUserService;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private IUserService userService;
	
	User user=null;
	
	@Test
	//signOutTest1 method 
	public void signOutTest01() {
		user=new User("386","jsdeus");
		assertEquals(userService.signOut(user),user);
	}
	@Test
	//signOutTest2 method 
	public void signOutTest02() {
		user=new User("7","xyz");
		assertEquals(userService.signOut(user),user);
	}
	
	@Test
	//changePasswordtTest1 method 
	public void changePasswordTest01() throws UserNotFoundException{
		user=new User("386","jsdeus");
		try {
			userService.changePassword("639", user);
		}
		catch(UserNotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
	@Test
	//changePasswordTest1 method 
	public void changePasswordgTest02() throws UserNotFoundException{
		user=new User("7","xyz");
		try {
		assertNotNull(userService.changePassword("7", user));
		}
		catch(UserNotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
}
