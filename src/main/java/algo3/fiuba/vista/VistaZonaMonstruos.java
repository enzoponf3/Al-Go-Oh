package algo3.fiuba.vista;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class VistaZonaMonstruos extends VistaZonaCartas {

    public VistaZonaMonstruos(Jugador jugador) {
        super(jugador);
    }

    @Override
    public void dibujar() {
        List<Monstruo> zonaMonstruos = jugador.getMonstuosEnCampo();
        for(Monstruo monstruo: zonaMonstruos) {
            String imageUrl = "/algo3/fiuba/resources/img/" + monstruo.getNombre() + ".gif";
            super.reemplazarCarta(new ImageView(new Image(imageUrl,
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
        }
    }
}
