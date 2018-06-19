package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;
import java.util.List;

public class EfectoWasteland implements EfectoCarta {
    @Override
    public void activar(Juego juego, Carta carta) {
        juego.activarEfecto(this, carta);
    }

    public void aumentarATKPropio(Carta carta) {
        carta.aumentarATKPropio(200);
    }

    public void aumentarDEFOponente(Carta carta) {
        carta.aumentarDEFOponente(300);
    }
}
