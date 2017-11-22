/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testapplication.entity.controller;

import com.mycompany.testapplication.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
//        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        User user = new User(24, "Inna", "innatihun1@rambler.ru", "0680889942", "kalinchuk", new Date(2017, 11, 15));
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!servlet!");
//        HttpSession session = request.getSession();
//        
//        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);

        
        

//      out.println
//          (", Employee number:" + request.getAttribute("empid") + "</B>");
        this.getServletContext().getRequestDispatcher("/cabinet.jsp").
                include(request, response);

    }

}
