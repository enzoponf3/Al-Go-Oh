package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

import java.util.LinkedList;

public class Campo {


    public Campo() {

    }

    public boolean colocarCarta(Carta carta, EnJuego tipoEnJuego) {
        carta.pasarAModoJuego(tipoEnJuego);
        return true;
    }
}
