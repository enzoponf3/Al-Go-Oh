package algo3.fiuba.modelo.resultado_combate;

import algo3.fiuba.modelo.Campo;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.TableroJugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PierdeContraModoAtaqueTest {

    private Campo campo;
    private Jugador jugador;

    @Before
    public void setUp() {
        campo = new Campo();
        jugador = new Jugador();
        jugador.setEstadoJugador(new PreInvocacion());
        jugador.setTableroJugador(new TableroJugador());
    }

    @Test
    public void monstruoAtacanteMuere() {
        Monstruo monstruoAtacante = new BebeDragon(jugador);
        monstruoAtacante.setJugador(jugador);
        monstruoAtacante.colocarEnCampo(jugador, new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();

        ResultadoCombate resultado = new PierdeContraModoDeAtaque(1000);
        resultado.afectarAtacante(monstruoAtacante);

        Assert.assertFalse(monstruoAtacante.estaEnJuego());
    }

    @Test
    public void monstruoDefensorSigueVivo() {
        Monstruo monstruoDefensor = new BebeDragon(jugador);
        monstruoDefensor.setJugador(jugador);
        monstruoDefensor.colocarEnCampo(jugador, new BocaArriba());
        monstruoDefensor.pasarAModoAtaque();

        ResultadoCombate resultado = new PierdeContraModoDeAtaque(1000);
        resultado.afectarDefensor(monstruoDefensor);

        Assert.assertTrue(monstruoDefensor.estaEnJuego());
    }

    @Test
    public void jugadorAtacantePierdePuntosDeVida() {
        Monstruo monstruoAtacante = new BebeDragon(jugador);
        monstruoAtacante.setJugador(jugador);
        monstruoAtacante.colocarEnCampo(jugador, new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();

        ResultadoCombate resultado = new PierdeContraModoDeAtaque(1000);
        resultado.afectarAtacante(monstruoAtacante);

        // 7000 = 8000 - 1000
        Integer puntosDeVidaEsperados = 7000;
        Assert.assertEquals(puntosDeVidaEsperados, jugador.getPuntosDeVida());
    }

    @Test
    public void jugadorDefensorNoPierdePuntosDeVida() {
        Monstruo monstruoDefensor = new BebeDragon(jugador);
        monstruoDefensor.setJugador(jugador);
        monstruoDefensor.colocarEnCampo(jugador, new BocaArriba());
        monstruoDefensor.pasarAModoAtaque();

        ResultadoCombate resultado = new PierdeContraModoDeAtaque(1000);
        resultado.afectarDefensor(monstruoDefensor);

        // 8000 porque no fue afectado.
        Integer puntosDeVidaEsperados = 8000;
        Assert.assertEquals(puntosDeVidaEsperados, jugador.getPuntosDeVida());
    }

}
