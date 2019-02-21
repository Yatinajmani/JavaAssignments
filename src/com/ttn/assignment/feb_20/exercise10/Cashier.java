package com.ttn.assignment.feb_20.exercise10;

import java.util.UUID;

class Cashier extends Person {
    UUID id;

    public Cashier(String name, int age, Long contact) {
        super(name, age, contact);
    }

    public UUID getId() {
        return id;
    }

    Order receivesOrder(Customer customer, float amount) {
        System.out.println(getName() + " receives an order from " + customer.getName() + " of Rs." + amount);
        Order order = new Order(amount, customer, this);
        this.id = order.getId();
        return order;
    }

    UUID intimateCustomer(Customer customer) {
        System.out.println(customer.getName() + " has to wait with current token : " + getId());
        return getId();
    }
}
