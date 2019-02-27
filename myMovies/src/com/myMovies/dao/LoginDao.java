package com.myMovies.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.myMovies.connection.DbConnection;
import com.myMovies.pojo.LoginDetailsPojo;
public class LoginDao {
	public int newUser(LoginDetailsPojo login) throws SQLException {
		System.out.println(login.getUserName()+" "+login.getPassword());
		String query="insert into Login values(?,?)";
		Connection conn =DbConnection.getConnection();
		PreparedStatement ps= conn.prepareStatement(query);
		ps.setString(1, login.getUserName());
		ps.setString(2, login.getPassword());
	  int l= ps.executeUpdate();
		return l;
	}
	public boolean isUser(LoginDetailsPojo login) throws SQLException {
		
			Connection conn = DbConnection.getConnection();
				String query="select * from Login where username=? password=?";
				PreparedStatement ps= conn.prepareStatement(query);
  		        ps.setString(1, login.getUserName());
		         ps.setString(2, login.getPassword());
	            ResultSet results = ps.executeQuery(query);
	            while (results.next()) {
	               return true;
	               }
				return false;
	}
//	public static void main(String[] args) throws SQLException {
//		System.out.println(new LoginDao().isUser(new LoginDetailsPojo("mirza","okey")));
//	}
}
