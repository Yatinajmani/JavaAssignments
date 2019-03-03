package com.ttn.assignment.mar_1_design_patterns;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implement Abstract Factory Pattern to create cars of different categories from different countries.
 * <p>
 * Abstract Factory is a pattern that uses factory of Factories like here CarFactory is the super Factory for
 * cars of different categories from different countries.
 */
public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("Build Car");
        System.out.println("1. India");
        System.out.println("2. USA");
        System.out.println("Choose Location : ");
        Scanner scanner = new Scanner(System.in);
        int x, y;
        try {
            x = scanner.nextInt();
            Location location = x == 1 ? Location.INDIA : x == 2 ? Location.USA : Location.OTHER;
            System.out.println("1. Sedan");
            System.out.println("2. Hatchback");
            System.out.println("3. Luxury");
            System.out.println("Choose Car type: ");
            y = scanner.nextInt();
            CarType carType = y == 1 ? CarType.SEDAN : y == 2 ? CarType.HATCHBACK : y == 3 ?
                    CarType.LUXURY : CarType.SEDAN;

            System.out.println(CarFactory.buildCar(carType, location));
        } catch (InputMismatchException e) {
            System.out.println("Enter integers only. " + e);
        }
    }
}

//Fixed types of cars.
enum CarType {
    SEDAN, HATCHBACK, LUXURY
}

//Fixed Locations of cars.
enum Location {
    USA, INDIA, OTHER
}

//Blueprint for every car.
abstract class Car {

    private CarType carType;

    private Location location;

    Car(CarType carType, Location location) {
        this.carType = carType;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Car Build of " +
                "Type : " + carType.toString().toLowerCase() +
                " and location : " + location.toString().toLowerCase();
    }
}

//  classes for different types of cars.

class LuxuryCar extends Car {

    LuxuryCar(Location location) {
        super(CarType.LUXURY, location);
    }

}

class SedanCar extends Car {

    SedanCar(Location location) {
        super(CarType.SEDAN, location);
    }
}

class HatchbackCar extends Car {

    HatchbackCar(Location location) {
        super(CarType.HATCHBACK, location);
    }

}

//  classes for different locations of cars having different categories.

class IndianCarFactory {

    static Car buildCar(CarType carType) {
        Car car = null;
        switch (carType) {
            case SEDAN:
                car = new SedanCar(Location.INDIA);
                break;
            case HATCHBACK:
                car = new HatchbackCar(Location.INDIA);
                break;
            case LUXURY:
                car = new LuxuryCar(Location.INDIA);
                break;
        }
        return car;
    }

}

class OtherCarFactory {

    static Car buildCar(CarType carType) {
        Car car = null;
        switch (carType) {
            case SEDAN:
                car = new SedanCar(Location.OTHER);
                break;
            case HATCHBACK:
                car = new HatchbackCar(Location.OTHER);
                break;
            case LUXURY:
                car = new LuxuryCar(Location.OTHER);
                break;
        }
        return car;
    }

}


class USACarFactory {

    static Car buildCar(CarType carType) {
        Car car = null;
        switch (carType) {
            case SEDAN:
                car = new SedanCar(Location.USA);
                break;
            case HATCHBACK:
                car = new HatchbackCar(Location.USA);
                break;
            case LUXURY:
                car = new LuxuryCar(Location.USA);
                break;
        }
        return car;
    }
}

// Super factory for building the car from base.

class CarFactory {

    static Car buildCar(CarType carType, Location location) {
        Car car = null;
        switch (location) {
            case INDIA:
                car = IndianCarFactory.buildCar(carType);
                break;
            case USA:
                car = USACarFactory.buildCar(carType);
                break;
            case OTHER:
                car = OtherCarFactory.buildCar(carType);
                break;
        }
        return car;
    }
}