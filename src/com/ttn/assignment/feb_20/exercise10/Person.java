package com.ttn.assignment.feb_20.exercise10;

import java.util.Date;

/**
 * Absract Person class for storing similar details/properties of actors and also similar behavior they share.
 */
public abstract class Person {
    private String name;
    private int age;
    private Long contact;

    protected Person(String name, int age, Long contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Long getContact() {
        return contact;
    }
}
