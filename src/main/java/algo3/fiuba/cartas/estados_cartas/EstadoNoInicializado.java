package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
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
    public void activarEfecto(Juego juego, Carta carta, EfectoCarta efecto) {
        throw new RuntimeException("La carta nunca se ha inicializado en el duelo.");
    }

    @Override
    public void recibirAtaque(Monstruo carta) {
        throw new RuntimeException("No se pueden atacar Monstruos que están fuera de juego.");
    }

    @Override
    public void recibirAtaque(NoMonstruo carta) {
        throw new RuntimeException("No se pueden atacar cartas No Monstruos.");
    }
}
