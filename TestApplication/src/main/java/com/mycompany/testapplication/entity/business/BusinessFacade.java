package com.mycompany.testapplication.entity.business;

import com.mycompany.testapplication.dao.AbonementDao;
import com.mycompany.testapplication.dao.ServiceDao;
import com.mycompany.testapplication.dao.UserDao;
import com.mycompany.testapplication.entity.Abonement;
import com.mycompany.testapplication.entity.AbonementType;
import com.mycompany.testapplication.entity.Service;
import com.mycompany.testapplication.entity.User;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusinessFacade {

//    public static Map<Service, Integer> getOrderedServices(Date start, Date end) throws SQLException {
//        Map<Service, Integer> result = new HashMap<>();
//        List<Service> allServices = getAllServices();
//        for (Service service : allServices) {
//            int randomNum = ThreadLocalRandom.current().nextInt(200, 500 + 1);
//            result.put(service, randomNum);
//        }
//        return result;
//    }

    public static List<Service> getAllServices() throws SQLException {
        ServiceDao serviceDao = new ServiceDao();
        List<Service> services = serviceDao.getAllServices();
        return services;
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

    public static boolean updateUser(int id, String username, String email, String phone, String surname, String name, String password) throws SQLException {
        UserDao userDao = new UserDao();
        return userDao.updateUser(id, username, email, phone, surname, name, password);
    }

    public static Abonement getAbonement(int abonementId) throws SQLException {
        AbonementDao abonementDao = new AbonementDao();
        return abonementDao.getAbonement(abonementId);
    }

    public static double getAbonementPrice(AbonementType abonementType, String[] selectedServiceIds) throws SQLException {
        AbonementDao abonementDao = new AbonementDao();
        return abonementDao.getAbonementPrice(abonementType, selectedServiceIds);
    }

    public static void createAbonement(AbonementType abonementType, String[] selectedServiceIds, Date dateStart, Date dateEnd, double price, int userId) throws SQLException {
        AbonementDao abonementDao = new AbonementDao();
        int abonId = abonementDao.createAbonement(abonementType, selectedServiceIds, dateEnd, dateStart, price, userId);
        for (String selectedServiceId : selectedServiceIds) {
            ServiceDao serviceDao = new ServiceDao();
            serviceDao.addService(Integer.parseInt(selectedServiceId), abonId);
        }
    }
}
