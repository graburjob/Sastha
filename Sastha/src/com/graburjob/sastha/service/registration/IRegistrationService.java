package com.graburjob.sastha.service.registration;

import java.util.List;

import com.graburjob.sastha.model.registration.Document;

public interface IRegistrationService {
	
	public String isValidUser(String userId, String password);
	public List<Document> getUserProfile(String userId, String role);
	
}
