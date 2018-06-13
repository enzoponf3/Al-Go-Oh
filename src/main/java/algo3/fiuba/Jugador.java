package algo3.fiuba;


import algo3.fiuba.cartas.Carta;

import java.util.HashSet;

public class Jugador {

    private Integer puntosDeVida;
    private TableroJugador tableroParcial;
    private HashSet<Carta> mano;


    public Jugador() {

        this.puntosDeVida = 8000;
        this.tableroParcial = new TableroJugador();
        this.mano = new HashSet<>();
    }

    public boolean estaEnJuego() {
        return puntosDeVida > 0;
    }

    public void modificarPuntosDeVida(Integer puntos) {
        puntosDeVida += (-puntos > puntosDeVida) ? -puntosDeVida : puntos;
    }

    public void tomarCarta() {
        mano.add(tableroParcial.tomarCartaMazo());
    }

    public Integer cantidadCartas() {
        return mano.size();
    }

    public Integer getPuntosDeVida() {
        return puntosDeVida;
    }

    public void colocarCartaEnTablero(Carta carta) {
        if(!mano.contains(carta)) {
            throw new RuntimeException("No se posee la carta que se quiere colocar en Tablero");
        }
        tableroParcial.colocarCartaEnTablero(carta);
        mano.remove(carta);
    }

    public boolean cartaEnTablero(Carta carta) {
        return tableroParcial.cartaEnTablero(carta);
    }

    public void agregarCartaAMazo(Carta carta) {
        tableroParcial.agregarCartaAMazo(carta);
    }
}
