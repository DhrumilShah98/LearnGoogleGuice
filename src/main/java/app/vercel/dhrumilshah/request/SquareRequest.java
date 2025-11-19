package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.Inject;

public class SquareRequest {
    DrawShape shape;

    @Inject
    public SquareRequest(DrawShape shape) {
        System.out.println("Instantiating SquareRequest object.");
        this.shape = shape;
    }

    public void makeRequest() {
        shape.draw();
    }

    public DrawShape getShape() {
        return shape;
    }
}
