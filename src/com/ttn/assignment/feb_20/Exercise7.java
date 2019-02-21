package com.ttn.assignment.feb_20;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * WAP to convert seconds into days, hours, minutes and seconds.
 */
public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Seconds : ");
        try {
            convertSeconds(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Exception Occurred : " + e);
        }
    }

    /**
     * This method is used to convert the seconds into days, hours, minutes and seconds, it takes seconds as argument
     * and checks whether the number provided is in negative or not, if it's not we process the number else just
     * print 0 for every field.
     *
     * @param seconds Seconds to be converted.
     *
     */
    private static void convertSeconds(int seconds) {
        int day = 0;
        int hour = 0;
        int minutes = 0;
        int sec = 0;
        if (seconds > 0) {
            day = seconds / (24 * 3600);
            seconds = seconds % (24 * 3600);
            hour = seconds / 3600;
            seconds = seconds % 3600;
            minutes = seconds / 60;
            seconds = seconds % 60;
            sec = seconds;
        }
        System.out.println(day + " days " + hour + " hours " + minutes + " minutes and " + sec + " seconds ");
    }

}
