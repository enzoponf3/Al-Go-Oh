package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

public class EnMazo extends FueraDeJuego {

    @Override
    public void verificarQuePuedeAtacar() {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("No puede atacar cuando está en el mazo.");
    }
}
