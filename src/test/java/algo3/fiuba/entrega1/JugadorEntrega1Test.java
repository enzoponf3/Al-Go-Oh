package algo3.fiuba.entrega1;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JugadorEntrega1Test {

    private Jugador jugador;

    @Before
    public void setUp() {
        jugador = new Jugador();
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
    public void leSacoMenosPuntosDeVidaDeLosQueTiene_SigueVivo() {
        Integer puntosASacar = 7999;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertTrue(jugador.estaEnJuego());
    }

    @Test
    public void leSacoMenosPuntosDeVidaDeLosQueTiene_SusPuntosDeVidaSonLosAdecuados() {
        Integer puntosASacar = 7999;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(1));
    }

    @Test
    public void leSacoLaMismaCantidadPuntosDeVidaDeLosQueTiene_ElJugadorMuere() {
        Integer puntosASacar = 8000;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertFalse(jugador.estaEnJuego());
        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(0));
    }

    @Test
    public void leSacoMasPuntosDeVidaDeLosQueTiene_ElJugadorMuere_SusPuntosDeVidaSonCero() {
        Integer puntosASacar = 8001;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertFalse(jugador.estaEnJuego());
        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(0));
    }

    @Test
    public void agregoUnaCartaALaMano_LaCartaEstaEnLaMano() {
        Integer cantidadInicialCartas = jugador.cantidadCartas() + 1;
        Carta carta = new Monstruo("m", 1000, 1000);
        jugador.agregarCartaAMazo(carta);

        jugador.tomarCartaDelMazo();
        Assert.assertEquals(jugador.cantidadCartas(), cantidadInicialCartas);
    }

    @Test
    public void jugadorColocarCartaMonstruoEnManoEnTablero() {
        Carta carta = new Monstruo("m", 1000, 1000);
        jugador.agregarCartaAMazo(carta);
        jugador.tomarCartaDelMazo();
        Integer cantidadFinalCartas = jugador.cantidadCartas() - 1;

        jugador.colocarCartaEnTablero(carta);
        Assert.assertEquals(cantidadFinalCartas, jugador.cantidadCartas());
        Assert.assertTrue(jugador.cartaEnTablero(carta));
    }

    @Test (expected = RuntimeException.class)
    public void jugadorNoPuedeColocarCartaMonstruoEnTableroSinCartasEnMano() {
        Carta carta = new Monstruo("m", 1000, 1000);
        jugador.colocarCartaEnTablero(carta);
    }
}
