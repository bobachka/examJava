package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.util.Objects;

public class Circle extends Figure {
    private final Logger logger = Logger.getLogger(Circle.class);
    private double radius;

    private Circle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_CIRCLE_ID, cx, cy, lineWidth, color);
    }

    public Circle(double cx, double cy, double lineWidth, Color color, double radius) {
        this(cx, cy, lineWidth, color);
        this.radius = radius < 10 ? 20 : radius;
    }

    @Override
    public String toString() {
        return new StringBuilder("Circle{")
                .append("radius=").append(radius)
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
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public void drawFigure(GraphicsContext gContext) {
        logger.debug("Circle is gonna be drawn");
        gContext.setLineWidth(lineWidth);
        gContext.setStroke(color);
        gContext.strokeOval(cx - radius, cy - radius, radius * 2, radius * 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


}
