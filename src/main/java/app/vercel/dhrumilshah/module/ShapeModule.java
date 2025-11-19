package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.annotation.DefaultCircleRadius;
import app.vercel.dhrumilshah.annotation.DefaultShapeColor;
import app.vercel.dhrumilshah.annotation.DefaultSquareEdge;
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
    }
}
