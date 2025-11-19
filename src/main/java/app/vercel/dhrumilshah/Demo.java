package app.vercel.dhrumilshah;

import app.vercel.dhrumilshah.constant.Shape;
import app.vercel.dhrumilshah.module.ShapeModule;
import app.vercel.dhrumilshah.request.ShapeRequest;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Demo {
    private static final String SQUARE = "SQUARE";
    private static final String CIRCLE = "CIRCLE";
    private static final String TRIANGLE = "TRIANGLE";

    public static void main(String[] args) {
        String shape = args[0];

        System.out.println("Creating injector.");
        Injector injector = Guice.createInjector(new ShapeModule());

        System.out.println("Getting a generic ShapeRequest object.");
        ShapeRequest shapeRequest = injector.getInstance(ShapeRequest.class);

        if (SQUARE.equalsIgnoreCase(shape)) {
            System.out.println("Sending a request to draw a square.");
            System.out.println("Initiating a request to draw a square.");
            shapeRequest.makeRequest(Shape.SQUARE);
        }

        if (CIRCLE.equalsIgnoreCase(shape)) {
            System.out.println("Sending a request to draw a circle.");
            System.out.println("Initiating a request to draw a circle.");
            shapeRequest.makeRequest(Shape.CIRCLE);
        }

        if (TRIANGLE.equalsIgnoreCase(shape)) {
            System.out.println("Sending a request to draw a triangle.");
            System.out.println("Initiating a request to draw a triangle.");
            shapeRequest.makeRequest(Shape.TRIANGLE);
        }
    }
}
