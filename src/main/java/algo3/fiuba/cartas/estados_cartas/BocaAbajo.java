package algo3.fiuba.cartas.estados_cartas;

public class BocaAbajo extends EnJuego {

    private static BocaAbajo INSTANCIA;

    private BocaAbajo() {
    }

    public static BocaAbajo INSTANCIA() {
        if (INSTANCIA == null){
            INSTANCIA = new BocaAbajo();
        }

        return INSTANCIA;
    }

}
