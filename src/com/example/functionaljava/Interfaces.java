package com.example.functionaljava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Interfaces {

    public static void main(String[] args) {

        Employee mike = new Employee("Mike",2000),
                louise = new Employee("Louise", 2500);

        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getName().compareTo(b.getName());
            }
        };

        System.out.println("By name:");
        System.out.println(byName.compare(mike,louise));

        try {
            System.out.println(byName.compare(mike,null));
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        Comparator<Employee> byNameThenNull = Comparator.nullsLast(byName);

        System.out.println("Then null:");
        System.out.println(byNameThenNull.compare(mike,louise));
        System.out.println(byNameThenNull.compare(mike,null));

        Comparator<Employee> nullThenByDecreasingName = byNameThenNull.reversed();

        System.out.println("Reversed:");
        System.out.println(nullThenByDecreasingName.compare(mike,louise));
        System.out.println(nullThenByDecreasingName.compare(mike,null));





        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));

        



    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
}
