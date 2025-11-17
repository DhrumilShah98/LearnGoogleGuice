package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.annotation.DefaultColor;
import app.vercel.dhrumilshah.annotation.DefaultSquareEdge;
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
        bind(DrawShape.class).to(DrawSquare.class);
    }
}
