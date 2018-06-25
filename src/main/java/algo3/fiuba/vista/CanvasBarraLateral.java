package algo3.fiuba.vista;


import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.io.DataOutput;

public class CanvasBarraLateral extends Canvas {

    public CanvasBarraLateral(Double w, Double h) {

        super(w, h);
    }

    public void drawInCanvas(GraphicsContext gc, Double x, Double y) {
        gc.fillOval(x, y, 199.0, 86.0);
        gc.setFill(Color.WHITE);
        gc.fillText("ACA VAN LOS PUNTOS", x+20, y+50);
    }

}
