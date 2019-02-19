package com.ttn.assignment;

public class Exercise10 {
    public static void main(String[] args) {
        int sum = add(10, 20);
        double dsum = add(10.5, 20.54);
        int product = mul(10, 20);
        float dproduct = mul(10.05f, 20.5f);
        String concatinatedStr = concat("10", "20");
        String concatinatedThreeStr = concat("10", "20", "30");
        System.out.println("Integer Sum : " + sum);
        System.out.println("Double Sum : " + dsum);
        System.out.println("Integer Product : " + product);
        System.out.println("Float Product : " + dproduct);
        System.out.println("Two String Concatination : " + concatinatedStr);
        System.out.println("Three String Concatination : " + concatinatedThreeStr);
    }

    private static String concat(String s, String s1, String s2) {
        return s + s1 + s2;
    }

    private static String concat(String s, String s1) {
        return s + s1;
    }

    private static float mul(float v, float v1) {
        return v * v1;
    }

    private static int mul(int i, int i1) {
        return i * i1;
    }

    private static double add(double v, double v1) {
        return v + v1;
    }

    private static int add(int i, int i1) {
        return i + i1;
    }
}
