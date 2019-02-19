package com.ttn.assignment.exercise11;

public class Application {
    public static void main(String[] args) {
        SBI sbi = new SBI();
        ICICI icici = new ICICI();
        BOI boi = new BOI();
        System.out.println(sbi.getDetails());
        System.out.println(icici.getDetails());
        System.out.println(boi.getDetails());
    }
}
