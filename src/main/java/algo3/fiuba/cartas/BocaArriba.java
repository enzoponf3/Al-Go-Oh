package algo3.fiuba.cartas;

public class BocaArriba extends EnJuego {

    private static BocaArriba INSTANCIA;

    private BocaArriba() {
    }

    public static BocaArriba INSTANCIA() {
        if (INSTANCIA == null){
            INSTANCIA = new BocaArriba();
        }

        return INSTANCIA;
    }

}
