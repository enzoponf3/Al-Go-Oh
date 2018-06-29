package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorActivarEfecto;
import algo3.fiuba.controladores.ControladorBocaArriba;
import algo3.fiuba.controladores.ControladorBocaAbajo;
import algo3.fiuba.controladores.ControladorInformacionCarta;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.event.Event;
import javafx.geometry.Bounds;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


public class VistaInformacionCarta {

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
    private MenuItem menuActivarEfecto;
    private ContextMenu menuOpciones;
    private MenuBar menuBar;

    public VistaInformacionCarta(VistaCarta vistaCarta, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo){
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
        menuBocaAbajo.setOnAction(new ControladorBocaAbajo(vistaCarta, jugador, carta, vistaMano, vistaZonaMonstruos, vistaZonaNoMonstruos, vistaCartaCampo));

        menuBocaArriba = new MenuItem("Arriba");
        menuBocaArriba.setOnAction(new ControladorBocaArriba(vistaCarta, jugador, carta, vistaMano, vistaZonaMonstruos, vistaZonaNoMonstruos, vistaCartaCampo));

        menuActivarEfecto = new MenuItem("Activar efecto");
        menuActivarEfecto.setOnAction(new ControladorActivarEfecto());

        menuCambiarPosicion.getItems().addAll(menuBocaArriba, menuBocaAbajo);

        menuOpciones.getItems().addAll(menuCambiarPosicion, menuActivarEfecto);

        menuBar = new MenuBar();

        menuBar.setContextMenu(menuOpciones);

        menuBar.setOnMouseClicked(new ControladorInformacionCarta(vistaCarta, menuOpciones));

    }
    public void dibujar() {
        Bounds posCarta = vistaCarta.localToScreen(vistaCarta.getBoundsInLocal());
        Event.fireEvent(menuBar, new MouseEvent(MouseEvent.MOUSE_CLICKED, posCarta.getMinX(),posCarta.getMinY() ,0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
                true, true, true, true, true, true, null));
    }

    public void update() {
        this.dibujar();
    }

}
