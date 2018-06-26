package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

public class EnMazo extends FueraDeJuego {

    @Override
    public void verificarQuePuedeAtacar() {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("No puede atacar cuando está en el mazo.");
    }
}
