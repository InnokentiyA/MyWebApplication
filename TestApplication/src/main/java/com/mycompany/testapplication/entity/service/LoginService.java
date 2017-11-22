/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testapplication.entity.service;

import com.mycompany.testapplication.entity.User;
import com.mycompany.testapplication.entity.business.BusinessFacade;

/**
 *
 * @author user
 */
public class LoginService {

    public String doLogin(String username, String password) {
        System.out.println("LOGIN SERVICE!!!!! " + username + ", " + password);
        User user = BusinessFacade.getUser(username, password);
        if (user != null) {
            return "SUCCESS";
        } else {
            return "FAILURE";
        }
    }

}
