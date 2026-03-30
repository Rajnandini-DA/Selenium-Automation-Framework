package com.comcost.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/*
 * DatabaseUtility class:
 * Provides reusable methods to connect, execute queries, and close database connections.
 */

public class DatabaseUtility {

	Connection con = null;

	
	/*
     * Establishes connection to the database using provided URL, username, and password.
     */
	public void getDbConnection(String url, String username, String password) {

		try {

			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getDbConnection() {

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/projects", "root@%", "root");

		} catch (Exception e) {
		}
	}

	/*
     * Closes the active database connection.
     */
	public void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
		}

	}

	
	 /*
     * Executes a SELECT query and returns the ResultSet.
     */
	public ResultSet executeConSelectQuery(String query) {

		ResultSet result = null;
		try {

			Statement stat = con.createStatement();
			result = stat.executeQuery(query);

		} catch (Exception e) {
		}

		return result;

	}

	
	 /*
     * Executes an UPDATE/INSERT/DELETE query and returns number of rows affected.
     */
	public int executeNonSelectQuery(String query) {

		int result = 0;
		try {

			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);

		} catch (Exception e) {
		}

		return result;

	}

}
