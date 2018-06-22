package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.efectos.*;

public class Juego {

    private static Juego INSTANCIA;

    private Jugador jugador1;
    private Jugador jugador2;

    private Juego() {

    }

    public static Juego getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new Juego();

        return INSTANCIA;
    }

    public void inicializar(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);
    }

    public void activarEfecto(EfectoWasteland wasteland, CartaCampo carta) {
        //wasteland.aumentarATKPropio();
    }



    public void activarEfecto(EfectoWasteland wasteland, Carta carta) {

    }

    public void activarEfecto(EfectoSogen sogen, Carta carta) {
    }

/*
    public void activarEfecto(EfectoRefuerzos refuerzos) {
        refuerzos.
    }
*/


}
