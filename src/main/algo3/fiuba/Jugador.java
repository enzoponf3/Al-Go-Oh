package main.algo3.fiuba;

public class Jugador {

    private Integer puntosDeVida;
    //private TableroParcial tableroParcial;
    //private Mano mano;

    public boolean sigueEnJuego() {
        return puntosDeVida > 0;
    }

    public void modificarPuntosDeVida(Integer puntos) {
        puntosDeVida += puntos;
    }
}
