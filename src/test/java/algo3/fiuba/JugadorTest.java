package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JugadorTest {

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
        Assert.assertEquals(jugador.cantidadCartasEnMano(), Integer.valueOf(0));
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
        Integer cantidadInicialCartas = jugador.cantidadCartasEnMano() + 1;
        Carta carta = new Monstruo("m", 1000, 1000, 1, new EfectoNulo());
        jugador.agregarCartaAMazo(carta);

        jugador.tomarCartaDelMazo();
        Assert.assertEquals(jugador.cantidadCartasEnMano(), cantidadInicialCartas);
    }
}
