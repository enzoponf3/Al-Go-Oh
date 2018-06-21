package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.Juego;
import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

public abstract class NoMonstruo extends Carta {

    public NoMonstruo(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    @Override
    public boolean estaEnTablero(TableroJugador tableroJugador) {
        return tableroJugador.cartaEstaEnTablero(this);
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

    public abstract boolean activarTrampa();

    @Override
    public void activarEfecto(Juego juego) {
        estadoCarta.activarEfecto(juego, this,  efecto);
        jugador.mandarCartaDelTableroAlCementerio(this);
    }

    @Override
    public void activarEfecto() {
        estadoCarta.activarEfecto(this,  efecto);
        jugador.mandarCartaDelTableroAlCementerio(this);
    }

    @Override
    public void activarEfecto(Monstruo otraCarta) {
        estadoCarta.activarEfecto(this,  otraCarta, efecto);
        jugador.mandarCartaDelTableroAlCementerio(this);
    }
}
