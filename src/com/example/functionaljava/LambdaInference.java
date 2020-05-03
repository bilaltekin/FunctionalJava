package com.example.functionaljava;

import java.util.function.Consumer;

public class LambdaInference {

    public static void main(String[] args) {

        //Standart syntax
        Consumer<String> c1 = msg -> System.out.println(msg.length());
/*
        //Compile-time error: not enough info
        Object x1 = msg -> System.out.println(msg.length());

        //Compile-time error: not enough info
        Object x2 = (String msg) -> System.out.println(msg.length());*/

        //Ok : casr added
        Object x3 = (Consumer<String>)((String msg) -> System.out.println(msg.length()));



        //*** part 2: identify parameter types

        //Ok: but inferred parameter type is Object
        Consumer<?> c2 = o -> System.out.println(o);
/*

        //Compile-time errror: Inference is *not* based on body of lambda
        Consumer<?> c3 = o -> System.out.println(o.length());
*/

        //Ok: added manifest type to parameter
        Consumer<?> c4 = (String o) -> System.out.println(o.length());



    }
}
