package algo3.fiuba.cartas.moldes_cartas.cartas_campo;

import algo3.fiuba.Juego;
import algo3.fiuba.Turno;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WastelandTest {

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
    public void colocoMonstruoACadaLadoDeCampoActivoCartaCampoWastelandSeEfectuaUnAtaqueLos2QuedanVivos() {
        Monstruo monstruo1 = new Monstruo("Monstruo 1",300,0,1, new EfectoNulo());
        Monstruo monstruo2 = new Monstruo("Monstruo 2",0,200,1, new EfectoNulo());

        CartaCampo wasteland = new Wasteland(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruo1, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruo2, new BocaArriba());
        monstruo2.pasarAModoDefensa();
        turno.pasarTurno();

        // Ni bien se coloca carta de campo esta se activa.
        jugador1.colocarCartaEnCampo((Carta) wasteland, new BocaArriba());


        monstruo1.atacar(monstruo2);

        //Deberian estar los 2 en juego ya que al activarse el efecto quedaron igualados en atk vs def y en ese caso no mueren en combate
        Assert.assertTrue(monstruo1.estaEnJuego());
        Assert.assertTrue(monstruo2.estaEnJuego());
    }
}
