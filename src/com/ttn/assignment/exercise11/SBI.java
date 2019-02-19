package com.ttn.assignment.exercise11;

class SBI extends Bank {
    SBI() {
        super.rateOfInterest = 3.15f;
        super.noOfBranches = 120;
    }

    @Override
    String getDetails() {
        return "State Bank of India has " + super.noOfBranches + " Branches and " +
                super.rateOfInterest + "% Rate of interest";
    }
}
