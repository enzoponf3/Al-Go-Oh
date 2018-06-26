package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

public class EnCementerio extends FueraDeJuego {

    @Override
    public boolean estaEnJuego() {
        return false;
    }

    @Override
    public void verificarQuePuedeAtacar() {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("No puede atacar si se encuentra en el cementerio.");
    }

}
