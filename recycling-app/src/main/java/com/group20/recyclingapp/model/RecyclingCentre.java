package com.group20.recyclingapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity

public class RecyclingCentre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String localAuthority; // also called borough
	@NotEmpty
	private String email;
	@NotNull
	private Integer telephone;
	@NotEmpty
	private String url;
	@NotEmpty
	private String postcode;

	private String collectionDay;

	
//Entity relationships often depend on the existence of another entity — for example,
// the Person–Address relationship. Without the Person, the Address entity doesn't have any meaning of its own.
// When we delete the Person entity, our Address entity should also get deleted.
//
//Cascading is the way to achieve this. When we perform some action on the target entity,
// the same action will be applied to the associated entity.

	@OneToOne(cascade = CascadeType.ALL)
	private Location location;

	
//constructor without id because it will be auto-generated		

	public RecyclingCentre(@NotEmpty String name,
						   @NotEmpty String localAuthority,
						   @NotEmpty String email,
						   @NotNull Integer telephone,
						   @NotEmpty String url,
						   @NotEmpty String postcode,
						   Location location,
						   String collectionDay) {
		this.name = name;
		this.localAuthority = localAuthority;
		this.email = email;
		this.telephone = telephone;
		this.url = url;
		this.postcode = postcode;
		this.location = location;
		this.collectionDay = collectionDay;
	}

	public RecyclingCentre() {

	}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getCollectionDay() {
		return collectionDay;
	}

	public void setCollectionDay(String collectionDate) {
		this.collectionDay = collectionDate;
	}
}
