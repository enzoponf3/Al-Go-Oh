package algo3.fiuba.excepciones;

public class CampoNoPermiteColocarCartaExcepcion extends RuntimeException {

    public CampoNoPermiteColocarCartaExcepcion(String message) {
        super(message);
    }
}
