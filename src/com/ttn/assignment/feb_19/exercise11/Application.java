package com.ttn.assignment.feb_19.exercise11;

/**
 * Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide
 * there specific details like rateofinterest etc,print details of every banks
 */
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
