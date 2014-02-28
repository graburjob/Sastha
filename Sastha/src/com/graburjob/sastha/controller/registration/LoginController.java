package com.graburjob.sastha.controller.registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graburjob.sastha.model.registration.UserProfile;
import com.graburjob.sastha.service.registration.RegistrationService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside Do Post LoginController");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RegistrationService regService = new RegistrationService();
		String role = regService.isValidUser(email,password);
		UserProfile patientProfile= regService.getUserProfile(email,role);
		request.setAttribute("currentPatientProfile", patientProfile);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("uploadImage.jsp");
		requestDispatcher.forward(request, response);
	}

}
