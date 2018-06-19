package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

public class CartaCampo extends Carta {
    public CartaCampo(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    @Override
    public boolean estaEnTablero(TableroJugador tableroJugador) {
        return false;
    }

    @Override
    public void removerDelCampo(Campo campo) {

    }

    @Override
    public void colocarEnCampo(Campo campo, EnJuego tipoEnJuego) {

    }

}
