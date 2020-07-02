package com.stormnet.fugeresfx.drawUtils;

import com.stormnet.fugeresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Drawer<T extends Figure & Drawable> {
    private List<T> figures;

    public Drawer(List<T> figures) {
        this.figures = figures;
    }

    public void draw(GraphicsContext graphicsContext) {
        for (T figure : figures) {
            figure.drawFigure(graphicsContext);
        }
    }
}
