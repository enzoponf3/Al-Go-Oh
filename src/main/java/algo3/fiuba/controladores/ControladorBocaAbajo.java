package algo3.fiuba.controladores;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControladorBocaAbajo implements EventHandler<ActionEvent> {

    private VistaCarta vistaCarta;
    private Jugador jugador;
    private Carta carta;
    private VistaMano vistaMano;
    private VistaZonaMonstruos vistaZonaMonstruos;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private VistaCartaCampo vistaCartaCampo;
    private ControladorTurnos controladorTurnos;

    public ControladorBocaAbajo(VistaCarta vistaCarta, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo) {
        this.vistaCarta = vistaCarta;
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaCartaCampo = vistaCartaCampo;
        controladorTurnos = ControladorTurnos.getInstancia();

    }

    @Override
    public void handle(ActionEvent event) {
        jugador.colocarCartaEnCampo(carta, new BocaAbajo());
        System.out.print(vistaCarta.getEstadoVision());
        vistaCarta.cambiarVision();
        vistaZonaMonstruos.agregarMonstruo(vistaCarta);
        controladorTurnos.actualizarTablero();
    }
}
