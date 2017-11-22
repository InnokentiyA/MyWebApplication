package com.mycompany.testapplication.entity;
import java.sql.Date;

public class Gold extends ClubCard{
    private Date start;
    private Date end;

    public Gold(int userId, double price) {
        super(userId, price);
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
    
    
}
