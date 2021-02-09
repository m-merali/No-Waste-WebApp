package com.group20.recyclingapp.model;

public class RecyclingCentre {

	private Long id;
	private String name;
	private String localAuthority;
	private String email;
	private Integer telephone;
	
//no args constructor
	public RecyclingCentre () {
		
	}
	
//constuctor	
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
	
	
	

}
