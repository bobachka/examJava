package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.util.Objects;

public class Rectangle extends Figure {
    private final Logger logger = Logger.getLogger(Circle.class);

    private double width;
    private double height;

    private Rectangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_RECTANGLE_ID, cx, cy, lineWidth, color);
    }

    public Rectangle(double cx, double cy, double lineWidth, Color color, double width, double height) {
        this(cx, cy, lineWidth, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return new StringBuilder("Rectangle{")
                .append("width=").append(width)
                .append(", height=").append(height)
                .append(", cx=").append(cx)
                .append(", cy=").append(cy)
                .append(", lineWidth=").append(lineWidth)
                .append(", color=").append(color)
                .append('}')
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 &&
                Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public void drawFigure(GraphicsContext gContext) {
        logger.debug("Rectangle is gonna be drawn");
        gContext.setLineWidth(lineWidth);
        gContext.setStroke(color);
        gContext.strokeRect(cx - width / 2, cy - height / 2, width, height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
