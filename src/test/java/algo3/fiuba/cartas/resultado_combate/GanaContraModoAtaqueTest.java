package algo3.fiuba.cartas.resultado_combate;

import algo3.fiuba.Campo;
import algo3.fiuba.Jugador;
import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GanaContraModoAtaqueTest {

    private Campo campo;
    private Jugador jugador;
    private EfectoCarta efectoNulo;

    @Before
    public void setUp() {
        campo = new Campo();
        jugador = new Jugador();
        jugador.setTableroJugador(new TableroJugador());
        efectoNulo = EfectoNulo.getInstancia();
    }

    @Test
    public void monstruoAtacanteSigueVivo() {
        Monstruo monstruoAtacante = new Monstruo("m", 0, 0, 1, efectoNulo);
        monstruoAtacante.setJugador(jugador);
        monstruoAtacante.colocarEnCampo(campo, BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();

        ResultadoCombate resultado = new GanaContraModoDeAtaque(1000);
        resultado.afectarAtacante(monstruoAtacante);

        Assert.assertTrue(monstruoAtacante.estaEnJuego());
    }

    @Test
    public void monstruoDefensorMuere() {
        Monstruo monstruoDefensor = new Monstruo("m", 0, 0, 1, efectoNulo);
        monstruoDefensor.setJugador(jugador);
        monstruoDefensor.colocarEnCampo(campo, BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoAtaque();

        ResultadoCombate resultado = new GanaContraModoDeAtaque(1000);
        resultado.afectarDefensor(monstruoDefensor);

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
    }

    @Test
    public void jugadorAtacanteNoPierdePuntosDeVida() {
        Monstruo monstruoAtacante = new Monstruo("m", 0, 0, 1, efectoNulo);
        monstruoAtacante.setJugador(jugador);
        monstruoAtacante.colocarEnCampo(campo, BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();

        ResultadoCombate resultado = new GanaContraModoDeAtaque(1000);
        resultado.afectarAtacante(monstruoAtacante);

        // 8000 porque no fue afectado.
        Integer puntosDeVidaEsperados = 8000;
        Assert.assertEquals(puntosDeVidaEsperados, jugador.getPuntosDeVida());
    }

    @Test
    public void jugadorDefensorPierdePuntosDeVida() {
        Monstruo monstruoDefensor = new Monstruo("m", 0, 0, 1, efectoNulo);
        monstruoDefensor.setJugador(jugador);
        monstruoDefensor.colocarEnCampo(campo, BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoAtaque();

        ResultadoCombate resultado = new GanaContraModoDeAtaque(1000);
        resultado.afectarDefensor(monstruoDefensor);

        // 7000 = 8000 - 1000
        Integer puntosDeVidaEsperados = 7000;
        Assert.assertEquals(puntosDeVidaEsperados, jugador.getPuntosDeVida());
    }
}
