/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testapplication.entity.controller;

import com.mycompany.testapplication.entity.AbonementType;
import com.mycompany.testapplication.entity.Service;
import com.mycompany.testapplication.entity.User;
import com.mycompany.testapplication.entity.business.BusinessFacade;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "OrderCardServlet", urlPatterns = {"/OrderCardServlet"})
public class OrderCardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get abonement type
        String abonementTypeAsString = req.getParameter("abonementType");
        AbonementType abonementType;
        switch (abonementTypeAsString) {
            case "gold":
                abonementType = AbonementType.GOLD;
                break;
            case "monthly":
                abonementType = AbonementType.MONTHLY;
                break;
            case "single":
                abonementType = AbonementType.SINGLE;
                break;

            default:
                abonementType = AbonementType.SINGLE;
        }
        // get services ids
        String[] selectedServiceIds = req.getParameterValues("services");
        // get start date
        Date dateStart = new Date(System.currentTimeMillis());
        // get end date
        Date dateEnd = null;
        if (abonementTypeAsString.equalsIgnoreCase("gold")) {
            dateEnd = new Date(dateStart.getYear() + 1, dateStart.getMonth(), dateStart.getDay());
        } 
        if (abonementTypeAsString.equalsIgnoreCase("monthly")) {
            dateEnd = new Date(dateStart.getYear(), dateStart.getMonth() + 1, dateStart.getDay());
        }
        else if (abonementTypeAsString.equalsIgnoreCase("single")) {
            dateEnd = dateStart;
        }
        
        double price = 0;
        try {
            price = BusinessFacade.getAbonementPrice(abonementType, selectedServiceIds);
            System.out.println("PRICE is " + price);
        } catch (SQLException ex) {
            Logger.getLogger(OrderCardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("USER IN CABINET " + user);
        int userId = user.getId();

        try {
            BusinessFacade.createAbonement(abonementType, selectedServiceIds, dateStart, dateEnd, price, userId);
        } catch (SQLException ex) {
            Logger.getLogger(OrderCardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        String nextJSP = "/cabinet.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
        System.out.println("ALL IS OK AFTER INDEX JSP");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Service> services;
        try {
            services = BusinessFacade.getAllServices();
            request.setAttribute("services", services);
            System.out.println("We have " + services.size() + " services");
        } catch (SQLException ex) {
            System.out.println("DATABASE ERROR!!");
            Logger.getLogger(OrderCardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/orderCard.jsp");
        dispatcher.forward(request, response);
        System.out.println("servlet____________________________________________________________");

        this.getServletContext().getRequestDispatcher("/orderCard.jsp").
                include(request, response);

    }

}
