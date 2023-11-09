package com.ola.in.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="admins")
@PrimaryKeyJoinColumn(referencedColumnName="user_id")
public class Admin extends User{
	private String userId;
}
