package com.ola.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ola.in.entity.User;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.exceptions.UserNotFoundException;
import com.ola.in.service.IUserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
					/*{
  						"userId": "1005",
  						"password": "sai@123"
						} */
	//Get sign in
	@PostMapping("/getsignin")
	public ResponseEntity<Object> signIn(@RequestBody User user) throws UserNotFoundException{
		ResponseEntity <Object>response=null;
		User u=userService.signIn(user);
		response=new ResponseEntity<>(u, HttpStatus.ACCEPTED);
		return response;
	}
	
	//Get sign out
	@PostMapping("/getsignout")
	public ResponseEntity<Object> signOut(@RequestBody User user) {
		ResponseEntity<Object> response=null;
		User u = userService.signOut(user);
		response=new ResponseEntity<Object>(u,HttpStatus.OK);
		return response;
	}
	
	//Update Password by id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> changePassword(@PathVariable String id,@RequestBody User user) throws UserNotFoundException{
		
			ResponseEntity <Object>response=null;
			User u= userService.changePassword(id, user);
			response=new ResponseEntity<>(u, HttpStatus.ACCEPTED);
		return response;
	}
	
}
