package com.ttn.assignment.feb_22_collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Write a program to sort the Student objects based on Score , if the score are same then sort on First Name.
 */
public class Exercise5 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("Yatin", 24, 91.56f)
                , new Student("Yatika", 24, 81.56f)
                , new Student("Harsh", 22, 71.56f)
                , new Student("Anjali", 25, 71.56f)
                , new Student("Manish", 26, 92.56f)
                , new Student("Manik", 29, 98.56f));
        list.sort(new ScoreAndNameComparator());
        for (Student student :
                (Student[]) list.toArray()) {
            System.out.println(student);
        }

    }
}

class Student {
    private String firstName;
    private int age;
    private Float score;

    String getFirstName() {
        return firstName;
    }

    Float getScore() {
        return score;
    }

    Student(String firstName, int age, Float score) {
        this.firstName = firstName;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

class ScoreAndNameComparator implements Comparator<Student>{
//  compare method overrides Comparator's compare method and checks first whether score are equal or not id they are
//  not equal we can return comparison of them using compareTo but if they are equal it compares firstName.
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getScore().compareTo(o2.getScore())!=0)
            return o1.getScore().compareTo(o2.getScore());
        else
            return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
