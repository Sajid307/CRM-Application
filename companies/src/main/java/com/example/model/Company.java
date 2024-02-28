package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "WEBSITE")
	private String website;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "TAGS")
	private String tags;
	
	private int companyTrash;
	

	public int getCompanyTrash() {
		return companyTrash;
	}

	public void setCompanyTrash(int companyTrash) {
		this.companyTrash = companyTrash;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Company(long id, String name, String website, String email, String address, String tags, int companyTrash) {
		super();
		this.id = id;
		this.name = name;
		this.website = website;
		this.email = email;
		this.address = address;
		this.tags = tags;
		this.companyTrash = companyTrash;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", website=" + website + ", email=" + email + ", address="
				+ address + ", tags=" + tags + ", companyTrash=" + companyTrash + "]";
	}

	

	
}