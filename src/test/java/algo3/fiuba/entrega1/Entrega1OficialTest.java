package algo3.fiuba.entrega1;

import algo3.fiuba.Juego;
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
import algo3.fiuba.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.excepciones.InhabilitadaParaActivarseExcepcion;
import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;
import org.junit.*;


public class Entrega1OficialTest {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        tablero = Tablero.getInstancia();
        tablero.inicializar(jugador1, jugador2);

        juego = new Juego(jugador1, jugador2, tablero);

    }

    @Test
    public void colocarUnaCartaDeMonstruoEnModoDeAtaquePuedeAtacarOtroMonstruo() {
        Monstruo monstruoAtacante = new Monstruo("monstruo test 1", 1000, 2000, 1, new EfectoNulo());
        monstruoAtacante.setJugador(jugador1);
        Monstruo monstruoDefensor = new Monstruo("monstruo test 2", 1000, 2000, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque.
        jugador1.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);

        // Como está en modo ataque puede atacar sin tirar excepción.
    }


    @Test(expected = InhabilitadoParaAtacarExcepcion.class)
    public void colocarUnaCartaDeMonstruoEnModoDeDefensaAlQuererAtacarLanzaExcepcion() {
        Monstruo monstruoAtacante = new Monstruo("monstruo test 1", 1000, 2000, 1, new EfectoNulo());
        Monstruo monstruoDefensor = new Monstruo("monstruo test 2", 1000, 2000, 1, new EfectoNulo());

        // Los monstruos se colocan por default en modo ataque, por eso luego se cambia el modo a modo de defensa.
        jugador1.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());
        monstruoAtacante.cambiarModo();

        jugador2.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);

        Assert.assertTrue(jugador1.cartaEstaEnTablero(monstruoAtacante));
        Assert.assertTrue(jugador2.cartaEstaEnTablero(monstruoDefensor));
        // Como está en modo defensa no puede atacar y tira excepción.
    }


    @Test(expected = InhabilitadaParaActivarseExcepcion.class)
    public void colocarCartaMagicaEnCampoBocaAbajo_NoActivaNingunEfecto() {
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica cartaMagica = new Magica("agujero negro", efectoCarta);

        cartaMagica.pasarAModoJuego(BocaAbajo.getInstancia());
        cartaMagica.activarEfecto(juego);
        // Como está boca abajo no puede activarEfecto el efecto y lanza error.
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
        Carta carta = new Monstruo("monstruo test", 1000, 2000, 1, new EfectoNulo());
        carta.setJugador(jugador1);

        jugador1.colocarCartaEnTablero(carta, BocaArriba.getInstancia());
        jugador1.mandarCartaDelTableroAlCementerio(carta);

        Assert.assertFalse(carta.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnTablero(carta));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(carta));
    }

    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConMayorAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ1MuereYJugador1PierdePuntosDeVida() {
        Integer ataqueDefensor = 1000;
        Integer ataqueAtacante = 2000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor, 0, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante, 0, 1, new EfectoNulo());
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque.
        jugador1.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador tenía 8000 hp - 1000 de diferencia en ataques.
        Integer puntosDeVidaEsperados = 8000 - 1000;

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaEsperados, jugador1.getPuntosDeVida());
    }

    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConMenorAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ2MuereYJugador2PierdePuntosDeVida() {
        Integer ataqueDefensor = 2000;
        Integer ataqueAtacante = 1000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor,2000, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,2000, 1, new EfectoNulo());
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque.
        jugador1.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador tenía 8000 hp - 1000 de diferencia en ataques.
        Integer puntosDeVidaEsperados = 8000 - 1000;

        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaEsperados, jugador2.getPuntosDeVida());
    }

    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConIgualAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ2yMonstruoJ1MuerenYNadiePierdePuntosDeVida() {
        Integer ataqueDefensor = 2000;
        Integer ataqueAtacante = 2000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor,2000, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,2000, 1, new EfectoNulo());
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque.
        jugador1.colocarCartaEnTablero(monstruoDefensor, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoDefensor);

        // Como no hay diferencia ninguno pierde puntos de vida.
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

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", 0, defensaDefensor, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante, 0, 1, new EfectoNulo());
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

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", 0, defensaDefensor, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante, 0, 1, new EfectoNulo());
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
        Magica agujeroNegro = new AgujeroNegro();

        Monstruo monstruoJugador1 = new Monstruo("Rodri", 100, 100, 1, new EfectoNulo());
        Monstruo monstruoJugador2 = new Monstruo("Delfi", 2120, 0, 2, new EfectoNulo());

        jugador1.colocarCartaEnTablero(monstruoJugador1, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoJugador2, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(agujeroNegro, BocaArriba.getInstancia());

        Assert.assertEquals(Integer.valueOf(2), tablero.monstruosEnJuego());


        agujeroNegro.activarEfecto(juego);
        Assert.assertEquals(Integer.valueOf(0), tablero.monstruosEnJuego());

        Assert.assertEquals(Integer.valueOf(0), tablero.monstruosEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnTablero(monstruoJugador1));
        Assert.assertFalse(jugador2.cartaEstaEnTablero(monstruoJugador2));
    }

    @Test
    public void seColocaUnMonstruoEnElCampo_seQuiereColocarUnMonstruoDe5o6Estrellas_seSacrificaAlPrimerMonstruoParaColocarAlSegundo() {
        Monstruo cartaMonstruoASacrificar = new Monstruo("aSacrificar", 1000, 1000, 1, new EfectoNulo());
        Monstruo cartaMonstruoAInvocar = new Monstruo("Sacrificador", 2300, 2000, 6, new EfectoNulo());
        // Coloco el monstruo a sacrificar en el campo y verifico que esté
        jugador1.colocarCartaEnTablero(cartaMonstruoASacrificar, BocaArriba.getInstancia());

        Assert.assertTrue(cartaMonstruoASacrificar.estaEnJuego());

        // Coloco el monstruo a invocar en el campo y verifico la destrucción del anterior
        jugador1.colocarCartaEnTablero(cartaMonstruoAInvocar, BocaArriba.getInstancia(), cartaMonstruoASacrificar);

        Assert.assertTrue(cartaMonstruoAInvocar.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnTablero(cartaMonstruoAInvocar));
        Assert.assertFalse(cartaMonstruoASacrificar.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnTablero(cartaMonstruoASacrificar));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(cartaMonstruoASacrificar));
    }


    @Test
    public void seColocan2MonstruosEnElCampo_seQuiereColocarUnMonstruoDe7OMasEstrellas_seSacrificanLosDosMonstruosParaInvocarlo() {
        Monstruo monstruoASacrificar1 = new Monstruo("aSacrificar 1", 1000, 1000, 1, new EfectoNulo());
        Monstruo monstruoASacrificar2 = new Monstruo("aSacrificar 2", 1000, 1000, 1, new EfectoNulo());
        Monstruo cartaMonstruoAInvocar = new Monstruo("Sacrificador", 2300, 2000, 7, new EfectoNulo());

        // Coloco los monstruos a sacrificar en el campo y verifico que estén.
        jugador1.colocarCartaEnTablero(monstruoASacrificar1, BocaArriba.getInstancia());
        jugador1.colocarCartaEnTablero(monstruoASacrificar2, BocaArriba.getInstancia());

        Assert.assertTrue(monstruoASacrificar1.estaEnJuego());
        Assert.assertTrue(monstruoASacrificar2.estaEnJuego());

        // Coloco la carta a invocar y verificio que esté y, la destrucción de los anteriores.
        jugador1.colocarCartaEnTablero(cartaMonstruoAInvocar, BocaArriba.getInstancia(), monstruoASacrificar1, monstruoASacrificar2);

        Assert.assertTrue(cartaMonstruoAInvocar.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnTablero(cartaMonstruoAInvocar));
        Assert.assertFalse(monstruoASacrificar1.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnTablero(monstruoASacrificar1));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(monstruoASacrificar1));
        Assert.assertFalse(monstruoASacrificar2.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnTablero(monstruoASacrificar2));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(monstruoASacrificar2));
    }

}
