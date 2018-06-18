package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;
import java.util.List;

public class EfectoAgujeroNegro implements EfectoCarta {
    @Override
    public void activar(Juego juego, Carta carta) {
        juego.activarEfecto(this);
    }

    public void matarMonstruos(Tablero tablero) {
        tablero.matarMonstruos();
    }
}
