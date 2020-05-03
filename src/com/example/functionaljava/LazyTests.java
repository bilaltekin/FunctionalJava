package com.example.functionaljava;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class LazyTests {

    public static void main(String[] args) {

        final Random random = new Random();

        Supplier<Integer> supp = () -> {
            Integer result = random.nextInt();
            System.out.println("(supplying "+result+")");
            return result;
        };

        System.out.println("\n Test 1");

        Stream<Integer> randoms = Stream.generate(supp);
        System.out.println("First stream built");

        randoms.filter(integer -> integer >=0)
                .limit(3).forEach(System.out::println);


        System.out.println("\n\n\n Test 2");

        Stream<Integer> randoms2 = Stream.generate(supp);

        randoms2.limit(3).filter(integer -> integer >=0).forEach(System.out::println);


    }
}
