package com.example.functionaljava;

import java.io.IOException;

@FunctionalInterface
public interface Scalable {


    void setScale(double scale) throws IOException, IndexOutOfBoundsException;


    double DEFAULT_SCALE = 1.0;

    static boolean isScalable(Object obj) {
        return obj instanceof Scalable;
    }

    default void resetScale() throws IOException {
        setScale(DEFAULT_SCALE);
    }






}
