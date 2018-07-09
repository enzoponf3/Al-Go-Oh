package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.Campo;
import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;

public abstract class EnJuego implements EstadoCarta {

    @Override
    public boolean estaEnJuego() {
        return true;
    }

    @Override
    public void verificarQuePuedeAtacar() {
        return;
    }

    @Override
    public EnJuego girarCarta() {
        return new BocaArriba();
    }

    @Override
    public boolean estaEnMazo() {
        return false;
    }

    public void colocarCartaEnCampo(Monstruo carta, Campo campo) {
        campo.colocarCarta(carta, this);
    }

    public abstract void colocarCartaEnCampo(Magica carta, Campo campo);

    public abstract void colocarCartaEnCampo(Trampa carta, Campo campo);

    public abstract void colocarCartaEnCampo(CartaCampo carta, Campo campo);


}
