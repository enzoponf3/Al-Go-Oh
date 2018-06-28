package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.jugador.Jugador;

import java.util.List;

public class EfectoInsectoComeHombres extends EfectoCarta {

    private Jugador jugador;

    public EfectoInsectoComeHombres(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void activar(Carta carta) {
        Jugador oponente = jugador.getOponente();

        List<Monstruo> monstruosPropios = jugador.getMonstuosEnCampo();
        List<Monstruo> monstruosOponente = oponente.getMonstuosEnCampo();

        if (monstruosOponente.isEmpty()) {
            if (monstruosPropios.size() > 1)
                monstruosPropios.get(0).mandarDelCampoAlCementerio();
        } else {
            monstruosOponente.get(0).mandarDelCampoAlCementerio();
        }
    }
}
