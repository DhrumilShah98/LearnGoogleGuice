package app.vercel.dhrumilshah.module;

import app.vercel.dhrumilshah.shape.DrawShape;
import app.vercel.dhrumilshah.shape.DrawSquare;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ShapeModule extends AbstractModule {

    public ShapeModule() {
        System.out.println("Instantiating ShapeModule object.");
    }

    @Provides
    private DrawShape provideDefaultDrawSquare() {
        System.out.println("Providing a default DrawSquare object.");
        return new DrawSquare("BLACK", 40);
    }
}
