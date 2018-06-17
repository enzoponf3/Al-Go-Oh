package algo3.fiuba.entrega1;

import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoAgujeroNegro;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.excepciones.InhabilitadaParaActivarseExcepcion;
import org.junit.Assert;
import org.junit.Test;

public class MagicaEntrega1Test {
/*
    @Test(expected = InhabilitadaParaActivarseExcepcion.class)
    public void cartaBocaAbajoNoActivaEfecto() {
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica carta = new Magica("agujero negro", efectoCarta);
        carta.pasarAModoJuego(BocaAbajo.getInstancia());
        Tablero tablero = new Tablero();
        carta.activar(tablero);
    }

    @Test
    public void cartaAgujeroNegroBocaArribaActivaEfectosSinMonstruosEnJuego() {
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica carta = new Magica("agujero negro", efectoCarta);
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        tablero.inicializar(jugador1, jugador2);
        jugador1.colocarCartaEnTablero(carta, BocaArriba.getInstancia());
        carta.activar(tablero);
        Assert.assertEquals(Integer.valueOf(0), tablero.monstruosEnJuego());
    }

    @Test
    public void cartaAgujeroNegroBocaArribaActivaEfectosConMonstruoEnOponenteBocaArriba() {
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica agujeroNegro = new Magica("agujero negro", efectoCarta);

        Monstruo monstruoEnemigo = new Monstruo("monstruoOponente", 100, 100, 1, EfectoNulo);
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        tablero.inicializar(jugador1, jugador2);
        agujeroNegro.pasarAModoJuego(BocaArriba.getInstancia());
        monstruoEnemigo.pasarAModoJuego(BocaArriba.getInstancia());

        jugador1.colocarCartaEnTablero(agujeroNegro, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoEnemigo, BocaArriba.getInstancia());
        agujeroNegro.activar(tablero);
        Assert.assertEquals(0, (int)tablero.monstruosEnJuego());
    }
    */
}
