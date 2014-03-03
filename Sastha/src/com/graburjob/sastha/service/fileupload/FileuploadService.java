package com.graburjob.sastha.service.fileupload;

import java.sql.Blob;

import com.graburjob.sastha.dao.fileupload.FileUploadDAO;
import com.graburjob.sastha.model.registration.Document;

public class FileuploadService implements IFileuploadService{

	@Override
	public int upLoadDocument(Document document, String userId) {
		FileUploadDAO fileUploadDAO = new FileUploadDAO();
		return fileUploadDAO.uploadDocument(document, userId);
	}

	public Blob getDocumentByID(String documentId) {
		FileUploadDAO fileUploadDAO = new FileUploadDAO();
		return fileUploadDAO.getDocumentByID(documentId);
	}

}
