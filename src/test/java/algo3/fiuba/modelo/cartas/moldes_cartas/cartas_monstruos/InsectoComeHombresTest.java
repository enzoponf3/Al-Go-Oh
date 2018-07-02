package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsectoComeHombresTest {

    private InsectoComeHombres insectoComeHombres;
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

        insectoComeHombres = new InsectoComeHombres(jugador1);
    }

    @Test
    public void alColocarseEnCampoBocaArribaNoSeActivaElEfecto() {
        Carta monstruoRival = new PezDe7Colores(jugador2);

        jugador1.colocarCartaEnCampo(insectoComeHombres, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoRival, new BocaArriba());

        Assert.assertTrue(insectoComeHombres.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));

        Assert.assertTrue(monstruoRival.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoRival));
    }

    @Test
    public void seColocaEnElCampoBocaArriba_alSerAtacadoNoActivaElEfecto() {
        Monstruo monstruoOponente = new PezDe7Colores(jugador2);

        jugador1.colocarCartaEnCampo((Carta) insectoComeHombres, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente, new BocaArriba());

        monstruoOponente.atacar(insectoComeHombres);

        Assert.assertFalse(insectoComeHombres.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(insectoComeHombres));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(insectoComeHombres));

        Assert.assertTrue(monstruoOponente.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoOponente));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoOponente));
    }

    @Test
    public void seColocaEnElCampoBocaAbajo_alGirarLaCaraBocaArribaEnElMismoTurnoNoSeActivaElEfecto() {
        Monstruo monstruoRival = new PezDe7Colores(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoRival, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) insectoComeHombres, new BocaAbajo());

        insectoComeHombres.girarCarta();

        Assert.assertTrue(insectoComeHombres.estaEnJuego());
        Assert.assertTrue(insectoComeHombres.getEstadoCarta() instanceof BocaArriba);
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));

        // Se activó el efecto y murió la otra carta
        Assert.assertTrue(monstruoRival.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoRival));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoRival));
    }

    @Test
    public void seColocaEnElCampoBocaAbajo_alQuererActivarElEfectoEnElPrimerTurnoQueEsConvocadaNoloLograYSeDaVueltaLaCarta() {
        Monstruo monstruoRival = new PezDe7Colores(jugador2);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoRival, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) insectoComeHombres, new BocaAbajo());

        insectoComeHombres.activarEfecto();

        Assert.assertTrue(insectoComeHombres.estaEnJuego());
        Assert.assertTrue(insectoComeHombres.getEstadoCarta() instanceof BocaArriba);
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(insectoComeHombres));

        // Se activó el efecto y murió la otra carta
        Assert.assertTrue(monstruoRival.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoRival));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoRival));
    }


    @Test
    public void seColocaEnElCampoBocaAbajo_alSerAtacadoActivaElEfecto() {
        Monstruo monstruoRival = new PezDe7Colores(jugador2);

        jugador1.colocarCartaEnCampo(insectoComeHombres, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoRival, new BocaArriba());

        monstruoRival.atacar(insectoComeHombres);

        Assert.assertTrue(insectoComeHombres.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(insectoComeHombres));

        // Se activó el efecto y murió la otra carta
        Assert.assertFalse(monstruoRival.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoRival));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoRival));
    }

    @Test
    public void seColocaEnElCampoBocaAbajo_alGirarLaCaraBocaArribaEnOtroTurnoSeActivaElEfecto() {
        Monstruo monstruoRival = new PezDe7Colores(jugador2);

        jugador1.colocarCartaEnCampo((Carta) insectoComeHombres, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoRival, new BocaArriba());
        turno.pasarTurno();

        insectoComeHombres.girarCarta();

        Assert.assertTrue(insectoComeHombres.estaEnJuego());
        Assert.assertTrue(insectoComeHombres.getEstadoCarta() instanceof BocaArriba);
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(insectoComeHombres));

        // Se activó el efecto y murió la otra carta
        Assert.assertFalse(monstruoRival.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoRival));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoRival));
    }

    @Test
    public void seColocaEnElCampoBocaAbajo_sePuedeActivarElEfectoYAutomaticamentePasaAEstarBocaArriba() {
        Monstruo monstruoRival = new PezDe7Colores(jugador2);

        jugador1.colocarCartaEnCampo((Carta) insectoComeHombres, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoRival, new BocaArriba());
        turno.pasarTurno();

        insectoComeHombres.activarEfecto();

        Assert.assertTrue(insectoComeHombres.estaEnJuego());
        Assert.assertTrue(insectoComeHombres.getEstadoCarta() instanceof BocaArriba);
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(insectoComeHombres));

        // Se activó el efecto y murió la otra carta
        Assert.assertFalse(monstruoRival.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoRival));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoRival));
    }





}
