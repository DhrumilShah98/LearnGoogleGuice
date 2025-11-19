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
            System.out.println("Sending a request to draw first square.");
            SquareRequest squareRequest1 = injector.getInstance(SquareRequest.class);
            squareRequest1.makeRequest();

            System.out.println("Sending a request to draw second square.");
            SquareRequest squareRequest2 = injector.getInstance(SquareRequest.class);
            squareRequest2.makeRequest();

            System.out.println("Are SquareRequest equal? " + (squareRequest1 == squareRequest2));
            System.out.println("Are Shape equal? " + (squareRequest1.getShape() == squareRequest2.getShape()));
        }
    }
}
