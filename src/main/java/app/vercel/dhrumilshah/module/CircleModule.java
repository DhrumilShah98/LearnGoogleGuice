package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.annotation.Circle;
import app.vercel.dhrumilshah.shape.DrawCircle;
import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.AbstractModule;

public class CircleModule extends AbstractModule {

    public CircleModule() {
        System.out.println("Instantiating CircleModule object.");
    }

    @Override
    protected void configure() {
        bind(DrawShape.class).annotatedWith(Circle.class).to(DrawCircle.class);
    }
}
