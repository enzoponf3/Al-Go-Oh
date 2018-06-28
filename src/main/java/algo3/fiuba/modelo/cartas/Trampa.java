package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.excepciones.SacrificiosIncorrectosExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;

import java.util.Observable;

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
    public void colocarEnCampo(Jugador jugador, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (sacrificios.length != 0)
            throw new SacrificiosIncorrectosExcepcion("No se pueden hacer sacrificios para invocar esta carta.");

        super.colocarEnCampo(jugador, tipoEnJuego, sacrificios);
        jugador.colocarCartaEnCampo(this, tipoEnJuego, sacrificios);
    }

    @Override
    public void activarEfecto() {
        estadoCarta.activarEfecto(this,  efecto);
        this.girarCarta();
    }

    @Override
    public void activarEfecto(Monstruo atacante, Monstruo atacado) {
        estadoCarta.activarEfecto(this,  atacante, atacado, efecto);
        estaActiva = true;
        super.girarCarta();
    }

    @Override
    public void activarEfecto(Carta carta, Jugador jugador) {
        estadoCarta.activarEfecto(this, jugador, efecto);
        this.girarCarta();
    }



    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
        if (estaActiva)
            jugador.mandarCartaDelCampoAlCementerio(this);
        estaActiva = false;

    }
}
