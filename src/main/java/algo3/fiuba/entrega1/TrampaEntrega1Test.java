package algo3.fiuba.entrega1;

import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import org.junit.Before;
import org.junit.Test;

public class TrampaEntrega1Test {
    private Trampa trampa;
    private Tablero tablero;

    @Before
    public void setUp() {
        trampa = new Trampa("n", new EfectoNulo());
        tablero = Tablero.getInstancia();
    }

    @Test(expected = RuntimeException.class)
    public void trampaBocaAbajoNoActivaEfecto() {
        trampa.pasarAModoJuego(BocaAbajo.getInstancia());
        tablero.colocarCarta(trampa, 1);
        trampa.activar();
    }

}
