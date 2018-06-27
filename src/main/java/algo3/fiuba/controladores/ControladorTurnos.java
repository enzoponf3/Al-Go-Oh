package algo3.fiuba.controladores;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.ContenedorPrincipal;

public class ControladorTurnos {

    private static ControladorTurnos INSTANCIA;
    private Jugador jugador1, jugador2;

    public static ControladorTurnos getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new ControladorTurnos();
        return INSTANCIA;
    }

    public ControladorTurnos() {
        //preg rodri
        //this.jugador1 = J1;
        //this.jugador2 = J2;
    }

    public Jugador getJugador() {

       return jugador1;
    }
}
