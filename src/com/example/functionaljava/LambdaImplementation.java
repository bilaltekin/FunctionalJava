package com.example.functionaljava;

import java.util.function.Consumer;

public class LambdaImplementation {

    public static void main(String[] args) {

        //Anonymous class, multiple instance
        System.out.println("\nAnonymous class:");
        for (int i = 0; i < 5; i++) {

            Consumer<String> myPrinter1 = new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.println("Consumung "+s);
                }
            };
            myPrinter1.accept(myPrinter1.toString());
        }

        //Non-capturing lambda, one instance
        System.out.println("\nNon-capturinglambda: ");
        for (int i = 0; i <5 ; i++) {

            Consumer<String> myPrinter2 =
                    s -> System.out.println("Consumung "+s);

            myPrinter2.accept("myPrinter2".toString());
        }

        //Constant-capturing lambda, one instance
        System.out.println("\nConstant-capturing lambda: ");
        final int secret =42;
        for (int i = 0; i <5 ; i++) {

            Consumer<String> myPrinter3 =
                    s -> System.out.println("Consumung "+s+", "+secret);

            myPrinter3.accept(myPrinter3.toString());
        }

        (new LambdaImplementation()).foo();
    }

    private int id=1;
    public void foo()
    {
        System.out.println("\nInstance-capturing lambda:");

        for (int i = 0; i <5 ; i++) {

            //this-capturing lambda, many instance!
            Consumer<String> myPrinter4 =
                    s -> System.out.println("Consumung "+s+", "+id);

            myPrinter4.accept(myPrinter4.toString());
        }
    }
}
