/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testapplication.dao;

import com.mycompany.testapplication.entity.Abonement;
import com.mycompany.testapplication.entity.AbonementType;
import com.mycompany.testapplication.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class AbonementDao {

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

    public Abonement getAbonement(int id) throws SQLException {
        String sql = "SELECT * FROM abonement WHERE id = ? ";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        Abonement abonement = null;
        while (rs.next()) {

            String abonType = rs.getString("type");
            AbonementType type;
            switch (abonType) {
                case "Gold":
                    type = AbonementType.GOLD;
                    break;
                case "Monthly":
                    type = AbonementType.MONTHLY;
                    break;
                case "Single":
                    type = AbonementType.SINGLE;
                    break;

                default:
                    type = AbonementType.SINGLE;
            }

            double price = rs.getDouble("price");
            Date start = rs.getDate("start");
            Date ent = rs.getDate("end");
            // TODO get all services from ServiceDao
            abonement = new Abonement(id, type, price, start, ent);
            break;
        }

        statement.close();
        disconnect();

        return abonement;
    }
}
