package algo3.fiuba.jugador;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

public interface TipoJugador {

    void colocarCartaEnCampo(Carta carta, EnJuego tipoEnJuego, Monstruo... sacrificios);


}
