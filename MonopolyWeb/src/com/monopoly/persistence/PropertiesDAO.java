package com.monopoly.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PropertiesDAO implements Properties {

	private Connection dbConnection = null;
    private String url = "jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com/MonopolyGameDB";
    private String sqlProperties = "SELECT NAME FROM PROPERTIES";
    private String sqlPropertyByPos = "SELECT NAME FROM PROPERTIES WHERE POSITION = ?";
	private Statement stmt;
	private PreparedStatement pstmt;

	static {
		try { 
	        Class.forName("com.mysql.jdbc.Driver"); 
	    }
	    catch(Exception x){ 
	        System.out.println( "Unable to load the driver class!" );
	    }
	}

	public PropertiesDAO() {

	    try{ 
	        dbConnection = DriverManager.getConnection(url,"improving","Improving");
	        stmt = dbConnection.createStatement();
	    }
	    catch( SQLException x ){
	        System.out.println( "Couldn't get connection!" );
	        x.printStackTrace();
	    }
	}

	/* (non-Javadoc)
	 * @see com.monopoly.persistence.Properties#getPropertyNameByPosition(int)
	 */
	@Override
	public String getPropertyNameByPosition(int position) {
		String name = null;

	    try{ 

	        pstmt = dbConnection.prepareStatement(sqlPropertyByPos);
	        pstmt.setInt(1, position);

	        ResultSet rs = pstmt.executeQuery();  
	        rs.next();
	        name = rs.getString("NAME");
	    }
	    catch( SQLException x ){
	        System.out.println( "Failed to execute Statement!" + position );
	        x.printStackTrace();
	    }
		return name;
	}


	/* (non-Javadoc)
	 * @see com.monopoly.persistence.Properties#selectAllPropertyNames(int)
	 */
	@Override
	public String selectAllPropertyNames(int position) {
		String name = null;
	    try{ 
	        ResultSet rs = stmt.executeQuery(sqlProperties);  

	        while (rs.next()) {
	            name = rs.getString("NAME");
	            System.out.println("Name: " + name);
	        }  
	    }
	    catch( SQLException x ){
	        System.out.println( "Failed to execute Statement!" );
	        x.printStackTrace();
	    }
		return name;
	}
}
