package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

public class EnMano extends FueraDeJuego {

    @Override
    public void verificarQuePuedeAtacar() {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("No puede atacar si está en la mano.");
    }

    @Override
    public void activarEfecto(Carta carta, Jugador jugador, EfectoCarta efecto) {
        efecto.activar(carta);
    }
}
