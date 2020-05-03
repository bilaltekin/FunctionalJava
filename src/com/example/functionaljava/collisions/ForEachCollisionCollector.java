package com.example.functionaljava.collisions;

import com.example.functionaljava.Box;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ForEachCollisionCollector {

    private final Consumer<Collision> handler;
    //stores previously seen boxes
    private final ArrayList<Box> cache = new ArrayList<>();

    public ForEachCollisionCollector(Consumer<Collision> handler) {
        this.handler = handler;
    }

    //Process a new box
    public void update(Box b) {
        //for every previously seen boxes 'a'
        for (Box a : cache)
            //check if 'a' overlaps with the new box 'b'
            if (Box.areOverlapping(a, b))
                handler.accept(new Collision(a, b));
        //store the new box
        cache.add(b);
    }

    //Merge another Collector with this one
    public void merge(ForEachCollisionCollector other) {
        //for every pair of boxes in the two caches
        for (Box a : cache)
            for (Box b : other.cache)
                handler.accept(new Collision(a, b));
        //merge the two caches
        cache.addAll(other.cache);
    }
}
