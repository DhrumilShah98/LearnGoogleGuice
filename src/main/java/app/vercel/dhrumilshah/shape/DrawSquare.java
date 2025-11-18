package app.vercel.dhrumilshah.shape;

public class DrawSquare implements DrawShape {
    private final String color;
    private final Integer edge;

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
