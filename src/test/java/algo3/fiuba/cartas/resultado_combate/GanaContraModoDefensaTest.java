package algo3.fiuba.cartas.resultado_combate;

import algo3.fiuba.Campo;
import algo3.fiuba.Jugador;
import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GanaContraModoDefensaTest {

    private Campo campo;
    private Jugador jugador;

    @Before
    public void setUp() {
        campo = new Campo();
        jugador = new Jugador();
        jugador.setTableroJugador(new TableroJugador());
    }

    @Test
    public void monstruoAtacanteSigueVivo() {
        Monstruo monstruoAtacante = new Monstruo("m", 0, 0, 1);
        monstruoAtacante.setJugador(jugador);
        monstruoAtacante.colocarEnCampo(campo, BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();

        ResultadoCombate resultado = new GanaContraModoDefensa();
        resultado.afectarAtacante(monstruoAtacante);

        Assert.assertTrue(monstruoAtacante.estaEnJuego());
    }

    @Test
    public void monstruoDefensorMuere() {
        Monstruo monstruoDefensor = new Monstruo("m", 0, 0, 1);
        monstruoDefensor.setJugador(jugador);
        monstruoDefensor.colocarEnCampo(campo, BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoDefensa();

        ResultadoCombate resultado = new GanaContraModoDefensa();
        resultado.afectarDefensor(monstruoDefensor);

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
    }

    @Test
    public void jugadorAtacanteNoPierdePuntosDeVida() {
        Monstruo monstruoAtacante = new Monstruo("m", 0, 0, 1);
        monstruoAtacante.setJugador(jugador);
        monstruoAtacante.colocarEnCampo(campo, BocaArriba.getInstancia());
        monstruoAtacante.pasarAModoAtaque();

        ResultadoCombate resultado = new GanaContraModoDefensa();
        resultado.afectarAtacante(monstruoAtacante);

        // 8000 porque no fue afectado.
        Integer puntosDeVidaEsperados = 8000;
        Assert.assertEquals(puntosDeVidaEsperados, jugador.getPuntosDeVida());
    }

    @Test
    public void jugadorDefensorNoPierdePuntosDeVida() {
        Monstruo monstruoDefensor = new Monstruo("m", 0, 0, 1);
        monstruoDefensor.setJugador(jugador);
        monstruoDefensor.colocarEnCampo(campo, BocaArriba.getInstancia());
        monstruoDefensor.pasarAModoDefensa();

        ResultadoCombate resultado = new GanaContraModoDefensa();
        resultado.afectarDefensor(monstruoDefensor);

        // 8000 porque no fue afectado.
        Integer puntosDeVidaEsperados = 8000;
        Assert.assertEquals(puntosDeVidaEsperados, jugador.getPuntosDeVida());
    }
}
