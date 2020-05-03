package com.example.functionaljava.collisions;

import com.example.functionaljava.Box;


import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;

import static com.example.functionaljava.collisions.BasicDetection.*;

public class CountingTest {

    public static final int XRES = 1920, YRES = 1080, MAXX = 200, MAXY = 200;

    //Generate random boxes
    public static ArrayList<Box> makeRandom(int n)
    {
        ArrayList<Box> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(Box.newRandom(XRES,YRES,MAXX,MAXY));
        }

        return result;
    }

    public static void main(String[] args) {
        final int TEST_SİZE =   5_000;
        ArrayList<Box> world = makeRandom(TEST_SİZE);

        System.out.println("\nCounting the number of collision:");

        final LongAdder atomicCounter = new LongAdder();
        Consumer<Collision> action = collision -> atomicCounter.increment();

        System.out.println("\n standart imperative");
        //warm up
        forEachCollision1(world,action);
        atomicCounter.reset();
        //Timed run
       // Time.timeIt(action()->forEachCollision1(world,action));
        forEachCollision1(world,action);
        System.out.println("# of com.example.functionaljava.collisions: "+atomicCounter);

        System.out.println("\n standart imperative (no duplicates)");

        //warm up
        forEachCollision2(world,action);
        atomicCounter.reset();
        //Timed run
        //Time.timeIt(action()->forEachCollision2(world,action));
        forEachCollision2(world,action);
        System.out.println("# of com.example.functionaljava.collisions: "+atomicCounter);

        System.out.println("\n Parallel stream (ForEachCollisionCollector)");

        //warm up
        forEachCollision3(world,action);
        atomicCounter.reset();
        //Timed run
        //Time.timeIt(action()->forEachCollision3(world,action));
        forEachCollision3(world,action);
        System.out.println("# of com.example.functionaljava.collisions: "+atomicCounter);

    }
}
