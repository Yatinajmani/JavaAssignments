package com.ttn.assignment.mar_1_design_patterns;

/**
 * Implement Decorator pattern to decorate the Pizza with toppings.
 * <p>
 * Decorator Pattern is used to add some additional functionalities to a concrete object.
 */
public class Exercise6 {
    public static void main(String[] args) {
        Pizza pizza = new PeppyPaneer();
        pizza = new Veggies(pizza);
        System.out.println(pizza.getDescription() + " Costs :" + pizza.getCost());

        Pizza pizza1 = new Margherita();
        pizza1 = new Veggies(pizza1);
        System.out.println(pizza1.getDescription() + " Costs :" + pizza1.getCost());

        Pizza pizza2 = new FarmHouse();
        pizza2 = new Paneer(pizza2);
        System.out.println(pizza2.getDescription() + " Costs :" + pizza2.getCost());

        Pizza pizza3 = new PanPizza();
        pizza3 = new Olives(pizza3);
        System.out.println(pizza3.getDescription() + " Costs :" + pizza3.getCost());
    }
}

abstract class Pizza {
    String description = "BasicPizza";

    String getDescription() {
        return description;
    }

    public abstract int getCost();
}

interface Toppings {
    String addToppings();
}

class FarmHouse extends Pizza {
    FarmHouse() {
        description = "FarmHousePizza";
    }

    public int getCost() {
        return 240;
    }
}

class PeppyPaneer extends Pizza {

    PeppyPaneer() {
        description = "PeppyPaneerPizza";
    }

    public int getCost() {
        return 200;
    }

}

class Margherita extends Pizza {
    Margherita() {
        description = "MargheritaPizza";
    }

    public int getCost() {
        return 190;
    }
}

class PanPizza extends Pizza {
    public int getCost() {
        return 50;
    }
}

//  Decorator classes

class Veggies extends Pizza implements Toppings {
    private Pizza pizza;

    Veggies(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String addToppings() {
        return pizza.getDescription() + " with Veggies";
    }

    @Override
    String getDescription() {
        return addToppings();
    }

    public int getCost() {
        return 40 + pizza.getCost();
    }
}

class Olives extends Pizza implements Toppings {
    private Pizza pizza;

    Olives(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String addToppings() {
        return pizza.getDescription() + " with Olives";
    }

    @Override
    String getDescription() {
        return addToppings();
    }

    public int getCost() {
        return 70 + pizza.getCost();
    }
}

class Paneer extends Pizza implements Toppings {
    private Pizza pizza;

    Paneer(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String addToppings() {
        return pizza.getDescription() + " with Paneer";
    }

    @Override
    String getDescription() {
        return addToppings();
    }

    public int getCost() {
        return 100 + pizza.getCost();
    }
}