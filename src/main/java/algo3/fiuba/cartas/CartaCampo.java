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
    public void colocarEnCampo(Campo campo, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (sacrificios.length != 0)
            throw new RuntimeException(String.format("No se pueden hacer sacrificios para invocar esta carta."));

        super.colocarEnCampo(campo, tipoEnJuego, sacrificios);
        campo.colocarCarta(this, tipoEnJuego, sacrificios);
        this.activarEfecto();
    }

    @Override
    public boolean estaEnCampo(Campo campo) {
        return campo.cartaEstaEnCampo(this);
    }

    /*
    @Override
    public boolean estaEnCampo(TableroJugador tableroJugador) {
        return tableroJugador.cartaEstaEnCampo(this);
    }
*/
    @Override
    public void removerDelCampo(Campo campo) {

    }
}
