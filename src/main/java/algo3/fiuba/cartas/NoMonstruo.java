package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

public abstract class NoMonstruo extends Carta {

    public NoMonstruo(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    public abstract boolean activarTrampa();

    public abstract boolean bloquearAtaque();

    @Override
    public boolean estaEnTablero(Campo campo) {
        return campo.cartaEstaEnCampo(this);
    }

    @Override
    public void removerDelCampo(Campo campo) {
        campo.removerCarta(this);
    }


    @Override
    public void colocarEnCampo(Campo campo, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (sacrificios.length != 0)
            throw new RuntimeException(String.format("No se pueden hacer sacrificios para invocar esta carta."));

        estadoCarta = tipoEnJuego;
        campo.colocarCarta(this, tipoEnJuego, sacrificios);
    }

    @Override
    public void activarEfecto() {
        estadoCarta.activarEfecto(this,  efecto);
        jugador.mandarCartaDelCampoAlCementerio(this);
    }

    @Override
    public void activarEfecto(Monstruo otraCarta1, Monstruo otraCarta2) {
        estadoCarta.activarEfecto(this, otraCarta1, otraCarta2, efecto);
        jugador.mandarCartaDelCampoAlCementerio(this);
    }
}
