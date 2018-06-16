package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

public class NoMonstruo extends Carta {

    public NoMonstruo(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    @Override
    public void colocarEnCampo(Campo campo, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (sacrificios.length != 0)
            throw new RuntimeException("No se pueden hacer sacrificios para una carta mágica.");
        estadoCarta = tipoEnJuego;
        campo.colocarCarta(this);
    }

    @Override
    public boolean estaEnTablero(TableroJugador tableroJugador) {
        return tableroJugador.cartaEstaEnTablero(this);
    }

    /*
    @Override
    public boolean esSacrificable() {
        return false;
    }
    */

    @Override
    public void removerDelCampo(Campo campo) {
        campo.removerCarta(this);
    }

}
