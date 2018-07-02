package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo;


import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.*;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.jugador.PreInvocacion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SogenTest {

    private Sogen sogen;
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

    @Test
    public void alActivarElEfectoElMonstruoDeSuLadoDelCampoGana500PuntosDeDefensa() {
        sogen = new Sogen(jugador1);
        Monstruo monstruoPropio = new BebeDragon(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio, new BocaArriba());

        Integer defensaInicialDelMonstruo = monstruoPropio.getDefensa();

        sogen.setEstado(new BocaArriba());
        sogen.activarEfecto();

        Integer defensaFinalDelMonstruo = defensaInicialDelMonstruo + 500;
        Assert.assertEquals(defensaFinalDelMonstruo, monstruoPropio.getDefensa());
    }

    @Test
    public void alActivarElEfectoTodosLosMonstruosDeSuLadoDelCampoGanan500PuntosDeDefensa() {
        sogen = new Sogen(jugador1);
        Monstruo monstruoPropio1 = new BebeDragon(jugador1);
        Monstruo monstruoPropio2 = new Kuriboh(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruoPropio2, new BocaArriba());

        Integer defensaInicialDelMonstruo1 = monstruoPropio1.getDefensa();
        Integer defensaInicialDelMonstruo2 = monstruoPropio2.getDefensa();

        sogen.setEstado(new BocaArriba());
        sogen.activarEfecto();

        Integer defensaFinalDelMonstruo1 = defensaInicialDelMonstruo1 + 500;
        Assert.assertEquals(defensaFinalDelMonstruo1, monstruoPropio1.getDefensa());
        Integer defensaFinalDelMonstruo2 = defensaInicialDelMonstruo2 + 500;
        Assert.assertEquals(defensaFinalDelMonstruo2, monstruoPropio2.getDefensa());
    }

    @Test
    public void alActivarElEfectoElMonstruoDelCampoDelOponenteGana200PuntosDeAtaque() {
        sogen = new Sogen(jugador1);
        Monstruo monstruoOponente = new BebeDragon(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente, new BocaArriba());

        Integer ataqueInicialDelMonstruo = monstruoOponente.getAtaque();

        sogen.setEstado(new BocaArriba());
        sogen.activarEfecto();

        Integer ataqueFinalDelMonstruo = ataqueInicialDelMonstruo + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo, monstruoOponente.getAtaque());
    }

    @Test
    public void alActivarElEfectoTodosLosMonstruosDelCampoDelOponenteGanan200PuntosDeAtaque() {
        sogen = new Sogen(jugador1);
        Monstruo monstruoOponente1 = new BebeDragon(jugador2);
        Monstruo monstruoOponente2 = new Kuriboh(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente2, new BocaArriba());

        Integer ataqueInicialDelMonstruo1 = monstruoOponente1.getAtaque();
        Integer ataqueInicialDelMonstruo2 = monstruoOponente2.getAtaque();

        sogen.setEstado(new BocaArriba());
        sogen.activarEfecto();

        Integer ataqueFinalDelMonstruo1 = ataqueInicialDelMonstruo1 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo1, monstruoOponente1.getAtaque());
        Integer ataqueFinalDelMonstruo2 = ataqueInicialDelMonstruo2 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo2, monstruoOponente2.getAtaque());
    }


    @Test
    public void alActivarElEfectoElJugador2TodosLosMonstruosDelJugador1EnCampoGanan200PuntosDeAtaque() {
        sogen = new Sogen(jugador2);
        Monstruo monstruo1 = new BebeDragon(jugador1);
        Monstruo monstruo2 = new Kuriboh(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruo1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruo2, new BocaArriba());

        Integer ataqueInicialDelMonstruo1 = monstruo1.getAtaque();
        Integer ataqueInicialDelMonstruo2 = monstruo2.getAtaque();

        sogen.setEstado(new BocaArriba());
        sogen.activarEfecto();

        Integer ataqueFinalDelMonstruo1 = ataqueInicialDelMonstruo1 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo1, monstruo1.getAtaque());
        Integer ataqueFinalDelMonstruo2 = ataqueInicialDelMonstruo2 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo2, monstruo2.getAtaque());
    }

    @Test
    public void alActivarElEfectoElJugador2TodosLosMonstruosDelJugador2EnCampoDelOponenteGanan500PuntosDeDefensa() {
        sogen = new Sogen(jugador2);
        Monstruo monstruo1 = new BebeDragon(jugador2);
        Monstruo monstruo2 = new Kuriboh(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruo1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruo2, new BocaArriba());

        Integer defensaInicialDelMonstruo1 = monstruo1.getDefensa();
        Integer defensaInicialDelMonstruo2 = monstruo2.getDefensa();

        sogen.setEstado(new BocaArriba());
        sogen.activarEfecto();

        Integer defensaFinalDelMonstruo1 = defensaInicialDelMonstruo1 + 500;
        Assert.assertEquals(defensaFinalDelMonstruo1, monstruo1.getDefensa());
        Integer defensaFinalDelMonstruo2 = defensaInicialDelMonstruo2 + 500;
        Assert.assertEquals(defensaFinalDelMonstruo2, monstruo2.getDefensa());
    }

    @Test
    public void colocaSogenEnCampoBocaArriba_elEfectoSeActivaAutomaticamente_seMantieneEnElCampo() {
        sogen = new Sogen(jugador1);

        jugador1.colocarCartaEnCampo((Carta) sogen, new BocaArriba());

        Assert.assertTrue(sogen.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo((Carta) sogen));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(sogen));
    }

    @Test
    public void colocaSogenEnCampoBocaArriba_elEfectoSeActivaAutomaticamente_losMonstruosDeSuLadoDelCampoGanan500PuntosDeDefensa() {
        sogen = new Sogen(jugador1);
        Monstruo monstruoPropio1 = new BebeDragon(jugador1);
        Monstruo monstruoPropio2 = new Kuriboh(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruoPropio2, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();

        Integer defensaInicialDelMonstruo1 = monstruoPropio1.getDefensa();
        Integer defensaInicialDelMonstruo2 = monstruoPropio2.getDefensa();

        jugador1.colocarCartaEnCampo((Carta) sogen, new BocaArriba());

        Integer defensaFinalDelMonstruo1 = defensaInicialDelMonstruo1 + 500;
        Assert.assertEquals(defensaFinalDelMonstruo1, monstruoPropio1.getDefensa());
        Integer defensaFinalDelMonstruo2 = defensaInicialDelMonstruo2 + 500;
        Assert.assertEquals(defensaFinalDelMonstruo2, monstruoPropio2.getDefensa());
    }

    @Test
    public void seColocaSogenEnCampoBocaArriba_elEfectoSeActivaAutomaticamente_losMonstruosDelLadoDelOponenteGanan200PuntosDeAtaque() {
        sogen = new Sogen(jugador1);
        Monstruo monstruoOponente1 = new BebeDragon(jugador2);
        Monstruo monstruoOponente2 = new Kuriboh(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente2, new BocaArriba());
        turno.pasarTurno();

        Integer ataqueInicialDelMonstruo1 = monstruoOponente1.getAtaque();
        Integer ataqueInicialDelMonstruo2 = monstruoOponente2.getAtaque();

        jugador1.colocarCartaEnCampo((Carta) sogen, new BocaArriba());

        Integer ataqueFinalDelMonstruo1 = ataqueInicialDelMonstruo1 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo1, monstruoOponente1.getAtaque());
        Integer ataqueFinalDelMonstruo2 = ataqueInicialDelMonstruo2 + 200;
        Assert.assertEquals(ataqueFinalDelMonstruo2, monstruoOponente2.getAtaque());
    }
    
    @Test
    public void seColocaSogenEnCampoYLuegoSeRemueve_losMonstruosDeAmbosLadosDeberianTenerLosPuntosPreviosASerInvocada() {
        sogen = new Sogen(jugador1);
        Monstruo monstruoPropio1 = new BebeDragon(jugador1);
        Monstruo monstruoPropio2 = new Kuriboh(jugador1);
        Monstruo monstruoOponente1 = new GuerreroCelta(jugador2);
        Monstruo monstruoOponente2 = new PezDe7Colores(jugador2);


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

        jugador1.colocarCartaEnCampo((Carta) sogen, new BocaArriba());
        jugador1.removerCartaDelCampo(sogen);

        Assert.assertEquals(defensaInicialDelMonstruoPropio1, monstruoPropio1.getDefensa());
        Assert.assertEquals(defensaInicialDelMonstruoPropio2, monstruoPropio2.getDefensa());
        Assert.assertEquals(ataqueInicialDelMonstruoOponente1, monstruoOponente1.getAtaque());
        Assert.assertEquals(ataqueInicialDelMonstruoOponente2, monstruoOponente2.getAtaque());
    }
}