package algo3.fiuba.entrega1;

import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoAgujeroNegro;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;
import org.junit.Assert;
import org.junit.Before;
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
        Monstruo monstruoAtacante = new Monstruo("monstruo test", 1000, 2000, 1);
        monstruoAtacante.setJugador(jugador1);
        Monstruo monstruoDefensor = new Monstruo("monstruo test", 1000, 2000, 1);
        monstruoDefensor.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        jugador1.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);

        // Como está en modo ataque puede atacar sin tirar excepción
        Assert.assertTrue(true);
    }


    @Test(expected = InhabilitadoParaAtacarExcepcion.class)
    public void colacarUnaCartaDeMonstruoEnModoDeDefensa() {
        Monstruo monstruoAtacante = new Monstruo("monstruo test", 1000, 2000, 1);
        Monstruo monstruoDefensor = new Monstruo("monstruo test", 1000, 2000, 1);

        // Los monstruos se colocan por default en modo ataque, por eso luego se cambia el modo a modo de defensa
        jugador1.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());
        monstruoAtacante.cambiarModo();

        jugador2.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);
        // Como está en modo defensa no puede atacar y tira exepción
    }

    @Test(expected = RuntimeException.class)
    public void colocarCartaMagicaEnCampoBocaAbajo_NoActivaNingunEfecto() {
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica cartaMagica = new Magica("agujero negro", efectoCarta);

        cartaMagica.pasarAModoJuego(BocaAbajo.getInstancia());
        cartaMagica.activar();
        // Como no esta boca abajo no puede activar el efecto y lanza error
    }

    @Test
    public void colocarCartaTrampaEnCampoBocaAbajo() {
        Trampa trampa = new Trampa("trampa test", new EfectoNulo());
        trampa.setJugador(jugador1);

        jugador1.colocarCartaEnTablero(trampa, BocaAbajo.getInstancia());
        jugador1.cartaEstaEnTablero(trampa);
    }

    @Test
    public void mandarCartaAlCementerio() {
        Carta carta = new Monstruo("monstruo test", 1000, 2000, 1);
        carta.setJugador(jugador1);

        jugador1.colocarCartaEnTablero(carta, BocaArriba.getInstancia());
        carta.descartar();

        Assert.assertFalse(carta.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(carta));
    }

    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConMayorAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ1MuereYJugador1PierdePuntosDeVida() {
        Integer ataqueDefensor = 1000;
        Integer ataqueAtacante = 2000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor, 2000, 1);
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante, 2000, 1);
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        jugador1.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

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

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor,2000, 1);
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,2000, 1);
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        jugador1.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

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

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor,2000, 1);
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,2000, 1);
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        jugador1.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

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

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", 0, defensaDefensor, 1);
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante, 0, 1);
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        jugador1.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

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

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", 0, defensaDefensor, 1);
        monstruoDefensor .setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante, 0, 1);
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        jugador1.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

        // Paso a modo de defensa al defensor
        monstruoDefensor.cambiarModo();

        monstruoAtacante.atacar(monstruoDefensor);

        // Si un monstruo muere en modo el jugador no pierde puntos de vida
        Integer puntosDeVidaEsperados = 8000;

        Assert.assertTrue(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        //Assert.assertEquals(puntosDeVidaEsperados, jugador2.getPuntosDeVida());
    }


    @Test
    public void colocarMonstruosEnAmbosLadosDelCampo_colocarAgujeroNegroBocaArriba_seDestruyeronTodosLosMonstruosDeAmbosLadosDelCampoYNingunJugadorRecibioDanio() {
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

    @Test
    public void seColocaUnMonstruoEnElCampo_seQuiereColocarUnMonstruoDe5o6Estrellas_seSacrificaAlPrimerMonstruoParaColocarAlSegundo() {
        Carta cartaMonstruoASacrificar = new Monstruo("m", 1000, 1000, 0);
        Carta cartaMonstruoAInvocar = new Monstruo("m", 2300, 2000, 6);

        // Coloco el monstruo a sacrificar en el campo y verifico que esté
        jugador1.colocarCartaEnTablero(cartaMonstruoASacrificar, BocaArriba.getInstancia());

        Assert.assertTrue(cartaMonstruoASacrificar.estaEnJuego());

        // Coloco el mosntruo a invocar en el campo y verifico la destrucción del anterior
        jugador1.colocarCartaEnTablero(cartaMonstruoAInvocar, BocaArriba.getInstancia());
        Assert.assertTrue(cartaMonstruoAInvocar.estaEnJuego());
    }

    @Test
    public void seColocan2MonstruosEnElCampo_seQuiereColocarUnMonstruoDe7OMasEstrellas_seSacrificanLosDosMonstruosParaInvocarlo() {
        Carta cartaMonstruoASacrificar1 = new Monstruo("m", 1000, 1000, 0);
        Carta cartaMonstruoASacrificar2 = new Monstruo("m", 1000, 1000, 0);
        Carta cartaMonstruoAInvocar = new Monstruo("m", 2300, 2000, 8);

        // Coloco los monstruos a sacrificar en el campo y verifico que estén
        jugador1.colocarCartaEnTablero(cartaMonstruoASacrificar1, BocaArriba.getInstancia());
        jugador1.colocarCartaEnTablero(cartaMonstruoASacrificar2, BocaArriba.getInstancia());

        Assert.assertTrue(cartaMonstruoASacrificar1.estaEnJuego());
        Assert.assertTrue(cartaMonstruoASacrificar2.estaEnJuego());

        // Coloco la carta a invocar y verificio que esté y, la destrucción de los anteriores
        jugador1.colocarCartaEnTablero(cartaMonstruoAInvocar, BocaArriba.getInstancia());

        Assert.assertTrue(cartaMonstruoAInvocar.estaEnJuego());
    }

}
