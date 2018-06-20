package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoCarta;

public abstract class EnJuego implements EstadoCarta {

    @Override
    public boolean estaEnJuego() {
        return true;
    }

    @Override
    public void verificarQuePuedeAtacar() {
        return;
    }

}
