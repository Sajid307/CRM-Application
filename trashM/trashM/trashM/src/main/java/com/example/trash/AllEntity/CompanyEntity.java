package com.example.trash.AllEntity;

public class CompanyEntity {
	
	private long id;
	private String name;
	private String website;
	private String email;
	private String address;
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

	public CompanyEntity(long id, String name, String website, String email, String address, String tags, int companyTrash) {
		super();
		this.id = id;
		this.name = name;
		this.website = website;
		this.email = email;
		this.address = address;
		this.tags = tags;
		this.companyTrash = companyTrash;
	}

	public CompanyEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
