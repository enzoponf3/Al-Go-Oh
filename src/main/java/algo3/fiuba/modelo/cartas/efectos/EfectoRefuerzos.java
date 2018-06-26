package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.modificadores.ModificadorRefuerzos;

public class EfectoRefuerzos extends EfectoCarta {

    @Override
    public void activar(Carta carta, Monstruo atacante, Monstruo atacado) {
        atacado.agregarModificador(new ModificadorRefuerzos());
    }

}
