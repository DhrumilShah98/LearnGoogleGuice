package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.annotation.DefaultCircleRadius;
import app.vercel.dhrumilshah.annotation.DefaultColor;
import app.vercel.dhrumilshah.annotation.DefaultSquareEdge;
import app.vercel.dhrumilshah.request.CircleRequest;
import app.vercel.dhrumilshah.request.SquareRequest;
import app.vercel.dhrumilshah.shape.DrawCircle;
import app.vercel.dhrumilshah.shape.DrawShape;
import app.vercel.dhrumilshah.shape.DrawSquare;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ShapeModule extends AbstractModule {

    public ShapeModule() {
        System.out.println("Instantiating ShapeModule object.");
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(DefaultColor.class).toInstance("BLACK");
        bind(Integer.class).annotatedWith(DefaultSquareEdge.class).toInstance(40);
        bind(Integer.class).annotatedWith(DefaultCircleRadius.class).toInstance(30);
        bind(DrawShape.class).annotatedWith(Names.named(SquareRequest.SQUARE)).to(DrawSquare.class);
        bind(DrawShape.class).annotatedWith(Names.named(CircleRequest.CIRCLE)).to(DrawCircle.class);
    }
}
