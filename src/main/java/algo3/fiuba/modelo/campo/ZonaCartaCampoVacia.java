package algo3.fiuba.modelo.campo;

import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.moldes_cartas.CartaCampoNula;

public class ZonaCartaCampoVacia implements ZonaCartaCampo {

    @Override
    public ZonaCartaCampo agregarCartaCampo(CartaCampo cartaCampo) {
        return new ZonaCartaCampoOcupada(cartaCampo);
    }

    @Override
    public ZonaCartaCampo removerCartaCampo(CartaCampo cartaCampo) {
        return this;
    }

    @Override
    public CartaCampo getCartaCampo() {
        return new CartaCampoNula();
    }

    @Override
    public boolean cartaEstaEnZona(CartaCampo cartaCampo) {
        return false;
    }
}
