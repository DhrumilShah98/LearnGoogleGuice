package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.constant.Shape;
import app.vercel.dhrumilshah.shape.DrawCircle;
import app.vercel.dhrumilshah.shape.DrawShape;
import app.vercel.dhrumilshah.shape.DrawSquare;
import app.vercel.dhrumilshah.shape.DrawTriangle;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class ShapeModule extends AbstractModule {

    public ShapeModule() {
        System.out.println("Instantiating ShapeModule object.");
    }

    private void configureShapes() {
        MapBinder<Shape, DrawShape> shapesBinder = MapBinder.newMapBinder(
                binder(),
                Shape.class,
                DrawShape.class
        );
        shapesBinder.addBinding(Shape.SQUARE).to(DrawSquare.class);
        shapesBinder.addBinding(Shape.CIRCLE).to(DrawCircle.class);
        shapesBinder.addBinding(Shape.TRIANGLE).to(DrawTriangle.class);
    }

    @Override
    protected void configure() {
        configureShapes();
    }
}
