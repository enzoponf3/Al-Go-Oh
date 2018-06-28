package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.modelo.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.DragonBlancoDeOjosAzules;
import algo3.fiuba.modelo.excepciones.CartasInsuficientesExcepcion;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OllaDeLaCodiciaTest {

    private OllaDeLaCodicia ollaDeLaCodicia;
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
    public void alActivarOllaDeLaCodiciaCon2CartasEnMazoGanaElOponenteElJuego() {
        ollaDeLaCodicia = new OllaDeLaCodicia(jugador1);

        Magica carta1 = new AgujeroNegro(jugador1);
        Monstruo carta2 = new DragonBlancoDeOjosAzules(jugador2);

        jugador1.agregarCartaAMazo(carta1);
        jugador1.agregarCartaAMazo(carta2);

        ollaDeLaCodicia.setEstado(new BocaArriba());
        ollaDeLaCodicia.activarEfecto();

        Assert.assertFalse(ollaDeLaCodicia.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(ollaDeLaCodicia));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(ollaDeLaCodicia));

        Assert.assertTrue(juego.terminoPartida());
        Assert.assertEquals(jugador2, juego.ganadorPartida());
    }

    @Test(expected = CartasInsuficientesExcepcion.class) // !!! sacar activar efecto
    public void alActivarOllaJugadorCon1CartaEnMazoLanzaExcepcion() {
        ollaDeLaCodicia = new OllaDeLaCodicia(jugador1);
        Magica agujeroNegro = new AgujeroNegro(jugador1);

        jugador1.agregarCartaAMazo(agujeroNegro);
        jugador1.agregarCartaAMazo(ollaDeLaCodicia);

        jugador1.tomarCartaDelMazo();

        jugador1.colocarCartaEnCampo(ollaDeLaCodicia, new BocaArriba());

        //Lanza excepcion ya que olla de la codicia hace que robes 2 cartas, y solo hay 1 en el mazo
        ollaDeLaCodicia.activarEfecto();
    }

    @Test
    public void ollaDeLaCodiciaSeColocaBocaAbajo_seActivaElEfectoYVaAlCementerio() {
        ollaDeLaCodicia = new OllaDeLaCodicia(jugador1);
        Magica carta1 = new AgujeroNegro(jugador1);
        Monstruo carta2 = new DragonBlancoDeOjosAzules(jugador2);
        Monstruo carta3 = new BebeDragon(jugador2);

        jugador1.agregarCartaAMazo(carta1);
        jugador1.agregarCartaAMazo(carta2);
        jugador1.agregarCartaAMazo(carta3);


        jugador1.colocarCartaEnCampo(ollaDeLaCodicia, new BocaAbajo());
        ollaDeLaCodicia.activarEfecto();

        Assert.assertFalse(ollaDeLaCodicia.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(ollaDeLaCodicia));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(ollaDeLaCodicia));
    }

    @Test
    public void ollaDeLaCodiciaSeColocaBocaArriba_seActivaElEfectoAutomaticamenteYVaAlCementerio() {
        ollaDeLaCodicia = new OllaDeLaCodicia(jugador1);

        Magica carta1 = new AgujeroNegro(jugador1);
        Monstruo carta2 = new DragonBlancoDeOjosAzules(jugador2);
        Monstruo carta3 = new BebeDragon(jugador2);

        jugador1.agregarCartaAMazo(carta1);
        jugador1.agregarCartaAMazo(carta2);
        jugador1.agregarCartaAMazo(carta3);

        Integer cantidadCartasInicialEnMano = 0;
        Assert.assertEquals(cantidadCartasInicialEnMano, Integer.valueOf(jugador1.getMano().size()));

        jugador1.colocarCartaEnCampo(ollaDeLaCodicia, new BocaArriba());

        Assert.assertFalse(ollaDeLaCodicia.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(ollaDeLaCodicia));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(ollaDeLaCodicia));

        Integer cantidadCartasFinalEnMano = cantidadCartasInicialEnMano + 2;
        Assert.assertEquals(cantidadCartasFinalEnMano, Integer.valueOf(jugador1.getMano().size()));
    }
}
