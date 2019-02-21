package com.ttn.assignment.feb_20.exercise1;

import com.ttn.assignment.feb_20.exercise10.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Borrower extends Person {
    int id;

    public int getId() {
        return id;
    }

    public Borrower(String name, int age, Long contact, int id) {
        super(name, age, contact);
        this.id = id;
    }
}
