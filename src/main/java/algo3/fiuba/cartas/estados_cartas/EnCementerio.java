package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

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
