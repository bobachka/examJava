package com.stormnet.fugeresfx.controller;

import com.stormnet.fugeresfx.draw_utils.Drawer;
import com.stormnet.fugeresfx.exeptions.IncorrectShapeException;
import com.stormnet.fugeresfx.exeptions.LowShurikenAxisCoeffExeption;
import com.stormnet.fugeresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private final Logger logger = Logger.getLogger(MainScreenViewController.class);

    private List<Figure> figures;
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.trace("We're about to start. Mind the gap!");
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    private Figure createFigure(double x, double y) throws IncorrectShapeException, LowShurikenAxisCoeffExeption {
        Figure figure;
        switch (random.nextInt(5)) {
            case Figure.FIGURE_CIRCLE_ID:
                figure = new Circle(x, y, Math.min(random.nextInt(20), 10), Color.AQUAMARINE, random.nextInt(50));
                break;
            case Figure.FIGURE_RECTANGLE_ID:
                figure = new Rectangle(x, y, Math.min(random.nextInt(20), 10), Color.LAVENDER,
                        random.nextInt(40) + 10, random.nextInt(40) + 10);
                break;
            case Figure.FIGURE_TRIANGLE_ID:
                figure = new Triangle(x, y, random.nextInt(5) + 5, Color.YELLOWGREEN);
                break;
            case Figure.FIGURE_SHURIKEN_ID:
                figure = new Shuriken(x, y, random.nextInt(2) + 5, Color.FIREBRICK);
                break;
            default:
                throw new IncorrectShapeException("Unknown figure");
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        try {
            logger.info(figures.add(createFigure(mouseEvent.getX(), mouseEvent.getY())));
        } catch (IncorrectShapeException | LowShurikenAxisCoeffExeption e) {
            logger.error(e.getMessage(), e);
        }
        repaint();
    }
}
