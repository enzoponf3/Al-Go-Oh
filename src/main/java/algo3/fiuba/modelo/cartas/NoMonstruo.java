package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.Campo;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.excepciones.SacrificiosIncorrectosExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;

public abstract class NoMonstruo extends Carta {

    public NoMonstruo(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    public abstract boolean activarTrampa();

    public abstract boolean negarAtaque();

    @Override
    public boolean estaEnCampo(Campo campo) {
        return campo.cartaEstaEnCampo(this);
    }

    @Override
    public void removerDelCampo(Campo campo) {
        campo.removerCarta(this);
    }

    @Override
    public void colocarEnCampo(Jugador jugador, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (sacrificios.length != 0)
            throw new SacrificiosIncorrectosExcepcion("No se pueden hacer sacrificios para invocar esta carta.");

        super.colocarEnCampo(jugador, tipoEnJuego, sacrificios);
        jugador.colocarCartaEnCampo(this, tipoEnJuego, sacrificios);
    }

    @Override
    public void activarEfecto() {
        super.girar();
        estadoCarta.activarEfecto(this,  efecto);
        jugador.mandarCartaDelCampoAlCementerio(this);
    }

    @Override
    public void activarEfecto(Monstruo otraCarta1, Monstruo otraCarta2) {
        super.girar();
        estadoCarta.activarEfecto(this, otraCarta1, otraCarta2, efecto);
        jugador.mandarCartaDelCampoAlCementerio(this);
    }
}
