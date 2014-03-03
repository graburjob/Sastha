package com.graburjob.sastha.service.fileupload;

import java.sql.Blob;

import com.graburjob.sastha.model.registration.Document;

public interface IFileuploadService {
	public int upLoadDocument(Document document,String userId);
	public Blob getDocumentByID(String documentId);
}
