package algo3.fiuba.controladores;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.ContenedorPrincipal;

public class ControladorDeTurno {

    private static ControladorDeTurno INSTANCIA;
    private Jugador jugador1, jugador2;

    public static ControladorDeTurno getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new ControladorDeTurno();
        return INSTANCIA;
    }

    public ControladorDeTurno() {
        //preg rodri
        //this.jugador1 = J1;
        //this.jugador2 = J2;
    }

    public Jugador getJugador() {

       return jugador1;
    }
}
