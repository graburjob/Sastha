package com.graburjob.sastha.dao.registration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.graburjob.sastha.model.registration.UserProfile;


public class RegistrationDAO extends BaseDataBaseAccess {

	public String isValidUser(String email, String password) {

		String role ="";
		Connection connection = getDBConnection();
		String query = "select password,role from passwords where email='" + email +"'";
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				
				if(password.equals(rs.getString("password")))
				{
					role=rs.getString("role");
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	public UserProfile getPatientProfile(String email, String role) {
		PatientProfile patientProfile=null;
		Connection connection = getDBConnection();
		String query = "select name,gender,dob,email,contact,address from patient_profile where email='" + email +"'";
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				patientProfile = new PatientProfile();
				patientProfile.setName(rs.getString("name"));
				patientProfile.setGender(rs.getString("gender"));
				patientProfile.setDOB(rs.getString("dob"));
				patientProfile.setEmail(rs.getString("email"));
				patientProfile.setContact(rs.getString("contact"));
				patientProfile.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patientProfile;		
	}
	
	/*public int createUser(User user) {

		Connection connection = getDBConnection();
		int result = 0;
		String query = "INSERT INTO PASSWORDS(email, password,role) VALUES('"+user.getEmail()+"','"+user.getPassword()+"','"+user.getRole()+"')";
		System.out.println(query);
		Statement stmt;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			System.out.println("Result ********" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public PatientProfile getPatientProfile(String email) {
		PatientProfile patientProfile=null;
		Connection connection = getDBConnection();
		String query = "select name,gender,dob,email,contact,address from patient_profile where email='" + email +"'";
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				patientProfile = new PatientProfile();
				patientProfile.setName(rs.getString("name"));
				patientProfile.setGender(rs.getString("gender"));
				patientProfile.setDOB(rs.getString("dob"));
				patientProfile.setEmail(rs.getString("email"));
				patientProfile.setContact(rs.getString("contact"));
				patientProfile.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patientProfile;		
	}*/

	
}
