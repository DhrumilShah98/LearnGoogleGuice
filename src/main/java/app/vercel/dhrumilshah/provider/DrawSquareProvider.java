package app.vercel.dhrumilshah.provider;

import app.vercel.dhrumilshah.shape.DrawSquare;
import com.google.inject.Provider;

public class DrawSquareProvider implements Provider<DrawSquare> {

    public DrawSquareProvider() {
        System.out.println("Instantiating DrawSquareProvider object.");
    }

    @Override
    public DrawSquare get() {
        System.out.println("Getting a DrawSquare object.");
        return new DrawSquare("BLACK", 40);
    }
}
