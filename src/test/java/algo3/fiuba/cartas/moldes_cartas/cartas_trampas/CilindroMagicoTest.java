package algo3.fiuba.cartas.moldes_cartas.cartas_trampas;

import algo3.fiuba.Juego;
import algo3.fiuba.Turno;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.Jinzo7;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.SevenColoredFish;
import org.junit.Assert;
import org.junit.Before;
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
    public void atacarATrampaCilindroMagico_seNiegaAtaqueYSeEfectuaALosPuntosDeVidaDelAtacante() {
        Monstruo monstruoAtacante = new SevenColoredFish(jugador2);
        Monstruo monstruoAtacado = new Jinzo7(jugador1);
        cilindroMagico = new CilindroMagico(jugador1);

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

        // Después de ser activada una carta Trampa va al cementerio.
        Assert.assertFalse(jugador1.cartaEstaEnCampo(cilindroMagico));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(cilindroMagico));
    }
}
