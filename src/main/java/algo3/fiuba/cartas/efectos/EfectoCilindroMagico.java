package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;

public class EfectoCilindroMagico extends EfectoCarta {

    private Jugador oponente;

    public EfectoCilindroMagico(Jugador oponente) {
        this.oponente = oponente;
    }

    @Override
    public void activar(Carta carta, Monstruo atacante, Monstruo atacado) {
        oponente.modificarPuntosDeVida(-atacante.getAtaque());
    }
}
