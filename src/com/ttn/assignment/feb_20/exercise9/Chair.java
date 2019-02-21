package com.ttn.assignment.feb_20.exercise9;

class Chair extends Furniture {
    private ChairType chairType;

    private ChairType getChairType() {
        return chairType;
    }
//  super keyword is used here to refer to the parent class constructor,it can also be used to access public or
//  protected methods or instance variables.
    Chair(float price, FurnitureType furnitureType, ChairType chairType) {
        super(price, furnitureType);
        this.chairType = chairType;
    }

    @Override
    String fire() {
        return "Fire Test running for : " + getChairType().toString().toLowerCase() + " type " + getFurnitureType().toString().toLowerCase() + " Chair of price : Rs." + getPrice();
    }

    @Override
    String stress() {
        return "Stress Test running for : " + getChairType().toString().toLowerCase() + " type " + getFurnitureType().toString().toLowerCase() + " Chair of price : Rs." + getPrice();
    }

}
