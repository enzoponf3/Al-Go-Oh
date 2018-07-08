package algo3.fiuba.modelo.cartas.moldes_cartas;

import algo3.fiuba.modelo.cartas.AccionCarta;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

import java.util.List;

public class CartaCampoNula extends CartaCampo {

    public CartaCampoNula() {
        super("Carta Campo Nula", new EfectoNulo());
    }

}
