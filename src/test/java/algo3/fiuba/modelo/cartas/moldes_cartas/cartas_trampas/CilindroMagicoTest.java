package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Kuriboh;
import algo3.fiuba.modelo.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Jinzo7;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.SevenColoredFish;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CilindroMagicoTest {

    private CilindroMagico cilindroMagico;
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
        cilindroMagico = new CilindroMagico(jugador1);

        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());

        Assert.assertTrue(cilindroMagico.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(cilindroMagico));
    }

    @Test
    public void seColocaBocaAbajo_noAfectaElAtaqueDelMonstruoEnCampoAlSerColocada() {
        cilindroMagico = new CilindroMagico(jugador1);
        Monstruo monstruo = new BebeDragon(jugador1);
        Integer ataqueIncialMonstruo = monstruo.getAtaque();

        jugador1.colocarCartaEnCampo((Carta) monstruo, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());

        Assert.assertEquals(ataqueIncialMonstruo, monstruo.getAtaque());
    }

    @Test(expected = CartaInhabilitadaParaActivarseExcepcion.class)
    public void seColocaBocaAbajo_noSePuedeActivarElEfectoManualmente() {
        cilindroMagico = new CilindroMagico(jugador1);

        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());
        cilindroMagico.activarEfecto();
    }

    @Test
    public void colocoTrampaCilindroMagico_seActivaAlAtacarAUnMonstruoDeSuCampo_sigueEnJuegoPorEseTurno() {
        cilindroMagico = new CilindroMagico(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);

        // La carta Trampa se activa y sigue en el campo.
        Assert.assertTrue(cilindroMagico.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(cilindroMagico));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(cilindroMagico));
    }

    @Test
    public void colocoTrampaCilindroMagico_seActivaAlAtacarAUnMonstruoDeSuCampo_quedaBocaArriba() {
        cilindroMagico = new CilindroMagico(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        Assert.assertTrue(cilindroMagico.getEstadoCarta() instanceof BocaAbajo);

        monstruoAtacante.atacar(monstruoAtacado);

        Assert.assertTrue(cilindroMagico.getEstadoCarta() instanceof BocaArriba);
    }


    @Test
    public void colocoTrampaCilindroMagico_seActivaAlAtacarAUnMonstruoDeSuCampo_enElSiguienteTurnoSeDescarta() {
        cilindroMagico = new CilindroMagico(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);
        turno.pasarTurno();

        // La carta Trampa se activa y sigue en el campo.
        Assert.assertFalse(cilindroMagico.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(cilindroMagico));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(cilindroMagico));
    }

    @Test
    public void colocoTrampaCilindroMagico_seActivaAlAtacarAUnMonstruoDeSuCampo_elMonstruoAtacadoQueDeberiaMorirNoMuerePorqueSeNiegaElAtaque() {
        cilindroMagico = new CilindroMagico(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);
        turno.pasarTurno();

        // La carta Trampa se activa y sigue en el campo.
        Assert.assertTrue(monstruoAtacado.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(monstruoAtacado));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(monstruoAtacado));
    }

    @Test
    public void colocoTrampaCilindroMagico_seActivaAlAtacarAUnMonstruoDeSuCampo_elMonstruoAtacanteSigueVivo() {
        cilindroMagico = new CilindroMagico(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);
        turno.pasarTurno();

        // La carta Trampa se activa y sigue en el campo.
        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoAtacante));
    }

    @Test
    public void colocoTrampaCilindroMagico_seActivaAlAtacarAUnMonstruoDeSuCampo_elAtaqueDelAtacanteVaDirectoALosPuntosDeDanioDelOponente() {
        cilindroMagico = new CilindroMagico(jugador1);
        Monstruo monstruoAtacante = new SevenColoredFish(jugador2);
        Monstruo monstruoAtacado = new Jinzo7(jugador1);

        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);

        // El que ataco recibió ataque a sus puntos de vida igual al ataque de la carta con la que atacó.
        Integer vidaFinalAtacante = 8000 - monstruoAtacante.getAtaque();
        Assert.assertEquals(vidaFinalAtacante, jugador2.getPuntosDeVida());
    }


    @Test
    public void atacarATrampaCilindroMagico_seNiegaAtaqueYSeEfectuaALosPuntosDeVidaDelAtacante() {
        cilindroMagico = new CilindroMagico(jugador1);
        Monstruo monstruoAtacante = new SevenColoredFish(jugador2);
        Monstruo monstruoAtacado = new Jinzo7(jugador1);

        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);

        // Las cartas monstruo de ambos lados del tablero siguen vivas.
        Assert.assertTrue(jugador1.cartaEstaEnCampo(monstruoAtacado));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(monstruoAtacado));
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoAtacante));

        // El que ataco recibió ataque a sus puntos de vida igual al ataque de la carta con la que atacó.
        Integer vidaFinalAtacante = 8000 - monstruoAtacante.getAtaque();
        Assert.assertEquals(vidaFinalAtacante, jugador2.getPuntosDeVida());

        // El atacado no recibe daño alguno.
        Integer vidaFinalAtacado = 8000;
        Assert.assertEquals(vidaFinalAtacado, jugador1.getPuntosDeVida());

        // Después de ser activada la carta Trampa se mantiene en el campo hasta el fin del turno.
        Assert.assertTrue(jugador1.cartaEstaEnCampo(cilindroMagico));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(cilindroMagico));

        turno.pasarTurno();
        // Cuando termina el turno la carta Trampa va al cementerio.
        Assert.assertFalse(jugador1.cartaEstaEnCampo(cilindroMagico));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(cilindroMagico));
    }
}
