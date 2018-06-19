package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.efectos.EfectoInsectoComeHombres;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;

public class InsectoComeHombres extends Monstruo {

    public InsectoComeHombres(Jugador jugador) {
        super("Insecto Come-HOMBRES", 450, 600, 2, new EfectoNulo());
        setJugador(jugador);
        setEfecto(new EfectoInsectoComeHombres());
    }

    @Override
    public ResultadoCombate recibirAtaque(Integer puntosAtaqueRival) {
        efecto.activar(null, this);
        return super.recibirAtaque(puntosAtaqueRival);
    }
}
