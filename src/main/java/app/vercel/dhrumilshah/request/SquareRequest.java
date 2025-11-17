package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.Inject;

public class SquareRequest {
    @Inject
    DrawShape shape;

    public SquareRequest() {
        System.out.println("Instantiating SquareRequest object.");
    }

    public void makeRequest() {
        shape.draw();
    }
}
