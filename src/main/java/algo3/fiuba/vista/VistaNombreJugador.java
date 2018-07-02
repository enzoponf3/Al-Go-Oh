package algo3.fiuba.vista;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaNombreJugador extends Label {

    private Jugador jugador;

    public VistaNombreJugador(Jugador jugador) {
        this.jugador = jugador;
        update();
    }

    public void update() {
        super.setText(jugador.getNombre());
        super.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        super.setTextFill(Color.WHITE);
    }
}
