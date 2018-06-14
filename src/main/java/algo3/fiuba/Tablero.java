package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Trampa;

public class Tablero {

    private static Tablero tableroInstance = new Tablero();

    public TableroJugador tableroJ1, tableroJ2;

    public static Tablero getInstance() {

        return tableroInstance;
    }

    public Tablero() {

        this.tableroJ1 = new TableroJugador();
        this.tableroJ2 = new TableroJugador();
    }

    public void colocarCarta(Carta carta, int jugador) {
        // Podemos modificarlo con algo de turno.
        if(jugador == 1) {
            tableroJ1.colocarCartaEnTablero(carta);
        }
        else {
            tableroJ2.colocarCartaEnTablero(carta);
        }
    }

    public Integer monstruosEnJuego() {
        return (tableroJ1.monstruosEnJuego() + tableroJ2.monstruosEnJuego());
    }

    // Se tiene que hacer dentro del campo del jugador correspondiente... Pero hardcodeo porque TDD. :)
    public void activarCarta(Carta carta) {
        carta.activar();
    }
}
