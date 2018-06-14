package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.cartas.efectos_cartas.EfectoCarta;

public class Trampa extends Carta {
    public Trampa(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    @Override
    public void colocarEnCampo(Campo campo) {
        campo.colocarCartaEspecial(this);
    }
}
