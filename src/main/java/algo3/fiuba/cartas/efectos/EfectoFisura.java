package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;

public class EfectoFisura extends EfectoCarta {
    private Jugador jugador;

    public EfectoFisura(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void activar(Carta carta) {
        jugador.destruirCartaMenorAtaqueEnTableroOponente();
        jugador.mandarCartaDelTableroAlCementerio(carta);
    }

    private void destruirMonstruoBocaArribaEnTableroConMenorAtaque() {

    }
}
