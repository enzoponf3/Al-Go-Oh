package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;
import java.util.List;

public class EfectoAgujeroNegro extends EfectoCarta {
    @Override
    public void activar(Juego juego, Carta carta) {
        juego.activarEfecto(this);
    }

    @Override
    public void activar(Carta carta) {
    }

    @Override
    public void activar(Carta carta, Monstruo otraCarta) {

    }


    public void matarMonstruos(Tablero tablero) {
        tablero.matarMonstruos();
    }
}
