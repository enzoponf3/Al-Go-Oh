package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.Campo;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.cartas.modificadores.Modificador;
import algo3.fiuba.modelo.excepciones.SacrificiosIncorrectosExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;

public class CartaCampo extends Carta {

    protected Modificador modificadorCampoPropio;
    protected Modificador modificadorCampoOponente;

    public CartaCampo(String nombre, EfectoCarta efecto) {
        super(nombre, efecto);
    }


    @Override
    public void colocarEnCampo(Jugador jugador, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        if (sacrificios.length != 0)
            throw new SacrificiosIncorrectosExcepcion(String.format("No se pueden hacer sacrificios para invocar esta carta."));

        super.colocarEnCampo(jugador, tipoEnJuego, sacrificios);
        jugador.colocarCartaEnCampo(this, tipoEnJuego, sacrificios);
        this.activarEfecto();
    }

    @Override
    public boolean estaEnCampo(Campo campo) {
        return campo.cartaEstaEnCampo(this);
    }

    @Override
    public void removerDelCampo(Campo campo) {
        campo.removerCarta(this);
        jugador.removerModificador(modificadorCampoPropio);
        jugador.getOponente().removerModificador(modificadorCampoOponente);
    }

    public void setModificadorCampoPropio(Modificador modificadorCampoPropio) {
        this.modificadorCampoPropio = modificadorCampoPropio;
    }

    public void setModificadorCampoOponente(Modificador modificadorCampoOponente) {
        this.modificadorCampoOponente = modificadorCampoOponente;
    }
}
