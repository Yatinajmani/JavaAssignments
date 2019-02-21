package com.ttn.assignment.feb_20.exercise9;

/**
 * Furniture is an abstract class that can be extended by any other class having two properties price and furnitureType
 * There are two abstract method whom implementation will be given by the subclasses as per requirement.But, overriding
 * of these abstract method is mandatory.
 */
abstract class Furniture {
    private float price;
    private FurnitureType furnitureType;

    float getPrice() {
        return price;
    }

    FurnitureType getFurnitureType() {
        return furnitureType;
    }

    Furniture(float price, FurnitureType furnitureType) {
        this.price = price;
        this.furnitureType = furnitureType;
    }

    abstract String fire();

    abstract String stress();
}
