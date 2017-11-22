package com.mycompany.testapplication.entity;

public abstract class ClubCard {
    private final int userId;
    private final double price;

    public ClubCard(int userId, double price) {
        this.userId = userId;
        this.price = price;
    }

    
    public int getUserId() {
        return userId;
    }

    public double getPrice() {
        return price;
    }
    
    
}
