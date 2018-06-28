package algo3.fiuba.a_reacomodar;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
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

    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);
    }

    @Test
    public void cartaMagicaBocaAbajoSePuedeActivar_luegoVaAlCementerioInmediatamente() {
        Magica carta = new AgujeroNegro(jugador1);
        jugador1.colocarCartaEnCampo((Carta) carta, new BocaAbajo());
        carta.activarEfecto();

        Assert.assertFalse(carta.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(carta));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(carta));
    }
}
