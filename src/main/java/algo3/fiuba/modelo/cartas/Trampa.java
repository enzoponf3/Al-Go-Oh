package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;

import java.util.Observable;
import java.util.Observer;

public class Trampa extends NoMonstruo {

    private boolean estaActiva;

    public Trampa(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
        estaActiva = false;
    }

    public boolean negarAtaque() {
        return true;
    }

    @Override
    public boolean activarTrampa() {
        return true;
    }

    @Override
    public void activarEfecto(Monstruo atacante, Monstruo atacado) {
        estadoCarta.activarEfecto(this,  atacante, atacado, efecto);
        estaActiva = true;
        super.girar();
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
        if (estaActiva)
            jugador.mandarCartaDelCampoAlCementerio(this);
        estaActiva = false;

    }
}
