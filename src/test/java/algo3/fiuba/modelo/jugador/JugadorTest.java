package algo3.fiuba.modelo.jugador;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.*;
import algo3.fiuba.modelo.excepciones.JugadorInhabilitadoParaColocarCartasExcepcion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JugadorTest {

    private Jugador jugador;
    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;
    private Turno turno;

    @Before
    public void setUp() {
        jugador = new Jugador();
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);

        turno = Turno.getInstancia();
    }


    @Test
    public void elJugadorRecienCreadoEstaVivo() {
        Assert.assertTrue(jugador.estaVivo());
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

        Assert.assertTrue(jugador.estaVivo());
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

        Assert.assertFalse(jugador.estaVivo());
        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(0));
    }

    @Test
    public void leSacoMasPuntosDeVidaDeLosQueTiene_elJugadorMuere_susPuntosDeVidaSonCero() {
        Integer puntosASacar = 8001;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertFalse(jugador.estaVivo());
        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(0));
    }

    @Test
    public void agregoUnaCartaALaMano_laCartaEstaEnLaMano() {
        Integer cantidadInicialCartas = jugador.cantidadCartasEnMano() + 1;
        Carta carta = new BebeDragon(jugador);
        jugador.agregarCartaAMazo(carta);

        jugador.tomarCartaDelMazo();
        Assert.assertEquals(jugador.cantidadCartasEnMano(), cantidadInicialCartas);
    }

    @Test
    public void empiezaElJuego_elJugador1PuedeInvocar() {
        Carta carta = new BebeDragon(jugador1);

        jugador1.colocarCartaEnCampo(carta, new BocaArriba());
    }

    @Test(expected = JugadorInhabilitadoParaColocarCartasExcepcion.class)
    public void empiezaElJuego_elJugador2NoPuedeInvocar() {
        Carta carta = new BebeDragon(jugador2);

        jugador2.colocarCartaEnCampo(carta, new BocaArriba());
    }

    @Test(expected = JugadorInhabilitadoParaColocarCartasExcepcion.class)
    public void empiezaElJuegoYPasaUnTurno_elJugador1NoPuedeInvocar() {
        turno.pasarTurno();
        Carta carta = new BebeDragon(jugador1);

        jugador1.colocarCartaEnCampo(carta, new BocaArriba());
    }

    @Test
    public void empiezaElJuegoYPasaUnTurno_elJugador2PuedeInvocar() {
        turno.pasarTurno();
        Carta carta = new BebeDragon(jugador2);

        jugador2.colocarCartaEnCampo(carta, new BocaArriba());
    }

    @Test(expected = JugadorInhabilitadoParaColocarCartasExcepcion.class)
    public void esElTurnoDelJugador1_realizaUnaInvocacion_yaNoPuedeInvocarMas() {
        Carta carta1 = new BebeDragon(jugador1);
        Carta carta2 = new Jinzo7(jugador1);

        jugador1.colocarCartaEnCampo(carta1, new BocaArriba());
        jugador1.colocarCartaEnCampo(carta2, new BocaArriba());
    }

    @Test(expected = JugadorInhabilitadoParaColocarCartasExcepcion.class)
    public void esElTurnoDelJugador1_realizaUnaInvocacion_elJugador2NoPuedeInvocarHastaQuePaseElTurnoExplicitamente() {
        Carta carta1 = new BebeDragon(jugador1);
        Carta carta2 = new Jinzo7(jugador1);

        jugador1.colocarCartaEnCampo(carta1, new BocaArriba());
        jugador2.colocarCartaEnCampo(carta2, new BocaArriba());
    }

    @Test(expected = JugadorInhabilitadoParaColocarCartasExcepcion.class)
    public void esElTurnoDelJugador2_realizaUnaInvocacion_yaNoPuedeInvocarMas() {
        Carta carta1 = new BebeDragon(jugador2);
        Carta carta2 = new Jinzo7(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo(carta1, new BocaArriba());
        jugador2.colocarCartaEnCampo(carta2, new BocaArriba());
    }


    @Test
    public void extraerTodasLasCartasDelMazo_elJugadorPierde() {

        //Agrego dos cartas iguales al mazo
        Carta carta1 = new Kuriboh(jugador1);
        Carta carta2 = new Kuriboh(jugador1);
        jugador.agregarCartaAMazo(carta1);
        jugador.agregarCartaAMazo(carta2);

        //Las tomo
        jugador.tomarCartaDelMazo();
        jugador.tomarCartaDelMazo();

        //Sin cartas, el jugador esta fuera de juego
        Assert.assertFalse(jugador.estaEnJuego());
    }
}
