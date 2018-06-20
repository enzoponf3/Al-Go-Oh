package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;

public class EfectoCilindroMagico extends EfectoCarta {

    private Jugador jugador;

    public EfectoCilindroMagico(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void activar(Carta carta, Monstruo atacante) {
        jugador.daniarPuntosDeVidaOponente(atacante.getAtaque());
    }
}
