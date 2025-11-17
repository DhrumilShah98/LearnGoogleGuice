package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class CircleRequest {
    public static final String CIRCLE = "CIRCLE";
    DrawShape shape;

    @Inject
    public CircleRequest(@Named(CIRCLE) DrawShape shape) {
        System.out.println("Instantiating CircleRequest object.");
        this.shape = shape;
    }

    public void makeRequest() {
        shape.draw();
    }
}
