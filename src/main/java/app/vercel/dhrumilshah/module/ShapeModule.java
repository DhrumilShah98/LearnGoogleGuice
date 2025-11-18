package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.shape.DrawShape;
import app.vercel.dhrumilshah.shape.DrawSquare;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class ShapeModule extends AbstractModule {

    public ShapeModule() {
        System.out.println("Instantiating ShapeModule object.");
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("DefaultShapeColor")).toInstance("BLACK");
        bind(Integer.class).annotatedWith(Names.named("DefaultSquareEdge")).toInstance(40);
    }

    @Provides
    @Singleton
    private DrawShape provideDefaultDrawSquare(@Named("DefaultShapeColor") String color,
                                               @Named("DefaultSquareEdge") Integer edge) {
        System.out.println("Providing a default DrawSquare object of color " + color + " and edge " + edge + ".");
        return new DrawSquare(color, edge);
    }
}
