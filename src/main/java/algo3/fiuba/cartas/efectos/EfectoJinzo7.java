package algo3.fiuba.cartas.efectos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Carta;

public class EfectoJinzo7 extends EfectoCarta {

    private Jugador oponente;
    private Integer danio;

    public EfectoJinzo7(Jugador oponente, Integer danio) {
        this.oponente = oponente;
        this.danio = danio;
    }

    @Override
    public void activar(Carta carta) {
        oponente.modificarPuntosDeVida(-danio);
    }

}
