package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.moldes_cartas.*;
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
    public void leSacoLaMismaCantidadPuntosDeVidaDeLosQueTiene_elJugadorPierde() {
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
        Carta carta = new Monstruo("m", 1000, 1000, 1, new EfectoNulo());
        jugador.agregarCartaAMazo(carta);

        jugador.tomarCartaDelMazo();
        Assert.assertEquals(jugador.cantidadCartas(), cantidadInicialCartas);
    }

 /*   @Test
    public void jugadorConsigueAExodia() {

        Juego
        Monstruo parteExodia1 = new PiernaDerechaExodia(jugador);
        Monstruo parteExodia2 = new PiernaIzquierdaExodia(jugador);
        Monstruo parteExodia3 = new CabezaExodia(jugador);
        Monstruo parteExodia4 = new BrazoDerechoExodia(jugador);
        Monstruo parteExodia5 = new BrazoIzquierdoExodia(jugador);

        Integer cant = 5;

        jugador.agregarCartaAMano(parteExodia1);
        jugador.agregarCartaAMano(parteExodia2);
        jugador.agregarCartaAMano(parteExodia3);
        jugador.agregarCartaAMano(parteExodia4);
        jugador.agregarCartaAMano(parteExodia5);

        jugador.cartaEstaEnMano(parteExodia5);
        parteExodia5.activar(new Juego(jugador, jugador, tablero));
        //Assert.assertEquals(jugador.cantidadCartas(), cant);
    }
   /*
    test de mazo vacio del jugador... ver inicializar mazo apenas empieza el juego o cargarlo...
    @Test
    public void extraerTodasLasCartasDelMazo_elJugadorPierde() {

        //Agrego dos cartas iguales al mazo
        Carta carta = new Monstruo("m", 1000, 1000, 1, new EfectoNulo());
        jugador.agregarCartaAMazo(carta);
        jugador.agregarCartaAMazo(carta);

        //Las tomo
        jugador.tomarCartaDelMazo();
        jugador.tomarCartaDelMazo();

        //Sin cartas, el jugador esta fuera de juego
        Assert.assertFalse(jugador.estaEnJuego());
    }*/
}
