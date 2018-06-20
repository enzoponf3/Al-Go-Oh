package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoCarta;

import java.awt.*;

public abstract class FueraDeJuego implements EstadoCarta {

    public boolean estaEnJuego() {
        return false;//throw new RuntimeException("La carta no se ha jugado aún.");
    }

    @Override
    public void activarEfecto(Carta carta, EfectoCarta efecto) {
        activarEfecto(carta, efecto);
    }
    
    @Override
    public void recibirAtaque(Monstruo carta) {
        throw new RuntimeException("No se pueden atacar Monstruos que están fuera de juego.");
    }

    @Override
    public void recibirAtaque(NoMonstruo carta) {
        throw new RuntimeException("No se pueden atacar cartas No Monstruos.");
    }

    @Override
    public void activarEfecto(Juego juego, Carta carta, EfectoCarta efecto) {
        throw new RuntimeException("No se pueden atacar Monstruos que están fuera de juego.");
    }

    @Override
    public void activarEfecto(Trampa trampa, Monstruo atacante, EfectoCarta efecto) {
        throw new RuntimeException("No se pueden activar cartas trampas que están fuera de juego");
    }

    @Override
    public void activarEfecto(Carta carta, Monstruo otraCarta, EfectoCarta efecto) {
        activarEfecto(carta, efecto);
    }
}
