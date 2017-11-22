package com.mycompany.testapplication.entity;

import java.sql.Date;

public class User {
    int id;
    String username;
    String surname;
    String lastName;
    String email;
    String password;
    String phone; 
    Date regDate;
    boolean isHealth;
    Sex sex;

    public User(int id, String username, String email, String phone, String password, Date regDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
        this.phone = phone;
    }

    




    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

   /* public String getSurname() {
        return surname;
    }

    public String getLastName() {
        return lastName;
    }*/

    public Date getRegDate() {
        return regDate;
    }

    public boolean isIsHealth() {
        return isHealth;
    }

    public Sex getSex() {
        return sex;
    }
    
   
    
    
    
}
