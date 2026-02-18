package com.activity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import detailsregister.InsertInfo;
import detailsregister.User_details;

/**
 * Servlet implementation class Registrtion
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		
		  response.setContentType("text/html;charset=UTF-8");
			PrintWriter pw=response.getWriter();
			String name=request.getParameter("txtname"),
			emailid=request.getParameter("email"),
			mobile=request.getParameter("txtmobile"),
			password=request.getParameter("txtpwd"),
			address=request.getParameter("txtaddress"),
			gender=request.getParameter("gender");
			String roll=request.getParameter("roll");
User_details uid= new User_details();			
uid.setUsername(name);
uid.setAddr(address);
uid.setemail(emailid);
uid.setpwd(password);
uid.setMonbileNo(mobile);
int i=0;
if(roll.equals("Patient"))
{
	String hospital_name=request.getParameter("hospital_name");
	
	i=InsertInfo.insertPatient(uid,hospital_name);
}
else if(roll.equals("Admin"))
{
	i=InsertInfo.inserthospital(uid);

}
else{
	
	i=InsertInfo.insertInsurance(uid);
}

				if(i!=0)
				{
					System.out.println("OK ");
					pw.println("<script> alert(' Register Successfuly');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.jsp");
					rd.include(request, response); 
				}
				else
				{
					
					RequestDispatcher rd = request.getRequestDispatcher("/RegisterPage.jsp");
							rd.include(request, response);
					//System.out.print(" Wrong ID and Password");
					
				}
			
	}

}
