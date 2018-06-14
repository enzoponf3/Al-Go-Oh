package algo3.fiuba.entrega1;

import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class Entrega1PostaTest {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        tablero = Tablero.getInstancia();
        tablero.empezarDuelo(jugador1, jugador2);
    }

    @Test
    public void colacarUnaCartaDeMonstruoEnModoDeAtaque() {
        Monstruo monstruoAtacante = new Monstruo("monstruo test", 1000,2000);
        monstruoAtacante.setJugador(jugador1);
        Monstruo monstruoDefensor = new Monstruo("monstruo test", 1000,2000);
        monstruoDefensor.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        monstruoAtacante.colocarEnCampo(BocaArriba.getInstancia());
        monstruoDefensor.colocarEnCampo(BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);

        // Como está en modo ataque puede atacar sin tirar excepción
        Assert.assertTrue(true);
    }

    @Test(expected = InhabilitadoParaAtacarExcepcion.class)
    public void colacarUnaCartaDeMonstruoEnModoDeDefensa() {
        Monstruo monstruoAtacante = new Monstruo("monstruo test", 1000,2000);
        Monstruo monstruoDefensor = new Monstruo("monstruo test", 1000,2000);

        // Los monstruos se colocan por default en modo ataque, por eso luego se cambia el modo a modo de defensa
        monstruoAtacante.colocarEnCampo(BocaArriba.getInstancia());
        monstruoAtacante.cambiarModo();

        monstruoDefensor.colocarEnCampo(BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);
        // Como está en modo defensa no puede atacar y tira exepción
    }

    @Ignore
    @Test
    public void colocarCartaMagicaEnCampoBocaAbajo_NoActivaNingunEfecto() {

    }

    @Ignore
    @Test
    public void colocarCartaTrampaEnCampoBocaAbajo() {
    }

    @Test
    public void mandarCartaAlCementerio() {
        Carta carta = new Monstruo("monstruo test", 1000, 2000);
        carta.setJugador(jugador1);

        carta.colocarEnCampo(BocaArriba.getInstancia());
        carta.descartar();

        Assert.assertFalse(carta.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(carta));
    }

    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConMayorAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ1MuereYJugador1PierdePuntosDeVida() {
        Integer ataqueDefensor = 1000;
        Integer ataqueAtacante = 2000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor,2000);
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,2000);
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        monstruoDefensor.colocarEnCampo(BocaArriba.getInstancia());
        monstruoAtacante.colocarEnCampo(BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador tenía 8000 hp - 1000 de diferencia en ataques
        Integer puntosDeVidaEsperados = 8000 - 1000;

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaEsperados, jugador1.getPuntosDeVida());
    }

    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConMenorAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ2MuereYJugador2PierdePuntosDeVida() {
        Integer ataqueDefensor = 2000;
        Integer ataqueAtacante = 1000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor,2000);
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,2000);
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        monstruoDefensor.colocarEnCampo(BocaArriba.getInstancia());
        monstruoAtacante.colocarEnCampo(BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador tenía 8000 hp - 1000 de diferencia en ataques
        Integer puntosDeVidaEsperados = 8000 - 1000;

        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaEsperados, jugador2.getPuntosDeVida());
    }

    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConIgualAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ2yMonstruoJ1MuerenYNadiePierdePuntosDeVida() {
        Integer ataqueDefensor = 2000;
        Integer ataqueAtacante = 2000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor,2000);
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,2000);
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        monstruoDefensor.colocarEnCampo(BocaArriba.getInstancia());
        monstruoAtacante.colocarEnCampo(BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);

        // Como no hay diferencia ninguno pierde puntos de vida
        Integer puntosDeVidaEsperados = 8000;

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaEsperados, jugador2.getPuntosDeVida());
        Assert.assertEquals(puntosDeVidaEsperados, jugador1.getPuntosDeVida());
    }

    @Test
    public void jugador1ColocaMonstruoModoDeDefensa_jugador2ColocaCartaModoDeAtaqueConMayorAtaqueQueLaDefensaDelAnterior_monstruoJ2AtacaAMonstruoJ1_monstruoJ1MuereYJugadorJ1NoPierdePuntosDeVida() {
        Integer defensaDefensor = 1000;
        Integer ataqueAtacante = 2000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", 0,defensaDefensor);
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,0);
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        monstruoDefensor.colocarEnCampo(BocaArriba.getInstancia());
        monstruoAtacante.colocarEnCampo(BocaArriba.getInstancia());

        // Paso a modo de defensa al defensor
        monstruoDefensor.cambiarModo();

        monstruoAtacante.atacar(monstruoDefensor);

        // Si un monstruo muere en modo el jugador no pierde puntos de vida
        Integer puntosDeVidaEsperados = 8000;

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaEsperados, jugador1.getPuntosDeVida());
    }

    @Test
    public void jugador1ColocaMonstruoModoDeDefensa_jugador2ColocaCartaModoDeAtaqueConMenorAtaqueQueLaDefensaDelAnterior_monstruoJ2AtacaAMonstruoJ1_ningunMonstruoMuere/*YJugador2PierdePuntosDeVida*/() {
        Integer defensaDefensor = 2000;
        Integer ataqueAtacante = 1000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", 0,defensaDefensor);
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,0);
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        monstruoDefensor.colocarEnCampo(BocaArriba.getInstancia());
        monstruoAtacante.colocarEnCampo(BocaArriba.getInstancia());

        // Paso a modo de defensa al defensor
        monstruoDefensor.cambiarModo();

        monstruoAtacante.atacar(monstruoDefensor);

        // Si un monstruo muere en modo el jugador no pierde puntos de vida
        Integer puntosDeVidaEsperados = 8000;

        Assert.assertTrue(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        //Assert.assertEquals(puntosDeVidaEsperados, jugador2.getPuntosDeVida());
    }

    @Ignore
    @Test
    public void colocarMonstruosEnAmbosLadosDelCampo_colocarAgujeroNegroBocaArriva_seDestruyeronTodosLosMonstruosDeAmbosLadosDelCampoYNingunJugadorRecibioDanio() {

    }

    @Ignore
    @Test
    public void seColocaUnMonstruoEnElCampo_seQuiereColocarUnMonstruoDe5o6Estrellas_seSacrificaAlPrimerMonstruoParaColocarAlSegundo() {

    }

    @Ignore
    @Test
    public void seColocan2MonstruosEnElCampo_seQuiereColocarUnMonstruoDe7OMasEstrellas_seSacrificanLosDosMonstruosParaInvocarlo() {

    }





/*
    @Test
    public void colacarUnaCartaDeMonstruoEnModoDeAtaque_AAAAA() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Monstruo monstruoAtacante = new Monstruo("monstruo test", 1000,2000);
        Monstruo monstruoDefensor = new Monstruo("monstruo test", 1000,2000);

        Tablero tablero = Tablero.getInstancia();
        tablero.empezarDuelo(jugador1, jugador2);

        jugador1.agregarCartaAMazo(monstruoAtacante);
        jugador1.tomarCartaDelMazo();

        jugador1.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());
        monstruoAtacante.atacar();
    }
    */
}
