package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class SquareRequest {
    public static final String SQUARE = "SQUARE";
    DrawShape shape;

    @Inject
    public SquareRequest(@Named(SQUARE) DrawShape shape) {
        System.out.println("Instantiating SquareRequest object.");
        this.shape = shape;
    }

    public void makeRequest() {
        shape.draw();
    }
}
