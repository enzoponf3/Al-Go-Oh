package algo3.fiuba.entrega1;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.Monstruo;
import org.junit.Assert;
import org.junit.Test;

public class MonstruoEntrega1Test {

    @Test(expected = RuntimeException.class)
    public void monstruoNoPuedeAtacarEnModoDefensa() {
        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", 1000, 1000);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 1500, 1500);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoDefensa();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();

        monstruoAtacante.atacar(monstruoDefensor);
    }

    @Test
    public void monstruoEnModoAtaquePuedeAtacarAMonstruoEnJuego() {
        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", 1000, 1000);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 1500, 1500);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(true);
    }

    @Test
    public void atacarAMonstruoEnModoDefensa_DefensorTieneMenosPuntosDeDefensa_MuereElDefensor() {
        Integer puntosAtacante = 2000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();

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

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();

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

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();

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

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();

        monstruoAtacante.atacar(monstruoDefensor);

        Assert.assertFalse(monstruoAtacante.estaVivo());
        Assert.assertTrue(monstruoDefensor.estaVivo());
    }

    @Test
    public void matarMonstruoDefensorEnModoAtaque_DiferenciaDePuntosDaniaLosPuntosDeVidaDelDefensor_JugadorDefensorPierde() {
        Integer puntosAtacante = 9000;
        Jugador jugadorAtacante = new Jugador();
        Integer puntosDefensor = 100;
        Jugador jugadorDefensor = new Jugador();

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorAtacante);

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();
        monstruoAtacante.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador defensor debe morir porque se crea con 8000 hp y se le resta 8900
        Assert.assertFalse(monstruoDefensor.estaVivo());
        Assert.assertFalse(jugadorDefensor.estaEnJuego());
        Assert.assertTrue(jugadorAtacante.estaEnJuego());
    }

    @Test
    public void matarMonstruoEnModoDefensa_DiferenciaDePuntosNoDaniaLosPuntosDeVidaDelDefensor() {
        Integer puntosAtacante = 9000;
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
        monstruoAtacante.setJugador(jugadorDefensor);


        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador defensor debe morir porque se crea con 8000 hp y se le resta 8900
        Assert.assertFalse(monstruoDefensor.estaVivo());
        Assert.assertTrue(jugadorDefensor.estaEnJuego());
        Assert.assertTrue(jugadorAtacante.estaEnJuego());
    }







}
