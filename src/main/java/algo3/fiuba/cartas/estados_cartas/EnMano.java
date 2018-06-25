package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;

public class EnMano extends FueraDeJuego {

    @Override
    public void verificarQuePuedeAtacar() {
        throw new InhabilitadoParaAtacarExcepcion("No puede atacar si está en la mano.");
    }

    @Override
    public void activarEfecto(Carta carta, Jugador jugador, EfectoCarta efecto) {
        efecto.activar(carta);
    }
}
