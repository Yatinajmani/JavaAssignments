package com.ttn.assignment.feb_28_java_8;

import java.util.UUID;

/**
 * Implement multiple inheritance with default method inside  interface.
 * <p>
 * Exercise8 is implementing both CustomTokenGenerator2 and CustomTokenGenerator1 hence it will create ambiguity
 * as in who's default method to use while using getToken default method. So it's mandatory to override the default
 * method. Also we can use getToken default method from a particular class using interfaceName.super.methodName inside
 * class.
 */
public class Exercise8 implements CustomTokenGenerator1, CustomTokenGenerator2 {

    @Override
    public String getToken() {
        return CustomTokenGenerator1.super.getToken().replace('_', '.');
    }

    public static void main(String[] args) {
        System.out.println("Custom Unique Token overriding default method in main class : "+new Exercise8().getToken());
    }
}

/**
 * CustomTokenGenerator1 is an interface that extends the TokenGenerator from Exercise7
 */
interface CustomTokenGenerator1 extends TokenGenerator {
    //  overriding getToken default method of TokenGenerator.
    @Override
    default String getToken() {
        return UUID.randomUUID().toString().replace('-', '_');
    }
}

/**
 * CustomTokenGenerator2 is also an interface that extends the TokenGenerator from Exercise7
 */
interface CustomTokenGenerator2 extends TokenGenerator {
    //  overriding getToken default method of TokenGenerator.
    @Override
    default String getToken() {
        return UUID.randomUUID().toString().replace('-', ',');
    }
}
