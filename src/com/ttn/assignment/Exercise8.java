package com.ttn.assignment;

public class Exercise8 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Yatin Ajmani");
        System.out.println("Original String : " + stringBuffer);
        stringBuffer.reverse();
        System.out.println("Reversed String : " + stringBuffer);
        stringBuffer.replace(4,9,"");
        System.out.println("Replaced String : " + stringBuffer);
    }
}
