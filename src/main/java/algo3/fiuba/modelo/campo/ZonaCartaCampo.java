package algo3.fiuba.modelo.campo;

import algo3.fiuba.modelo.cartas.CartaCampo;

public interface ZonaCartaCampo {

    ZonaCartaCampo agregarCartaCampo(CartaCampo cartaCampo);

    ZonaCartaCampo removerCartaCampo(CartaCampo cartaCampo);

    CartaCampo getCartaCampo();

    boolean cartaEstaEnZona(CartaCampo cartaCampo);
}
