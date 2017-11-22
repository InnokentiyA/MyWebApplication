package com.mycompany.testapplication.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

public class MonthlyCard extends ClubCard {
    private final Date start;
    private final Date end;
    Set<Service> services;
    
    private final Timestamp from;
    private final Timestamp to;

    public MonthlyCard(Date start, Date end, Set<Service> services, Timestamp from, Timestamp to, int userId, double price) {
        super(userId, price);
        this.start = start;
        this.end = end;
        this.services = services;
        this.from = from;
        this.to = to;
    }

    
    
    public Timestamp getTo() {
        return to;
    }


    public Timestamp getFrom() {
        return from;
    }


    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
    
    
}
