package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;

public class Magica extends NoMonstruo {


    public Magica(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    @Override
    public boolean activarTrampa() {
        return false;
    }

    @Override
    public boolean negarAtaque() {
        return false;
    }
}
