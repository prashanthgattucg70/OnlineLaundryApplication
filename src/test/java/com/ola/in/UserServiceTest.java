package com.ola.in;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ola.in.entity.User;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.service.IUserService;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private IUserService userService;
	
	User user=null;
	
	
	@Test
	public void signInTest01() throws NotFoundException{
		//signInTest1 method 
		user=new User("386","jsdeus");
		try {
		userService.signIn(user);
		}
		catch(NotFoundException ex) {
		assertEquals("UserId or Password is not correct",ex.getMessage());
		}
	}
	@Test
	public void signInTest02() throws NotFoundException{
		//signInTest2 method 
		user=new User("7","xyz");
		try {
		assertNotNull(userService.signIn(user));
		}
		catch(NotFoundException ex) {
		assertEquals("UserId or Password is not correct",ex.getMessage());
		}
	}
	
	@Test
	public void signOutTest01() {
		//signOutTest1 method 
		user=new User("386","jsdeus");
		assertEquals(userService.signOut(user),user);
	}
	@Test
	public void signOutTest02() {
		//signOutTest2 method 
		user=new User("7","xyz");
		assertEquals(userService.signOut(user),user);
	}
	
	@Test
	public void changePasswordTest01() throws NotFoundException{
		//changePasswordtTest1 method 
		user=new User("386","jsdeus");
		try {
			userService.changePassword("639", user);
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
	@Test
	public void changePasswordgTest02() throws NotFoundException{
		//changePasswordTest1 method 
		user=new User("7","xyz");
		try {
		assertNotNull(userService.changePassword("7", user));
		}
		catch(NotFoundException ex) {
			assertEquals("User Id is not valid",ex.getMessage());
		}
	}
}
