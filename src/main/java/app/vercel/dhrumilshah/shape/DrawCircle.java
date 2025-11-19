package app.vercel.dhrumilshah.shape;

public class DrawCircle implements DrawShape {

    public DrawCircle() {
        System.out.println("Instantiating DrawCircle object.");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}
