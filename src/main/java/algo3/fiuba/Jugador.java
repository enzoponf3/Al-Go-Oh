package algo3.fiuba;


import algo3.fiuba.cartas.Carta;

import java.util.HashSet;
import java.util.Set;

public class Jugador {

    private Integer puntosDeVida;
    private TableroJugador tableroParcial;
    private Set<Carta> mano;


    public Jugador() {
        this.puntosDeVida = 8000;
        this.mano = new HashSet<>();
    }

    public boolean estaEnJuego() {
        return puntosDeVida > 0;
    }

    public void modificarPuntosDeVida(Integer puntos) {
        puntosDeVida += (-puntos > puntosDeVida) ? -puntosDeVida : puntos;
    }

    public void tomarCartaDelMazo() {
        mano.add(tableroParcial.tomarCartaDelMazo());
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
        tableroParcial.agregarCartaAlMazo(carta);
    }

    public void setTableroParcial(TableroJugador tableroParcial) {
        this.tableroParcial = tableroParcial;
    }
}
