package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.constant.Shape;
import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.Inject;

import java.util.Map;

public class ShapeRequest {
    Map<Shape, DrawShape> shapes;

    @Inject
    public ShapeRequest(Map<Shape, DrawShape> shapes) {
        System.out.println("Instantiating ShapeRequest object.");
        this.shapes = shapes;
    }

    public void makeRequest(Shape shape) {
        shapes.get(shape).draw();
    }
}
