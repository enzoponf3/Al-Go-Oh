package algo3.fiuba.vista;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class VistaZonaNoMonstruos extends VistaZonaCartas {

    public VistaZonaNoMonstruos(Jugador jugador) {
        super(jugador);
    }

    @Override
    public void dibujar() {
        List<NoMonstruo> zonaNoMonstruos = jugador.getNoMonstuosEnCampo();
        for(NoMonstruo noMonstruo: zonaNoMonstruos) {
            String imageUrl = "/algo3/fiuba/resources/img/" + noMonstruo.getNombre() + ".gif";
            super.reemplazarCarta(new ImageView(new Image(imageUrl,
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
        }
    }
}
