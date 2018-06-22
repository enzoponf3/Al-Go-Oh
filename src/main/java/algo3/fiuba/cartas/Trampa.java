package algo3.fiuba.cartas;

import algo3.fiuba.cartas.efectos.EfectoCarta;

public class Trampa extends NoMonstruo {

    public Trampa(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    public boolean bloquearAtaque() {
        return true;
    }

    @Override
    public boolean activarTrampa() {
        return true;
    }

    @Override
    public void activarEfecto(Monstruo atacante, Monstruo atacado) {
        estadoCarta.activarEfecto(this,  atacante, atacado, efecto);
        jugador.mandarCartaDelCampoAlCementerio(this);
    }


}
