package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.shape.DrawCircle;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class CircleRequest {
    Provider<DrawCircle> shape;

    @Inject
    public CircleRequest(Provider<DrawCircle> shape) {
        System.out.println("Instantiating CircleRequest object.");
        this.shape = shape;
    }

    public void makeRequest() {
        // Calling 'get()' instantiates DrawCircleProvider and gets DrawCircle
        shape.get().draw();
    }
}
