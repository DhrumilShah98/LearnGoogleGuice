package app.vercel.dhrumilshah.shape;

import app.vercel.dhrumilshah.annotation.DefaultCircleRadius;
import app.vercel.dhrumilshah.annotation.DefaultShapeColor;
import com.google.inject.Inject;

public class DrawCircle implements DrawShape {
    private final String color;
    private final Integer radius;

    @Inject
    public DrawCircle(@DefaultShapeColor String color, @DefaultCircleRadius Integer radius) {
        System.out.println("Instantiating DrawCircle object of color " + color + " and radius " + radius + ".");
        this.color = color;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle of color " + color + " and radius " + radius + ".");
    }
}
