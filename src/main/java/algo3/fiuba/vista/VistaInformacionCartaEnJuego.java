package algo3.fiuba.vista;

import algo3.fiuba.controladores.controladores_de_carta.*;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoInsectoComeHombres;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.cartas.estado_en_turno.UsadaEnTurno;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.modo_monstruo.ModoDeAtaque;
import algo3.fiuba.modelo.cartas.modo_monstruo.ModoDeDefensa;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PostInvocacion;
import algo3.fiuba.vista.vista_tablero.VistaCartaCampo;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class VistaInformacionCartaEnJuego {

    private VistaCarta vistaCarta;
    private Jugador jugador;
    private Carta carta;

    public VistaInformacionCartaEnJuego(VistaCarta vistaCarta, Jugador jugador, Carta carta){
        this.vistaCarta = vistaCarta;
        this.jugador = jugador;
        this.carta = carta;
    }

    public void dibujar(MouseEvent evento) {
        ContextMenu menuOpciones = new ContextMenu();


        if (carta instanceof Monstruo) {
            Monstruo monstruo = (Monstruo) carta;

            if (jugador.getEstadoJugador() instanceof PostInvocacion
                    /*&& !(carta.getEstadoEnTurno() instanceof UsadaEnTurno) !!!! */) {
                MenuItem menuModo = new MenuItem("Cambiar modo");
                menuModo.setOnAction(new ControladorCambiarModo(monstruo));

                menuOpciones.getItems().add(menuModo);

                if (monstruo.getModo() instanceof ModoDeAtaque) {
                    MenuItem menuAtacar = new MenuItem("Atacar");
                    menuAtacar.setOnAction(new ControladorAtacar(monstruo, jugador));

                    menuOpciones.getItems().add(menuAtacar);
                }

                if (!(monstruo.getEfecto() instanceof EfectoNulo)
                        && !(monstruo.getEfecto() instanceof EfectoInsectoComeHombres)) {
                    MenuItem menuActivarEfecto = new MenuItem("Activar efecto");
                    menuActivarEfecto.setOnAction(new ControladorActivarEfecto(vistaCarta, carta));

                    menuOpciones.getItems().add(menuActivarEfecto);
                }
            }

            if (jugador.getEstadoJugador() instanceof PostInvocacion && carta.getEstadoCarta() instanceof BocaAbajo) {
                MenuItem menuCambiarPosicion = new MenuItem("Girar carta");
                menuCambiarPosicion.setOnAction(new ControladorGirarCarta(carta));

                menuOpciones.getItems().add(menuCambiarPosicion);
            }
        }

        if (carta instanceof Magica) {
            MenuItem menuActivarEfecto = new MenuItem("Activar efecto");
            menuActivarEfecto.setOnAction(new ControladorActivarEfecto(vistaCarta, carta));

            menuOpciones.getItems().add(menuActivarEfecto);
        }

        MenuBar menuBar = new MenuBar();
        menuBar.setContextMenu(menuOpciones);

        menuOpciones.show(vistaCarta,evento.getScreenX(),evento.getScreenY());
    }

    public void update(MouseEvent evento) {
        this.dibujar(evento);
    }

}


