package com.zhoubw.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table ( name ="user" )
public class UserEntity {

	@Id
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "password" )
	private String password;

	@OneToOne(mappedBy="userEntity")
	private UserRole UserRole;

	public UserEntity(){}

	@Override
	public String toString() {
		return "UserEntity{" +
				"id='" + id + '\'' +
				"name='" + name + '\'' +
				"password='" + password + '\'' +
				'}';
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public com.zhoubw.pojo.UserRole getUserRole() {
		return UserRole;
	}

	public void setUserRole(com.zhoubw.pojo.UserRole userRole) {
		UserRole = userRole;
	}
}
