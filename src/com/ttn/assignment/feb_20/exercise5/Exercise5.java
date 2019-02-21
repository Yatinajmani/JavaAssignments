package com.ttn.assignment.feb_20.exercise5;

/**
 * WAP to show object cloning in java using cloneable.
 * Here Exercise5 is implementing Cloneable which is a marker interface that just instructs that this class
 * supports cloning and we can override Object class clone method.By default Cloneable does shallow copy.
 */
public class Exercise5 implements Cloneable {
    private String name;

    Exercise5(String name) {
        this.name = name;
    }

    public Exercise5(Exercise5 exercise5) {
        this.name= exercise5.name;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Exercise5 clone()throws CloneNotSupportedException{
        return (Exercise5)super.clone();
    }
}
