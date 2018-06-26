package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Trampa;
import algo3.fiuba.modelo.cartas.efectos.EfectoCilindroMagico;

public class CilindroMagico extends Trampa {


    public CilindroMagico(Jugador jugador) {
        super("Cilindro Mágico", new EfectoCilindroMagico(jugador.getOponente()));
        super.setJugador(jugador);
    }

}
