package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.provider.DrawSquareProvider;
import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.AbstractModule;

public class ShapeModule extends AbstractModule {

    public ShapeModule() {
        System.out.println("Instantiating ShapeModule object.");
    }

    @Override
    protected void configure() {
        bind(DrawShape.class).toProvider(DrawSquareProvider.class);
    }
}
