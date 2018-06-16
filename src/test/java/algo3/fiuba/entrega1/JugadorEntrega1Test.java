package algo3.fiuba.entrega1;

import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JugadorEntrega1Test {

    private Jugador jugador;
    private Tablero tablero;

    @Before
    public void setUp() {
        jugador = new Jugador();
        tablero = Tablero.getInstancia();
        tablero.empezarDuelo(jugador,jugador);
    }


    @Test
    public void elJugadorRecienCreadoEstaEnJuego() {
        Assert.assertTrue(jugador.estaEnJuego());
    }

    @Test
    public void elJugadorRecienCreadoNoTieneCartas() {
        Assert.assertEquals(jugador.cantidadCartas(), Integer.valueOf(0));
    }

    @Test
    public void elJugadorSeCreaCon8000PuntosDeVida() {
        Integer puntosDeVida = 8000;

        Assert.assertEquals(jugador.getPuntosDeVida(), puntosDeVida);
    }

    @Test
    public void leSacoMenosPuntosDeVidaDeLosQueTiene_SigueVivo() {
        Integer puntosASacar = 7999;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertTrue(jugador.estaEnJuego());
    }

    @Test
    public void leSacoMenosPuntosDeVidaDeLosQueTiene_SusPuntosDeVidaSonLosAdecuados() {
        Integer puntosASacar = 7999;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(1));
    }

    @Test
    public void leSacoLaMismaCantidadPuntosDeVidaDeLosQueTiene_ElJugadorMuere() {
        Integer puntosASacar = 8000;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertFalse(jugador.estaEnJuego());
        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(0));
    }

    @Test
    public void leSacoMasPuntosDeVidaDeLosQueTiene_ElJugadorMuere_SusPuntosDeVidaSonCero() {
        Integer puntosASacar = 8001;
        jugador.modificarPuntosDeVida(-puntosASacar);

        Assert.assertFalse(jugador.estaEnJuego());
        Assert.assertEquals(jugador.getPuntosDeVida(), Integer.valueOf(0));
    }

    @Test
    public void agregoUnaCartaALaMano_LaCartaEstaEnLaMano() {
        Integer cantidadInicialCartas = jugador.cantidadCartas() + 1;
        Carta carta = new Monstruo("m", 1000, 1000, 0, EfectoNulo);
        jugador.agregarCartaAMazo(carta);

        jugador.tomarCartaDelMazo();
        Assert.assertEquals(jugador.cantidadCartas(), cantidadInicialCartas);
    }

    /*
    @Test
    public void jugadorColocarCartaMonstruoEnManoEnTablero() {
        Carta carta = new Monstruo("m", 1000, 1000, 0);
        jugador.agregarCartaAMazo(carta);
        jugador.tomarCartaDelMazo();
        Integer cantidadFinalCartas = jugador.cantidadCartas() - 1;

        jugador.colocarCartaEnTablero(carta);
        Assert.assertEquals(cantidadFinalCartas, jugador.cantidadCartas());
        Assert.assertTrue(jugador.cartaEstaEnTablero(carta));
    }

*/

    /*
    @Test (expected = RuntimeException.class)
    public void jugadorNoPuedeColocarCartaMonstruoEnTableroSinCartasEnMano() {
        Carta carta = new Monstruo("m", 1000, 1000, 0);
        jugador.colocarCartaEnTablero(carta);
    }

    @Test
    public void jugadorColocarMonstruo5EstrellasOMasSeRequiereUnSacrifico() {
        Carta cartaMonstruoASacrificar = new Monstruo("m", 1000, 1000, 0);
        Carta cartaMonstruoAInvocar = new Monstruo("m", 2300, 2000,6);

        jugador.agregarCartaAMazo(cartaMonstruoASacrificar);
        jugador.agregarCartaAMazo(cartaMonstruoAInvocar);
        jugador.tomarCarta();
        jugador.tomarCarta();
        jugador.colocarCartaEnTablero(cartaMonstruoASacrificar);
        Assert.assertTrue(jugador.cartaEstaEnTablero(cartaMonstruoASacrificar));

        jugador.colocarCartaEnTablero(cartaMonstruoAInvocar);
        Assert.assertTrue(jugador.cartaEstaEnTablero(cartaMonstruoAInvocar));
        Assert.assertFalse(jugador.cartaEstaEnTablero(cartaMonstruoASacrificar));
    }

    @Test
    public void jugadorColocarMonstruo7EstrellasOMasRequiereDosSacrificios() {
        Carta cartaMonstruoASacrificar1 = new Monstruo("m", 1000, 1000, 0);
        Carta cartaMonstruoASacrificar2 = new Monstruo("m", 1000, 1000, 0);
        Carta cartaMonstruoAInvocar = new Monstruo("m", 2300, 2000, 8);

        jugador.agregarCartaAMazo(cartaMonstruoAInvocar);
        jugador.agregarCartaAMazo(cartaMonstruoASacrificar1);
        jugador.agregarCartaAMazo(cartaMonstruoASacrificar2);
        jugador.tomarCarta();
        jugador.tomarCarta();
        jugador.colocarCartaEnTablero(cartaMonstruoASacrificar1);
        jugador.colocarCartaEnTablero(cartaMonstruoASacrificar2);
        Assert.assertTrue(jugador.cartaEstaEnTablero(cartaMonstruoASacrificar1));
        Assert.assertTrue(jugador.cartaEstaEnTablero(cartaMonstruoASacrificar2));

        jugador.tomarCarta();
        jugador.colocarCartaEnTablero(cartaMonstruoAInvocar);
        Assert.assertTrue(jugador.cartaEstaEnTablero(cartaMonstruoAInvocar));
    }

    @Test (expected = RuntimeException.class)
    public void noHaySuficientesCartasParaSacrificar() {
        Carta cartaMonstruoAInvocar = new Monstruo("m", 1000, 1000, 7);

        jugador.agregarCartaAMazo(cartaMonstruoAInvocar);
        jugador.tomarCarta();
        jugador.colocarCartaEnTablero(cartaMonstruoAInvocar);
    }

=======
    */
}
