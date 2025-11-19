package app.vercel.dhrumilshah.provider;

import app.vercel.dhrumilshah.annotation.DefaultCircleRadius;
import app.vercel.dhrumilshah.annotation.DefaultShapeColor;
import app.vercel.dhrumilshah.shape.DrawCircle;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class DrawCircleProvider implements Provider<DrawCircle> {
    private final String color;
    private final Integer radius;

    @Inject
    public DrawCircleProvider(@DefaultShapeColor String color, @DefaultCircleRadius Integer radius) {
        System.out.println("Instantiating DrawCircleProvider object of color " + color + " and radius " + radius + ".");
        this.color = color;
        this.radius = radius;
    }

    @Override
    public DrawCircle get() {
        System.out.println("Getting a DrawCircle object of color " + color + " and radius " + radius + ".");
        return new DrawCircle(color, radius);
    }
}
