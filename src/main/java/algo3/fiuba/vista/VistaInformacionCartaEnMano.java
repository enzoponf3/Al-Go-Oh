package algo3.fiuba.vista;

import algo3.fiuba.controladores.controladores_de_carta.ControladorActivarEfecto;
import algo3.fiuba.controladores.controladores_de_carta.ControladorBocaArribaEnMano;
import algo3.fiuba.controladores.controladores_de_carta.ControladorBocaAbajoEnMano;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.Trampa;
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
    private ContextMenu menuOpciones;

    public VistaInformacionCartaEnMano(VistaCarta vistaCarta, Jugador jugador, Carta carta){
        this.vistaCarta = vistaCarta;

        menuOpciones = new ContextMenu();

        Menu menuCambiarPosicion = new Menu("Colocar boca");

        MenuItem menuBocaAbajo = new MenuItem("Abajo");
        menuBocaAbajo.setOnAction(new ControladorBocaAbajoEnMano(jugador, carta));

        MenuItem menuBocaArriba = new MenuItem("Arriba");
        menuBocaArriba.setOnAction(new ControladorBocaArribaEnMano(jugador, carta));

        if (!(carta instanceof Trampa)) menuCambiarPosicion.getItems().add(menuBocaArriba);

        if (!(carta instanceof CartaCampo)) menuCambiarPosicion.getItems().add(menuBocaAbajo);

        menuOpciones.getItems().addAll(menuCambiarPosicion);

        MenuBar menuBar = new MenuBar();

        menuBar.setContextMenu(menuOpciones);

    }

    public void dibujar(MouseEvent evento) {
        menuOpciones.show(vistaCarta,evento.getScreenX(), evento.getScreenY());
    }

    public void update(MouseEvent evento) {
        this.dibujar(evento);
    }

}
