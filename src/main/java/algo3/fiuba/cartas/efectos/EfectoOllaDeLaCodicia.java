package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;

import java.util.List;

public class EfectoOllaDeLaCodicia implements EfectoCarta {
    private Jugador jugador;

    @Override
    public void activar(Juego juego, Carta carta) {
        robar2Cartas(jugador);
    }

    public EfectoOllaDeLaCodicia(Jugador jugador){
        this.jugador = jugador;

    }
    public void robar2Cartas(Jugador jugador) {
        jugador.tomarCartaDelMazo();
        jugador.tomarCartaDelMazo();
    }
}

