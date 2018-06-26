package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;

import java.util.List;

public class EfectoAgujeroNegro extends EfectoCarta {

    private Jugador jugador;
    private Jugador oponente;

    public EfectoAgujeroNegro(Jugador jugador, Jugador oponente) {
        this.jugador = jugador;
        this.oponente = oponente;
    }

    @Override
    public void activar(Carta carta) {
        mandarMonstruosDelCampoAlCementerio(jugador, jugador.getMonstuosEnCampo());
        mandarMonstruosDelCampoAlCementerio(oponente, oponente.getMonstuosEnCampo());
    }

    private void mandarMonstruosDelCampoAlCementerio(Jugador jugador, List<Monstruo> monstruos) {
        for (Monstruo monstruo : monstruos) {
            jugador.mandarCartaDelCampoAlCementerio(monstruo);
        }
    }
}
