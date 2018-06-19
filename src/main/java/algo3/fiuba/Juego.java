package algo3.fiuba;

import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.efectos.*;

public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;

    public Juego(Jugador jugador1, Jugador jugador2, Tablero tablero) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
    }

    public  void activarEfecto(EfectoWasteland wasteland, CartaCampo carta) {
        //wasteland.aumentarATKPropio();
    }

    public void activarEfecto(EfectoAgujeroNegro agujeroNegro) {
        agujeroNegro.matarMonstruos(tablero);
    }
    /*
    public void activarEfecto(EfectoOllaDeLaCodicia ollaDeLaCodicia) {
        ollaDeLaCodicia.robar2Cartas()
    }
    */
}
