package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.Trampa;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.*;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.CilindroMagico;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.Refuerzos;
import algo3.fiuba.modelo.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AgujeroNegroTest {

    private AgujeroNegro agujeroNegro;
    private Jugador jugador;
    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;
    private Turno turno;

    @Before
    public void setUp() {
        jugador = new Jugador();
        jugador.setEstadoJugador(new PreInvocacion());
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);

        turno = Turno.getInstancia();
    }

    @Test(expected = CartaInhabilitadaParaActivarseExcepcion.class)
    public void cartaBocaAbajoNoActivaEfecto() {
        Magica agujeroNegro = new AgujeroNegro(jugador);
        jugador.colocarCartaEnCampo((Carta) agujeroNegro, new BocaAbajo());
        agujeroNegro.activarEfecto();
    }

    @Test // !!!
    public void cartaAgujeroNegroAlActivarseMataALosMonstruosEnCampo() {
        agujeroNegro = new AgujeroNegro(jugador1);
        Monstruo monstruoEnemigo = new Kuriboh(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoEnemigo, new BocaArriba());
        turno.pasarTurno();

        agujeroNegro.setEstado(new BocaArriba());
        agujeroNegro.activarEfecto();

        Assert.assertFalse(monstruoEnemigo.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoEnemigo));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoEnemigo));
    }

    @Test
    public void cartaAgujeroNegroSeColocaBocaAbajo_activaEfectosSinMonstruosEnJuegoYLuegoSeDescarta() {
        agujeroNegro = new AgujeroNegro(jugador);

        jugador.colocarCartaEnCampo((Carta) agujeroNegro, new BocaAbajo());

        Assert.assertTrue(agujeroNegro.estaEnJuego());
        Assert.assertTrue(jugador.cartaEstaEnCampo(agujeroNegro));
        Assert.assertFalse(jugador.cartaEstaEnCementerio(agujeroNegro));

        agujeroNegro.activarEfecto();

        Assert.assertFalse(agujeroNegro.estaEnJuego());
        Assert.assertFalse(jugador.cartaEstaEnCampo(agujeroNegro));
        Assert.assertTrue(jugador.cartaEstaEnCementerio(agujeroNegro));
    }

    @Test
    public void jugador2ColocaUnMonstruoYjugador1ColocaAgujeroNegroBocaArriba_activaElEfectoAutomaticamente_elMonstruoVaAlCementerioYAgujeroNegroVanAlCementerio() {
        agujeroNegro = new AgujeroNegro(jugador1);
        Monstruo monstruoEnemigo = new Kuriboh(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoEnemigo, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) agujeroNegro, new BocaArriba());

        Assert.assertFalse(monstruoEnemigo.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoEnemigo));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoEnemigo));

        Assert.assertFalse(agujeroNegro.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(agujeroNegro));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(agujeroNegro));
    }

    @Test
    public void jugador1ColocaUnMonstruYAgujeroNegroBocaArriba_activaElEfectoAutomaticamente_elMonstruoVaAlCementerioYAgujeroNegroVanAlCementerio() {
        agujeroNegro = new AgujeroNegro(jugador1);
        Monstruo monstruoPropio = new Kuriboh(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) agujeroNegro, new BocaArriba());

        Assert.assertFalse(monstruoPropio.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(monstruoPropio));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(monstruoPropio));

        Assert.assertFalse(agujeroNegro.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(agujeroNegro));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(agujeroNegro));
    }

    @Test
    public void jugador1YJugador2ColocanVariosMonstruosYSeJuegaAgujeroNegroBocaArriba_activaElEfectoAutomaticamente_elMonstruoVaAlCementerioYAgujeroNegroVanAlCementerio() {
        agujeroNegro = new AgujeroNegro(jugador1);
        Monstruo monstruoPropio1 = new BebeDragon(jugador1);
        Monstruo monstruoPropio2 = new GuerreroCelta(jugador1);
        Monstruo monstruoOponente1 = new Jinzo7(jugador2);
        Monstruo monstruoOponente2 = new IncursorDelHacha(jugador2);

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio1, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente1, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruoPropio2, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente2, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) agujeroNegro, new BocaArriba());

        Assert.assertFalse(monstruoPropio1.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(monstruoPropio1));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(monstruoPropio1));

        Assert.assertFalse(monstruoPropio2.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(monstruoPropio2));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(monstruoPropio2));

        Assert.assertFalse(monstruoOponente1.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoOponente1));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoOponente1));

        Assert.assertFalse(monstruoOponente2.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoOponente2));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoOponente2));

        Assert.assertFalse(agujeroNegro.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(agujeroNegro));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(agujeroNegro));
    }

    @Test
    public void jugador1YJugador2ColocanVariosMonstruosMagicasYTrampasYSeJuegaAgujeroNegroBocaArriba_activaElEfectoAutomaticamente_losMonstruosVanAlCementerioYAgujeroNegroVanAlCementerioElRestoDeLosNoMonstruosSeQuedanEnElCampo() {
        agujeroNegro = new AgujeroNegro(jugador1);
        Monstruo monstruoPropio = new BebeDragon(jugador1);
        Magica magicaPropia = new Fisura(jugador1);
        Trampa trampaPropia = new Refuerzos(jugador1);
        Monstruo monstruoOponente = new Jinzo7(jugador2);
        Magica magicaOponente = new OllaDeLaCodicia(jugador2);
        Trampa trampaOponente = new CilindroMagico(jugador2);

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente, new BocaAbajo());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) magicaPropia, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) magicaOponente, new BocaAbajo());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) trampaPropia, new BocaAbajo());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) trampaOponente, new BocaAbajo());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) agujeroNegro, new BocaAbajo());

        Assert.assertFalse(monstruoPropio.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(monstruoPropio));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(monstruoPropio));

        Assert.assertTrue(magicaPropia.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(magicaPropia));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(magicaPropia));

        Assert.assertTrue(trampaPropia.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(trampaPropia));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(trampaPropia));

        Assert.assertFalse(monstruoOponente.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoOponente));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoOponente));

        Assert.assertTrue(magicaOponente.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCampo(magicaOponente));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(magicaOponente));

        Assert.assertTrue(trampaOponente.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCampo(trampaOponente));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(trampaOponente));

        Assert.assertFalse(agujeroNegro.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(agujeroNegro));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(agujeroNegro));
    }
}
