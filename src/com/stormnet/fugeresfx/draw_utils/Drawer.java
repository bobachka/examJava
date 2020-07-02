package com.stormnet.fugeresfx.draw_utils;

import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Drawer<T extends Drawable> {
    private final List<T> figures;

    public Drawer(List<T> figures) {
        this.figures = figures;
    }

    public void draw(GraphicsContext graphicsContext) {
        for (T figure : figures) {
            figure.drawFigure(graphicsContext);
        }
    }
}
