package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.shape.DrawShape;
import app.vercel.dhrumilshah.shape.DrawSquare;
import com.google.inject.AbstractModule;

public class ShapeModule extends AbstractModule {

    public ShapeModule() {
        System.out.println("Instantiating ShapeModule object.");
    }

    @Override
    protected void configure() {
        bind(String.class).toInstance("BLACK");
        bind(Integer.class).toInstance(40);
        bind(DrawShape.class).to(DrawSquare.class);
    }
}
