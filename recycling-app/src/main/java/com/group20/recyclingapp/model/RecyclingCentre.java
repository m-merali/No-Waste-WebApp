package com.group20.recyclingapp.model;

import javax.persistence.*;

@Entity
@Table
public class RecyclingCentre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String localAuthority;
	private String email;
	private Integer telephone;
	
//no argument constructor
	public RecyclingCentre () {
		
	}
	
//constructor with everything
	public RecyclingCentre(
			Long id, 
			String name, 
			String localAuthority, 
			String email, 
			Integer telephone) {
		
		
		this.id = id;
		this.name = name;
		this.localAuthority = localAuthority;
		this.email = email;
		this.telephone = telephone;
	}
	
//constructor without id because it will be auto-generated		
public RecyclingCentre(String name,
		String localAuthority, 
		String email, 
		Integer telephone) {
	this.name = name;
	this.localAuthority = localAuthority;
	this.email = email;
	this.telephone = telephone;
}

//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalAuthority() {
		return localAuthority;
	}

	public void setLocalAuthority(String localAuthority) {
		this.localAuthority = localAuthority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "RecyclingCentre{" +
				"id=" + id +
				", name='" + name + '\'' +
				", localAuthority='" + localAuthority + '\'' +
				", email='" + email + '\'' +
				", telephone=" + telephone +
				'}';
	}
}
