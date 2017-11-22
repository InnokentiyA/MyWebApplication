package com.mycompany.testapplication.dao;

import com.mycompany.testapplication.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private String jdbcURL = "jdbc:mysql://localhost:3305/project?zeroDateTimeBehavior=convertToNull";
    private String jdbcUsername = "inna";
    private String jdbcPassword = "kalinchuk";
    private Connection jdbcConnection;

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertUser(String username, String email, String password) throws SQLException {
        String sql = "INSERT INTO user (username, email, password) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, email);
        statement.setString(3, password);

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public User getUser(String usernameOrEmail, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE password = ? AND  (username = '1' OR email = 'hkhjk')";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, password.trim());
 //       statement.setString(2, usernameOrEmail);
//        statement.setString(3, usernameOrEmail);

        System.out.println("!+++!!=========================================!!!");
        System.out.println(statement);
        System.out.println("=========================================");
        ResultSet rs = statement.executeQuery(sql);
        
//        System.out.println("!!!!!!!!!!!!!!!!111  ROW COUNT IS " + rowcount);
        User user = null;
        if (true) {
            rs.next();
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            Date birthday = rs.getDate("birthday");
            Date regDate = rs.getDate("date_reg");

            user = new User(id, username, email, phone, password, regDate);
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
//        user = new User(0, "dfdf", "fff", "dddd", "dfdf", new Date(2017,9,9));
        statement.close();
        disconnect();

        return user;
    }

}
