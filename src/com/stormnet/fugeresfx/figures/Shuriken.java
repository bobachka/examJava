package com.stormnet.fugeresfx.figures;

import com.stormnet.fugeresfx.exeptions.LowShurikenAxisCoeffExeption;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class Shuriken extends Figure {
    private final Logger logger = Logger.getLogger(Shuriken.class);

    private double[] xPoints = new double[8];
    private double[] yPoints = new double[8];

    public Shuriken(double cx, double cy, double lineWidth, Color color) throws LowShurikenAxisCoeffExeption {
        super(FIGURE_SHURIKEN_ID, cx, cy, lineWidth, color);
        Random random = new Random(System.currentTimeMillis());
        double axis = random.nextDouble() * 20 + 10;
        double shurikenAxisCoeff = random.nextDouble() * 6;
        if (shurikenAxisCoeff == 0) {
            logger.warn("coeff = 0; exception may occur");
        } else if (shurikenAxisCoeff <= 2) {
            throw new LowShurikenAxisCoeffExeption("Axis Coefficient must be > 2, so the figure will look like shuriken");
        }
        xPoints[0] = cx - axis;
        xPoints[1] = cx - axis / shurikenAxisCoeff;
        xPoints[2] = cx;
        xPoints[3] = cx + axis / shurikenAxisCoeff;
        xPoints[4] = cx + axis;
        xPoints[5] = cx + axis / shurikenAxisCoeff;
        xPoints[6] = cx;
        xPoints[7] = cx - axis / shurikenAxisCoeff;
        yPoints[0] = cy;
        yPoints[1] = cy + axis / shurikenAxisCoeff;
        yPoints[2] = cy + axis;
        yPoints[3] = cy + axis / shurikenAxisCoeff;
        yPoints[4] = cy;
        yPoints[5] = cy - axis / shurikenAxisCoeff;
        yPoints[6] = cy - axis;
        yPoints[7] = cy - axis / shurikenAxisCoeff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shuriken shuriken = (Shuriken) o;
        return Arrays.equals(xPoints, shuriken.xPoints) &&
                Arrays.equals(yPoints, shuriken.yPoints);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(xPoints);
        result = 31 * result + Arrays.hashCode(yPoints);
        return result;
    }

    @Override
    public void drawFigure(GraphicsContext gContext) {
        logger.debug("Shuriken is gonna be drawn");
        gContext.setLineWidth(lineWidth);
        gContext.setStroke(color);
        gContext.strokePolygon(xPoints, yPoints, 8);
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
        final StringBuilder sb = new StringBuilder("Shuriken{");
        sb.append("xPoints=").append(Arrays.toString(xPoints));
        sb.append(", yPoints=").append(Arrays.toString(yPoints));
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
