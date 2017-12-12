/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testapplication.entity;

import java.sql.Date;
import java.util.List;

public class Abonement {

    private int id;
    private AbonementType type;
    private double price;
    private Date start;
    private Date end;
    
    private List<Service> services;

    public Abonement(int id, AbonementType type, double price, Date start, Date end) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public AbonementType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public List<Service> getServices() {
        return services;
    }
    
    
}
