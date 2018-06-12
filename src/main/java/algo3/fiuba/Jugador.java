package algo3.fiuba;


import algo3.fiuba.cartas.Carta;

public class Jugador {

    private Integer puntosDeVida;
    //private TableroParcial tableroParcial;
    //private Mano mano;


    public Jugador() {
        this.puntosDeVida = 8000;
    }

    public boolean estaEnJuego() {
        return puntosDeVida > 0;
    }

    public void modificarPuntosDeVida(Integer puntos) {
        puntosDeVida += -puntos > puntosDeVida ? -puntosDeVida : puntos;
    }

    public void tomarCarta(Carta carta) {

    }

    public Integer getPuntosDeVida() {
        return puntosDeVida;
    }

    public Mano getMano() {
        return null;
    }
}
