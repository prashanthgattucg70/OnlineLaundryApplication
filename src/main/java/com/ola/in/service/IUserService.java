package com.ola.in.service;

import com.ola.in.entity.User;
import com.ola.in.exceptions.UserNotFoundException;


public interface IUserService {
	User signIn(User user) throws UserNotFoundException;
	User signOut(User user);
	User changePassword(String id, User user) throws UserNotFoundException;
}
