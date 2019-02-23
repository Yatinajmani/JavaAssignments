package com.ttn.assignment.feb_22_collection;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Write a program to sort Employee objects based on highest salary using Comparator.
 * Employee class{ Double Age; Double Salary; String Name
 */
public class Exercise4 {
    public static void main(String[] args) {
//      asList method of Arrays class is used to Return a list of the elements of array.

        List<Employee> list = Arrays.asList(new Employee("Yatin", 24, 65491.56)
                , new Employee("Yatika", 24, 64491.56)
                , new Employee("Harsh", 22, 65391.56)
                , new Employee("Manish", 26, 65291.56)
                , new Employee("Manik", 29, 65411.56));
//      sort method of List interface helps in sort the list according to the Comparator provided as the argument.
//      toArray method is used to return an Array of Objects from the list.
        list.sort(new SalaryComparator());
        for (Employee employee :
                (Employee[]) list.toArray()) {
            System.out.println(employee);
        }
    }
}

class Employee {
    private String name;
    private int age;
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    Employee(String name, int age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

}

/**
 * SalaryComparator is implementing Comparator interface and overriding the compare method to provide custom compare
 * functionality on the basis of the employees salary.
 */
class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
//      Compares the salary of two objects.Returns a negative integer,zero,or a positive integer as the calling
//      object's salary is less than, equal to, or greater than the second respectively.
        return o1.getSalary().compareTo(o2.getSalary());
    }
}