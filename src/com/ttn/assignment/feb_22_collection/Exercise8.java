package com.ttn.assignment.feb_22_collection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Write a program to format date as example "21-March-2016"
 */
public class Exercise8 {
    public static void main(String[] args) {
//      Calendar is an abstract class and has methods for calendar manipulation and also defined calendar related
//      terms.GregorianCalendar is a subclass of Calendar class having custom modification methods over calendar
//      instance.
        Calendar calendar= GregorianCalendar.getInstance();
//      Date class is used to get the system time and by default it returns current time in milliseconds
//      getTime return a date object according to GregorianCalendar calendar instance date and time.
        Date date=calendar.getTime();
//      SimpleDateFormat is used to get date or time in specified pattern.
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMMMM-yyyy");
//      format method is used to format the date as a string on the basis of specified pattern in simpleDateFormat
//      instance.
        System.out.println(simpleDateFormat.format(date));

    }
}
