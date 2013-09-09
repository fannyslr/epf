package com.formation.jee.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formation.jee.dao.UserDao;
import com.formation.jee.domain.User;

public class UserDaoImpl implements UserDao {
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test-epf";
	private static final String USER = "admin";
	private static final String PASS = "admin";
	private Connection conn = null;
	private Statement stmt = null;

	public UserDaoImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Couldn't load jdbc Driver:" + e.getMessage());
		}
	}

	@Override
	public List<User> getUsers() {
		
		List<User> users = new ArrayList<User>();			
		
		try {
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, login, password FROM user";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				User user = new User.Builder()
									.id(rs.getInt("id"))
									.login(rs.getString("login"))
									.password(rs.getString("password"))
									.build();
				users.add(user);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
		} catch (SQLException se) {
			System.err.println("Error in SQL query:" + se.getMessage());
		} finally {			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return users;
	}
}
