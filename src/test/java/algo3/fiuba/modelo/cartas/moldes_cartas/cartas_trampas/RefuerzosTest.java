package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Jinzo7;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Kuriboh;
import algo3.fiuba.modelo.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class RefuerzosTest {

    private Refuerzos refuerzos;
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
    public void seColocaBocaAbajo_laCartaEstaEnElCampo() {
        refuerzos = new Refuerzos(jugador1);

        jugador1.colocarCartaEnCampo((Carta) refuerzos, new BocaAbajo());

        Assert.assertTrue(refuerzos.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(refuerzos));
    }

    @Test
    public void seColocaBocaAbajo_noAfectaElAtaqueDelMonstruoEnCampoAlSerColocada() {
        refuerzos = new Refuerzos(jugador1);
        Monstruo monstruo = new BebeDragon(jugador1);
        Integer ataqueIncialMonstruo = monstruo.getAtaque();

        jugador1.colocarCartaEnCampo((Carta) monstruo, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) refuerzos, new BocaAbajo());

        Assert.assertEquals(ataqueIncialMonstruo, monstruo.getAtaque());
    }

    @Test(expected = CartaInhabilitadaParaActivarseExcepcion.class)
    public void seColocaBocaAbajo_noSePuedeActivarElEfectoManualmente() {
        refuerzos = new Refuerzos(jugador1);

        jugador1.colocarCartaEnCampo((Carta) refuerzos, new BocaAbajo());
        refuerzos.activarEfecto();
    }

    @Test
    public void colocoTrampaRefuerzos_seActivaAlAtacarAUnMonstruoDeSuCampo_sigueEnJuegoPorEseTurno() {
        refuerzos = new Refuerzos(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) refuerzos, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);

        // La carta Trampa se activa y sigue en el campo.
        Assert.assertTrue(refuerzos.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(refuerzos));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(refuerzos));
    }

    @Test
    public void colocoTrampaRefuerzos_seActivaAlAtacarAUnMonstruoDeSuCampo_quedaBocaArriba() {
        refuerzos = new Refuerzos(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) refuerzos, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        Assert.assertTrue(refuerzos.getEstadoCarta() instanceof BocaAbajo);

        monstruoAtacante.atacar(monstruoAtacado);

        Assert.assertTrue(refuerzos.getEstadoCarta() instanceof BocaArriba);
    }


    @Test
    public void colocoTrampaRefuerzos_seActivaAlAtacarAUnMonstruoDeSuCampo_enElSiguienteTurnoSeDescarta() {
        refuerzos = new Refuerzos(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) refuerzos, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);
        turno.pasarTurno();

        // La carta Trampa se activa y sigue en el campo.
        Assert.assertFalse(refuerzos.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(refuerzos));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(refuerzos));
    }

    @Test
    public void colocoTrampaRefuerzos_seActivaAlAtacarAUnMonstruoDeSuCampo_elMonstruoAtacadoGana500PuntosDeAtaquePorEseTurno() {
        refuerzos = new Refuerzos(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        Integer ataqueInicialAtacado = monstruoAtacado.getAtaque();

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) refuerzos, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);

        Integer ataqueFinalAtacado = ataqueInicialAtacado + 500;
        Assert.assertEquals(ataqueFinalAtacado, monstruoAtacado.getAtaque());
    }

    @Test
    public void colocoTrampaRefuerzos_seActivaAlAtacarAUnMonstruoDeSuCampo_enElSiguienteTurnoElMonstruoAtacadoVuelveASuAtaqueInicial() {
        refuerzos = new Refuerzos(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        Integer ataqueInicialAtacado = monstruoAtacado.getAtaque();

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) refuerzos, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);
        turno.pasarTurno();

        Integer ataqueFinalAtacado = ataqueInicialAtacado;
        Assert.assertEquals(ataqueFinalAtacado, monstruoAtacado.getAtaque());
    }

    @Test
    public void colocoTrampaRefuerzos_seAtacaConMonstruoDe200ATKMas_monstruoAtacadoAumenta500ATKAlActivarTrampa() {
        refuerzos = new Refuerzos(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) refuerzos, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        // Al atacar al monstruoAtacado se activa la trampa, que le suma 500ATK a este mismo.
        monstruoAtacante.atacar(monstruoAtacado);

        // Muere el monstruo atacante.
        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoAtacante));

        Assert.assertTrue(monstruoAtacado.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(monstruoAtacado));
        Assert.assertTrue(jugador1.cartaEstaEnCampo(monstruoAtacado));

        // Se le resta a los puntos de vida del atacante la diferencia de ataques.
        Integer vidaFinalAtacante = 8000 - ((300 + 500) - 500);
        Assert.assertEquals(vidaFinalAtacante, jugador2.getPuntosDeVida());

        // El jugador atacado no recibe daño.
        Integer vidaFinalAtacado = 8000;
        Assert.assertEquals(vidaFinalAtacado, jugador1.getPuntosDeVida());
    }
}
