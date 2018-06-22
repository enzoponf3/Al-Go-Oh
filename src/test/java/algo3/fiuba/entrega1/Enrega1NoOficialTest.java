package algo3.fiuba.entrega1;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Enrega1NoOficialTest {

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

    // VALIDAR QUE CARTA ESTÁ EN UN ÚNICO LUGAR

    @Test
    public void verificoQueSiAgregoUnaCartaALaManoDelJugador1SeEncuentraSoloAlli() {
        Carta carta = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador1.agregarCartaAMano(carta);

        Assert.assertTrue(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnTablero(carta));
        Assert.assertFalse(jugador2.cartaEstaEnTablero(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiAgregoUnaCartaALaManoDelJugador2SeEncuentraSoloAlli() {
        Carta carta = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador2.agregarCartaAMano(carta);

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertTrue(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnTablero(carta));
        Assert.assertFalse(jugador2.cartaEstaEnTablero(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiColocarUnaCartaEnElCementerioDelJugador1SeEncuentraSoloAlli() {
        Carta carta = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador1.mandarCartaACementerio(carta);

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnTablero(carta));
        Assert.assertFalse(jugador2.cartaEstaEnTablero(carta));

        Assert.assertTrue(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiColocarUnaCartaEnElCementerioDelJugador2SeEncuentraSoloAlli() {
        Carta carta = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador2.mandarCartaACementerio(carta);

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnTablero(carta));
        Assert.assertFalse(jugador2.cartaEstaEnTablero(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }


    @Test
    public void verificoQueSiColocarUnMonstruoEnElTableroDelJugador1SeEncuentraSoloAlli() {
        Carta carta = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador1.colocarCartaEnTablero(carta, BocaArriba.getInstancia());

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertTrue(jugador1.cartaEstaEnTablero(carta));
        Assert.assertFalse(jugador2.cartaEstaEnTablero(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiColocarUnMonstruoEnElTableroDelJugador2SeEncuentraSoloAlli() {
        Carta carta = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador2.colocarCartaEnTablero(carta, BocaArriba.getInstancia());

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnTablero(carta));
        Assert.assertTrue(jugador2.cartaEstaEnTablero(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiColocarUnNoMonstruoEnElTableroDelJugador1SeEncuentraSoloAlli() {
        Carta carta = new Magica("no monstruo test", new EfectoNulo());

        jugador1.colocarCartaEnTablero(carta, BocaArriba.getInstancia());

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertTrue(jugador1.cartaEstaEnTablero(carta));
        Assert.assertFalse(jugador2.cartaEstaEnTablero(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiColocarUnNoMonstruoEnElTableroDelJugador2SeEncuentraSoloAlli() {
        Carta carta = new Magica("no monstruo test", new EfectoNulo());

        jugador2.colocarCartaEnTablero(carta, BocaArriba.getInstancia());

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnTablero(carta));
        Assert.assertTrue(jugador2.cartaEstaEnTablero(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }


    // VERIFICAR QUE CARTA NO DEBE ESTAR EN JUEGO CUANDO NO DEBE ESTARLO

    @Test
    public void siLaCartaEstaEnElCementerioEntoncesNoEstaEnJuego() {
        Carta carta = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador1.mandarCartaACementerio(carta);

        Assert.assertFalse(carta.estaEnJuego());
    }

    @Test
    public void siLaCartaEstaEnLaManoEntoncesNoEstaEnJuego() {
        Carta carta = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador1.agregarCartaAMano(carta);

        Assert.assertFalse(carta.estaEnJuego());
    }

    @Test
    public void siLaCartaEstaEnElMazoEntoncesNoEstaEnJuego() {
        Carta carta = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador1.agregarCartaAMazo(carta);

        Assert.assertFalse(carta.estaEnJuego());
    }



    // VALIDAR QUE MONSTRUO NO PUEDA ATACAR CUANDO NO DEBE PODER

    @Test(expected = InhabilitadoParaAtacarExcepcion.class)
    public void monstruoNoPuedeAtacarDesdeLaMano() {
        Monstruo monstruo = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador1.agregarCartaAMano(monstruo);
        monstruo.atacar(null);
    }

    @Test(expected = InhabilitadoParaAtacarExcepcion.class)
    public void monstruoNoPuedeAtacarDesdeElCementerio() {
        Monstruo monstruo = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador1.mandarCartaACementerio(monstruo);
        monstruo.atacar(null);
    }

    @Test(expected = InhabilitadoParaAtacarExcepcion.class)
    public void monstruoNoPuedeAtacarSiEstaEnElMazo() {
        Monstruo monstruo = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador1.agregarCartaAMazo(monstruo);

        monstruo.atacar(null);
    }

    @Test(expected = InhabilitadoParaAtacarExcepcion.class)
    public void monstruoNoPuedeAtacarSiEstaEnElTableroEnModoDefensa() {
        Monstruo monstruo = new Monstruo("monstruo test", 0, 0, 1, new EfectoNulo());

        jugador1.colocarCartaEnTablero(monstruo, BocaArriba.getInstancia());
        monstruo.cambiarModo();

        monstruo.atacar(null);
    }



}
