/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testapplication.entity;

/**
 *
 * @author user
 */
public enum AbonementType {
    //ENUM('Gold', 'Monthly', 'Single')
    GOLD("Gold"),
    MONTHLY("Monthly"),
    SINGLE("Single");
    private final String code;

    private AbonementType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
