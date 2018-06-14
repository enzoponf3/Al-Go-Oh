package algo3.fiuba.cartas.estados_cartas;

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

}
