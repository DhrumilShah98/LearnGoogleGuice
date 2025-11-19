package app.vercel.dhrumilshah.shape;

public class DrawTriangle implements DrawShape {

    public DrawTriangle() {
        System.out.println("Instantiating DrawTriangle object.");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a triangle.");
    }
}