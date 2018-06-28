package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.Campo;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.Monstruo;
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
    public EnJuego girar() {
        return new BocaArriba();
    }

    //public abstract void colocarCartaEnCampo(Carta carta, Campo campo);

    //public abstract void colocarCartaEnCampo(Magica carta, Campo campo);

}
