package com.graburjob.sastha.controller.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.graburjob.sastha.model.registration.Document;
import com.graburjob.sastha.service.fileupload.FileuploadService;
import com.graburjob.sastha.service.registration.RegistrationService;

@WebServlet("/UploadServlet")
@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = -1623656324694499109L;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Document document = new Document();
		String userId = null;
		String role = null;
		InputStream inputStream = null;
		
		String documentType = request.getParameter("optionsRadios");
		document.setDocumentType(documentType);
		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("scannedCopy");
		if (filePart != null) {
			// debug messages
			System.out.println(getFileName(filePart));
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
			document.setImage(inputStream);
			document.setDocumentName(getFileName(filePart));
		}
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        	userId=(String)session.getAttribute("userId");
        	role=(String)session.getAttribute("role");  
        }
		FileuploadService fileuploadService =  new FileuploadService();
		fileuploadService.upLoadDocument(document, userId);
		RegistrationService regService = new RegistrationService();
		List<Document> listOfDocument= regService.getUserProfile(userId,role);
		request.setAttribute("uploadedDocumentsByUser", listOfDocument);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserHome.jsp");
		requestDispatcher.forward(request, response);
	}
	
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}