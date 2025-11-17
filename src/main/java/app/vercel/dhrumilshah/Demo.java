package app.vercel.dhrumilshah;

import app.vercel.dhrumilshah.module.ShapeModule;
import app.vercel.dhrumilshah.request.SquareRequest;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Demo {
    private static final String SQUARE = "SQUARE";

    public static void main(String[] args) {
        String shape = args[0];

        System.out.println("Creating injector.");
        Injector injector = Guice.createInjector(new ShapeModule());

        if (SQUARE.equalsIgnoreCase(shape)) {
            SquareRequest squareRequest = injector.getInstance(SquareRequest.class);

            System.out.println("Sending a request to draw a square.");
            squareRequest.makeRequest();
        }
    }
}
