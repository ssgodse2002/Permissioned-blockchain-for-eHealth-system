package com.activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

import detailsregister.InsertInfo;
import detailsregister.User_details;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	 public static  int hitCount;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
       
        // 
    }
    public void init() { 
        // Reset hit counter.
    	Dbconn.hitCount = 0;
     } 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        HttpSession session=request.getSession();  
        session.invalidate();  
        
        out.println("<script type=\"text/javascript\">");  
		out.println("alert('You are successfully logged out!');");  
		out.println("</script>");
        request.getRequestDispatcher("LoginPage.jsp").include(request, response);         
        out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		 HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		System.out.println("Login Servlet");
		String emailid=request.getParameter("email");
		String Password=request.getParameter("password");
		String roll=request.getParameter("roll");
		System.out.println("Email-ID=>"+emailid);
		System.out.println("Password=>"+Password+"\tRoll:"+roll);
		String msg;
		if(roll.equals("Patient"))
		{
			//User_details uid= new User_details();	
			session.setAttribute("pemailid",emailid);
			msg=InsertInfo.searchPatient(emailid, Password);
			session.setAttribute("pname",InsertInfo.pname);
		}
		else if(roll.equals("Admin"))
		{
			msg=InsertInfo.searchHospital(emailid, Password);
			System.out.println("Email-ID=>"+emailid);
			session.setAttribute("hospitalname",emailid);

		}
		else{
			session.setAttribute("Insuranceemailid",emailid);
			msg=InsertInfo.searchInsurance(emailid, Password);
			session.setAttribute("Insurancename",InsertInfo.Insurancename);
		}
	if(msg.equals("1"))
	{
		//PatientProfile
		pw.println("<script> alert('Login Successfully');</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/ProfileUpdate.jsp");
		rd.include(request, response); 
		
	}
	else if(msg.equals("2"))
	{
		//HospitalProfile
		pw.println("<script> alert('Login Successfully');</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/H_ShowPatient.jsp");
		rd.include(request, response); 
		
	}
	else if(msg.equals("3"))
	{
		//InsuranceProfile
		pw.println("<script> alert('Login Successfully');</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/InsuranceDetails.jsp");
		rd.include(request, response); 
	}
	else
	{
		pw.println("<script> alert('Login Fail Try Again');</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.jsp");
		rd.include(request, response); 
		
	}
	
	}

}
