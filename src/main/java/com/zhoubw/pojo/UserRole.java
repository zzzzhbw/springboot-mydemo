package com.zhoubw.pojo;

import javax.persistence.*;

/**
 * @Author  isalo
 * @Create 2021-01-03 21:50:14 
 * @Description  
 */

@Entity
@Table ( name ="user_role" )
public class UserRole   {

	@Id
	@Column(name = "id" )
	private Long id;

	@JoinColumn(name = "user_id")
	@OneToOne(cascade = CascadeType.ALL)
	private UserEntity userEntity;

   	@JoinColumn(name = "role" )
	@ManyToOne
	private Role role;


	public UserRole(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return userEntity;
	}

	public void setUser(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
