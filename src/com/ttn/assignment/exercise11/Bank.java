package com.ttn.assignment.exercise11;

/**
 * Bank is an Abstract Class having two attributes and an abstract method for getting bank details
 * these attributes and method can be set and defined respectively according to the child class needs.
 */
abstract class Bank {
    float rateOfInterest;
    float noOfBranches;

    abstract String getDetails();
}
