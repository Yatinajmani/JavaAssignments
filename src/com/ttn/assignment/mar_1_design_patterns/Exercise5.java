package com.ttn.assignment.mar_1_design_patterns;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implement Bridge Design Pattern for Color and Shape such that Shape and Color can be combined together
 * e.g BlueSquare, RedSquare, PinkTriangle etc.
 * <p>
 * Bridge Pattern is used to build a bridge between independent classes using an interface, here color acts like
 * that interface
 */
public class Exercise5 {
    public static void main(String[] args) {
        System.out.println("Build Shape");
        System.out.println("1. Red");
        System.out.println("2. Pink");
        System.out.println("3. Blue");
        System.out.println("Choose Color : ");
        Scanner scanner = new Scanner(System.in);
        int x, y;
        try {
            x = scanner.nextInt();
            Color color = x == 1 ? new Red() : x == 2 ? new Pink() : new Blue();
            System.out.println("1. Rectangle");
            System.out.println("2. Square");
            System.out.println("3. Triangle");
            System.out.println("Choose Shape : ");
            y = scanner.nextInt();
            switch (y) {
                case 1:
                    System.out.println(new Rectangle(color, "Parallelogram"));
                    break;
                case 2:
                    System.out.println(new Square(color, "Rhombus"));
                    break;
                case 3:
                    System.out.println(new Triangle(color, "Equilateral"));
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter integers only. " + e);
        }

    }
}

// Implementor
interface Color {
    String getColor();
}

// Concrete Implementor
class Pink implements Color {

    @Override
    public String getColor() {
        return "Pink";
    }
}

// Concrete Implementor
class Red implements Color {

    @Override
    public String getColor() {
        return "Red";
    }
}

// Concrete Implementor
class Blue implements Color {

    @Override
    public String getColor() {
        return "Blue";
    }
}

// Abstraction
abstract class Shape {
    private Integer sides;
    //  interface reference used to link color and shape classes.
    private Color color;
    private String type;

    Integer getSides() {
        return sides;
    }

    Color getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    Shape(Integer sides, Color color, String type) {
        this.sides = sides;
        this.color = color;
        this.type = type;
    }
}

// Refined Abstraction
class Triangle extends Shape {

    Triangle(Color color, String type) {
        super(3, color, type);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "type='" + super.getType() + '\'' +
                ", sides='" + super.getSides() + '\'' +
                ", color='" + super.getColor().getColor() + '\'' +
                '}';
    }
}

// Refined Abstraction
class Square extends Shape {

    Square(Color color, String type) {
        super(4, color, type);
    }

    @Override
    public String toString() {
        return "Square{" +
                "type='" + super.getType() + '\'' +
                ", sides='" + super.getSides() + '\'' +
                ", color='" + super.getColor().getColor() + '\'' +
                '}';
    }
}

// Refined Abstraction
class Rectangle extends Shape {

    Rectangle(Color color, String type) {
        super(4, color, type);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "type='" + super.getType() + '\'' +
                ", sides='" + super.getSides() + '\'' +
                ", color='" + super.getColor().getColor() + '\'' +
                '}';
    }
}