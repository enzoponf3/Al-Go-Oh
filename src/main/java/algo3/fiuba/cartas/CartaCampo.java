package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.excepciones.SacrificiosIncorrectosExcepcion;
import algo3.fiuba.jugador.Jugador;

public class CartaCampo extends Carta {

    public CartaCampo(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }


    @Override
    public void colocarEnCampo(Jugador jugador, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (sacrificios.length != 0)
            throw new SacrificiosIncorrectosExcepcion(String.format("No se pueden hacer sacrificios para invocar esta carta."));

        super.colocarEnCampo(jugador, tipoEnJuego, sacrificios);
        jugador.colocarCartaEnCampo(this, tipoEnJuego, sacrificios);
        this.activarEfecto();
    }

    @Override
    public boolean estaEnCampo(Campo campo) {
        return campo.cartaEstaEnCampo(this);
    }

    @Override
    public void removerDelCampo(Campo campo) {
        campo.removerCarta(this);
    }
}
