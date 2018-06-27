package algo3.fiuba.controladores;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;


public class ControladorMazo implements EventHandler<MouseEvent> {


    @Override
    public void handle(MouseEvent event) {

        ControladorTurnos ct = ControladorTurnos.getInstancia();
        Jugador actual = ct.getJugador();
        if (actual.getEstadoJugador() instanceof PreInvocacion ) {//


        } else {
            Alert errorMazo = new Alert(Alert.AlertType.INFORMATION);
            errorMazo.show();
        }
    }

    public void tomarCartaDelMazo() {

        ControladorMano controlMano = new ControladorMano();
        controlMano.agregarCartaAMano();
    }

}
