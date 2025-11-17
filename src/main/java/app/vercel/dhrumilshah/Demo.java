package app.vercel.dhrumilshah;

import app.vercel.dhrumilshah.request.SquareRequest;
import app.vercel.dhrumilshah.shape.DrawShape;
import app.vercel.dhrumilshah.shape.DrawSquare;

public class Demo {
    private static final String SQUARE = "SQUARE";

    public static void main(String[] args) {
        String shape = args[0];

        if (SQUARE.equalsIgnoreCase(shape)) {
            DrawShape square = new DrawSquare();
            SquareRequest request = new SquareRequest(square);

            System.out.println("Making a request.");
            request.makeRequest();
        }
    }
}
