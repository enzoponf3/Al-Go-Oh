package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.efectos.EfectoCarta;

public class EstadoNoInicializado implements EstadoCarta {

    @Override
    public void verificarQuePuedeAtacar() {
        return;
    }

    @Override
    public boolean estaEnJuego() {
        throw new RuntimeException("La carta nunca se ha inicializado en el duelo.");
    }

    @Override
    public void activar(Juego juego, Carta carta, EfectoCarta efecto) {
        throw new RuntimeException("La carta nunca se ha inicializado en el duelo.");
    }
}
