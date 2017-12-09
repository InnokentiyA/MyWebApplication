package com.mycompany.testapplication.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

public class MonthlyCard extends ClubCard {
    private final Date start;
    private final Date end;
    Set<Service> services;

    public MonthlyCard(Date start, Date end, Set<Service> services, int id, double price) {
        super(id, price);
        this.start = start;
        this.end = end;
        this.services = services;
    }

    
   


    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
    
    
}
