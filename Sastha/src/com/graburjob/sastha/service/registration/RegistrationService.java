package com.graburjob.sastha.service.registration;

import com.graburjob.sastha.dao.registration.RegistrationDAO;
import com.graburjob.sastha.model.registration.UserProfile;

public class RegistrationService implements IRegistrationService{

	@Override
	public String isValidUser(String email, String password) {
		RegistrationDAO rDAO = new RegistrationDAO();
		return rDAO.isValidUser(email,password);
	}

	public UserProfile getUserProfile(String email, String role) {
	    RegistrationDAO rDAO = new RegistrationDAO();
		return rDAO.getPatientProfile(email,role);
	}

}
