package com.graburjob.sastha.dao.fileupload;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.graburjob.sastha.dao.registration.BaseDataBaseAccess;
import com.graburjob.sastha.model.registration.Document;


public class FileUploadDAO extends BaseDataBaseAccess {
	
	public int uploadDocument(Document document, String userId) {
		Connection connection = getDBConnection();
		int result = 0;
		String query = new String("INSERT INTO document(document_name,document_type,document,user_id) VALUES(?, ?, ?, ?)");
		System.out.println(query);
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
			stmt.setString(1, document.getDocumentName());
			stmt.setString(2, document.getDocumentType());
			if (document.getImage() != null) {
				// fetches input stream of the upload file for the blob column
				stmt.setBlob(3, document.getImage());
			}
			stmt.setString(4, userId);
			result = stmt.executeUpdate();
			System.out.println("Result ********" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Blob getDocumentByID(String documentId) {
		Connection connection = getDBConnection();
		Blob document=null;
		String query = "select document from document where document_id=?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
			stmt.setString(1, documentId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				document = rs.getBlob("document");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return document;		
	}

}
