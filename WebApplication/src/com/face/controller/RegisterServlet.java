package com.face.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.face.dao.UserDAO;
import com.face.model.UserAccount;
import com.face.utility.ConnectionManager;
import com.prograd.logic.ValidationClass;

/**
 * Servlet implementation class RegisterServlet
 * Registration 
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ConnectionManager conn=new ConnectionManager();
       UserDAO userdao=new UserDAO();
       UserAccount user=new UserAccount();
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerView.jsp");
	rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		ValidationClass valid=new ValidationClass();
		if(valid.isValid(firstname,lastname,username,password,confirmpassword,email,mobile)) {
		
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUsername(username);
		user.setPassword(password);
		user.setConfirmpassword(confirmpassword);
		user.setEmail(email);
		user.setMobile(mobile);
		
		try {
			if(userdao.save(user,conn))
			{
				response.sendRedirect("/WebApplication/LoginServlet");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
	}

	

}
