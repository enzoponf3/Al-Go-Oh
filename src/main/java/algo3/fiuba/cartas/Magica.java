package algo3.fiuba.cartas;

import algo3.fiuba.cartas.efectos.EfectoCarta;

public class Magica extends NoMonstruo {


    public Magica(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    @Override
    public boolean activarTrampa() {
        return false;
    }
}
