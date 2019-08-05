package com.bae.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 50, unique = true)
	private String firstname;
	@Column(length = 50)
	private String lastname;
	@Column(length = 5)
	private String prize;

	public User(long id, String firstname, String lastname, String prize) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.prize = prize;
	}

	public User() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstNname() {
		return firstname;
	}

	public void setFirstNname(String firstNname) {
		this.firstname = firstNname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

}
