package algo3.fiuba.controladores;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorCarta implements EventHandler<MouseEvent> {

    private VistaZonaMonstruos vistaZonaMonstruos;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private VistaMano vistaMano;
    private VistaCarta vistaCarta;
    private Jugador jugador;
    private Carta carta;


    public ControladorCarta(VistaCarta vistaCarta, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaZonaMonstruos vistaZonaMonstruos) {
        this.vistaCarta = vistaCarta;
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
    }

    @Override
    public void handle(MouseEvent evento) {
        jugador.colocarCartaEnCampo(carta, new BocaArriba());
        vistaCarta.update();
        vistaMano.update();
        vistaZonaMonstruos.update();
        vistaZonaNoMonstruos.update();
    }

    public void jugarEnModoDefensa(VistaCarta vistaCarta) {
        //carta.setRotate(90);
    }

    public void activar() {

    }

    public void mandarAlCementerio() {

    }



}
