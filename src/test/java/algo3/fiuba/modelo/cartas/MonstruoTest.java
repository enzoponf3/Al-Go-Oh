package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Jinzo7;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Kuriboh;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.PezDe7Colores;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MonstruoTest {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;
    private Turno turno;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);

        turno = Turno.getInstancia();
    }

    @Test(expected = MonstruoInhabilitadoParaAtacarExcepcion.class)
    public void monstruoNoPuedeAtacarEnModoDefensa() {
        Monstruo monstruoAtacante = new BebeDragon(jugador1);
        Monstruo monstruoDefensor = new Kuriboh(jugador2);

        monstruoAtacante.setEstado(new BocaArriba());
        monstruoAtacante.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugador1);

        monstruoDefensor.setEstado(new BocaArriba());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);
    }

    @Test
    public void monstruoEnModoAtaquePuedeAtacarAMonstruoEnJuego() {
        Monstruo monstruoAtacante = new BebeDragon(jugador1);
        Monstruo monstruoDefensor = new Kuriboh(jugador2);

        monstruoAtacante.setEstado(new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugador1);

        monstruoDefensor.setEstado(new BocaArriba());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(true);
    }

    @Test
    public void atacarAMonstruoEnModoDefensa_DefensorTieneMenosPuntosDeDefensa_MuereElDefensor() {
        Monstruo monstruoAtacante = new BebeDragon(jugador1);
        Monstruo monstruoDefensor = new Kuriboh(jugador2);

        monstruoAtacante.setEstado(new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugador1);


        monstruoDefensor.setEstado(new BocaArriba());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertFalse(monstruoDefensor.estaEnJuego());
    }

    @Test
    public void atacarAMonstruoEnModoDefensa_DefensorTieneMasPuntosDeDefensa_NoMuereNadie() {
        Monstruo monstruoAtacante = new Kuriboh(jugador1);
        Monstruo monstruoDefensor = new BebeDragon(jugador2);

        monstruoAtacante.setEstado(new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugador1);

        monstruoDefensor.setEstado(new BocaArriba());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(monstruoDefensor.estaEnJuego());
    }


    @Test
    public void atacarAMonstruoEnModoAtaque_DefensorTieneMenosPuntosDeAtaque_MuereElDefensor() {
        Monstruo monstruoAtacante = new BebeDragon(jugador1);
        Monstruo monstruoDefensor = new Kuriboh(jugador2);

        monstruoAtacante.setEstado(new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugador1);

        monstruoDefensor.setEstado(new BocaArriba());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertFalse(monstruoDefensor.estaEnJuego());
    }

    @Test
    public void atacarAMonstruoEnModoAtaque_DefensorTieneMasPuntosDeAtaque_MuereElAtacante() {
        Monstruo monstruoAtacante = new Kuriboh(jugador1);
        Monstruo monstruoDefensor = new BebeDragon(jugador2);

        monstruoAtacante.setEstado(new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugador1);

        monstruoDefensor.setEstado(new BocaArriba());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugador2);

        monstruoAtacante.atacar(monstruoDefensor);

        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(monstruoDefensor.estaEnJuego());
    }

    @Test
    public void atacarMonstruoEnModoAtaque_GanaAtacante_DiferenciaDePuntosDaniaLosPuntosDeVidaDelDefensor() {
        Jugador jugadorAtacante = jugador1;
        Jugador jugadorDefensor = jugador2;

        Monstruo monstruoAtacante = new BebeDragon(jugador1);
        Monstruo monstruoDefensor = new Kuriboh(jugador2);

        monstruoAtacante.setEstado(new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.setEstado(new BocaArriba());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador defensor pierde 100 puntos de vida, porque se crea con 8000 hp y se le resta 7900
        Integer puntosDeVidaJugadorAtacanteEsperados = 8000;
        Integer puntosDeVidaJugadorDefensorEsperados = 8000 - (monstruoAtacante.getAtaque() - monstruoDefensor.getAtaque());

        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugadorAtacante.estaVivo());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(jugadorDefensor.estaVivo());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }

    @Test
    public void atacarMonstruoEnModoDefensa_GanaAtacante_DiferenciaDePuntosNoDaniaLosPuntosDeVidaDelDefensor() {
        Jugador jugadorAtacante = jugador1;
        Jugador jugadorDefensor = jugador2;

        Monstruo monstruoAtacante = new BebeDragon(jugador1);
        Monstruo monstruoDefensor = new Kuriboh(jugador2);

        monstruoAtacante.setEstado(new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.setEstado(new BocaArriba());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        Integer puntosDeVidaJugadorAtacanteEsperados = 8000;
        Integer puntosDeVidaJugadorDefensorEsperados = 8000;

        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugadorAtacante.estaVivo());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(jugadorDefensor.estaVivo());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }

    @Test
    public void atacarMonstruoEnModoAtaque_PierdeAtacante_DiferenciaDePuntosDaniaLosPuntosDeVidaDelAtacante() {
        Jugador jugadorAtacante = jugador1;
        Jugador jugadorDefensor = jugador2;

        Monstruo monstruoAtacante = new Kuriboh(jugador1);
        Monstruo monstruoDefensor = new BebeDragon(jugador2);

        monstruoAtacante.setEstado(new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.setEstado(new BocaArriba());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        Integer puntosDeVidaJugadorAtacanteEsperados = 8000 - (monstruoDefensor.getAtaque() - monstruoAtacante.getAtaque());
        Integer puntosDeVidaJugadorDefensorEsperados = 8000;

        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugadorAtacante.estaVivo());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertTrue(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(jugadorDefensor.estaVivo());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }

    @Test
    public void atacarMonstruoEnModoDefensa_PierdeAtacante_DiferenciaDePuntosNoDaniaLosPuntosDeVidaDelAtacante() {
        Jugador jugadorAtacante = jugador1;
        Jugador jugadorDefensor = jugador2;

        Monstruo monstruoAtacante = new Kuriboh(jugador1);
        Monstruo monstruoDefensor = new BebeDragon(jugador2);

        monstruoAtacante.setEstado(new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.setEstado(new BocaArriba());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        Integer puntosDeVidaJugadorAtacanteEsperados = 8000 - (monstruoDefensor.getDefensa() - monstruoAtacante.getAtaque());
        Integer puntosDeVidaJugadorDefensorEsperados = 8000;

        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugadorAtacante.estaVivo());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertTrue(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(jugadorDefensor.estaVivo());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }

    @Test
    public void unMonstruoBocaAbajoAlSerAtacadoPasaAEstarBocaArriba() {
        Monstruo monstruoAtacado = new PezDe7Colores(jugador1); // ATK 1800
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        Assert.assertTrue(monstruoAtacado.getEstadoCarta() instanceof BocaAbajo);

        monstruoAtacante.atacar(monstruoAtacado);

        Assert.assertTrue(monstruoAtacado .estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(monstruoAtacado));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(monstruoAtacado));
        Assert.assertTrue(monstruoAtacado.getEstadoCarta() instanceof BocaArriba);
    }

    @Test
    public void unMonstruoBocaAbajoAlActivarElEfectoPasaAEstarBocaArriba() {
        Monstruo monstruo = new PezDe7Colores(jugador1);

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) monstruo, new BocaAbajo());

        Assert.assertTrue(monstruo.getEstadoCarta() instanceof BocaAbajo);

        monstruo.activarEfecto();

        Assert.assertTrue(monstruo .estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(monstruo));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(monstruo));
        Assert.assertTrue(monstruo.getEstadoCarta() instanceof BocaArriba);
    }

}
