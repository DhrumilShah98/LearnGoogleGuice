package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.annotation.*;
import app.vercel.dhrumilshah.shape.DrawCircle;
import app.vercel.dhrumilshah.shape.DrawShape;
import app.vercel.dhrumilshah.shape.DrawSquare;
import com.google.inject.AbstractModule;

public class ShapeModule extends AbstractModule {

    public ShapeModule() {
        System.out.println("Instantiating ShapeModule object.");
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(DefaultColor.class).toInstance("BLACK");
        bind(Integer.class).annotatedWith(DefaultSquareEdge.class).toInstance(40);
        bind(Integer.class).annotatedWith(DefaultCircleRadius.class).toInstance(30);
        bind(DrawShape.class).annotatedWith(Square.class).to(DrawSquare.class);
        bind(DrawShape.class).annotatedWith(Circle.class).to(DrawCircle.class);
    }
}
