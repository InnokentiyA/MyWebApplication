package com.mycompany.testapplication.entity.controller;

import com.mycompany.testapplication.entity.Abonement;
import com.mycompany.testapplication.entity.User;
import com.mycompany.testapplication.entity.business.BusinessFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CurrentCardServlet", urlPatterns = {"/CurrentCardServlet"})

public class CurrentCardServlet extends HttpServlet {

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

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int abonementId = user.getAbonementId();
        
        if (abonementId > 0) {
            try {

                Abonement abonement = BusinessFacade.getAbonement(abonementId);
                request.setAttribute("abonement", abonement);

            } catch (SQLException ex) {
                Logger.getLogger(CurrentCardServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/currentCard.jsp");
        dispatcher.forward(request, response);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!servlet!");
        

        this.getServletContext().getRequestDispatcher("/currentCard.jsp").
                forward(request, response);

    }

}
