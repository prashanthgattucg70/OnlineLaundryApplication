package com.ola.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@Inheritance(strategy= InheritanceType.JOINED)
public class User {
	@Id
	@Column(name="user_id")
	private String userId;
	@Column(name="password")
	private String password;
}

