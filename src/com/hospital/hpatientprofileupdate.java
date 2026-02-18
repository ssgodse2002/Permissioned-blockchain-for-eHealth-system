package com.hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Blockchain.ptop;

import com.algo.AESencrp;
import com.connection.Dbconn;

import Blockchain.Block;
import Blockchain.ChainConsensus;
/**
 * Servlet implementation class hpatientprofileupdate
 */
@WebServlet("/hpatientprofileupdate")
public class hpatientprofileupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String Insurance_Company;
	public static String Policy_Name;
	public static String Months;
	public static String Coverage_Msg;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public hpatientprofileupdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String txtfirstname = request.getParameter("txtfirstname");
		String txtmiddlename = request.getParameter("txtmiddlename"), txtlastname = request
				.getParameter("txtlastname");
		String txtdd = request.getParameter("txtdd");
		//String txtmm = request.getParameter("txtmm");
//		String txtyy = request.getParameter("txtyy");
		String bod =txtdd;
		System.out.println("Date=>"+bod);
		String first_disease = request.getParameter("txtsysbp"), second_disease = request
				.getParameter("txtdysbp"), threes_disease = request
				.getParameter("txtpp"), four_disease = request.getParameter("txtcho"), five_disease = request
				.getParameter("txtldl"), six_disease = request
				.getParameter("txthdl");
		Connection con;
		HttpSession session = request.getSession(true);
		String Hospitalemail = (String) session.getAttribute("hospitalname");
		// String email=(String)session.getAttribute("pemailid");
		
		int i = 0;
		try {
			if(first_disease.isEmpty()||first_disease.equals(null)||first_disease==null) 
			{
				first_disease="-";
			}
			 if(second_disease.isEmpty()||second_disease.equals(null)||second_disease==null)
			{
				 second_disease="-";
			}
			 if(threes_disease.isEmpty()||threes_disease.equals(null)||threes_disease==null)
			{
				 threes_disease="-";
			}
			 if(four_disease.isEmpty()||four_disease.equals(null)||four_disease==null)
			{
				 four_disease="-";
			}
			 if(five_disease.isEmpty()||five_disease.equals(null)||five_disease==null)
			{
				 five_disease="-";
			}
			 if(six_disease.isEmpty()||six_disease.equals(null)||six_disease==null)
			{
				 six_disease="-";
			}
			con = Dbconn.conn();

			String f1disease=AESencrp.encrypt(first_disease);
			String s2disease=AESencrp.encrypt(first_disease);
			String t3disease=AESencrp.encrypt(first_disease);
			String f4disease=AESencrp.encrypt(first_disease);
			String f5disease=AESencrp.encrypt(first_disease);
			String s6disease=AESencrp.encrypt(first_disease);
			String data = email + txtfirstname + txtmiddlename + txtlastname
					+ bod + f1disease + s2disease + t3disease + f4disease + f5disease
					+ s6disease;
			
			 ptop.ptopverify(4, data);
			System.out.println("Data");
			Statement st0 = con.createStatement();
			String query1 = "select * from tblinfoinsurance where PatientEmail='"
					+ email + "'";
			ResultSet rs1 = st0.executeQuery(query1);
			while (rs1.next()) {
				Insurance_Company = rs1.getString("Company_Name");
				Policy_Name = rs1.getString("Policy_Name");
				Months = rs1.getString("Policy_Tenue");
				Coverage_Msg = rs1.getString("Coverage_Info");
			}
			PreparedStatement p1;
			String sql = "insert into tblinfohospital(PatientEmail,Insurance_Company,Policy_Name,Months,Coverage_Msg,Hospital_Email_ID) values(?,?,?,?,?,?)";   
			p1 = (PreparedStatement) con.prepareStatement(sql);
			p1.setString(1, email);
			p1.setString(2, Insurance_Company);
			p1.setString(3, Policy_Name);
			p1.setString(4, Months);
			p1.setString(5, Coverage_Msg);
			p1.setString(6, Hospitalemail);
			p1.executeUpdate();
			String txtdate = request.getParameter("txtdate");
			String txttime = request.getParameter("txttime");
			String currenttime = txtdate + " " + txttime;
			PreparedStatement p2;
			String sq2 = "insert into tblblockchain(Hospital_Email_ID,BlocKData,Current_Times) values(?,?,?)";
			p2 = (PreparedStatement) con.prepareStatement(sq2);
			p2.setString(1, Hospitalemail);
			p2.setString(2,Block.hash);
			p2.setString(3, currenttime);
			p2.executeUpdate();

			
			
			
			PreparedStatement p20;
			String sq20 = "insert into tblmaster(Transcation_Hash,FromName,ToName,NonceData,PreViewHash,DiseaseFirst,DiseaseSecond,DiseaseThrees,DiseaseFour,DiseaseFive,DiseaseSix) values(?,?,?,?,?,?,?,?,?,?,?)";
			p20 = (PreparedStatement) con.prepareStatement(sq20);
			p20.setString(1, Block.hash);
			p20.setString(2, Hospitalemail);
			p20.setString(3, email);
			p20.setString(4, String.valueOf(Block.nonce));
			p20.setString(5, Block.previousHash);
//			p20.setString(6, first_disease);
//			p20.setString(7, second_disease);
//			p20.setString(8, threes_disease);
//			p20.setString(9, four_disease);
//			p20.setString(10, five_disease);
//			p20.setString(11, six_disease);
			p20.setString(6, f1disease);
			p20.setString(7, s2disease);
			p20.setString(8, t3disease);
			p20.setString(9, f4disease);
			p20.setString(10, f5disease);
			p20.setString(11, s6disease);
			p20.executeUpdate();

			// /

			PreparedStatement p120;
			String sq120 = "insert into tblmasterpatientnew(First_Name,Middle_Name,Last_Name,Birth_Of_Date,DiseaseFirst,DiseaseSecond,DiseaseThrees,DiseaseFour,DiseaseFive,DiseaseSix,Email_ID,DateShow) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			p120 = (PreparedStatement) con.prepareStatement(sq120);
			p120.setString(1, txtfirstname);
			p120.setString(2, txtmiddlename);
			p120.setString(3, txtlastname);
			p120.setString(4, bod);
			p120.setString(5, f1disease);
			p120.setString(6, s2disease);
			p120.setString(7, t3disease);
			p120.setString(8, f4disease);
			p120.setString(9, f5disease);
			p120.setString(10, s6disease);
			p120.setString(11, email);
			p120.setString(12, currenttime);
			p120.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		{
			pw.println("<script> alert('Update Profile Successfully');</script>");
			RequestDispatcher rd = request
					.getRequestDispatcher("/H_ShowPatient.jsp");
			rd.include(request, response);
		}
	}
}
