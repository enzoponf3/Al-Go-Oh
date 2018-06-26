package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;

public abstract class EfectoCarta {

    public void activar(Carta carta) {
        return;
    }

    public void activar(Carta carta, Monstruo otraCarta1, Monstruo otraCarta2) {
        return;
    }

    public void desactivar() {return;}
}
