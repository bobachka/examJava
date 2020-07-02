package com.stormnet.fugeresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class Triangle extends Figure {
    private static final Logger logger = Logger.getLogger(Triangle.class);

    private double[] xPoints = new double[3];
    private double[] yPoints = new double[3];
    private Random random;

    public Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TRIANGLE_ID, cx, cy, lineWidth, color);
        random = new Random(System.currentTimeMillis());
        xPoints[0] = random.nextInt(120) - 60 + cx;
        xPoints[1] = random.nextInt(120) - 60 + cx;
        xPoints[2] = random.nextInt(120) - 60 + cx;
        yPoints[0] = random.nextInt(120) - 60 + cy;
        yPoints[1] = random.nextInt(120) - 60 + cy;
        yPoints[2] = random.nextInt(120) - 60 + cy;
    }

    public double[] getXPoints() {
        return xPoints;
    }

    public void setXPoints(double[] xPoints) {
        this.xPoints = xPoints;
    }

    public double[] getYPoints() {
        return yPoints;
    }

    public void setYPoints(double[] yPoints) {
        this.yPoints = yPoints;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("xPoints=").append(Arrays.toString(xPoints));
        sb.append(", yPoints=").append(Arrays.toString(yPoints));
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(xPoints, triangle.xPoints) &&
                Arrays.equals(yPoints, triangle.yPoints);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(xPoints);
        result = 31 * result + Arrays.hashCode(yPoints);
        return result;
    }

    @Override
    public void drawFigure(GraphicsContext gContext) {
        logger.debug("Triangle is gonna be drawn");
        gContext.setLineWidth(lineWidth);
        gContext.setStroke(color);
        gContext.strokePolygon(xPoints, yPoints, 3);
    }
}
