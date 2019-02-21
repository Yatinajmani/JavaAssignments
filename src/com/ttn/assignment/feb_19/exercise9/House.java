package com.ttn.assignment.feb_19.exercise9;

public enum House {
//  Instances of House enum with there prices passed using parameterized constructor.
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
