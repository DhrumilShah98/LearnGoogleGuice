package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.annotation.*;
import app.vercel.dhrumilshah.shape.DrawCircle;
import app.vercel.dhrumilshah.shape.DrawShape;
import app.vercel.dhrumilshah.shape.DrawSquare;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class ShapeModule extends AbstractModule {

    public ShapeModule() {
        System.out.println("Instantiating ShapeModule object.");
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(DefaultShapeColor.class).toInstance("BLACK");
        bind(Integer.class).annotatedWith(DefaultEdge.class).toInstance(40);
        bind(Integer.class).annotatedWith(DefaultRadius.class).toInstance(30);
    }

    @Provides
    @Singleton
    @Square
    private DrawShape provideDefaultDrawSquare(@DefaultShapeColor String color,
                                               @DefaultEdge Integer edge) {
        System.out.println("Providing a default DrawSquare object of color " + color + " and edge " + edge + ".");
        return new DrawSquare(color, edge);
    }

    @Provides
    @Singleton
    @Circle
    private DrawShape provideDefaultDrawCircle(@DefaultShapeColor String color,
                                               @DefaultRadius Integer radius) {
        System.out.println("Providing a default DrawCircle object of color " + color + " and radius " + radius + ".");
        return new DrawCircle(color, radius);
    }
}
