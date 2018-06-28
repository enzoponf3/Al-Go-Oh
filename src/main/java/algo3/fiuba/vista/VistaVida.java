package algo3.fiuba.vista;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaVida extends Label {

    Jugador jugador;

    Rectangle rectanguloVida = new Rectangle(200,150,Paint.valueOf("red"));
    //ImageView imagen = new ImageView(new Image("/algo3/fiuba/resources/img/Life_point_counter.jpg",
    //200, 150, false, false));

    public VistaVida(Jugador jugador) {
        this.jugador = jugador;
        this.setText("LP:");
        this.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        this.setGraphic(rectanguloVida);
        this.setTextFill(Color.WHITE);
        this.setContentDisplay(ContentDisplay.CENTER);
    }
}
