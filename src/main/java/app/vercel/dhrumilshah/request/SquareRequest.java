package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.annotation.Square;
import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class SquareRequest {
    Provider<DrawShape> shape;

    @Inject
    public SquareRequest(@Square Provider<DrawShape> shape) {
        System.out.println("Instantiating SquareRequest object.");
        this.shape = shape;
    }

    public void makeRequest() {
        // Calling 'get()' instantiates DrawSquareProvider and get DrawSquare
        shape.get().draw();
    }
}
