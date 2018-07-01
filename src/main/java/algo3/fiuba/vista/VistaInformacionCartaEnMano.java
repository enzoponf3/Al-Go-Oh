package algo3.fiuba.vista;

import algo3.fiuba.controladores.controladores_de_carta.ControladorActivarEfecto;
import algo3.fiuba.controladores.controladores_de_carta.ControladorBocaArribaEnMano;
import algo3.fiuba.controladores.controladores_de_carta.ControladorBocaAbajoEnMano;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.vista_tablero.VistaCartaCampo;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;


public class VistaInformacionCartaEnMano {

    private VistaCarta vistaCarta;
    private Jugador jugador;
    private Carta carta;
    private VistaMano vistaMano;
    private VistaZonaMonstruos vistaZonaMonstruos;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private VistaCartaCampo vistaCartaCampo;
    private Menu menuCambiarPosicion;
    private MenuItem menuBocaAbajo;
    private MenuItem menuBocaArriba;
    private ContextMenu menuOpciones;
    private MenuBar menuBar;

    public VistaInformacionCartaEnMano(VistaCarta vistaCarta, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo){
        this.vistaCarta = vistaCarta;
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaCartaCampo = vistaCartaCampo;

        menuOpciones = new ContextMenu();

        menuCambiarPosicion = new Menu("Colocar boca");

        menuBocaAbajo = new MenuItem("Abajo");
        menuBocaAbajo.setOnAction(new ControladorBocaAbajoEnMano(vistaCarta, jugador, carta, vistaMano, vistaZonaMonstruos, vistaZonaNoMonstruos, vistaCartaCampo));

        menuBocaArriba = new MenuItem("Arriba");
        menuBocaArriba.setOnAction(new ControladorBocaArribaEnMano(vistaCarta, jugador, carta, vistaMano, vistaZonaMonstruos, vistaZonaNoMonstruos, vistaCartaCampo));

        menuCambiarPosicion.getItems().addAll(menuBocaArriba, menuBocaAbajo);

        menuOpciones.getItems().addAll(menuCambiarPosicion);

        menuBar = new MenuBar();

        menuBar.setContextMenu(menuOpciones);

    }
    public void dibujar(MouseEvent evento) {
        menuOpciones.show(vistaCarta,evento.getScreenX(),evento.getScreenY());
    }

    public void update(MouseEvent evento) {
        this.dibujar(evento);
    }

}
