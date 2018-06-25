package algo3.fiuba.a_reacomodar;

public class MagicaEntrega1Test {
/*
    @Test(expected = CartaInhabilitadaParaActivarseExcepcion.class)
    public void cartaBocaAbajoNoActivaEfecto() {
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica carta = new Magica("agujero negro", efectoCarta);
        carta.pasarAModoJuego(new BocaAbajo());
        Tablero tablero = new Tablero();
        carta.activarEfecto(tablero);
    }

    @Test
    public void cartaAgujeroNegroBocaArribaActivaEfectosSinMonstruosEnJuego() {
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica carta = new Magica("agujero negro", efectoCarta);
        Tablero tablero = Tablero.getInstancia();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        tablero.inicializar(jugador1, jugador2);
        jugador1.colocarCartaEnCampo(carta, new BocaArriba());
        carta.activarEfecto(tablero);
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
        agujeroNegro.pasarAModoJuego(new BocaArriba());
        monstruoEnemigo.pasarAModoJuego(new BocaArriba());

        jugador1.colocarCartaEnCampo(agujeroNegro, new BocaArriba());
        jugador2.colocarCartaEnCampo((Carta) monstruoEnemigo, new BocaArriba());
        agujeroNegro.activarEfecto(tablero);
        Assert.assertEquals(0, (int)tablero.monstruosEnJuego());
    }
    */
}
