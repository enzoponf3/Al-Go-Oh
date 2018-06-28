package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.modificadores.ModificadorRefuerzos;

import java.util.Observable;
import java.util.Observer;

public class EfectoRefuerzos extends EfectoCarta implements Observer {

    private boolean estaActivo;
    private Turno turno;
    private Monstruo monstruoConEfecto;
    private ModificadorRefuerzos modificadorRefuerzos;

    public EfectoRefuerzos() {
        this.estaActivo = false;
        this.turno = Turno.getInstancia();
        this.modificadorRefuerzos = new ModificadorRefuerzos();
        turno.addObserver(this);
    }

    @Override
    public void activar(Carta carta, Monstruo atacante, Monstruo atacado) {
        estaActivo = true;
        this.monstruoConEfecto = atacado;
        atacado.agregarModificador(modificadorRefuerzos);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (estaActivo)
            this.monstruoConEfecto.removerModificador(modificadorRefuerzos);
        estaActivo = false;
    }
}
