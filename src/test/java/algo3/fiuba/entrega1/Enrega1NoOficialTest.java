package algo3.fiuba.entrega1;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Kuriboh;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Enrega1NoOficialTest {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;
    private Turno turno;

    @Before
    public void setUp() {
        juego = Juego.getInstancia();
        turno = Turno.getInstancia();

        jugador1 = new Jugador();
        jugador2 = new Jugador();
        juego.inicializar(jugador1, jugador2);
    }

    // VALIDAR QUE CARTA ESTÁ EN UN ÚNICO LUGAR
    @Test
    public void verificoQueSiAgregoUnaCartaALaManoDelJugador1SeEncuentraSoloAlli() {
        Carta carta = new Kuriboh(jugador1);

        jugador1.agregarCartaAMano(carta);

        Assert.assertTrue(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCampo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiAgregoUnaCartaALaManoDelJugador2SeEncuentraSoloAlli() {
        Carta carta = new Kuriboh(jugador2);

        jugador2.agregarCartaAMano(carta);

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertTrue(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCampo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiColocarUnaCartaEnElCementerioDelJugador1SeEncuentraSoloAlli() {
        Carta carta = new Kuriboh(jugador1);

        jugador1.mandarCartaACementerio(carta);

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCampo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(carta));

        Assert.assertTrue(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiColocarUnaCartaEnElCementerioDelJugador2SeEncuentraSoloAlli() {
        Carta carta = new Kuriboh(jugador2);

        jugador2.mandarCartaACementerio(carta);

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCampo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }


    @Test
    public void verificoQueSiColocarUnMonstruoEnElTableroDelJugador1SeEncuentraSoloAlli() {
        Carta carta = new Kuriboh(jugador1);

        jugador1.colocarCartaEnCampo(carta, new BocaArriba());

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertTrue(jugador1.cartaEstaEnCampo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiColocarUnMonstruoEnElTableroDelJugador2SeEncuentraSoloAlli() {
        Carta carta = new Kuriboh(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo(carta, new BocaArriba());

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCampo(carta));
        Assert.assertTrue(jugador2.cartaEstaEnCampo(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiColocarUnNoMonstruoEnElTableroDelJugador1SeEncuentraSoloAlli() {
        Carta carta = new AgujeroNegro(jugador1);

        jugador1.colocarCartaEnCampo(carta, new BocaAbajo());

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertTrue(jugador1.cartaEstaEnCampo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }

    @Test
    public void verificoQueSiColocarUnNoMonstruoEnElTableroDelJugador2SeEncuentraSoloAlli() {
        Carta carta = new AgujeroNegro(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo(carta, new BocaAbajo());

        Assert.assertFalse(jugador1.cartaEstaEnMano(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMano(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCampo(carta));
        Assert.assertTrue(jugador2.cartaEstaEnCampo(carta));

        Assert.assertFalse(jugador1.cartaEstaEnCementerio(carta));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(carta));

        Assert.assertFalse(jugador1.cartaEstaEnMazo(carta));
        Assert.assertFalse(jugador2.cartaEstaEnMazo(carta));
    }


    // VERIFICAR QUE CARTA NO DEBE ESTAR EN JUEGO CUANDO NO DEBE ESTARLO

    @Test
    public void siLaCartaEstaEnElCementerioEntoncesNoEstaEnJuego() {
        Carta carta = new Kuriboh(jugador1);

        jugador1.mandarCartaACementerio(carta);

        Assert.assertFalse(carta.estaEnJuego());
    }

    @Test
    public void siLaCartaEstaEnLaManoEntoncesNoEstaEnJuego() {
        Carta carta = new Kuriboh(jugador1);

        jugador1.agregarCartaAMano(carta);

        Assert.assertFalse(carta.estaEnJuego());
    }

    @Test
    public void siLaCartaEstaEnElMazoEntoncesNoEstaEnJuego() {
        Carta carta = new Kuriboh(jugador1);

        jugador1.agregarCartaAMazo(carta);

        Assert.assertFalse(carta.estaEnJuego());
    }



    // VALIDAR QUE MONSTRUO NO PUEDA ATACAR CUANDO NO DEBE PODER

    @Test(expected = MonstruoInhabilitadoParaAtacarExcepcion.class)
    public void monstruoNoPuedeAtacarDesdeLaMano() {
        Monstruo monstruo = new Kuriboh(jugador1);

        jugador1.agregarCartaAMano(monstruo);
        monstruo.atacar(null);
    }

    @Test(expected = MonstruoInhabilitadoParaAtacarExcepcion.class)
    public void monstruoNoPuedeAtacarDesdeElCementerio() {
        Monstruo monstruo = new Kuriboh(jugador1);

        jugador1.mandarCartaACementerio(monstruo);
        monstruo.atacar(null);
    }

    @Test(expected = MonstruoInhabilitadoParaAtacarExcepcion.class)
    public void monstruoNoPuedeAtacarSiEstaEnElMazo() {
        Monstruo monstruo = new Kuriboh(jugador1);

        jugador1.agregarCartaAMazo(monstruo);

        monstruo.atacar(null);
    }

    @Test(expected = MonstruoInhabilitadoParaAtacarExcepcion.class)
    public void monstruoNoPuedeAtacarSiEstaEnElTableroEnModoDefensa() {
        Monstruo monstruo = new Kuriboh(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruo, new BocaArriba());
        monstruo.cambiarModo();

        monstruo.atacar(null);
    }

}
