package algo3.fiuba.controladores.botones;

import algo3.fiuba.controladores.ControladorTurnos;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class BotonCambiarDeFase implements EventHandler<ActionEvent> {

    ControladorTurnos ct = ControladorTurnos.getInstancia();

    @Override
    public void handle(ActionEvent event) {

        //ct.cambiarDeFase(); !!!! ESTO HAY QUE SACARL TODA LA CLASE PORQUE LO HACE EL MODELO
    }



    public String obtenerFaseActual() {

        if (ct.getJugador().getEstadoJugador() instanceof PreInvocacion)
            return "Fase de invocacion";
        else
            return "Fase de ataque!";
    }
}
