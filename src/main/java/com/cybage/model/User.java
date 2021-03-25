package com.cybage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="user", uniqueConstraints = {
@UniqueConstraint(columnNames = "uid"),
@UniqueConstraint(columnNames = "email"),
@UniqueConstraint(columnNames = "phoneno")})
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique = true, nullable = false,length = 5)
	private Long uid;
	@Column(unique = true,nullable = false,length=50)
	private String username;
	
	private String password;
	@Column(unique = true, nullable = false, length = 70)
	private String email;
	@Column(unique = true,length = 10)
	private Long phoneno;
	@Column(nullable = false, length=5)
	@NotBlank(message="role can not be empty")
	private String role;
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "users")
//	List<Order> userorder;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long uid, String name, String password, String email, Long phoneno, String role) {
		super();
		this.uid = uid;
		this.username = name;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
		this.role = role;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUserame(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + username + ", password=" + password + ", email=" + email + ", phoneno="
				+ phoneno + ", role=" + role + "]";
	}
	
}
