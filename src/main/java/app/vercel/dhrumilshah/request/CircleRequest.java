package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.annotation.Circle;
import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.Inject;

public class CircleRequest {
    DrawShape shape;

    @Inject
    public CircleRequest(@Circle DrawShape shape) {
        System.out.println("Instantiating CircleRequest object.");
        this.shape = shape;
    }

    public void makeRequest() {
        shape.draw();
    }
}
