package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Sogen;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Wasteland;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.GuerreroCelta;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Kuriboh;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.Refuerzos;
import algo3.fiuba.modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartaCampoTest {

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
    public void alColocarUnaCartaCampoYLuegoColocarOtra_laCartaCampoActivaEsLaSegunda() {
        CartaCampo cartaCampo1 = new Wasteland(jugador1);
        CartaCampo cartaCampo2 = new Sogen(jugador1);

        jugador1.colocarCartaEnCampo((Carta) cartaCampo1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) cartaCampo2, new BocaArriba());

        Assert.assertEquals(cartaCampo2, jugador1.getCartaCampoActiva());
    }

    @Test
    public void alColocarUnaCartaCampoYLuegoRemoverla_losMonstruosSeQuedanConElEstadoInicial() {
        CartaCampo cartaCampo = new Wasteland(jugador1);
        Monstruo monstruoPropio = new Kuriboh(jugador1);
        Monstruo monstruoOponente = new GuerreroCelta(jugador2);

        Integer ataqueInicialDelMonstruoPropio = monstruoPropio.getAtaque();
        Integer defensaInicialDelMonstruoOponente = monstruoOponente.getDefensa();


        jugador1.colocarCartaEnCampo((Carta) cartaCampo, new BocaArriba());
        jugador1.colocarCartaEnCampo((Carta) monstruoPropio, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente, new BocaArriba());
        turno.pasarTurno();

        jugador1.colocarCartaEnCampo((Carta) cartaCampo, new BocaArriba());
        jugador1.removerCartaDelCampo(cartaCampo);

        // No queda el efecto de cartaCampo (Wasteland)
        Assert.assertEquals(ataqueInicialDelMonstruoPropio, monstruoPropio.getAtaque());
        Assert.assertEquals(defensaInicialDelMonstruoOponente, monstruoOponente.getDefensa());
    }


    @Test
    public void alColocarUnaCartaCampoYLuegoColocarOtra_seMantieneSoloElEfectoDeLaSegunda() {
        CartaCampo cartaCampo1 = new Wasteland(jugador1);
        CartaCampo cartaCampo2 = new Sogen(jugador1);
        Monstruo monstruoPropio = new Kuriboh(jugador1);
        Monstruo monstruoOponente = new GuerreroCelta(jugador2);

        Integer ataqueInicialDelMonstruoPropio = monstruoPropio.getAtaque();
        Integer defensaInicialDelMonstruoPropio = monstruoPropio.getDefensa();
        Integer ataqueInicialDelMonstruoOponente = monstruoOponente.getAtaque();
        Integer defensaInicialDelMonstruoOponente = monstruoOponente.getDefensa();


        jugador1.colocarCartaEnCampo((Carta) cartaCampo1, new BocaArriba());
        jugador1.colocarCartaEnCampo((Carta) monstruoPropio, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo(cartaCampo2, new BocaArriba());

        // No queda el efecto de cartaCampo1 (Wasteland)
        Assert.assertEquals(ataqueInicialDelMonstruoPropio, monstruoPropio.getAtaque());
        Assert.assertEquals(defensaInicialDelMonstruoOponente, monstruoOponente.getDefensa());

        // Queda sólo el efecto de cartaCampo2 (Sogen)
        Integer defensaFinalDelMonstruoPropio = defensaInicialDelMonstruoPropio + 500;
        Assert.assertEquals(defensaFinalDelMonstruoPropio, monstruoPropio.getDefensa());
        Integer ataqueFinalDelMonstruoOponente = ataqueInicialDelMonstruoOponente + 200;
        Assert.assertEquals(defensaFinalDelMonstruoPropio, monstruoPropio.getAtaque());
    }
}
