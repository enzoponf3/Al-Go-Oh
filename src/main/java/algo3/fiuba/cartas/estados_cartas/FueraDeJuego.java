package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.efectos.EfectoCarta;

public abstract class FueraDeJuego implements EstadoCarta {

    public boolean estaEnJuego() {
        return false;//throw new RuntimeException("La carta no se ha jugado aún.");
    }

    @Override
    public void activar(Juego juego, Carta carta, EfectoCarta efecto) {
        // no hace nada.
    }
}
