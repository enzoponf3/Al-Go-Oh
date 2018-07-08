package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.excepciones.SacrificiosIncorrectosExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;

import java.util.List;

public abstract class Magica extends NoMonstruo {


    public Magica(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }

    @Override
    public boolean activarTrampa() {
        return false;
    }

    @Override
    public boolean negarAtaque() {
        return false;
    }

    @Override
    public void colocarEnCampo(Jugador jugador, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (sacrificios.length != 0)
            throw new SacrificiosIncorrectosExcepcion("No se pueden hacer sacrificios para invocar esta carta.");

        super.colocarEnCampo(jugador, tipoEnJuego, sacrificios);
        jugador.colocarCartaEnCampo(this, tipoEnJuego, sacrificios);
    }

    @Override
    public List<AccionCarta> accionesDisponibles() {
        return estadoEnTurno.accionesDisponibles(this, estadoCarta);
    }
}
