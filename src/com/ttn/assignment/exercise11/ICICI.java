package com.ttn.assignment.exercise11;

class ICICI extends Bank {
    ICICI() {
        super.rateOfInterest = 2.15f;
        super.noOfBranches = 90;
    }

    @Override
    String getDetails() {
        return "ICICI has " + super.noOfBranches + " Branches and " +
                super.rateOfInterest + "% Rate of interest";
    }
}
