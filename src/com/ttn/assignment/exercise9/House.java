package com.ttn.assignment.exercise9;

public enum House {
    VILLA(9999.99f), CASTLE(2564.54f), PALACE(2535.54f);

    float price;

    House(float price) {
        this.price = price;
        System.out.println("House Type : " + this.toString() + " price : Rs." + this.price);
    }

    public float getPrice() {
        return price;
    }
}
