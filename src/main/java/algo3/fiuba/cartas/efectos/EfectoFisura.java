package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;

import java.util.List;

public class EfectoFisura extends EfectoCarta {

    private Jugador jugador;

    public EfectoFisura(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void activar(Carta carta) {
        Jugador oponente = jugador.getOponente();
        List<Monstruo> monstruosOponenteEnCampo = oponente.getMonstuosEnCampo();
        if (!monstruosOponenteEnCampo.isEmpty()) {
            Monstruo monstruoOponenteConMenorAtaque = obtenerMonstruoConMenorAtaque(monstruosOponenteEnCampo);
            oponente.mandarCartaDelCampoAlCementerio(monstruoOponenteConMenorAtaque);
        }
    }

    private Monstruo obtenerMonstruoConMenorAtaque(List<Monstruo> monstruos) {
        Monstruo monstruo = monstruos.stream().reduce(monstruos.get(0), (m, acc) -> {
            if (m.getAtaque() < acc.getAtaque())
                return m;
            return acc;
        });
        return monstruo;
    }
}
