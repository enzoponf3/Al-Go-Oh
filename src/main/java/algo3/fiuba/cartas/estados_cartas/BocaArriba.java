package algo3.fiuba.cartas.estados_cartas;

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

}
