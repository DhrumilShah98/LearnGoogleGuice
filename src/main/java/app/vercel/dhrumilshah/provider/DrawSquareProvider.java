package app.vercel.dhrumilshah.provider;

import app.vercel.dhrumilshah.annotation.DefaultShapeColor;
import app.vercel.dhrumilshah.annotation.DefaultSquareEdge;
import app.vercel.dhrumilshah.shape.DrawSquare;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class DrawSquareProvider implements Provider<DrawSquare> {
    private final String color;
    private final Integer edge;

    @Inject
    public DrawSquareProvider(@DefaultShapeColor String color, @DefaultSquareEdge Integer edge) {
        System.out.println("Instantiating DrawSquareProvider object of color " + color + " and edge " + edge + ".");
        this.color = color;
        this.edge = edge;
    }

    @Override
    public DrawSquare get() {
        System.out.println("Getting a DrawSquare object of color " + color + " and edge " + edge + ".");
        return new DrawSquare(color, edge);
    }
}
