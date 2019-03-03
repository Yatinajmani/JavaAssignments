package com.ttn.assignment.mar_1_design_patterns;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implement Factory Pattern to get the PolygonType of different type.
 * <p>
 * Factory pattern is used here to create different types of polygon on the basis of there sides.
 */
public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("Polygon Types : ");
        System.out.println("4. Quadrilateral");
        System.out.println("5. Pentagon");
        System.out.println("6. Hexagon");
        System.out.println("8. Octagon");
        System.out.println("Choose sides : ");
        Scanner scanner = new Scanner(System.in);

        int x;
        try {
            x = scanner.nextInt();
//          sending sides to choose the polygon and printing info.
            System.out.println(PolygonFactory.getInstance(x).getPolygonType().info());
        } catch (InputMismatchException e) {
            System.out.println("Enter integers only. " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//  PolygonType interface is used to provide the reference for every polygon type
//  this is called coding to interfaces.
interface PolygonType {
    String info();
}

class Quadrilateral implements PolygonType {
    @Override
    public String info() {
        return "Quadrilateral created.";
    }
}

class Pentagon implements PolygonType {
    @Override
    public String info() {
        return "Pentagon created.";
    }
}

class Hexagon implements PolygonType {
    @Override
    public String info() {
        return "Hexagon created.";
    }
}

class Octagon implements PolygonType {
    @Override
    public String info() {
        return "Octagon created.";
    }
}

// Polygon is main class that binds different polygon to it's PolygonType interface.
class Polygon {
    private PolygonType polygonType;

    PolygonType getPolygonType() {
        return polygonType;
    }

    void setPolygonType(PolygonType polygonType) {
        this.polygonType = polygonType;
    }
}

// Factory class that is creates polygon of different types on the basis of the sides.
class PolygonFactory {
    static Polygon getInstance(int sides) throws Exception {
        Polygon polygon = new Polygon();
        switch (sides) {
            case 4: {
                polygon.setPolygonType(new Quadrilateral());
                break;
            }
            case 5: {
                polygon.setPolygonType(new Pentagon());
                break;
            }
            case 6: {
                polygon.setPolygonType(new Hexagon());
                break;
            }
            case 8: {
                polygon.setPolygonType(new Octagon());
                break;
            }
            default:
                throw new Exception("Choose Valid Input.");
        }
        return polygon;
    }
}