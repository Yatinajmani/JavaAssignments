package com.ttn.assignment.feb_19;

/**
 * Write a single program for following operation using overloading
 * A) Adding 2 integer number
 * B) Adding 2 double
 * C) multiplying 2 float
 * D) multiplying 2 int
 * E) concate 2 string
 * F) Concate 3 String
 */
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

    /**
     * @param s
     * @param s1
     * @param s2
     * @return Concatination of three Strings.
     */
    private static String concat(String s, String s1, String s2) {
        return s + s1 + s2;
    }

    /**
     * @param s
     * @param s1
     * @return Concatination of two Strings.
     */
    private static String concat(String s, String s1) {
        return s + s1;
    }

    /**
     * @param v
     * @param v1
     * @return Product of two floating point numbers.
     */
    private static float mul(float v, float v1) {
        return v * v1;
    }

    /**
     * @param i
     * @param i1
     * @return Product of two integer numbers
     */
    private static int mul(int i, int i1) {
        return i * i1;
    }

    /**
     * @param v
     * @param v1
     * @return Addition of two integer numbers
     */
    private static double add(double v, double v1) {
        return v + v1;
    }

    /**
     * @param i
     * @param i1
     * @return Addition of two floating point numbers
     */
    private static int add(int i, int i1) {
        return i + i1;
    }
}
