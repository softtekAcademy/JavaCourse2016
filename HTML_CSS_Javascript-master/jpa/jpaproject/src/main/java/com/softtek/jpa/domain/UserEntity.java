package com.softtek.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="users")
@Entity
public class UserEntity {

	@Id
	@Column(name="user_id")
	private int id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_password")
	private String password;
	
}
