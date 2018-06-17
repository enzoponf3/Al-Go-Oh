package algo3.fiuba;

import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JugadorTest {

    private Jugador jugador;
    private Tablero tablero;

    @Before
    public void setUp() {
        jugador = new Jugador();
        tablero = Tablero.getInstancia();
        tablero.inicializar(jugador,jugador);
    }


    @Test
    public void elJugadorRecienCreadoEstaEnJuego() {
        Assert.assertTrue(jugador.estaEnJuego());
    }

    @Test
    public void elJugadorRecienCreadoNoTieneCartas() {
        Assert.assertEquals(jugador.cantidadCartas(), Integer.valueOf(0));
    }

    @Test
    public void elJugadorSeCreaCon8000PuntosDeVida() {
        Integer puntosDeVida = 8000;

        Assert.assertEquals(jugador.getPuntosDeVida(), puntosDeVida);
    }

    @Test
    public void leSacoMenosPuntosDeVidaDeLosQueTiene_sigueVivo() {
        Integer puntosASacar = 7999;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertTrue(jugador.estaEnJuego());
    }

    @Test
    public void leSacoMenosPuntosDeVidaDeLosQueTiene_susPuntosDeVidaSonLosAdecuados() {
        Integer puntosASacar = 7999;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(1));
    }

    @Test
    public void leSacoLaMismaCantidadPuntosDeVidaDeLosQueTiene_elJugadorMuere() {
        Integer puntosASacar = 8000;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertFalse(jugador.estaEnJuego());
        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(0));
    }

    @Test
    public void leSacoMasPuntosDeVidaDeLosQueTiene_elJugadorMuere_susPuntosDeVidaSonCero() {
        Integer puntosASacar = 8001;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertFalse(jugador.estaEnJuego());
        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(0));
    }

    @Test
    public void agregoUnaCartaALaMano_laCartaEstaEnLaMano() {
        Integer cantidadInicialCartas = jugador.cantidadCartas() + 1;
        Carta carta = new Monstruo("m", 1000, 1000, 0, EfectoNulo.getInstancia());
        jugador.agregarCartaAMazo(carta);

        jugador.tomarCartaDelMazo();
        Assert.assertEquals(jugador.cantidadCartas(), cantidadInicialCartas);
    }
}
