package com.example.trash.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@javax.persistence.Entity
@Table(name = "trash")
public class TrashEntity {

	@Id
	private Long id;

	@Column(nullable = false)
	private String recordType;
	
	@Column(nullable = false)
	private LocalDateTime timestamp;
	
	@Column(nullable = false)
	private Long userId;
	
	@Column(nullable = false)
	private Long recordId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getrecordType() {
		return recordType;
	}

	public void setrecordType(String recordType) {
		this.recordType = recordType;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public TrashEntity(Long id, String recordType, LocalDateTime timestamp, Long userId, Long recordId) {
		super();
		this.id = id;
		this.recordType = recordType;
		this.timestamp = timestamp;
		this.userId = userId;
		this.recordId = recordId;
	}

	public TrashEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "trashEntity [id=" + id + ", recordType=" + recordType + ", timestamp=" + timestamp + ", userId=" + userId
				+ ", recordId=" + recordId + "]";
	}

}
