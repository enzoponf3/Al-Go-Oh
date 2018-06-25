package algo3.fiuba.entrega3;

import algo3.fiuba.Juego;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.Turno;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.Jinzo7;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.SevenColoredFish;
import algo3.fiuba.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;
import org.junit.Before;
import org.junit.Test;

public class Entrega3NoOficial {

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
    public void agregoUnMonstruoAlCampo_puedeAtacarCuandoReciénFueInvocado() {
        Monstruo monstruoAtacante = new SevenColoredFish(jugador1);
        Monstruo monstruoDefensor = new Jinzo7(jugador2);

        jugador1.colocarCartaEnCampo(monstruoAtacante, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruoDefensor, new BocaArriba());

        monstruoAtacante.atacar(monstruoDefensor);
    }

    @Test(expected = MonstruoInhabilitadoParaAtacarExcepcion.class)
    public void agregoUnMonstruoAlCampoYAtaco_noPuedeVolverAAtacarEnEseTurno() {
        Monstruo monstruoAtacante = new Jinzo7(jugador1);
        Monstruo monstruoDefensor = new SevenColoredFish(jugador2);

        jugador1.colocarCartaEnCampo(monstruoAtacante, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruoDefensor, new BocaArriba());
        monstruoDefensor.cambiarModo();

        // El Monstruo atacante no mata al defensor porque no alcanza con los puntos de ataque
        monstruoAtacante.atacar(monstruoDefensor);

        // No puede atacar otra vez en el mismo turno
        monstruoAtacante.atacar(monstruoDefensor);
    }

    @Test(expected = MonstruoInhabilitadoParaAtacarExcepcion.class)
    public void agregoUnMonstruoAlCampo_noAtacaYPasoElTurno_noPuedeAtacarEnElTurnoRival() {
        Monstruo monstruo1 = new Jinzo7(jugador1);
        Monstruo monstruo2 = new SevenColoredFish(jugador2);

        jugador1.colocarCartaEnCampo(monstruo1, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruo2, new BocaArriba());
        monstruo2.cambiarModo();

        turno.pasarTurno();

        monstruo1.atacar(monstruo2);
    }

    @Test(expected = MonstruoInhabilitadoParaAtacarExcepcion.class)
    public void agregoUnMonstruoAlCampo_atacaYPasoElTurno_noPuedeAtacarEnElTurnoRival() {
        Monstruo monstruo1 = new Jinzo7(jugador1);
        Monstruo monstruo2 = new SevenColoredFish(jugador2);

        jugador1.colocarCartaEnCampo(monstruo1, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruo2, new BocaArriba());
        monstruo2.cambiarModo();

        monstruo1.atacar(monstruo2);

        turno.pasarTurno();

        monstruo1.atacar(monstruo2);
    }
}