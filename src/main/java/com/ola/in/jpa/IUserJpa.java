package com.ola.in.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ola.in.entity.User;

public interface IUserJpa extends JpaRepository<User, String>{
	@Query("Select u from User u where u.userId= ?1 and u.password= ?2")
	User findByUserIdAndPassword(String user_id, String password);

}
