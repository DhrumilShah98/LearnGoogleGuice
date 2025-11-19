package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.annotation.Square;
import app.vercel.dhrumilshah.shape.DrawShape;
import app.vercel.dhrumilshah.shape.DrawSquare;
import com.google.inject.AbstractModule;

public class SquareModule extends AbstractModule {

    public SquareModule() {
        System.out.println("Instantiating SquareModule object.");
    }

    @Override
    protected void configure() {
        bind(DrawShape.class).annotatedWith(Square.class).to(DrawSquare.class);
    }
}
