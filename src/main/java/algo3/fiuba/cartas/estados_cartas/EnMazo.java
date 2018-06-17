package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;

public class EnMazo extends FueraDeJuego {

    private static EnMazo INSTANCIA;

    private EnMazo() {

    }

    public static EstadoCarta getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new EnMazo();
        return INSTANCIA;
    }

    @Override
    public void verificarQuePuedeAtacar() {
        throw new InhabilitadoParaAtacarExcepcion("No puede atacar cuando está en el mazo.");
    }
}
