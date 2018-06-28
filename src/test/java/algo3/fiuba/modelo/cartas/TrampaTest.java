package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Wasteland;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.Refuerzos;
import algo3.fiuba.modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrampaTest {

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
    public void seColocaLaCartaCampoBocaAbajo_estaEnJuego() {
        Trampa trampa = new Refuerzos(jugador1);

        jugador1.colocarCartaEnCampo((Carta) trampa, new BocaAbajo());

        Assert.assertTrue(trampa.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(trampa));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(trampa));
        Assert.assertTrue(trampa.getEstadoCarta() instanceof BocaAbajo);
    }

    @Test
    public void seColocaLaCartaCampoBocaArriba_automaticamenteSeColocaBocaAbajo() {
        Trampa trampa = new Refuerzos(jugador1);

        jugador1.colocarCartaEnCampo((Carta) trampa, new BocaArriba());

        Assert.assertTrue(trampa.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(trampa));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(trampa));
        Assert.assertTrue(trampa.getEstadoCarta() instanceof BocaAbajo);
    }

}
