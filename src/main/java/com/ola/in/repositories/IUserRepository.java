package com.ola.in.repositories;

import com.ola.in.entity.User;
import com.ola.in.exceptions.NotFoundException;

public interface IUserRepository {
	User signIn(User user)throws NotFoundException;
	User signOut(User user);
	User changePassword(String id, User user)throws NotFoundException;
}
