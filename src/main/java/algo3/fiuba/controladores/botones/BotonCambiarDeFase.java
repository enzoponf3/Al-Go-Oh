package algo3.fiuba.controladores.botones;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCambiarDeFase implements EventHandler<ActionEvent> {

    ControladorDeTurnos ct = ControladorDeTurnos.getInstancia();

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
