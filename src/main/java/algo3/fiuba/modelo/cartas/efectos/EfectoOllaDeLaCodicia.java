package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;

public class EfectoOllaDeLaCodicia extends EfectoCarta {

    private Jugador jugador;

    @Override
    public void activar(Carta carta) {
        robar2Cartas();
    }

    public EfectoOllaDeLaCodicia(Jugador jugador) {
        this.jugador = jugador;
    }

    public void robar2Cartas() {
        jugador.tomarCartaDelMazo();
        jugador.tomarCartaDelMazo();
    }
}

