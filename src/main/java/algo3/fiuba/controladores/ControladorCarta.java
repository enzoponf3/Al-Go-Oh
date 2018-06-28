package algo3.fiuba.controladores;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.VistaCarta;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorCarta implements EventHandler<MouseEvent> {

    Jugador jugador;
    VistaCarta vistaCarta;

    @Override
    public void handle(MouseEvent evento) {

        //if (jugador.getMano().contains(vistaCarta.)){}


    }

    public ControladorCarta(Jugador jugador, VistaCarta vistaCarta) {

        this.jugador = jugador;
        this.vistaCarta = vistaCarta;
    }

    public void jugarEnModoDefensa(VistaCarta vistaCarta) {
        //carta.setRotate(90);
    }

    public void activar() {

    }

    public void mandarAlCementerio() {

    }



}
