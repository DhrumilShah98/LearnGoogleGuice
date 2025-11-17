package app.vercel.dhrumilshah.request;

import app.vercel.dhrumilshah.shape.DrawShape;

public class SquareRequest {
    DrawShape shape;

    public SquareRequest(DrawShape shape) {
        System.out.println("Instantiating SquareRequest object.");
        this.shape = shape;
    }

    public void makeRequest() {
        shape.draw();
    }
}
