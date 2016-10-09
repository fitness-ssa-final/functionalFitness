package com.dao;
import java.sql.*;
import java.util.ArrayList;

import com.User;

public class DAO {
    
    static final String JDBC_DRIVER = "";
    static final String DB_URL = "";
    static final String USER = "root";
    static final String PASSWORD = "";
    
    static Connection CONN = null;
    static Statement STMT = null;
    static PreparedStatement PREP_STMT = null;
    static ResultSet RES_SET = null;
    
    public static final ArrayList<User> myUsers = new ArrayList<>();
    
    public static void connToDB(){
        
        try {
            
            Class.forName(JDBC_DRIVER);
            
            System.out.println("Trying to connect to the DB...");
            CONN= DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to DB.");
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }
    
    public static void readFromDB(){
        
        connToDB();
        
        try {
            STMT = CONN.createStatement();
            RES_SET = STMT.executeQuery("SELECT * ;");
                                                //^insert database name here
        while (RES_SET.next()) {
            
            User userInDB = new User();
            
            userInDB.setPlayerID(RES_SET.getString("user_id"));
            userInDB.setLastName(RES_SET.getString("last_name"));
            userInDB.setFirstName(RES_SET.getString("first_name"));
            //insert whatever DB fields we have
            
            myUsers.add(userInDB);
        }
        
        for (User user : myUsers){
            System.out.println(user);
        }
        
        } catch (SQLException e){
            e.printStackTrace();
        }
    
    }
    
    public static void writeToDB(User user){
        
                
        try{
            
            connToDB();
            
            PREP_STMT = CONN.prepareStatement(insertIntoTable);
            
            PREP_STMT.setString(1, user.getLastName());
            PREP_STMT.setString(2, user.getFirstName());
        
            PREP_STMT.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    private static String insertIntoTable = "INSERT INTO "
                                                        //^insert database info
            + "(last_name, first_name...etc,etc,etc)"
            + " VALUES "
            + "(?, ?, ?, ?)";
}