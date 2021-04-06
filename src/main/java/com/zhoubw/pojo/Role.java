package com.zhoubw.pojo;

import javax.persistence.*;
import java.util.List;


@Entity
@Table ( name ="role" )
public class Role {

   	@Column(name = "role" )
	private String role;

	@Id
	@Column(name = "id")
	private Long id;

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private List<UserRole> userRoles;

	public Role(){}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
