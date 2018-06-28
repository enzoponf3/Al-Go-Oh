package algo3.fiuba.controladores;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.VistaMano;

public class ControladorMano {

    private VistaMano vista;
    private Jugador jugador;

    public ControladorMano(VistaMano vista, Jugador jugador) {

        this.jugador = jugador;
        this.vista = vista;
    }


}
