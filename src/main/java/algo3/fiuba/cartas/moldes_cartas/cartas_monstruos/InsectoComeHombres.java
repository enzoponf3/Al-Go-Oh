package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoInsectoComeHombres;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.resultado_combate.ResultadoCombate;
import algo3.fiuba.resultado_combate.ResultadoCombateNulo;

public class InsectoComeHombres extends Monstruo {

    public InsectoComeHombres(Jugador jugador) {
        super("Insecto Come-HOMBRES", 450, 600, 2, new EfectoNulo());
        setJugador(jugador);
        setEfecto(new EfectoInsectoComeHombres());
    }

    @Override
    public ResultadoCombate recibirAtaque(Monstruo monstruoAtacante, Integer puntosAtaqueRival) {
        efecto.activar(monstruoAtacante);
        return new ResultadoCombateNulo();
    }
}
