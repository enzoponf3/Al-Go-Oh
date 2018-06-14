package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.cartas.efectos.EfectoCarta;

public class BocaArriba extends EnJuego {

    private static BocaArriba INSTANCIA;

    private BocaArriba() {
    }

    public static BocaArriba getInstancia() {
        if (INSTANCIA == null){
            INSTANCIA = new BocaArriba();
        }

        return INSTANCIA;
    }

    @Override
    public void activar(EfectoCarta efecto) {
        // to do
    }
}
