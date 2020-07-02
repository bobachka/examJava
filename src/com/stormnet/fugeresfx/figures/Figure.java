package com.stormnet.fugeresfx.figures;

import com.stormnet.fugeresfx.draw_utils.Drawable;
import javafx.scene.paint.Color;

public abstract class Figure implements Drawable {
    public static final int FIGURE_CIRCLE_ID = 0;
    public static final int FIGURE_RECTANGLE_ID = 1;
    public static final int FIGURE_TRIANGLE_ID = 2;
    public static final int FIGURE_SHURIKEN_ID = 3;

    private final int type;
    protected double cx;
    protected double cy;
    protected double lineWidth;
    protected Color color;

    public Figure(int type, double cx, double cy, double lineWidth, Color color) {
        this.type = type;
        this.cx = cx;
        this.cy = cy;
        this.lineWidth = lineWidth;
        this.color = color;
    }

    public int getType() {
        return type;
    }

    public double getCx() {
        return cx;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }

    public double getCy() {
        return cy;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
