package algo3.fiuba.vista.vista_cartas;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.jugador.Jugador;

public class MonstruoVista extends CartaVista {

    private Monstruo monstruo;

    public MonstruoVista(String imageUrl, Jugador jugador, Monstruo monstruo) {
        super(imageUrl, jugador, monstruo);
        this.monstruo = monstruo;
    }

    @Override
    public void dibujar() {
        super.dibujar();

        if (monstruo.estaEnModoDeDefensa()) {
            this.setRotate(90);
        }

        estadoCartaVista.aniadirFuncionalidad(this, monstruo);
    }
}
