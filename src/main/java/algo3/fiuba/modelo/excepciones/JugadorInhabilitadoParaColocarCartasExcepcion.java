package algo3.fiuba.modelo.excepciones;

import org.junit.Test;

public class JugadorInhabilitadoParaColocarCartasExcepcion extends RuntimeException {

    public JugadorInhabilitadoParaColocarCartasExcepcion(String message) {
        super(message);
    }
}
