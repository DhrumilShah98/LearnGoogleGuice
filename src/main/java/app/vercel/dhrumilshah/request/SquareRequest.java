package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.shape.DrawShape;
import com.google.inject.Inject;

public class SquareRequest {
    DrawShape shape;

    public SquareRequest() {
        System.out.println("Instantiating SquareRequest object.");
    }

    @Inject
    public void setDrawShape(DrawShape shape) {
        System.out.println("Setting shape in SquareRequest.");
        this.shape = shape;
    }

    public void makeRequest() {
        shape.draw();
    }
}
