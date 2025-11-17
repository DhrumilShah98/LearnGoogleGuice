package app.vercel.dhrumilshah.shape;

import com.google.inject.Inject;

public class DrawSquare implements DrawShape {
    private final String color;
    private final Integer edge;

    @Inject
    public DrawSquare(String color, Integer edge) {
        System.out.println("Instantiating DrawSquare object of color " + color + " and edge " + edge + ".");
        this.color = color;
        this.edge = edge;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square of color " + color + " and edge " + edge + ".");
    }
}
