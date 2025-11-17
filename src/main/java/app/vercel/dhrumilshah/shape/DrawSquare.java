package app.vercel.dhrumilshah.shape;

public class DrawSquare implements DrawShape {

    public DrawSquare() {
        System.out.println("Instantiating DrawSquare object.");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square.");
    }
}
