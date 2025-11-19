package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.shape.DrawSquare;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class SquareRequest {
    Provider<DrawSquare> shape;

    @Inject
    public SquareRequest(Provider<DrawSquare> shape) {
        System.out.println("Instantiating SquareRequest object.");
        this.shape = shape;
    }

    public void makeRequest() {
        // Calling 'get()' instantiates DrawSquareProvider and get DrawSquare
        shape.get().draw();
    }
}
