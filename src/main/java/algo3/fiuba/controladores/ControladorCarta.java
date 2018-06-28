package algo3.fiuba.controladores;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorCarta implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent evento) {

        ControladorTurnos ct = ControladorTurnos.getInstancia();
        //Jugador act = ct.getJugadorActual();

    }

    public void jugarEnModoDefensa(/*Carta carta*/) {
        //carta.setRotate(90);
    }

    public void activar(/*Carta*/) {

    }

    public void mandarAlCementerio() {

    }


}
