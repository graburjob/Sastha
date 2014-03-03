package com.graburjob.sastha.model.registration;

import java.util.List;

public class User {

	private String userId;
	private String role;
	private List<Document> uploadedDocuments;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Document> getUploadedDocuments() {
		return uploadedDocuments;
	}
	public void setUploadedDocuments(List<Document> uploadedDocuments) {
		this.uploadedDocuments = uploadedDocuments;
	}
}
