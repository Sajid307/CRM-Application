package com.example.trash.AllEntity;

public class DocumentEntity {

	private long id;

	private String documentName;

	private String typeOfDoc;

	private Long contacts;

	private String tags;

	private int trash;

	public int getTrash() {
		return trash;
	}

	public void setTrash(int trash) {
		this.trash = trash;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getTypeOfDoc() {
		return typeOfDoc;
	}

	public void setTypeOfDoc(String typeOfDoc) {
		this.typeOfDoc = typeOfDoc;
	}

	public Long getContacts() {
		return contacts;
	}

	public void setContacts(Long contacts) {
		this.contacts = contacts;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public DocumentEntity(long id, String documentName, String typeOfDoc, Long contacts, String tags, int trash) {
		super();
		this.id = id;
		this.documentName = documentName;
		this.typeOfDoc = typeOfDoc;
		this.contacts = contacts;
		this.tags = tags;
		this.trash = trash;
	}

	public DocumentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", documentName=" + documentName + ", typeOfDoc=" + typeOfDoc + ", contacts="
				+ contacts + ", tags=" + tags + "]";
	}

}
