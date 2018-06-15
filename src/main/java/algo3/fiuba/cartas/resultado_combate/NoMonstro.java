package algo3.fiuba.cartas.resultado_combate;

import algo3.fiuba.Campo;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.modo_monstruo.ModoDeAtaque;

public class NoMonstro extends Carta {

    public NoMonstro(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    @Override
    public void colocarEnCampo(Campo campo, EnJuego tipoEnJuego) {
        estadoCarta = tipoEnJuego;
        campo.colocarCarta(this);
    }

}
