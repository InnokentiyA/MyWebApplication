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
import java.sql.Statement;
import java.util.Arrays;

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

    public double getAbonementPrice(AbonementType abonementType, String[] selectedServiceIds) throws SQLException {

//        String str = Arrays.toString(selectedServiceIds);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < selectedServiceIds.length; i++) {
            sb.append(selectedServiceIds[i]);
            if (i < selectedServiceIds.length - 1) {
                sb.append(',');
            }
        }
        String str = sb.toString();
        System.out.println("STR IS " + str);
        String sql = null;

        if (abonementType == AbonementType.SINGLE) {
            sql = "SELECT SUM(priceSingle) FROM service WHERE id IN (" + str + ");";
        }
        if (abonementType == AbonementType.MONTHLY) {
            sql = "SELECT SUM(priceMonth) FROM service WHERE id IN (" + str + ");";
        } else if (abonementType == AbonementType.GOLD) {
            sql = "SELECT SUM(priceGold) FROM service WHERE id IN (" + str + ");";
        }

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setString(1, str);
        System.out.println("Statement is ");

        ResultSet result = statement.executeQuery();
        String resultAsString = null;
        while (result.next()) {
            resultAsString = result.getString(1);
        }
        return Double.parseDouble(resultAsString);
    }

    public int createAbonement(AbonementType abonementType, String[] selectedServiceIds, Date dateEnd, Date dateStart, double price, int userId) throws SQLException {

        String sql = "INSERT INTO abonement (`type`, `price`, `end`, `start`, `id_user`) VALUES (?, ?, ?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, abonementType.getCode());
        statement.setDouble(2, price);
        statement.setDate(3, dateEnd);
        statement.setDate(4, dateStart);
        statement.setInt(5, userId);

        statement.executeUpdate();
        int abonId = 0;
        boolean returnLastInsertId = true;
        if (returnLastInsertId) {
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            abonId = rs.getInt(1);
        }


        System.out.println("Abonement ID is: " + abonId);
        statement.close();
        disconnect();
        return abonId;
    }
}
