package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;

public class EnCementerio extends FueraDeJuego {

    private static EnCementerio INSTANCIA;

    private EnCementerio(){

    }

    public static EnCementerio getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new EnCementerio();
        return INSTANCIA;
    }

    @Override
    public boolean estaEnJuego() {
        return false;
    }

    @Override
    public void verificarQuePuedeAtacar() {
        throw new InhabilitadoParaAtacarExcepcion("No puede atacar si se encuentra en el cementerio.");
    }

}
