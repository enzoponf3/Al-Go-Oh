package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.modificadores.ModificadorWastelandOponente;
import algo3.fiuba.modelo.cartas.modificadores.ModificadorWastelandPropio;

public class EfectoWasteland extends EfectoCarta {

    private Jugador oponente;
    private Jugador jugador;

    public EfectoWasteland(Jugador jugador, Jugador oponente) {
        this.jugador = jugador;
        this.oponente = oponente;
    }

    @Override
    public void activar(Carta carta) {
        jugador.agregarModificador(new ModificadorWastelandPropio());
        oponente.agregarModificador(new ModificadorWastelandOponente());
    }

}