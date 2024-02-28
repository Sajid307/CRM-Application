package com.example.trash.AllEntity;

public class ContactEntity {
	private int id;
	private String firstName;
	private String lastName;
	private String company;
	private String email;
	private String address;
	private String tags;
	private int cTrash;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public int getcTrash() {
		return cTrash;
	}
	public void setcTrash(int cTrash) {
		this.cTrash = cTrash;
	}
	public ContactEntity(int id, String firstName, String lastName, String company, String email, String address,
			String tags, int cTrash) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.email = email;
		this.address = address;
		this.tags = tags;
		this.cTrash = cTrash;
	}
	public ContactEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ContactEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company="
				+ company + ", email=" + email + ", address=" + address + ", tags=" + tags + ", cTrash=" + cTrash + "]";
	}
	
}
