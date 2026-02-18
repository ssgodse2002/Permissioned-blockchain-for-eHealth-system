package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dbconn {
	public static ArrayList<String> ResList = new ArrayList<String>();
	public static ArrayList<String> filetitle = new ArrayList<String>();
	public static ArrayList<String> offline2list = new ArrayList<String>();
	public static int hitCount;
	public static String data = "";
	public static int blockchain1msg=0,blockchain2msg=0,blockchain3msg=0,blockchain4msg=0;
	public static String cid=null,c_Name=null,cp_Name=null,eid=null,CVoter=null,BlockData=null;
	public static String PrevHash1=null,PrevHash2=null,PrevHash3="0",PrevHash4=null;

	
	public Dbconn() throws SQLException {
		super();
	}

	public static Connection conn() throws SQLException, ClassNotFoundException {
		Connection con;

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost/23and24_e_health", "root",
				"admin");
		return (con);
	}

	
}
