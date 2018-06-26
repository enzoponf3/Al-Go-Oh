package algo3.fiuba.modelo.excepciones;

public class CampoNoPermiteColocarCartaExcepcion extends RuntimeException {

    public CampoNoPermiteColocarCartaExcepcion(String message) {
        super(message);
    }
}
