package algo3.fiuba.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;

public class CanvasTablero extends Canvas{

    public CanvasTablero(Double w, Double h) {

        super(w, h);
    }

    public void drawInCanvas(GraphicsContext gc) {

        gc.strokeRect(10,10.0, 101.0, 128.0);
        gc.strokeRect(10,212.0, 101.0, 128.0);
        gc.strokeRect(850.0, 212.0, 101.0, 128.0);
        gc.strokeRect(125, 113, 709, 227);
        gc.fillRect(125,226,709, 2);
        gc.fillRect(0.0, 354.0, 973.0, 15.0);
    }


}
