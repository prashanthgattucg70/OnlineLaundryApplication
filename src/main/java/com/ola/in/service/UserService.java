package com.ola.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.in.entity.User;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.repositories.IUserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserRepository userRepository;
	
	//sign in for user
	public User signIn(User user) throws NotFoundException {
		//("User service - SignIn method executed");
		return userRepository.signIn(user) ;
	}
	
	//Sign out for user
	public User signOut(User user) {
		//("User service - SignOut method executed");
		return userRepository.signOut(user);
	}
	
	//Change password for user
	public User changePassword(String id, User user) throws NotFoundException{
		//("User service - ChangePassword method executed");
		return userRepository.changePassword(id, user);
	}
}
