package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.GuerreroCelta;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Kuriboh;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.SevenColoredFish;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WastelandTest {

    private Wasteland wasteland;
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

    @Ignore
    @Test
    public void xxx() {
        wasteland = new Wasteland(jugador);

        jugador.colocarCartaEnCampo((Carta) wasteland, new BocaAbajo());
    }

    @Test
    public void alActivarElEfectoElMonstruoDeSuLadoDelCampoGana200PuntosDeAtaque() {
        wasteland = new Wasteland(jugador1);
        Monstruo monstruoPropio = new BebeDragon(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio, new BocaArriba());

        Integer ataqueInicialDelMonstruo = monstruoPropio.getAtaque();

        wasteland.setEstado(new BocaArriba());
        wasteland.activarEfecto();

        Integer ataqueFinalDelMonstruo = ataqueInicialDelMonstruo + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo, monstruoPropio.getAtaque());
    }

    @Test
    public void alActivarElEfectoTodosLosMonstruosDeSuLadoDelCampoGanan200PuntosDeAtaque() {
        wasteland = new Wasteland(jugador1);
        Monstruo monstruoPropio1 = new BebeDragon(jugador1);
        Monstruo monstruoPropio2 = new Kuriboh(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruoPropio2, new BocaArriba());

        Integer ataqueInicialDelMonstruo1 = monstruoPropio1.getAtaque();
        Integer ataqueInicialDelMonstruo2 = monstruoPropio2.getAtaque();

        wasteland.setEstado(new BocaArriba());
        wasteland.activarEfecto();

        Integer ataqueFinalDelMonstruo1 = ataqueInicialDelMonstruo1 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo1, monstruoPropio1.getAtaque());
        Integer ataqueFinalDelMonstruo2 = ataqueInicialDelMonstruo2 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo2, monstruoPropio2.getAtaque());
    }

    @Test
    public void alActivarElEfectoElMonstruoDelCampoDelOponenteGana300PuntosDeDefensa() {
        wasteland = new Wasteland(jugador1);
        Monstruo monstruoOponente = new BebeDragon(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente, new BocaArriba());

        Integer defensaInicialDelMonstruo = monstruoOponente.getDefensa();

        wasteland.setEstado(new BocaArriba());
        wasteland.activarEfecto();

        Integer defensaFinalDelMonstruo = defensaInicialDelMonstruo + 300;
        Assert.assertEquals(defensaFinalDelMonstruo, monstruoOponente.getDefensa());
    }

    @Test
    public void alActivarElEfectoTodosLosMonstruosDelCampoDelOponenteGanan300PuntosDeDefensa() {
        wasteland = new Wasteland(jugador1);
        Monstruo monstruoOponente1 = new BebeDragon(jugador2);
        Monstruo monstruoOponente2 = new Kuriboh(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente2, new BocaArriba());

        Integer defensaInicialDelMonstruo1 = monstruoOponente1.getDefensa();
        Integer defensaInicialDelMonstruo2 = monstruoOponente2.getDefensa();

        wasteland.setEstado(new BocaArriba());
        wasteland.activarEfecto();

        Integer defensaFinalDelMonstruo1 = defensaInicialDelMonstruo1 + 300;
        Assert.assertEquals(defensaFinalDelMonstruo1, monstruoOponente1.getDefensa());
        Integer defensaFinalDelMonstruo2 = defensaInicialDelMonstruo2 + 300;
        Assert.assertEquals(defensaFinalDelMonstruo2, monstruoOponente2.getDefensa());
    }


    @Test
    public void alActivarElEfectoElJugador2TodosLosMonstruosDelJugador1EnCampoGanan300PuntosDeDefensa() {
        wasteland = new Wasteland(jugador2);
        Monstruo monstruo1 = new BebeDragon(jugador1);
        Monstruo monstruo2 = new Kuriboh(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruo1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruo2, new BocaArriba());

        Integer defensaInicialDelMonstruo1 = monstruo1.getDefensa();
        Integer defensaInicialDelMonstruo2 = monstruo2.getDefensa();

        wasteland.setEstado(new BocaArriba());
        wasteland.activarEfecto();

        Integer defensaFinalDelMonstruo1 = defensaInicialDelMonstruo1 + 300;
        Assert.assertEquals(defensaFinalDelMonstruo1, monstruo1.getDefensa());
        Integer defensaFinalDelMonstruo2 = defensaInicialDelMonstruo2 + 300;
        Assert.assertEquals(defensaFinalDelMonstruo2, monstruo2.getDefensa());
    }

    @Test
    public void alActivarElEfectoElJugador2TodosLosMonstruosDelJugador2EnCampoDelOponenteGanan200PuntosDeAtaque() {
        wasteland = new Wasteland(jugador2);
        Monstruo monstruo1 = new BebeDragon(jugador2);
        Monstruo monstruo2 = new Kuriboh(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruo1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruo2, new BocaArriba());

        Integer ataqueInicialDelMonstruo1 = monstruo1.getAtaque();
        Integer ataqueInicialDelMonstruo2 = monstruo2.getAtaque();

        wasteland.setEstado(new BocaArriba());
        wasteland.activarEfecto();

        Integer ataqueFinalDelMonstruo1 = ataqueInicialDelMonstruo1 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo1, monstruo1.getAtaque());
        Integer ataqueFinalDelMonstruo2 = ataqueInicialDelMonstruo2 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo2, monstruo2.getAtaque());
    }

    @Test
    public void colocaWastelandEnCampoBocaArriba_elEfectoSeActivaAutomaticamente_seMantieneEnElCampo() {
        wasteland = new Wasteland(jugador1);

        jugador1.colocarCartaEnCampo((Carta) wasteland, new BocaArriba());

        Assert.assertTrue(wasteland.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(wasteland));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(wasteland));
    }

    @Test
    public void colocaWastelandEnCampoBocaArriba_elEfectoSeActivaAutomaticamente_losMonstruosDeSuLadoDelCampoGanan200PuntosDeAtaque() {
        wasteland = new Wasteland(jugador1);
        Monstruo monstruoPropio1 = new BebeDragon(jugador1);
        Monstruo monstruoPropio2 = new Kuriboh(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruoPropio2, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();

        Integer ataqueInicialDelMonstruo1 = monstruoPropio1.getAtaque();
        Integer ataqueInicialDelMonstruo2 = monstruoPropio2.getAtaque();

        jugador1.colocarCartaEnCampo((Carta) wasteland, new BocaArriba());

        Integer ataqueFinalDelMonstruo1 = ataqueInicialDelMonstruo1 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo1, monstruoPropio1.getAtaque());
        Integer ataqueFinalDelMonstruo2 = ataqueInicialDelMonstruo2 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo2, monstruoPropio2.getAtaque());
    }

    @Test
    public void seColocaWastelandEnCampoBocaArriba_elEfectoSeActivaAutomaticamente_losMonstruosDelLadoDelOponenteGanan300PuntosDeDefensa() {
        wasteland = new Wasteland(jugador1);
        Monstruo monstruoOponente1 = new BebeDragon(jugador2);
        Monstruo monstruoOponente2 = new Kuriboh(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente2, new BocaArriba());
        turno.pasarTurno();

        Integer defensaInicialDelMonstruo1 = monstruoOponente1.getDefensa();
        Integer defensaInicialDelMonstruo2 = monstruoOponente2.getDefensa();

        jugador1.colocarCartaEnCampo((Carta) wasteland, new BocaArriba());

        Integer defensaFinalDelMonstruo1 = defensaInicialDelMonstruo1 + 300;
        Assert.assertEquals(defensaFinalDelMonstruo1, monstruoOponente1.getDefensa());
        Integer defensaFinalDelMonstruo2 = defensaInicialDelMonstruo2 + 300;
        Assert.assertEquals(defensaFinalDelMonstruo2, monstruoOponente2.getDefensa());
    }

    @Test
    public void seColocaWastelandEnCampoYLuegoSeRemueve_losMonstruosDeAmbosLadosDeberianTenerLosPuntosPreviosASerInvocada() {
        wasteland = new Wasteland(jugador1);
        Monstruo monstruoPropio1 = new BebeDragon(jugador1);
        Monstruo monstruoPropio2 = new Kuriboh(jugador1);
        Monstruo monstruoOponente1 = new GuerreroCelta(jugador2);
        Monstruo monstruoOponente2 = new SevenColoredFish(jugador2);


        jugador1.colocarCartaEnCampo((Carta) monstruoPropio1, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente1, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruoPropio2, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente2, new BocaArriba());
        turno.pasarTurno();

        Integer defensaInicialDelMonstruoPropio1 = monstruoPropio1.getDefensa();
        Integer defensaInicialDelMonstruoPropio2 = monstruoPropio2.getDefensa();
        Integer ataqueInicialDelMonstruoOponente1 = monstruoOponente1.getAtaque();
        Integer ataqueInicialDelMonstruoOponente2 = monstruoOponente2.getAtaque();

        jugador1.colocarCartaEnCampo((Carta) wasteland, new BocaArriba());
        jugador1.removerCartaDelCampo(wasteland);

        Assert.assertEquals(defensaInicialDelMonstruoPropio1, monstruoPropio1.getDefensa());
        Assert.assertEquals(defensaInicialDelMonstruoPropio2, monstruoPropio2.getDefensa());
        Assert.assertEquals(ataqueInicialDelMonstruoOponente1, monstruoOponente1.getAtaque());
        Assert.assertEquals(ataqueInicialDelMonstruoOponente2, monstruoOponente2.getAtaque());
    }
}
