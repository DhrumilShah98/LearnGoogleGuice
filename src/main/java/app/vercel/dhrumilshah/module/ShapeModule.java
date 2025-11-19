package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.annotation.*;
import app.vercel.dhrumilshah.provider.DrawCircleProvider;
import app.vercel.dhrumilshah.provider.DrawSquareProvider;
import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.AbstractModule;

public class ShapeModule extends AbstractModule {

    public ShapeModule() {
        System.out.println("Instantiating ShapeModule object.");
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(DefaultShapeColor.class).toInstance("BLACK");
        bind(Integer.class).annotatedWith(DefaultSquareEdge.class).toInstance(40);
        bind(Integer.class).annotatedWith(DefaultCircleRadius.class).toInstance(30);
        bind(DrawShape.class).annotatedWith(Square.class).toProvider(DrawSquareProvider.class);
        bind(DrawShape.class).annotatedWith(Circle.class).toProvider(DrawCircleProvider.class);
    }
}
