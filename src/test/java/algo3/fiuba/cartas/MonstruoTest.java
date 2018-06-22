package algo3.fiuba.cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MonstruoTest {

    private Jugador jugador1;
    private Jugador jugador2;
//    private Tablero tablero;
    private Juego juego;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        /*
        tablero = Tablero.getInstancia();
        tablero.inicializar(jugador1,jugador2);
*/
        juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);


    }

    @Test(expected = InhabilitadoParaAtacarExcepcion.class)
    public void monstruoNoPuedeAtacarEnModoDefensa() {
        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", 1000, 1000, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 1500, 1500, 1, new EfectoNulo());

        monstruoAtacante.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugador1);

        monstruoDefensor.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);
    }

    @Test
    public void monstruoEnModoAtaquePuedeAtacarAMonstruoEnJuego() {
        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", 1000, 1000, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 1500, 1500, 1, new EfectoNulo());

        monstruoAtacante.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugador1);

        monstruoDefensor.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(true);
    }

    @Test
    public void atacarAMonstruoEnModoDefensa_DefensorTieneMenosPuntosDeDefensa_MuereElDefensor() {
        Integer puntosAtacante = 2000;
        Integer puntosDefensor = 1500;


        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor, 1, new EfectoNulo());

        monstruoAtacante.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugador1);


        monstruoDefensor.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertFalse(monstruoDefensor.estaEnJuego());
    }

    @Test
    public void atacarAMonstruoEnModoDefensa_DefensorTieneMasPuntosDeDefensa_NoMuereNadie() {
        Integer puntosAtacante = 1000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor, 1, new EfectoNulo());

        monstruoAtacante.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugador1);

        monstruoDefensor.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(monstruoDefensor.estaEnJuego());
    }


    @Test
    public void atacarAMonstruoEnModoAtaque_DefensorTieneMenosPuntosDeAtaque_MuereElDefensor() {
        Integer puntosAtacante = 2000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0, 1, new EfectoNulo());

        monstruoAtacante.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugador1);

        monstruoDefensor.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertFalse(monstruoDefensor.estaEnJuego());
    }

    @Test
    public void atacarAMonstruoEnModoAtaque_DefensorTieneMasPuntosDeAtaque_MuereElAtacante() {
        Integer puntosAtacante = 1000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0, 1, new EfectoNulo());

        monstruoAtacante.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugador1);

        monstruoDefensor.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);

        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(monstruoDefensor.estaEnJuego());
    }

    @Test
    public void atacarMonstruoEnModoAtaque_GanaAtacante_DiferenciaDePuntosDaniaLosPuntosDeVidaDelDefensor() {
        Integer puntosAtacante = 8000;
        Jugador jugadorAtacante = jugador1;
        Integer puntosDefensor = 100;
        Jugador jugadorDefensor = jugador2;


        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0, 1, new EfectoNulo());

        monstruoAtacante.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador defensor pierde 100 puntos de vida, porque se crea con 8000 hp y se le resta 7900
        Integer puntosDeVidaJugadorAtacanteEsperados = 8000;
        Integer puntosDeVidaJugadorDefensorEsperados = 100;

        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugadorAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(jugadorDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }

    @Test
    public void atacarMonstruoEnModoDefensa_GanaAtacante_DiferenciaDePuntosNoDaniaLosPuntosDeVidaDelDefensor() {
        Integer puntosAtacante = 8000;
        Jugador jugadorAtacante = jugador1;
        Integer puntosDefensor = 100;
        Jugador jugadorDefensor = jugador2;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor, 1, new EfectoNulo());

        monstruoAtacante.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        Integer puntosDeVidaJugadorAtacanteEsperados = 8000;
        Integer puntosDeVidaJugadorDefensorEsperados = 8000;

        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugadorAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(jugadorDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }

    @Test
    public void atacarMonstruoEnModoAtaque_PierdeAtacante_DiferenciaDePuntosDaniaLosPuntosDeVidaDelAtacante() {
        Integer puntosAtacante = 1000;
        Jugador jugadorAtacante = jugador1;
        Integer puntosDefensor = 2000;
        Jugador jugadorDefensor = jugador2;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0, 1, new EfectoNulo());

        monstruoAtacante.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        Integer puntosDeVidaJugadorAtacanteEsperados = 7000;
        Integer puntosDeVidaJugadorDefensorEsperados = 8000;

        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugadorAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertTrue(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(jugadorDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }

    @Test
    public void atacarMonstruoEnModoDefensa_PierdeAtacante_DiferenciaDePuntosNoDaniaLosPuntosDeVidaDelAtacante() {
        Integer puntosAtacante = 1000;
        Jugador jugadorAtacante = jugador1;
        Integer puntosDefensor = 2000;
        Jugador jugadorDefensor = jugador2;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor, 1, new EfectoNulo());

        monstruoAtacante.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        Integer puntosDeVidaJugadorAtacanteEsperados = 7000;
        Integer puntosDeVidaJugadorDefensorEsperados = 8000;

        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugadorAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertTrue(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(jugadorDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }





}
