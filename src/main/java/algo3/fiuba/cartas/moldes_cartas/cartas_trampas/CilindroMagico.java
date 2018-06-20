package algo3.fiuba.cartas.moldes_cartas.cartas_trampas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.efectos.EfectoCilindroMagico;

public class CilindroMagico extends Trampa {


    public CilindroMagico(Jugador jugador) {
        super("Cilindro Mágico", new EfectoCilindroMagico(jugador));
        super.setJugador(jugador);
    }

}
