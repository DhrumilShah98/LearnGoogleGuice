package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.annotation.Circle;
import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class CircleRequest {
    Provider<DrawShape> shape;

    @Inject
    public CircleRequest(@Circle Provider<DrawShape> shape) {
        System.out.println("Instantiating CircleRequest object.");
        this.shape = shape;
    }

    public void makeRequest() {
        // Calling 'get()' instantiates DrawCircleProvider and gets DrawCircle
        shape.get().draw();
    }
}
