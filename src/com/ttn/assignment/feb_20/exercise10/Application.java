package com.ttn.assignment.feb_20.exercise10;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Design classes having attributes and method(only skeleton) for a coffee shop. There are three different actors
 * in our scenario and listed the different actions they do is below
 * <p>
 * * Customer
 * - Pays the cash to the cashier and places his order, get a token number back
 * - Waits for the intimation that order for his token is ready
 * - Upon intimation/notification he collects the coffee and enjoys his drink
 * ( Assumption:  Customer waits till the coffee is done, he wont timeout and cancel the order.
 * Customer always likes the drink served. Exceptions like he not liking his coffee, he getting wrong coffee
 * are not considered to keep the design simple.)
 * <p>
 * * Cashier
 * - Takes an order and payment from the customer
 * - Upon payment, creates an order and places it into the order queue
 * - Intimates the customer that he has to wait for his token and gives him his token
 * ( Assumption: Token returned to the customer is the order order. Order queue is unlimited. With a simple
 * modification, we can design for a limited queue size)
 * <p>
 * * Barista
 * - Gets the next order from the queue
 * - Prepares the coffee
 * - Places the coffee in the completed order queue
 * - Places a notification that order for token is ready
 */
public class Application {
    public static void main(String[] args) throws ParseException {
//      Using CopyOnWriteArrayList for making list modifiable at the runtime.
        CopyOnWriteArrayList<Order> orders = new CopyOnWriteArrayList<>();
        Customer customer = new Customer("Yatin", 24, 9654773125L);
        Customer customer1 = new Customer("Yatika", 22, 9654673125L);
        Cashier cashier = new Cashier("Harsh", 22, 9845654459L);
        Cashier cashier1 = new Cashier("Harsha", 24, 9845654462L);
        Barista barista = new Barista("Naman", 25, 98456455559L);

        customer.orders();
        orders.add(cashier.receivesOrder(customer, 646.84f));
        customer.setId(cashier.intimateCustomer(customer));
        customer.waits();

        customer1.orders();
        orders.add(cashier1.receivesOrder(customer1, 6461.4f));
        customer1.setId(cashier1.intimateCustomer(customer1));
        customer.waits();

        for (Order order : orders) {
            System.out.print("Pending Orders : { ");
//          Using forEach Method is used to Print pending orders, it is method of JAVA 8 Collections.
            orders.forEach(order1 -> {
                System.out.print(order.getId()+" ,");
            });
            System.out.println("}");
            barista.takeOrder(order);
            barista.preparesCoffee();
            barista.nofifyCustomer();
            barista.getOrder().getCustomer().collectsOrder();
            orders.remove(order);
        }
    }
}
