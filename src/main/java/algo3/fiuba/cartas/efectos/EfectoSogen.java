package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.cartas.Carta;

public class EfectoSogen implements EfectoCarta{

    @Override
    public void activar(Juego juego, Carta carta) {
        juego.activarEfecto(this, carta);
    }

    public void aumentarDEFPropio(Carta carta) {
        carta.aumentarDEFPropio(500);
    }

    public void aumentarATKOponente(Carta carta) {
        carta.aumentarATKOponente(200);
    }
}
