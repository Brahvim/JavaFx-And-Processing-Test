package com.brahvim.javafx_processing_test;

import java.util.concurrent.atomic.AtomicBoolean;

import processing.core.PApplet;

public class Sketch extends PApplet {

    // Will be set to `true` as soon as the class loads:
    private static final AtomicBoolean isRunning = new AtomicBoolean(true);

    @Override
    public void settings() {
        // super.size(PApplet.DEFAULT_WIDTH, PApplet.DEFAULT_HEIGHT, PConstants.FX2D);
        System.out.println("MADE IT!");
    }

    public static boolean isRunning() {
        return Sketch.isRunning.get();
    }

    @Override
    public void exitActual() {
        Sketch.isRunning.set(false);

        if (!App.isRunning())
            System.exit(0);
    }

}
