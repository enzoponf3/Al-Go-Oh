package algo3.fiuba.entrega1;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.excepciones.MonstruoEnModoDefensaNoPuedeAtacarException;
import org.junit.Assert;
import org.junit.Test;

public class MonstruoEntrega1Test {

    @Test(expected = MonstruoEnModoDefensaNoPuedeAtacarException.class)
    public void monstruoNoPuedeAtacarEnModoDefensa() {
        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", 1000, 1000);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 1500, 1500);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoDefensa();
        monstruoDefensor.setJugador(new Jugador());

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(new Jugador());

        monstruoAtacante.atacar(monstruoDefensor);
    }

    @Test
    public void monstruoEnModoAtaquePuedeAtacarAMonstruoEnJuego() {
        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", 1000, 1000);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 1500, 1500);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(new Jugador());

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(new Jugador());

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(true);
    }

    @Test
    public void atacarAMonstruoEnModoDefensa_DefensorTieneMenosPuntosDeDefensa_MuereElDefensor() {
        Integer puntosAtacante = 2000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor);
        monstruoAtacante.setJugador(new Jugador());

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(new Jugador());

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaVivo());
        Assert.assertFalse(monstruoDefensor.estaVivo());
    }

    @Test
    public void atacarAMonstruoEnModoDefensa_DefensorTieneMasPuntosDeDefensa_NoMuereNadie() {
        Integer puntosAtacante = 1000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(new Jugador());

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(new Jugador());

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaVivo());
        Assert.assertTrue(monstruoDefensor.estaVivo());
    }


    @Test
    public void atacarAMonstruoEnModoAtaque_DefensorTieneMenosPuntosDeAtaque_MuereElDefensor() {
        Integer puntosAtacante = 2000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(new Jugador());

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(new Jugador());

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaVivo());
        Assert.assertFalse(monstruoDefensor.estaVivo());
    }

    @Test
    public void atacarAMonstruoEnModoAtaque_DefensorTieneMasPuntosDeAtaque_MuereElAtacante() {
        Integer puntosAtacante = 1000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(new Jugador());

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(new Jugador());

        monstruoAtacante.atacar(monstruoDefensor);

        Assert.assertFalse(monstruoAtacante.estaVivo());
        Assert.assertTrue(monstruoDefensor.estaVivo());
    }

    @Test
    public void atacarMonstruoEnModoAtaque_GanaAtacante_DiferenciaDePuntosDaniaLosPuntosDeVidaDelDefensor() {
        Integer puntosAtacante = 8000;
        Jugador jugadorAtacante = new Jugador();
        Integer puntosDefensor = 100;
        Jugador jugadorDefensor = new Jugador();


        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador defensor pierde 100 puntos de vida, porque se crea con 8000 hp y se le resta 7900
        Integer puntosDeVidaJugadorAtacanteEsperados = 8000;
        Integer puntosDeVidaJugadorDefensorEsperados = 100;

        Assert.assertTrue(monstruoAtacante.estaVivo());
        Assert.assertTrue(jugadorAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertFalse(monstruoDefensor.estaVivo());
        Assert.assertTrue(jugadorDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }

    @Test
    public void atacarMonstruoEnModoDefensa_GanaAtacante_DiferenciaDePuntosNoDaniaLosPuntosDeVidaDelDefensor() {
        Integer puntosAtacante = 8000;
        Jugador jugadorAtacante = new Jugador();
        Integer puntosDefensor = 100;
        Jugador jugadorDefensor = new Jugador();

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        Integer puntosDeVidaJugadorAtacanteEsperados = 8000;
        Integer puntosDeVidaJugadorDefensorEsperados = 8000;

        Assert.assertTrue(monstruoAtacante.estaVivo());
        Assert.assertTrue(jugadorAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertFalse(monstruoDefensor.estaVivo());
        Assert.assertTrue(jugadorDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }

    @Test
    public void atacarMonstruoEnModoAtaque_PierdeAtacante_DiferenciaDePuntosDaniaLosPuntosDeVidaDelAtacante() {
        Integer puntosAtacante = 1000;
        Jugador jugadorAtacante = new Jugador();
        Integer puntosDefensor = 2000;
        Jugador jugadorDefensor = new Jugador();

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        Integer puntosDeVidaJugadorAtacanteEsperados = 7000;
        Integer puntosDeVidaJugadorDefensorEsperados = 8000;

        Assert.assertFalse(monstruoAtacante.estaVivo());
        Assert.assertTrue(jugadorAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertTrue(monstruoDefensor.estaVivo());
        Assert.assertTrue(jugadorDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }

    @Test
    public void atacarMonstruoEnModoDefensa_PierdeAtacante_DiferenciaDePuntosNoDaniaLosPuntosDeVidaDelAtacante() {
        Integer puntosAtacante = 1000;
        Jugador jugadorAtacante = new Jugador();
        Integer puntosDefensor = 2000;
        Jugador jugadorDefensor = new Jugador();

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();
        monstruoDefensor.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        Integer puntosDeVidaJugadorAtacanteEsperados = 7000;
        Integer puntosDeVidaJugadorDefensorEsperados = 8000;

        Assert.assertTrue(monstruoAtacante.estaVivo());
        Assert.assertTrue(jugadorAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorAtacanteEsperados, jugadorAtacante.getPuntosDeVida());

        Assert.assertTrue(monstruoDefensor.estaVivo());
        Assert.assertTrue(jugadorDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaJugadorDefensorEsperados, jugadorDefensor.getPuntosDeVida());
    }







}
