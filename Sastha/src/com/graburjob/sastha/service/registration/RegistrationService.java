package com.graburjob.sastha.service.registration;

import java.util.List;

import com.graburjob.sastha.dao.registration.RegistrationDAO;
import com.graburjob.sastha.model.registration.Document;

public class RegistrationService implements IRegistrationService{

	@Override
	public String isValidUser(String userId, String password) {
		RegistrationDAO rDAO = new RegistrationDAO();
		return rDAO.isValidUser(userId,password);
	}

	public List<Document> getUserProfile(String userId, String role) {
	    RegistrationDAO rDAO = new RegistrationDAO();
		return rDAO.getPatientProfile(userId,role);
	}

}
