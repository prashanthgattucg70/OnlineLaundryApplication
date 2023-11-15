package com.ola.in.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ola.in.entity.User;
import com.ola.in.exceptions.NotFoundException;
import com.ola.in.exceptions.UserNotFoundException;
import com.ola.in.repositories.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService{
	@Autowired
	private IUserRepository userRepository;
	
	public User signIn(User user) throws UserNotFoundException{
		User u = userRepository.findByUserIdAndPassword(user.getUserId(),user.getPassword());
		
		if(u==null) {
			throw new UserNotFoundException("check password and userId");
		}
		return u;
		
	}
	
	public User signOut(User user) {
		return user;
	}
	
	public User changePassword(String id, User user) throws UserNotFoundException{
		Optional<User> ou=userRepository.findById(id);
		if(ou.isPresent()) {
			User u=ou.get();
			u.setPassword(user.getPassword());
			userRepository.save(u);
			return u;
		}
		else
			throw new UserNotFoundException("User Id is not valid");	
	}
}
