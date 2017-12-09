package com.mycompany.testapplication.entity;

import java.sql.Date;

public class User {

    int id;
    String username;
    String name;
    String surname;
    String email;
    String password;
    String phone;
    Date regDate;
    boolean isHealth;
    Sex sex;

    private int abonementId;

    public int getAbonementId() {
        return abonementId;
    }

    public void setAbonementId(int abonementId) {
        this.abonementId = abonementId;
    }

    public User(int id, String name, String surname, String username, String email, String phone, String password, Date regDate, int abonementId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.regDate = regDate;
        this.abonementId = abonementId;

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Date getRegDate() {
        return regDate;
    }

    public boolean isIsHealth() {
        return isHealth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public void setIsHealth(boolean isHealth) {
        this.isHealth = isHealth;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", name=" + name + ", email=" + email + '}';
    }

}
