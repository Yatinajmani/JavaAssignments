package com.ttn.assignment.feb_19;


/**
 * Write a program to reverse a string and remove character from index 4 to index 9 from the
 * reversed string using String Buffer
 */
public class Exercise8 {
    public static void main(String[] args) {
//      String Buffer is used mostly where we need synchronised String manipulation as it is mutable and thread safe
//      Therefore it is a bit slower than string and string builder
        StringBuffer stringBuffer = new StringBuffer("Yatin Ajmani");
        System.out.println("Original String : " + stringBuffer);
        stringBuffer.reverse();
        System.out.println("Reversed String : " + stringBuffer);
        stringBuffer.replace(4,9,"");
        System.out.println("Replaced String : " + stringBuffer);
    }
}
