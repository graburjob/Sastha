package com.graburjob.sastha.controller.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graburjob.sastha.service.fileupload.FileuploadService;

/**
 * Servlet implementation class DisplayPhotoServlet
 */
@WebServlet("/DisplayPhotoServlet")
public class DisplayPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String documentId = request.getParameter("Document_ID");
		FileuploadService fileuploadService = new FileuploadService();
		
        Blob b = fileuploadService.getDocumentByID(documentId);
        response.setContentType("image/jpeg");
        try {
			response.setContentLength((int) b.length());
			InputStream is = b.getBinaryStream();
			OutputStream os = response.getOutputStream();
			byte buf[] = new byte[(int) b.length()];
	        is.read(buf);
	        os.write(buf);
	        os.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
