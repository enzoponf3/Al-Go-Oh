package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.excepciones.InhabilitadaParaActivarseExcepcion;

public class BocaAbajo extends EnJuego {

    private static BocaAbajo INSTANCIA;

    private BocaAbajo() {
    }

    public static BocaAbajo getInstancia() {
        if (INSTANCIA == null){
            INSTANCIA = new BocaAbajo();
        }

        return INSTANCIA;
    }

    @Override
    public void activar(EfectoCarta efecto) {
        throw new InhabilitadaParaActivarseExcepcion("No se puede activar efecto de una carta boca abajo");
    }
}
