package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.annotation.DefaultShapeColor;
import app.vercel.dhrumilshah.annotation.DefaultSquareEdge;
import app.vercel.dhrumilshah.provider.DrawSquareProvider;
import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class ShapeModule extends AbstractModule {

    public ShapeModule() {
        System.out.println("Instantiating ShapeModule object.");
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(DefaultShapeColor.class).toInstance("BLACK");
        bind(Integer.class).annotatedWith(DefaultSquareEdge.class).toInstance(40);
        bind(DrawShape.class).toProvider(DrawSquareProvider.class).in(Scopes.SINGLETON);
    }
}
