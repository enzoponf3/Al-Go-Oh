package algo3.fiuba.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.efectos.EfectoAgujeroNegro;

public class AgujeroNegro extends Magica {
    public AgujeroNegro() {
        super("Agujero Negro", new EfectoAgujeroNegro());
    }
}
