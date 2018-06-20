package algo3.fiuba.cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.cartas.efectos.EfectoCarta;

public class Trampa extends NoMonstruo {

    public Trampa(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    @Override
    public boolean activarTrampa() {
        return true;
    }

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
    public void activarEfecto(Monstruo atacante) {
        estadoCarta.activarEfecto(this,  atacante, efecto);
        jugador.mandarCartaDelTableroAlCementerio(this);
    }

}
