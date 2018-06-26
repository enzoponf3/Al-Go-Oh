package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;

import java.util.List;

public class EfectoFisura extends EfectoCarta {

    private Jugador oponente;

    public EfectoFisura(Jugador oponente) {
        this.oponente = oponente;
    }

    @Override
    public void activar(Carta carta) {
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
