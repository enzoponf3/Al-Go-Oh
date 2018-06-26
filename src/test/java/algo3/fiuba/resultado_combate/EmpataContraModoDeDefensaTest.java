package algo3.fiuba.resultado_combate;

import algo3.fiuba.Campo;
import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.jugador.PreInvocacion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmpataContraModoDeDefensaTest {
    
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
    public void monstruoAtacanteNoMuere() {
        Monstruo monstruoAtacante = new BebeDragon(jugador);
        monstruoAtacante.setJugador(jugador);
        monstruoAtacante.colocarEnCampo(jugador, new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();

        ResultadoCombate resultado = new EmpataContraModoDeDefensa();
        resultado.afectarAtacante(monstruoAtacante);

        Assert.assertTrue(monstruoAtacante.estaEnJuego());
    }

    @Test
    public void monstruoDefensorNoMuere() {
        Monstruo monstruoDefensor = new BebeDragon(jugador);
        monstruoDefensor.setJugador(jugador);
        monstruoDefensor.colocarEnCampo(jugador, new BocaArriba());
        monstruoDefensor.pasarAModoAtaque();

        ResultadoCombate resultado = new EmpataContraModoDeDefensa();
        resultado.afectarDefensor(monstruoDefensor);

        Assert.assertTrue(monstruoDefensor.estaEnJuego());
    }

    @Test
    public void jugadorAtacanteNoPierdePuntosDeVida() {
        Monstruo monstruoAtacante = new BebeDragon(jugador);
        monstruoAtacante.setJugador(jugador);
        monstruoAtacante.colocarEnCampo(jugador, new BocaArriba());
        monstruoAtacante.pasarAModoAtaque();

        ResultadoCombate resultado = new EmpataContraModoDeDefensa();
        resultado.afectarAtacante(monstruoAtacante);

        // 8000 porque no fue afectado.
        Integer puntosDeVidaEsperados = 8000;
        Assert.assertEquals(puntosDeVidaEsperados, jugador.getPuntosDeVida());
    }

    @Test
    public void jugadorDefensorNoPierdePuntosDeVida() {
        Monstruo monstruoDefensor = new BebeDragon(jugador);
        monstruoDefensor.setJugador(jugador);
        monstruoDefensor.colocarEnCampo(jugador, new BocaArriba());
        monstruoDefensor.pasarAModoAtaque();

        ResultadoCombate resultado = new EmpataContraModoDeDefensa();
        resultado.afectarDefensor(monstruoDefensor);

        // 8000 porque no fue afectado.
        Integer puntosDeVidaEsperados = 8000;
        Assert.assertEquals(puntosDeVidaEsperados, jugador.getPuntosDeVida());
    }

}
