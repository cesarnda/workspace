package com.nevermind.jse7.jdbc;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class JDBC {

	public static void main(String[] args) {
		fetchData();
		//fetchWebRowSetData();
		//fetchJoinRowSetData();
		fetchFilterRowSetData();
	}
	
	public static void fetchData(){
		Properties properties = new Properties();
		properties.put("user", "cesarnda");
		properties.put("password", "123456");
		String protocol = "jdbc:mysql://";
		String url = "localhost:8889/javase7";
		String statement = "select * from users";
		try(Connection conn = DriverManager.getConnection(protocol + url, properties) ){
			Statement stmt = conn.createStatement();
			stmt.execute(statement);
			ResultSet resultSet = stmt.getResultSet();
			while(resultSet.next()){
				String email = resultSet.getString("email");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				System.out.println(email + " - " + firstName + " " + lastName);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void fetchWebRowSetData(){
		String user = "cesarnda";
		String password = "123456";
				
		Properties properties = new Properties();
		properties.put("user", user);
		properties.put("password", password);
		String protocol = "jdbc:mysql://";
		String url = "localhost:8889/javase7";
		String statement = "select * from users";
		try{
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			WebRowSet webRowSet = rowSetFactory.createWebRowSet();
			webRowSet.setUsername(user);
			webRowSet.setPassword(password);
			webRowSet.setUrl(protocol + url);
			webRowSet.setCommand(statement);
			
			webRowSet.execute();
			StringWriter stringWriter = new StringWriter();
			
			webRowSet.writeXml(stringWriter);
			System.out.println("In XML:");
			System.out.println(stringWriter.toString());
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void fetchJoinRowSetData(){
		String user = "cesarnda";
		String password = "123456";
				
		Properties properties = new Properties();
		properties.put("user", user);
		properties.put("password", password);
		String protocol = "jdbc:mysql://";
		String url = "localhost:8889/javase7";
		String statement = "select * from users";
		String statementAddress = "SELECT * FROM ADDRESS";
		try{
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			WebRowSet webRowSet_01 = rowSetFactory.createWebRowSet();
			webRowSet_01.setUsername(user);
			webRowSet_01.setPassword(password);
			webRowSet_01.setUrl(protocol + url);
			webRowSet_01.setCommand(statement);
			
			webRowSet_01.execute();
			
			WebRowSet webRowSet_02 = rowSetFactory.createWebRowSet();
			webRowSet_02.setUsername(user);
			webRowSet_02.setPassword(password);
			webRowSet_02.setUrl(protocol + url);
			webRowSet_02.setCommand(statementAddress);
			
			webRowSet_02.execute();
			
			JoinRowSet joinRowSet = rowSetFactory.createJoinRowSet();
			joinRowSet.addRowSet(webRowSet_01, "email");
			joinRowSet.addRowSet(webRowSet_02, "user_id");
			
			
			StringWriter stringWriter = new StringWriter();
			
			joinRowSet.writeXml(stringWriter);
			System.out.println("In XML:");
			System.out.println(stringWriter.toString());
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	
	public static void fetchFilterRowSetData(){
		String user = "cesarnda";
		String password = "123456";
				
		Properties properties = new Properties();
		properties.put("user", user);
		properties.put("password", password);
		String protocol = "jdbc:mysql://";
		String url = "localhost:8889/javase7";
		String statement = "select * from users";
		try{
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			FilteredRowSet filterRowSet = rowSetFactory.createFilteredRowSet();
			filterRowSet.setUsername(user);
			filterRowSet.setPassword(password);
			filterRowSet.setUrl(protocol + url);
			filterRowSet.setCommand(statement);
			
			filterRowSet.execute();
			filterRowSet.setFilter(new FilterByName());
			StringWriter stringWriter = new StringWriter();
			
			
			filterRowSet.writeXml(stringWriter);
			System.out.println("In XML:");
			System.out.println(stringWriter.toString());
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
