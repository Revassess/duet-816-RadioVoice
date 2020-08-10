package com.revature.config;

import javassist.bytecode.analysis.Type;
import org.postgresql.Driver;

import java.sql.*;

/**
 * 
 * @author Revature
 *
 *         This is a paceholder class to hold the configurations of your db
 *         connection. You should change the url, username, and password. DO NOT
 *         CHANGE THE MODIFIERS OR THE NAMES OF THE VARIABLES. These are used to
 *         test your db schema.
 */
public class ConnectionUtil {
	//for singleton instance
	private static ConnectionUtil cu;
	
	// add your jdbc url
	public static final String URL = "jdbc:postgresql://revassess-kessler.cfgzpq9si94d.us-east-1.rds.amazonaws.com:5432/postgres";
	// add your jdbc username
	public static final String USERNAME = "daniel_kessler";
	// add your jdbc password
	public static final String PASSWORD = "password";
	// name of the created stored procedure in tier 3
	public static final String TIER_3_PROCEDURE_NAME = "";
	// name of the created sequence in tier 3
	public static final String TIER_3_SEQUENCE_NAME = "weirdincrement";

	static {
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}

	// implement this method to connect to the db and return the connection object
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}


	//implement this method with a callable statement that calls the absolute value sql function
	public long callAbsoluteValueFunction(long value) throws SQLException {
		CallableStatement cstmt = null;
		Connection conn = null;
		long returnLong = 0;

		try {
			String SQL = "{?= call ABS(?)}";
			conn = connect();
			cstmt = conn.prepareCall (SQL);

			cstmt.setLong(2, value);
			cstmt.registerOutParameter(1, Types.BIGINT);
			cstmt.execute();
			returnLong = cstmt.getLong(1);
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			cstmt.close();
		}

		return returnLong;
	}

	

	//make the class into a singleton
	private ConnectionUtil(){
		super();
	}

	public static ConnectionUtil getInstance(){
		if(cu == null){
			cu = new ConnectionUtil();
		}
		return cu;
	}
}
