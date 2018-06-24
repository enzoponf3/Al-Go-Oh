package algo3.fiuba.cartas.efectos;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.modificadores.ModificadorRefuerzos;

public class EfectoRefuerzos extends EfectoCarta {

    @Override
    public void activar(Carta carta, Monstruo atacante, Monstruo atacado) {
        atacado.agregarModificador(new ModificadorRefuerzos());
    }

}
