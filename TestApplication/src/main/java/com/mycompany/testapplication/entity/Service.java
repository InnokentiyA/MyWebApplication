package com.mycompany.testapplication.entity;

public class Service {
    private int id;
    private String name;
    private double priceSingle;
    private double priceMonth;
    private double priceGold;

    public Service(int id, String name, double priceSingle, double priceMonth, double priceGold) {
        this.id = id;
        this.name = name;
        this.priceSingle = priceSingle;
        this.priceMonth = priceMonth;
        this.priceGold = priceGold;
    }


    public double getPriceSingle() {
        return priceSingle;
    }

    public void setPriceSingle(double priceSingle) {
        this.priceSingle = priceSingle;
    }

    public double getPriceMonth() {
        return priceMonth;
    }

    public void setPriceMonth(double priceMonth) {
        this.priceMonth = priceMonth;
    }

    public double getPriceGold() {
        return priceGold;
    }

    public void setPriceGold(double priceGold) {
        this.priceGold = priceGold;
    }
 

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Service other = (Service) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", name=" + name + ", priceSingle=" + priceSingle + ", priceMonth=" + priceMonth + ", priceGold=" + priceGold + '}';
    }


    
    
    
}
