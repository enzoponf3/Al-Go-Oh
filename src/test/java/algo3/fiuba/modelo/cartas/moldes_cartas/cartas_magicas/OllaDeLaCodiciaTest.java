package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.DragonBlancoDeOjosAzules;
import algo3.fiuba.modelo.excepciones.CartasInsuficientesExcepcion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OllaDeLaCodiciaTest {

    private Jugador jugador1;
    private Jugador jugador2;
    private OllaDeLaCodicia ollaDeLaCodicia;
    private Juego juego;
    private Turno turno;

    @Before
    public void setUp(){
        juego = Juego.getInstancia();
        turno = Turno.getInstancia();

        jugador1 = new Jugador();
        jugador2 = new Jugador();

        juego.inicializar(jugador1, jugador2);
        ollaDeLaCodicia = new OllaDeLaCodicia(jugador1);
    }

    @Test(expected = CartasInsuficientesExcepcion.class)
    public void alActivarOllaJugadorCon1CartaEnMazoLanzaExcepcion() {
        Magica agujeroNegro = new AgujeroNegro(jugador1);

        jugador1.agregarCartaAMazo(agujeroNegro);
        jugador1.agregarCartaAMazo(ollaDeLaCodicia);

        jugador1.tomarCartaDelMazo();

        jugador1.colocarCartaEnCampo(ollaDeLaCodicia, new BocaArriba());

        //Lanza excepcion ya que olla de la codicia hace que robes 2 cartas, y solo hay 1 en el mazo
        ollaDeLaCodicia.activarEfecto();
    }

    @Test
    public void alActivarOllaDeLaCodiciaCon2CartasEnMazoGanaElOponenteElJuego() {
        Juego juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);

        Magica agujeroNegro = new AgujeroNegro(jugador1);
        Monstruo dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules(jugador2);

        jugador1.agregarCartaAMazo(agujeroNegro);
        jugador1.agregarCartaAMazo(agujeroNegro);
        jugador1.agregarCartaAMazo(ollaDeLaCodicia);

        jugador2.agregarCartaAMazo(dragonBlancoDeOjosAzules);

        jugador1.tomarCartaDelMazo();
        jugador1.colocarCartaEnCampo(ollaDeLaCodicia,new BocaArriba());
        ollaDeLaCodicia.activarEfecto();

        Assert.assertTrue(juego.terminoPartida());
        Assert.assertEquals(jugador2,juego.ganadorPartida());
    }
}
