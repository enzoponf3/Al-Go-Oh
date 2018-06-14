package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Trampa;

public class Tablero {

    private static Tablero INSTANCIA;

    private TableroJugador tableroJugador1;
    private TableroJugador tableroJugador2;

    private Tablero() {
        this.tableroJugador1 = new TableroJugador();
        this.tableroJugador2 = new TableroJugador();
    }

    public static Tablero getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new Tablero();

        return INSTANCIA;
    }

    public void empezarDuelo(Jugador jugador1, Jugador jugador2) {
        jugador1.setTableroJugador(tableroJugador1);
        jugador2.setTableroJugador(tableroJugador2);
    }

    public void colocarCarta(Carta carta, int jugador) {
        // Podemos modificarlo con algo de turno.
        /*
        if(jugador == 1) {
            tableroJugador1.colocarCartaEnTablero(carta);
        }
        else {
            tableroJugador2.colocarCartaEnTablero(carta);
        }
        */
    }

    public Integer monstruosEnJuego() {
        return (tableroJugador1.monstruosEnJuego() + tableroJugador2.monstruosEnJuego());
    }

    // Se tiene que hacer dentro del campo del jugador correspondiente... Pero hardcodeo porque TDD. :)
    public void activarCarta(Carta carta) {
        carta.activar();
    }
}
