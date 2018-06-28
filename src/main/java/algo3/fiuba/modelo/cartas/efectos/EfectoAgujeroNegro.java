package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;

import java.util.LinkedList;
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
        List<Monstruo> aux = new LinkedList<>();
        for (Monstruo monstruo : monstruos) {
            aux.add(monstruo);
        }

        for (Monstruo monstruo : aux) {
            jugador.mandarCartaDelCampoAlCementerio(monstruo);
        }
    }
}
