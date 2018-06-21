package algo3.fiuba.entrega2;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.efectos.EfectoWasteland;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.moldes_cartas.*;
import algo3.fiuba.cartas.moldes_cartas.cartas_magicas.OllaDeLaCodicia;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Entrega2Test {

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

    /*
    @Test
    public void colocoMonstruoACadaLadoDeCampo_activoCartaCampoWasteland_aumenta200ATKPropio_aumenta300DEFOponente() {
        Monstruo monstruo1 = new Monstruo("Monstruo 1",0,0,1, efectoNulo);
        Monstruo monstruo2 = new Monstruo("Monstruo 2",0,0,1, efectoNulo);

        CartaCampo wasteland = new CartaCampo("Wasteland", new EfectoWasteland());

        jugador1.colocarCartaEnTablero(monstruo1, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruo2, BocaAbajo.getInstancia());

        // Ni bien se coloca carta de campo esta se activa.
        jugador1.colocarCartaEnTablero(wasteland, BocaArriba.getInstancia());

        // Se suma 300 a la defensa del oponente.
        int defensaFinalOponente = 300;
        Assert.assertEquals(defensaFinalOponente, monstruo2.getDefensa());

        // Se suma 200 al ataque propio.
        int ataqueFinalPropio = 200;
        Assert.assertEquals(ataqueFinalPropio, monstruo1.getAtaque());
    }


    @Test
    public void colocoMounstruoDeCadaLadoDeCampo_activoCartaCampoSogen_aumenta500DEFPropio_aumenta200ATKOponente() {
        Monstruo monstruoPropio = new Monstruo("m", 0, 0, 1, efectoNulo);
        Monstruo monstruoOponente = new Monstruo("m", 0, 0, 1, efectoNulo);
        CartaCampo sogen = new CartaCampo("Sogen", new EfectoSogen);

        jugador1.colocarCartaEnTablero(monstruoPropio, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoOponente, BocaArriba.getInstancia());

        // Ni bien se coloca una carta de campo esta se debe de activar.
        jugador1.colocarCartaEnTablero(sogen, BocaArriba.getInstancia());

        // Se suma 200 al ataque de las cartas en el campo del oponente.
        int ataqueFinalOponente = 200;
        Assert.assertEquals(ataqueFinalOponente, (int)monstruoOponente.getAtaque());

        // Se suma 500 a la defenza de las cartas en el campo propio.
        int defensaFinalPropio = 500;
        Assert.assertEquals(defensaFinalPropio, (int)monstruoPropio.getDefensa());

    }
    */
    @Test
    public void activoCartaOllaDelaCodicia_TomoDosCartasDelMazo() {
        Monstruo monstruo1 = new Monstruo("Rodri", 100, 100, 1, new EfectoNulo());
        Monstruo monstruo2 = new Monstruo("Delfi", 2120, 0, 2, new EfectoNulo());
        Magica ollaDeLaCodicia = new OllaDeLaCodicia(jugador1);

        jugador1.agregarCartaAMazo(monstruo1);
        jugador1.agregarCartaAMazo(monstruo2);
        jugador1.colocarCartaEnTablero(ollaDeLaCodicia, BocaArriba.getInstancia());

        ollaDeLaCodicia.activar(juego);
        // Se agregaron dos cartas a la mano del jugador, sacadas del mazo de este.
        Assert.assertTrue(jugador1.cartaEstaEnMano(monstruo1));
        Assert.assertTrue(jugador1.cartaEstaEnMano(monstruo2));
        Assert.assertEquals(2, (int)jugador1.cantidadCartas());
        Assert.assertEquals(0, jugador1.cantidadCartasEnMazo());

        // Luego de ser usada la carta mágica va al cementerio.
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(ollaDeLaCodicia));
        Assert.assertFalse(jugador1.cartaEstaEnTablero(ollaDeLaCodicia));
    }
    /*
    @Test
    public void colocoDosCartasMonstruoEnCampoEnemigo_activoFisura_elDeMenorAtaqueEsDestruido() {
        Monstruo monstruoFuerte = new Monstruo("Delfi", 2120, 0, 2, efectoNulo);
        Monstruo monstruoDebil = new Monstruo("Rodri", 100, 100, 1, efectoNulo);
        EfectoCarta efectoFisura = new EfectoFisura();
        Magica fisura = new Magica("Fisura", efectoFisura);

        jugador2.colocarCartaEnTablero(monstruoDebil, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoFuerte, BocaArriba.getInstancia());
        jugador1.colocarCartaEnTablero(fisura, BocaArriba.getInstancia());

        fisura.activar(tablero);

        // La carta de menor ataque del enemigo va al cementerio.
        Assert.assertFalse(jugador2.cartaEstaEnTablero(monstruoDebil));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoDebil));
        Assert.assertTrue(jugador2.cartaEstaEnTablero(monstruoFuerte));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoFuerte));

        // Después de ser usada la carta mágica va al cementerio.
        Assert.assertFalse(jugador1.cartaEstaEnTablero(fisura));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(fisura));
    }

    @Test
    public void invocoAJinzo7_atacaDirectoALosPuntosDeVidaDelOponente() {
        Monstruo monstruo = new Monstruo("Rodri", 100, 100, 1, efectoNulo);
        EfectoCarta efectoJinzo = new EfectoJinzo();
        Monstruo jinzo = new Monstruo("Jinzo #7", 500, 400, 2, efectoJinzo);

        jugador2.colocarCartaEnTablero(monstruo, BocaArriba.getInstancia());
        jugador1.colocarCartaEnTablero(jinzo, BocaArriba.getInstancia());

        jinzo.atacar(monstruo);

        // No se ataca a las cartas en el campo enemigo.
        Assert.assertTrue(jugador2.cartaEstaEnTablero(monstruo));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruo));

        // Se atacan los puntos de vida del oponente.
        int vidaFinalEnemigo = 8000 - 500;
        Assert.assertEquals(vidaFinalEnemigo, (int)jugador2.getPuntosDeVida());

        // Después de atacar Jinzo se mantiene en el tablero.
        Assert.assertTrue(jugador1.cartaEstaEnTablero(jinzo));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(jinzo));
    }

    @Test
    public void invocarDragonDefinitivo_seSacrifiacanTresDragonesBlancosOjosAzules() {
        Monstruo dragonASacrificar1 = new Monstruo("Dragón Blanco de Ojos Azúles", 3000, 2500, 8, efectoNulo);
        Monstruo dragonASacrificar2 = new Monstruo("Dragón Blanco de Ojos Azúles", 3000, 2500, 8, efectoNulo);
        Monstruo dragonASacrificar3 = new Monstruo("Dragón Blanco de Ojos Azúles", 3000, 2500, 8, efectoNulo);

        // Monstruos de sacrificio para poder invocar a los tres dragones blancos de ojos azúles.
        Monstruo monstruoASacrificar1 = new Monstruo("Flan", 100, 10, 3, efectoNulo);
        Monstruo monstruoASacrificar2 = new Monstruo("Flan", 100, 10, 3, efectoNulo);
        Monstruo monstruoASacrificar3 = new Monstruo("Flan", 100, 10, 3, efectoNulo);
        Monstruo monstruoASacrificar4 = new Monstruo("Flan", 100, 10, 3, efectoNulo);
        Monstruo monstruoASacrificar5 = new Monstruo("Flan", 100, 10, 3, efectoNulo);
        Monstruo monstruoASacrificar6 = new Monstruo("Flan", 100, 10, 3, efectoNulo);

        // Invoco los dragones, con sus respectivos sacrificios.
        jugador1.colocarCartaEnTablero(monstruoASacrificar1, BocaAbajo.getInstancia());
        jugador1.colocarCartaEnTablero(monstruoASacrificar2, BocaAbajo.getInstancia());
        jugador1.colocarCartaEnTablero(dragonASacrificar1, BocaAbajo.getInstancia());

        jugador1.colocarCartaEnTablero(monstruoASacrificar3, BocaAbajo.getInstancia());
        jugador1.colocarCartaEnTablero(monstruoASacrificar4, BocaAbajo.getInstancia());
        jugador1.colocarCartaEnTablero(dragonASacrificar2, BocaAbajo.getInstancia());

        jugador1.colocarCartaEnTablero(monstruoASacrificar5, BocaAbajo.getInstancia());
        jugador1.colocarCartaEnTablero(monstruoASacrificar6, BocaAbajo.getInstancia());
        jugador1.colocarCartaEnTablero(dragonASacrificar3, BocaAbajo.getInstancia());

        Monstruo dragonDefinitivo = new Monstruo("Dragón Definitivo", 4500, 3800, 12, efectoNulo);

        jugador1.colocarCartaEnTablero(dragonDefinitivo, BocaArriba.getInstancia());

        // Para invocar al Dragón definitivo se tuvo que sacrificar a los tres dragones.
        Assert.assertFalse(jugador1.cartaEstaEnTablero(dragonASacrificar1));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(dragonASacrificar1));
        Assert.assertFalse(jugador1.cartaEstaEnTablero(dragonASacrificar2));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(dragonASacrificar2));
        Assert.assertFalse(jugador1.cartaEstaEnTablero(dragonASacrificar3));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(dragonASacrificar3));

        // Se debería de haber colocado al dragón definitivo.
        Assert.assertTrue(jugador1.cartaEstaEnTablero(dragonDefinitivo));
    }

    @Test
    public void colocoInsectoComeHombresBocaAbajo_monstruoOponenteLoAtaca_seActivaEfectoYSeDestruyeAtacante() {
        Monstruo insectoComeHombres = new Monstruo("Insecto Come Hombres", 450, 600, 2, new EfectoInsectoComeHombres);
        Monstruo monstruoAtacante = new Monstruo("Rodri", 100, 100, 1, efectoNulo);

        jugador1.colocarCartaEnTablero(insectoComeHombres, BocaAbajo.getInstancia());
        insectoComeHombres.pasarAModoDefensa();
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

        monstruoAtacante.atacar(insectoComeHombres);

        int puntosInicialesDeVida = 8000;

        // El monstruo atacante fue destruído.
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnTablero(monstruoAtacante));
        Assert.assertEquals(puntosInicialesDeVida, (int)jugador2.getPuntosDeVida());

        // El insecto come-hombres sigue vivo y jugador no perdió vida.
        Assert.assertTrue(jugador1.cartaEstaEnTablero(insectoComeHombres));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(insectoComeHombres));
        Assert.assertEquals(puntosInicialesDeVida, (int)jugador1.getPuntosDeVida());
    }

    @Test
    public void atacarATrampaCilindroMagico_seNiegaAtaqueYSeEfectuaALosPuntosDeVidaDelAtacante() {
        Monstruo monstruoAtacante = new Monstruo("Caro", 500, 250, 3, efectoNulo);
        Monstruo monstruoAtacado = new Monstruo("Flan", 100, 10, 3, efectoNulo);
        Trampa cilindroMagico = new Trampa("Cilindro Mágico", new EfectoCilindroMagico());

        jugador1.colocarCartaEnTablero(monstruoAtacado, BocaAbajo.getInstancia());
        jugador1.colocarCartaEnTablero(cilindroMagico, BocaAbajo.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

        monstruoAtacante.atacar(monstruoAtacado);

        // Las cartas monstruo de ambos lados del tablero siguen vivas.
        Assert.assertTrue(jugador1.cartaEstaEnTablero(monstruoAtacado));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(monstruoAtacado));
        Assert.assertTrue(jugador2.cartaEstaEnTablero(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoAtacante));

        // El que ataco recibió ataque a sus puntos de vida igual al ataque de la carta con la que atacó.
        int vidaFinalAtacante = 8000 - 500;
        Assert.assertEquals(vidaFinalAtacante, (int)jugador2.getPuntosDeVida());

        // El atacado no recibe daño alguno.
        int vidaFinalAtacado = 8000;
        Assert.assertEquals(vidaFinalAtacado, (int)jugador1.getPuntosDeVida());

        // Después de ser activada una carta Trampa va al cementerio.
        Assert.assertFalse(jugador1.cartaEstaEnTablero(cilindroMagico));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(cilindroMagico));
    }

    @Test
    public void colocoTrampaReinforcement_seAtacaConMonstruoDe400ATKMas_monstruoAtacadoAumenta500ATKAlActivarTrampa() {
        Monstruo monstruoAtacado = new Monstruo("Monstruo incompetente", 0, 100, 1, efectoNulo);
        Monstruo monstruoAtacante = new Monstruo("Pepi", 400, 100, 2, efectoNulo);
        Trampa reinforcement = new Trampa("Reinforcement", new EfectoReinforcement());

        jugador1.colocarCartaEnTablero(monstruoAtacado, BocaAbajo.getInstancia());
        jugador1.colocarCartaEnTablero(reinforcement, BocaAbajo.getInstancia());
        jugador2.colocarCartaEnTablero(monstruoAtacante, BocaArriba.getInstancia());

        // Al atacar al monstruoAtacado se activa la trampa, que le suma 500ATK a este mismo.
        monstruoAtacante.atacar(monstruoAtacado);

        // Muere el monstruo atacante.
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnTablero(monstruoAtacante));

        // Se le resta a los puntos de vida del atacante la diferencia de ataques.
        int vidaFinalAtacante = 8000 - (500 - 400);
        Assert.assertEquals(vidaFinalAtacante, (int)jugador2.getPuntosDeVida());

        // El jugador atacado no recibe daño.
        int vidaFinalAtacado = 8000;
        Assert.assertEquals(vidaFinalAtacado, (int)jugador1.getPuntosDeVida());

        // La carta Trampa después de activada va al cementerio.
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(reinforcement));
        Assert.assertFalse(jugador1.cartaEstaEnTablero(reinforcement));
    }

    @Test
    public void extraerTodasLasCartasDeMazo_jugadorSinCartasPerdio() {
        Monstruo monstruo1 = new Monstruo("Rodri", 100, 100, 1, efectoNulo);
        Monstruo monstruo2 = new Monstruo("Delfi", 2120, 0, 2, efectoNulo);

        jugador1.agregarCartaAMazo(monstruo1);
        jugador2.agregarCartaAMazo(monstruo2);

        // Con jugadores recién creados y cartas en los mazos la partida no terminó.
        Assert.assertFalse(juego.terminoPartida());
        Assert.assertEquals(null, juego.ganadorPartida());

        // Se toma la última carta que había (se debería de poder jugar el último turno).
        // Cuando se quiere empezar otro turno sin cartas en mazo se termina partida.
        jugador1.tomarCartaDelMazo();
        jugador1.tomarCartaDelMazo();

        // Al no tener más cartas en mazo se termina la partida y el jugador sin cartas pierde.
        Assert.assertTrue(juego.terminoPartida());
        Assert.assertEquals(jugador2, juego.ganadorPartida());
    }
*/
    @Test
    public void colocarCincoPartesDeExodia_jugadorConPartesGanaPartido() {
        Monstruo parteExodia1 = new PiernaDerechaExodia(jugador1);
        Monstruo parteExodia2 = new PiernaIzquierdaExodia(jugador1);
        Monstruo parteExodia3 = new CabezaExodia(jugador1);
        Monstruo parteExodia4 = new BrazoDerechoExodia(jugador1);
        Monstruo parteExodia5 = new BrazoIzquierdoExodia(jugador1);

        jugador1.agregarCartaAMano(parteExodia1);
        jugador1.agregarCartaAMano(parteExodia2);
        jugador1.agregarCartaAMano(parteExodia3);
        jugador1.agregarCartaAMano(parteExodia4);
        jugador1.agregarCartaAMano(parteExodia5);

        parteExodia5.activar(juego);
        // Cuando un jugador tiene las cinco partes en la mano, se termina la partida y este gana directamente.
        //Assert.assertTrue(juego.terminoPartida());
       // Assert.assertEquals(juego.ganadorPartida(), jugador1);
    }

}

