package algo3.fiuba.modelo.campo;

import algo3.fiuba.modelo.cartas.CartaCampo;

public class ZonaCartaCampoOcupada implements ZonaCartaCampo {

    private CartaCampo cartaCampo;

    public ZonaCartaCampoOcupada(CartaCampo cartaCampo) {
        this.cartaCampo = cartaCampo;
    }

    @Override
    public ZonaCartaCampo agregarCartaCampo(CartaCampo cartaCampo) {
        this.cartaCampo.mandarDelCampoAlCementerio();
        return new ZonaCartaCampoOcupada(cartaCampo);
    }

    @Override
    public ZonaCartaCampo removerCartaCampo(CartaCampo cartaCampo) {
        if (this.cartaEstaEnZona(cartaCampo)) {
            return new ZonaCartaCampoVacia();
        } else {
            return this;
        }
    }

    @Override
    public CartaCampo getCartaCampo() {
        return cartaCampo;
    }

    @Override
    public boolean cartaEstaEnZona(CartaCampo cartaCampo) {
        return this.cartaCampo.equals(cartaCampo);
    }
}
