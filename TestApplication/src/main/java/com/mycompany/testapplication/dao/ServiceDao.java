package com.mycompany.testapplication.dao;

import com.mycompany.testapplication.entity.Abonement;
import com.mycompany.testapplication.entity.AbonementType;
import com.mycompany.testapplication.entity.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ServiceDao {

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

    public List<Service> getAllServices() throws SQLException {
        List<Service> result = new ArrayList();
        String sql = "SELECT * FROM service ";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        Abonement abonement = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double priceSingle = rs.getDouble("priceSingle");
            double priceMonth = rs.getDouble("priceMonth");
            double priceGold = rs.getDouble("priceGold");
            Service service = new Service(id, name, priceSingle, priceMonth, priceGold);
            result.add(service);
        }

        statement.close();
        disconnect();

        return result;

    }

    public void addService(int selectedServiceId, int abonId) throws SQLException {

        String sql = "INSERT INTO `order` (`id_service`, `id_abon`) VALUES (?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        statement.setInt(1, selectedServiceId);
        statement.setInt(2, abonId);
        statement.executeUpdate();
        statement.close();

        disconnect();

    }
}
