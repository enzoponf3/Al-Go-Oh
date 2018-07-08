package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.vista.vista_cartas.CartaVista;
import algo3.fiuba.vista.VistaZoomEfectoMagica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorActivarEfecto implements EventHandler<ActionEvent> {

    private Carta carta;
    private ControladorDeTurnos controladorDeTurnos;
    private VistaZoomEfectoMagica vistaZoomEfectoMagica;

    public ControladorActivarEfecto(CartaVista vistaCarta, Carta carta) {
        this.carta = carta;
        this.controladorDeTurnos = ControladorDeTurnos.getInstancia();
        this.vistaZoomEfectoMagica = new VistaZoomEfectoMagica(vistaCarta);
    }

    @Override
    public void handle(ActionEvent event) {
       /* Media musica = new Media(getClass().getResource("/algo3/fiuba/resources/media/actefect.mp3").toExternalForm());
        MediaPlayer rprMusica = new MediaPlayer(musica);
        rprMusica.play();*/

        carta.activarEfecto();
        if (carta instanceof Magica) {
            vistaZoomEfectoMagica.update();
        }
        controladorDeTurnos.actualizarTablero();
    }
}
