package algo3.fiuba.entrega1;

import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos_cartas.EfectoAgujeroNegro;
import algo3.fiuba.cartas.efectos_cartas.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import org.junit.Assert;
import org.junit.Test;

public class MagicaEntrega1Test {

    @Test(expected = RuntimeException.class)
    public void cartaBocaAbajoNoActivaEfecto() {
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica carta = new Magica("agujero negro", efectoCarta);
        carta.pasarAModoJuego(BocaAbajo.getInstancia());
        carta.activar();
    }

    @Test
    public void cartaAgujeroNegroBocaArribaActivaEfectosSinMonstruosEnJuego() {
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica carta = new Magica("agujero negro", efectoCarta);
        Tablero tablero = Tablero.getInstancia();
        carta.pasarAModoJuego(BocaArriba.getInstancia());
        tablero.colocarCarta(carta, 1);
        carta.activar();
        Assert.assertEquals(Integer.valueOf(0), tablero.monstruosEnJuego());
    }

    @Test
    public void cartaAgujeroNegroBocaArribaActivaEfectosConMonstruoEnOponenteBocaArriba() {
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica agujeroNegro = new Magica("agujero negro", efectoCarta);

        Monstruo monstruoEnemigo = new Monstruo("monstruoOponente", 100, 100, 0);
        Tablero tablero = Tablero.getInstancia();
        agujeroNegro.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoEnemigo.pasarAModoJuego(BocaArriba.getInstancia());

        tablero.colocarCarta(agujeroNegro, 1);
        tablero.colocarCarta(monstruoEnemigo, 2);
        agujeroNegro.activar();
        Assert.assertEquals(0, (int)tablero.monstruosEnJuego());
    }
}
