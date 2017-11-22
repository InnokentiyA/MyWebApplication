package com.mycompany.testapplication.entity;
import java.sql.*;
public class RegisterModel {
    private String username;
    private String email;
    private String password;
    public RegisterModel(String username,String email,String password)
    {
        this.username=username;
        this.email=email;
        this.password=password;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }  
    public boolean addData()
    {
        boolean result = false;
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:/ /127.0.0.1:3306/sportclub", "username", "password");
            PreparedStatement pstmt=con.prepareStatement("insert into user values(?,?,?)");
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeQuery();
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println(ex.toString());
        }             
        return result;      
    }          
}