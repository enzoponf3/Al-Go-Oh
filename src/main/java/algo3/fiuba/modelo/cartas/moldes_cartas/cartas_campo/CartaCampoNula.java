package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo;

import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class CartaCampoNula extends CartaCampo {

    public CartaCampoNula() {
        super("Carta Campo Nula", new EfectoNulo());
    }
}
