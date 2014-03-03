package com.graburjob.sastha.dao.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.graburjob.sastha.model.registration.Document;
import com.graburjob.sastha.model.registration.User;


public class RegistrationDAO extends BaseDataBaseAccess {

	public String isValidUser(String userId, String password) {

		String role ="";
		Connection connection = getDBConnection();
		String query = "select password,role from users where user_Id='" + userId +"'";
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

	public List<Document> getPatientProfile(String userId, String role) {
		User user= new User();
		user.setUserId(userId);
		List<Document> listOfDocuments = new ArrayList<Document>();
		Document document = null;
		Connection connection = getDBConnection();
		String query = null;		
		PreparedStatement stmt;
		try {
			if("B".equals(role)){
				query= "select Document_ID,Document_Name,Document_Type from document where user_id=?";
			} else {
				query = "select Document_ID,Document_Name,Document_Type from document";
			}
			stmt = (PreparedStatement) connection.prepareStatement(query);
			if("B".equals(role)){
				stmt.setString(1, userId);
			}
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				document = new Document();
				document.setDocumentId(rs.getString("Document_ID"));
				document.setDocumentType(rs.getString("Document_Type"));
				document.setDocumentName(rs.getString("Document_Name"));
				listOfDocuments.add(document);					
			}
			user.setUploadedDocuments(listOfDocuments);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfDocuments;		
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
