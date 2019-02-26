package com.myMovies.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.myMovies.connection.DbConnection;
import com.myMovies.pojo.LoginDetailsPojo;
public class Login {
	public int insert(LoginDetailsPojo login) throws SQLException {
		String query="insert into Login values(?,?)";
		Connection conn =DbConnection.getConnection();
		PreparedStatement pStatement= conn.prepareStatement(query);
		pStatement.setString(1, login.getUserName());
		pStatement.setString(2, login.getPassword());
		int output=pStatement.executeUpdate();
		return output;
	}
	public LoginDetailsPojo read() throws SQLException {
		String query="select * from Login";
		LoginDetailsPojo login=null;
		Connection conn = DbConnection.getConnection();
		PreparedStatement pStatement= conn.prepareStatement(query);
		ResultSet resultSet=pStatement.executeQuery();
		while(resultSet.next()) {
			login=new LoginDetailsPojo();
			login.setUserName(resultSet.getString("userName"));
			login.setPassword(resultSet.getString("password"));
		}
		return login;
	}

	}
