package br.com.edu.ufca;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML // fx:id="room"
    private AnchorPane room; // Value injected by FXMLLoader

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="circlePoint"
    private Circle circlePoint; // Value injected by FXMLLoader

    @FXML // fx:id="distanceLine"
    private Line distanceLine; // Value injected by FXMLLoader

    @FXML // fx:id="coordinatesText"
    private Text coordinatesText; // Value injected by FXMLLoader

    @FXML // fx:id="distanceText"
    private Text distanceText; // Value injected by FXMLLoader

    private double mouseAnchorX;
    private double mouseAnchorY;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert circlePoint != null
                : "fx:id=\"circlePoint\" was not injected: check your FXML file 'primary.fxml'.";
        assert coordinatesText != null
                : "fx:id=\"coordinatesText\" was not injected: check your FXML file 'primary.fxml'.";

        // Setup positions
        double startX = room.getPrefWidth() / 2d;
        double startY = room.getPrefHeight() / 2d;
        double circleRadius = circlePoint.getRadius();

        // Coordinates
        coordinatesText.setX(startX + circleRadius);
        coordinatesText.setY(startY + circleRadius);

        // Distance
        distanceText.setX(startX - distanceText.getLayoutBounds().getWidth() / 2d);
        distanceText.setY(startY);

        // Makes Circle Draggable
        circlePoint.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });

        circlePoint.setOnMouseDragged(mouseEvent -> {
            double x = mouseEvent.getSceneX() - mouseAnchorX;
            double y = mouseEvent.getSceneY() - mouseAnchorY;

            // Circle point
            circlePoint.setLayoutX(x);
            circlePoint.setLayoutY(y);

            // Coordinates
            coordinatesText.setText(String.format("(%.0f, %.0f)", x, y));
            // TODO -> Rotate text offset in direction to origin
            coordinatesText.setX(startX + circleRadius + x);
            coordinatesText.setY(startY + circleRadius + y);

            // Distance
            distanceText.setX(
                    startX - distanceText.getLayoutBounds().getWidth() / 2d + x / 2d);
            distanceText.setY(startY + y / 2d);
            distanceText.setText(String.format(
                    "%.0f", DistanceCalculator.getDistance(0d, 0d, x, y)));

            distanceLine.setEndX(startX + x);
            distanceLine.setEndY(startY + y);
        });
    }

}
