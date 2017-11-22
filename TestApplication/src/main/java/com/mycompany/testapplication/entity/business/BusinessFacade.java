package com.mycompany.testapplication.entity.business;

import com.mycompany.testapplication.dao.UserDao;
import com.mycompany.testapplication.entity.Service;
import com.mycompany.testapplication.entity.Sex;
import com.mycompany.testapplication.entity.User;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusinessFacade {

    public static Map<Service, Integer> getOrderedServices(Date start, Date end) {
        Map<Service, Integer> result = new HashMap<>();
        List<Service> allServices = getAllServices();
        for (Service service : allServices) {
            int randomNum = ThreadLocalRandom.current().nextInt(200, 500 + 1);
            result.put(service, randomNum);
        }
        return result;
    }

    public static List<Service> getAllServices() {
        Service service1 = new Service(1, "Pool", 45.5);
        Service service2 = new Service(2, "Fitness", 30);
        Service service3 = new Service(3, "Sauna", 60);
        List<Service> allServices = new ArrayList();
        allServices.add(service1);
        allServices.add(service2);
        allServices.add(service3);
        return allServices;
    }

    public static User getUser(String usernameOrEmail, String password) {
        UserDao userDao = new UserDao();
        try {
            return userDao.getUser(usernameOrEmail, password);
        } catch (SQLException ex) {

            Logger.getLogger(BusinessFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean registerUser(String username, String email, String password) throws SQLException {
        UserDao userDao = new UserDao();
        return userDao.insertUser(username, email, password);
    }
}
