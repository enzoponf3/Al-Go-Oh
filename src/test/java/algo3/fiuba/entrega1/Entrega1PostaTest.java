package algo3.fiuba.entrega1;

import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import org.junit.Test;

public class Entrega1PostaTest {

    @Test
    public void colacarUnaCartaDeMonstruoEnModoDeAtaque() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Tablero tablero = Tablero.getInstancia();
        tablero.empezarDuelo(jugador1, jugador2);

        jugador1.tomarCartaDelMazo();
    }
}
