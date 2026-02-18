package com.patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.AESencrp;
import com.connection.Dbconn;

/**
 * Servlet implementation class patientprofile
 */
@WebServlet("/patientprofile")
public class patientprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public patientprofile() {
        super();
        // 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		String txtfirstname=request.getParameter("txtfirstname");
		String txtmiddlename=request.getParameter("txtmiddlename"),
				txtlastname=request.getParameter("txtlastname");
		String txtdd=request.getParameter("txtdd"),
				txtmm=request.getParameter("txtmm"),
				txtyy=request.getParameter("txtyy"),bod=txtyy+"/"+txtmm+"/"+txtdd;

		Connection con;
		HttpSession session= request.getSession(true);
		//String email=(String)session.getAttribute("pemailid");
	int i=0;
try {
	con = Dbconn.conn();

		String fname=AESencrp.encrypt(txtfirstname);
		String Mname=AESencrp.encrypt(txtfirstname);
		String Lname=AESencrp.encrypt(txtfirstname);
		String sql1="update tblmasterpatient set First_Name='"+fname+"',Middle_Name='"+Mname+"',Last_Name='"+Lname+"',Birth_Of_Date='"+bod+"' where Email_ID='"+email+"'";
		Statement st=con.createStatement();
		st.executeUpdate(sql1);
} catch (ClassNotFoundException e) {
	// 
	e.printStackTrace();
} catch (SQLException e) {
	// 
	e.printStackTrace();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

{
pw.println("<script> alert('Update Profile Successfully');</script>");
RequestDispatcher rd = request.getRequestDispatcher("/PatientProfile.jsp");
rd.include(request, response); 
}

}

}
