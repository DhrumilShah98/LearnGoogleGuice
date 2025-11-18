package app.vercel.dhrumilshah.shape;

public class DrawCircle implements DrawShape {
    private final String color;
    private final Integer radius;

    public DrawCircle(String color, Integer radius) {
        System.out.println("Instantiating DrawSquare object of color " + color + " and radius " + radius + ".");
        this.color = color;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square of color " + color + " and radius " + radius + ".");
    }
}
