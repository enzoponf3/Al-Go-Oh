package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;

public class EfectoJinzo implements EfectoCarta {

    private Jugador jugadorRival;
    private Integer danio;

    public EfectoJinzo(Jugador jugadorRival, Integer danio) {
        this.jugadorRival = jugadorRival;
        this.danio = danio;
    }

    @Override
    public void activar(Juego juego, Carta carta) {
        jugadorRival.modificarPuntosDeVida(-danio);
    }

}
