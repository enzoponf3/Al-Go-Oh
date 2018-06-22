package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;

public class EfectoJinzo7 extends EfectoCarta {

    private Jugador jugador;
    private Integer danio;

    public EfectoJinzo7(Jugador jugador, Integer danio) {
        this.jugador = jugador;
        this.danio = danio;
    }

    @Override
    public void activar(Carta carta) {
        jugador.getOponente().modificarPuntosDeVida(-danio);
    }

}
