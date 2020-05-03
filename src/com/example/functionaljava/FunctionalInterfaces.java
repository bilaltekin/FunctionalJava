package com.example.functionaljava;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Stream;

public class FunctionalInterfaces {

    public static void main(String[] args) throws Exception{

        System.out.println(composeHashcodes2("Hello", "orld"));
 //       System.out.println(composeHashcodes2("Hello", null));

        Comparator<Employee> by =
                Comparator.comparing(employee -> employee.getName());

        /*PrintWriter writer  = new PrintWriter("filename.txt");
        Consumer<String> logger = writer::println;
        Consumer<String> screener = System.out::println;
        Consumer<String> both = screener.andThen(logger);
        both.accept("Program started");*/

        Employee[] employees ={new Employee("ds",2500)};

        Arrays.stream(employees).filter(employee -> employee.getSalary()>=2500)
                                .map(Employee::getName)
                                .sorted()
                                .forEach(System.out::println);


        Random random = new Random();
        Stream<Integer>  randoms=
                Stream.generate(random::nextInt);



    }

    public static int composeHashcodes(Object a, Object b)
    {
        return a.hashCode() ^ b.hashCode();
    }


    //A "slow" method
    public static String getApplicationStatus()
    {
        System.out.println("getApplicationStatus");
        return "It's " + LocalTime.now();
    }

    public static int composeHashcodes2(Object a, Object b)
    {
        Objects.requireNonNull(a,"a may not be null! "+getApplicationStatus());
        Objects.requireNonNull(b,"b may not be null! "+getApplicationStatus());

        return a.hashCode() ^ b.hashCode();
    }

    public static int composeHashcodes3(Object a, Object b)
    {
        Objects.requireNonNull(a,() ->"a may not be null! "+getApplicationStatus());
        Objects.requireNonNull(b,() ->"b may not be null! "+getApplicationStatus());


        return a.hashCode() ^ b.hashCode();
    }
}
