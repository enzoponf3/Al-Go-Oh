package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;

public class EfectoInsectoComeHombres implements EfectoCarta {

    private Tablero tablero;
    private Jugador jugadorRival;

    public EfectoInsectoComeHombres() {
        this.tablero = Tablero.getInstancia();

    }

    @Override
    public void activar(Juego juego, Carta carta) {

    }
}
