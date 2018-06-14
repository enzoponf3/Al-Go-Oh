package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.cartas.efectos.EfectoCarta;

public class FueraDeJuego implements EstadoCarta {

    public boolean estaEnJuego() {
        throw new RuntimeException("La carta no se ha jugado aún.");
    }

    @Override
    public void activar(EfectoCarta efecto) {
        // no hace nada.
    }
}
