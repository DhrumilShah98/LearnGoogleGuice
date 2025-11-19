package app.vercel.dhrumilshah;

import app.vercel.dhrumilshah.module.CircleModule;
import app.vercel.dhrumilshah.module.SquareModule;
import app.vercel.dhrumilshah.request.CircleRequest;
import app.vercel.dhrumilshah.request.SquareRequest;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Demo {
    private static final String SQUARE = "SQUARE";
    private static final String CIRCLE = "CIRCLE";

    public static void main(String[] args) {
        String shape = args[0];

        System.out.println("Creating injector.");
        Injector injector = Guice.createInjector(new SquareModule(), new CircleModule());

        if (SQUARE.equalsIgnoreCase(shape)) {
            System.out.println("Sending a request to draw a square.");
            SquareRequest squareRequest = injector.getInstance(SquareRequest.class);
            System.out.println("Initiating a request to draw a square.");
            squareRequest.makeRequest();
        }

        if (CIRCLE.equalsIgnoreCase(shape)) {
            System.out.println("Sending a request to draw a circle.");
            CircleRequest circleRequest = injector.getInstance(CircleRequest.class);
            System.out.println("Initiating a request to draw a circle.");
            circleRequest.makeRequest();
        }
    }
}
