package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Jinzo7;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.PezDe7Colores;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FisuraTest {

    private Fisura fisura;
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


    @Test
    public void alActivarseMataAlMonstruoMasDebilDelOponente_fisuraVaAlCementerio() {
        fisura = new Fisura(jugador1);
        Monstruo monstruoFuerte = new PezDe7Colores(jugador2);
        Monstruo monstruoDebil = new Jinzo7(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoDebil, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoFuerte, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo(fisura, new BocaArriba());

        fisura.setEstado(new BocaArriba());
        fisura.activarEfecto();

        Assert.assertFalse(monstruoDebil.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoDebil));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoDebil));

        Assert.assertFalse(fisura.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(fisura));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(fisura));
    }

    @Test
    public void alActivarseMataAlMonstruoMasDebilDelOponente_siHayUnoSoloMataAEseYFisuraVaAlCementerio() {
        fisura = new Fisura(jugador1);
        Monstruo monstruoOponente = new PezDe7Colores(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo(fisura, new BocaArriba());

        fisura.setEstado(new BocaArriba());
        fisura.activarEfecto();

        Assert.assertFalse(monstruoOponente.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoOponente));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoOponente));

        Assert.assertFalse(fisura.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(fisura));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(fisura));
    }

    @Test
    public void fisuraSeColocaBocaAbajo_activaEfectosSinMonstruosEnJuegoYLuegoSeDescarta() {
        fisura = new Fisura(jugador1);

        jugador1.colocarCartaEnCampo(fisura, new BocaAbajo());
        fisura.activarEfecto();

        Assert.assertFalse(fisura.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(fisura));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(fisura));
    }

    @Test
    public void seColocaBocaAbajoYLuegoSeActiva_fisuraVaAlCementerio() {
        fisura = new Fisura(jugador1);
        Monstruo monstruoFuerte = new PezDe7Colores(jugador2);
        Monstruo monstruoDebil = new Jinzo7(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoDebil, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoFuerte, new BocaArriba());
        turno.pasarTurno();

        jugador1.colocarCartaEnCampo(fisura, new BocaAbajo());
        fisura.activarEfecto();

        Assert.assertFalse(monstruoDebil.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoDebil));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoDebil));

        Assert.assertFalse(fisura.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(fisura));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(fisura));
    }


    @Test
    public void fisuraSeColocaBocaAbajoYSeActivaAutomaticamente_fisuraVaAlCementerio() {
        fisura = new Fisura(jugador1);
        Monstruo monstruoFuerte = new PezDe7Colores(jugador2);
        Monstruo monstruoDebil = new Jinzo7(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoDebil, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoFuerte, new BocaArriba());
        turno.pasarTurno();

        jugador1.colocarCartaEnCampo(fisura, new BocaArriba());

        Assert.assertFalse(monstruoDebil.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoDebil));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoDebil));

        Assert.assertFalse(fisura.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(fisura));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(fisura));
    }
}
