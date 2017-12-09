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
                System.out.println("Error during connection!!!");
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
        String sql = "INSERT INTO user (`username`, `email`, `password`) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, username.trim());
        statement.setString(2, email.trim());
        statement.setString(3, password.trim());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public User getUser(String usernameOrEmail, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE password = ? AND  (username = ? OR email = ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, password.trim());
        statement.setString(2, usernameOrEmail.trim());
        statement.setString(3, usernameOrEmail.trim());

        System.out.println("!+++!!=========================================!!!!");
        System.out.println(statement);
        System.out.println("=========================================");
        ResultSet rs = statement.executeQuery();

//        System.out.println("!!!!!!!!!!!!!!!!111  ROW COUNT IS " + rowcount);
        User user = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            Date birthday = rs.getDate("birthday");
            Date regDate = rs.getDate("date_reg");
            int abonementId = rs.getInt("id_abon");

            user = new User(id, name, surname, username, email, phone, password, regDate, abonementId);
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            break;
        }
        if (user == null){
            System.out.println("No user//////////");
        }
//        user = new User(0, "dfdf", "fff", "dddd", "dfdf", new Date(2017,9,9));
        statement.close();
        disconnect();

        return user;
    }

    public boolean updateUser(int id, String username, String email,String phone,String surname,String name, String password) throws SQLException {
       String sql = "UPDATE user SET email = ?, phone = ?, surname = ?, name = ? WHERE id = ?" ;
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, email.trim());
        statement.setString(2, phone.trim());
        statement.setString(3, surname.trim());
        statement.setString(4, name.trim());
        statement.setInt(5, id);

        System.out.println("!+++!!=========================================!!!!");
        System.out.println(statement);
        System.out.println("=========================================");
        int result = statement.executeUpdate();

        statement.close();
        disconnect();
        return (result == 1);
    }

}
