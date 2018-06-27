package algo3.fiuba.a_reacomodar;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoAgujeroNegro;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.modelo.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.vista.Tablero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MagicaEntrega1Test {

    private Jugador jugador;

    @Before
    public void setUp() {
        jugador = new Jugador();
        jugador.setEstadoJugador(new PreInvocacion());
    }

    @Test(expected = CartaInhabilitadaParaActivarseExcepcion.class)
    public void cartaBocaAbajoNoActivaEfecto() {
        Magica carta = new AgujeroNegro(jugador);
        jugador.colocarCartaEnCampo((Carta) carta, new BocaAbajo());
        carta.activarEfecto();
    }
}
