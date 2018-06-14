package algo3.fiuba.entrega1;

import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
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

    @Ignore
    @Test
    public void mandarCartaAlCementerio() {

    }

    @Ignore
    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConMayorAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ1MuereYJugador1PierdePuntosDeVida() {

    }

    @Ignore
    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConMenorAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ2MuereYJugador2PierdePuntosDeVida() {

    }

    @Ignore
    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConIgualAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ2yMonstruoJ1MuerenYNadiePierdePuntosDeVida() {

    }

    @Ignore
    @Test
    public void jugador1ColocaMonstruoModoDeDefensa_jugador2ColocaCartaModoDeAtaqueConMayorAtaqueQueLaDefensaDelAnterior_monstruoJ2AtacaAMonstruoJ1_monstruoJ1MuereYJugadorJ1NoPierdePuntosDeVida() {

    }

    @Ignore
    @Test
    public void jugador1ColocaMonstruoModoDeDefensa_jugador2ColocaCartaModoDeAtaqueConMenorAtaqueQueLaDefensaDelAnterior_monstruoJ2AtacaAMonstruoJ1_ningunMonstruoMuere/*YJugador2PierdePuntosDeVida*/() {

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
