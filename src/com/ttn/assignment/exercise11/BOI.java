package com.ttn.assignment.exercise11;

class BOI extends Bank {
    BOI() {
        super.rateOfInterest = 2.25f;
        super.noOfBranches = 110;
    }

    @Override
    String getDetails() {
        return "Bank of India has " + super.noOfBranches + " Branches and " +
                super.rateOfInterest + "% Rate of interest";
    }
}
