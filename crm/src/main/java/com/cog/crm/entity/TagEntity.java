package com.cog.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class TagEntity {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "tag")
	private String tag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public TagEntity(int id, String tag) {
		super();
		this.id = id;
		this.tag = tag;
	}

	public TagEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}