package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;

public class EfectoFisura implements EfectoCarta {
    private Jugador jugador;

    public EfectoFisura(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void activar(Juego juego, Carta carta) {

    }

    public void destruirMonstruoBocaArribaEnTableroConMenorAtaque(Jugador jugador) {

    }
}
