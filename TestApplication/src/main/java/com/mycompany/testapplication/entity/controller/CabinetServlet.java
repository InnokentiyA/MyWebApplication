/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testapplication.entity.controller;

import com.mycompany.testapplication.entity.User;
import com.mycompany.testapplication.entity.business.BusinessFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class CabinetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newSurname = req.getParameter("surname");
        String newName = req.getParameter("name");
        String newEmail = req.getParameter("email");
        String newPhone = req.getParameter("phone");

        System.out.println("DO POST IN CABINET!!");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String nextJSP;
        if (user == null) {
            nextJSP = "/index.jsp";
        } else {
            System.out.println("USER INSIDE DO POST: " + user);
            System.out.println("NEW SURNAME " + req.getParameter("surname"));
            System.out.println("NEW NAME " + req.getParameter("name"));
            System.out.println("NEW EMAIL " + req.getParameter("email"));
            System.out.println("NEW PHONE " + req.getParameter("phone"));

            if (!newEmail.equals(user.getEmail()) || !newPhone.equals(user.getPhone()) || !newSurname.equals(user.getSurname()) || !newName.equals(user.getName())) {
                try {
                    if (BusinessFacade.updateUser(user.getId(), user.getUsername(), newEmail, newPhone, newSurname, newName, user.getPassword())) {
                        user.setName(newName);
                        user.setSurname(newSurname);
                        user.setEmail(newEmail);
                        user.setPhone(newPhone);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CabinetServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            nextJSP = "/cabinet.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String nextJSP;
        System.out.println(" =================================== ");
        if (user == null) {
            nextJSP = "/index.jsp";
        } else {
            nextJSP = "/cabinet.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

//        HttpSession session = request.getSession();
//        
//        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);

//      out.println
//          (", Employee number:" + request.getAttribute("empid") + "</B>");
        this.getServletContext().getRequestDispatcher("/cabinet.jsp").
                forward(request, response);

    }

}
