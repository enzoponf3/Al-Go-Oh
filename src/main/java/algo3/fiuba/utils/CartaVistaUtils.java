package algo3.fiuba.utils;

import algo3.fiuba.controladores.controladores_de_carta.*;
import algo3.fiuba.modelo.cartas.AccionCarta;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.vista_cartas.CartaVista;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.util.List;

public class CartaVistaUtils {

    public String getImagenDeCarta(String nombreCarta) {
        return "/algo3/fiuba/resources/img/" + nombreCarta + ".jpg";
    }

    public String getImagenEspacioVacioNoMonstruo() {
        return "algo3/fiuba/resources/img/magica-atr.jpg";
    }

    public String getImagenEspacioVacioMonstruo() {
        return "algo3/fiuba/resources/img/monstruo-atr.jpg";
    }

    public String getImagenCartaBocaAbajo() {
        return "/algo3/fiuba/resources/img/carta-vista-trasera.png";
    }

    public ContextMenu menuAcciones(CartaVista cartaVista, Jugador jugador, Carta carta, List<AccionCarta> acciones) {
        ContextMenu menuAcciones = new ContextMenu();

        for (AccionCarta ac : acciones) {
            switch (ac) {
                case GIRAR_CARTA:
                    MenuItem itemGirarCarta = new MenuItem("Girar carta");
                    itemGirarCarta.setOnAction(new ControladorGirarCarta(carta));

                    menuAcciones.getItems().add(itemGirarCarta);
                    break;
                case CAMBIAR_MODO:
                    MenuItem itemCambiarModo = new MenuItem("Cambiar modo");
                    itemCambiarModo.setOnAction(new ControladorCambiarModo((Monstruo) carta));

                    menuAcciones.getItems().add(itemCambiarModo);
                    break;
                case ATACAR:
                    MenuItem itemAtacar = new MenuItem("Atacar");
                    itemAtacar.setOnAction(new ControladorAtacar((Monstruo) carta, jugador));

                    menuAcciones.getItems().add(itemAtacar);
                    break;
                case ACTIVAR_EFECTO:
                    MenuItem itemActivarEfecto = new MenuItem("Activar efecto");
                    itemActivarEfecto.setOnAction(new ControladorActivarEfecto(cartaVista, carta));

                    menuAcciones.getItems().add(itemActivarEfecto);
                    break;
                case COLOCAR_EN_CAMPO:
                    Menu menuCambiarPosicion = new Menu("Colocar boca");

                    MenuItem menuBocaAbajo = new MenuItem("Abajo");
                    menuBocaAbajo.setOnAction(new ControladorBocaAbajoEnMano(cartaVista, jugador, carta));

                    MenuItem menuBocaArriba = new MenuItem("Arriba");
                    menuBocaArriba.setOnAction(new ControladorBocaArribaEnMano(cartaVista, jugador, carta));

                    menuCambiarPosicion.getItems().addAll(menuBocaAbajo, menuBocaArriba);

                    menuAcciones.getItems().addAll(menuCambiarPosicion);
                    break;
                default:
                    break;
            }
        }

        return menuAcciones;
    }
}
