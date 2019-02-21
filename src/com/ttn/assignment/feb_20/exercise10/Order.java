package com.ttn.assignment.feb_20.exercise10;

import java.util.UUID;

public class Order {
    //Universally Unique Identifier a 128-bit long value that is unique for all.A UUID is made of up of hex digits
    // (4 chars each) along with 4 “-” symbols which make its length equal to 36 characters.
    UUID id;
    private float amount;
    private Customer customer;
    private Cashier cashier;

    Order(float amount, Customer customer, Cashier cashier) {
        id = UUID.randomUUID();
        this.amount = amount;
        this.customer = customer;
        this.cashier = cashier;
    }

    UUID getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    Customer getCustomer() {
        return customer;
    }

    public Cashier getCashier() {
        return cashier;
    }
}
