package com.ttn.assignment.feb_28_java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Implement following functional interfaces from java.util.function using lambdas:
 * <p>
 * (1) Consumer
 * <p>
 * (2) Supplier
 * <p>
 * (3) Predicate
 * <p>
 * (4) Function
 */
public class Exercise5 {
    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("Using Consumer : ");
//      Consumer is a functional interface that takes single argument and do not return anything
//      consumer is a consumer instance that is referenced with the System.out::println as method signature of
//      System.out::println and apply method of Consumer interface is similar.
        Consumer<Integer> consumer = System.out::println;
//      passing consumer instance with forEach method of collection interface as it takes an argument of consumer.
        integers.forEach(consumer);

        System.out.println("Using Supplier : ");
//      Supplier is also a function interface that do not take any argument but returns something.
//      we are using getToken method that takes Supplier as an argument so we are passing lambda to provide definition
//      for get() method of that supplier.
        Map<Integer, String> intMap = integers
                .stream().collect(Collectors.toMap(e -> e, e ->
                        Tokenizer.getToken(() -> UUID.randomUUID().toString())
                ));
        for (Map.Entry<Integer, String> map : intMap.entrySet()
        ) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }

        System.out.println("Using Predicate : ");
//      Predicate is also a function interface that takes an argument and returns a boolean.
//      Here removeif method of ArrayList class takes a predicate as argument and removes the element if the predicate
//      returns true on that.
        Predicate<Integer> predicate = e -> e > 9;
        integers.removeIf(predicate);
        integers.forEach(consumer);

        System.out.println("Using Function : ");
//      Function is also a function interface that takes an argument and returns a value after processing the argument.
//      where first generic represents the argument type and second represents the return type.
        Function<Integer, Integer> squareFunction = e -> e * 2;
        integers.stream().map(squareFunction).forEach(consumer);

    }
}

interface Tokenizer {
    static String getToken(Supplier<String> supplier) {
        return supplier.get();
    }
}