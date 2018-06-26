package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;

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
