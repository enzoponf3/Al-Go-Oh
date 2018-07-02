package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.cartas.moldes_cartas.MonstruoNulo;
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
            Monstruo monstruoOponenteConMenorAtaque = this.obtenerMonstruoConMenorAtaque(monstruosOponenteEnCampo);
            if (monstruoOponenteConMenorAtaque == null)
                return;
            oponente.mandarCartaDelCampoAlCementerio(monstruoOponenteConMenorAtaque);
        }
    }

    private Monstruo obtenerMonstruoConMenorAtaque(List<Monstruo> monstruos) {
        Monstruo semilla = null;
        for (Monstruo m: monstruos) {
            if (!m.equals(new MonstruoNulo())) {
                semilla = m;
                break;
            }
        }

        System.out.println("semilla: " + semilla);

        Monstruo monstruoDebil = monstruos.stream().reduce(semilla, (acc, m) -> {
            if (!m.equals(new MonstruoNulo()) && m.getAtaque() < acc.getAtaque())
                return m;
            return acc;
        });

        System.out.println("son iguales? " + new MonstruoNulo().equals(new MonstruoNulo()));

        System.out.println("monstruo débil: " + monstruoDebil);

        return monstruoDebil;
    }
}
