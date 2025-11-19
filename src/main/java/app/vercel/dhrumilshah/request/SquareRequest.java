package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.annotation.Square;
import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.Inject;

public class SquareRequest {
    private final DrawShape shape;

    @Inject
    public SquareRequest(@Square DrawShape shape) {
        System.out.println("Instantiating SquareRequest object.");
        this.shape = shape;
    }

    public void makeRequest() {
        shape.draw();
    }
}
