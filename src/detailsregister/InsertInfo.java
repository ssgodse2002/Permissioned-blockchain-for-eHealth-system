package detailsregister;

import java.sql.*;


import com.connection.Dbconn;

public class InsertInfo {
 public static int i=0;
 public static Connection con;
 public static PreparedStatement p,p1;
public static User_details uid= new User_details();
public static String pname,Insurancename;
	public static int insertPatient(User_details fd,String hospital_name)
	{
		try {
			con = Dbconn.conn();
		
		String sql="insert into tblregister(Name,Email_IDs,Mobile_No,Passwords,Address,Gender,Hospital_Name) values(?,?,?,?,?,?,?)";																													
		p1=(PreparedStatement) con.prepareStatement(sql);
		p1.setString(1,fd.getUsername());
		p1.setString(2, fd.getemail());
		p1.setString(3, fd.mobileno);
		p1.setString(4, fd.getpwd());
		p1.setString(5, fd.getMonbileNo());
		p1.setString(6,fd.getgender());
		p1.setString(7,hospital_name);
		i=p1.executeUpdate();
		PreparedStatement p2;
		String msg="0";
		String sql1="insert into tblmasterpatient(First_Name,Middle_Name,Last_Name,Birth_Of_Date,Email_ID) values(?,?,?,?,?)";
		p2=(PreparedStatement) con.prepareStatement(sql1);
		p2.setString(1,msg);
		p2.setString(2,msg);
		p2.setString(3,msg);
		p2.setString(4,msg);
		p2.setString(5,fd.getemail());
		i=p2.executeUpdate();
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	public static int inserthospital(User_details fd)
	{
		try {
			con = Dbconn.conn();
		
		String sql="insert into tblhospital(Name,Email_IDs,Mobile_No,Passwords,Address) values(?,?,?,?,?)";
		p=(PreparedStatement) con.prepareStatement(sql);
		p.setString(1,fd.getUsername());
		p.setString(2, fd.getemail());
		p.setString(3, fd.mobileno);
		p.setString(4, fd.getpwd());
		p.setString(5, fd.getAddr());
		
		i=p.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	public static int insertInsurance(User_details fd)
	{
		try {
			con = Dbconn.conn();
		
		String sql="insert into tblinsurance(Name,Email_IDs,Mobile_No,Passwords,Address,Gender) values(?,?,?,?,?,?)";
		p=(PreparedStatement) con.prepareStatement(sql);
		p.setString(1,fd.getUsername());
		p.setString(2, fd.getemail());
		p.setString(3, fd.mobileno);
		p.setString(4, fd.getpwd());
		p.setString(5, fd.getAddr());
		p.setString(6,fd.getgender());
		i=p.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	
	public static String searchPatient(String Email,String pwd)
	{
		String msg = null;
		try 
		{
					
			
			con=Dbconn.conn();
			String qury="select * from tblregister where Email_IDs='"+Email+"' and Passwords='"+pwd+"'";
			 Statement stm=con.createStatement();
	           ResultSet rs=stm.executeQuery(qury);
			
			if(rs.next())
			{
				msg="1";
				System.out.println("UserName=>"+Email);
				uid.setUsername(rs.getString("Name"));
				pname=rs.getString("Name");
				uid.setemail(Email);
		}
			else {
				msg="0";
				//msg="Login Fail Try Again";
				
			}	           
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return msg;
		
	}
	public static String searchInsurance(String Email,String pwd)
	{
		String msg = null;
		try 
		{
			con=Dbconn.conn();
			String qury="select * from tblinsurance where Email_IDs='"+Email+"' and Passwords='"+pwd+"'";
			 Statement stm=con.createStatement();
	           ResultSet rs=stm.executeQuery(qury);
	          
			if(rs.next())
			{
				msg="3";
				uid.setUsername(rs.getString("Name"));
				uid.setemail(Email);
				Insurancename=rs.getString("Name");
		}
			else {
				msg="0";
				//msg="Login Fail Try Again";
				
			}	           
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return msg;
		
	}
	public static String searchHospital(String Email,String pwd)
	{
		String msg = null;
		try 
		{
			con=Dbconn.conn();
			String qury="select * from tblhospital where Email_IDs='"+Email+"' and Passwords='"+pwd+"'";
			 Statement stm=con.createStatement();
	           ResultSet rs=stm.executeQuery(qury);
			
			if(rs.next())
			{
				msg="2";
				uid.setUsername(rs.getString("Name"));
				uid.setemail(Email);
		}
			else {
				msg="0";
				//msg="Login Fail Try Again";
				
			}	           
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return msg;
		
	}
	
	
	
	
	
	
}
