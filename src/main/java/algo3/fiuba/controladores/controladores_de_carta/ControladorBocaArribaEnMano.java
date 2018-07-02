package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorCantidadDeSacrificios;
import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.MagoOscuro;
import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.*;
import algo3.fiuba.vista.vista_tablero.VistaCartaCampo;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ControladorBocaArribaEnMano extends ControladorColocarCarta {


    public ControladorBocaArribaEnMano(VistaCarta vistaCarta, Jugador jugador, Carta carta) {
        super(vistaCarta, jugador, carta);
    }

    @Override
    public EnJuego tipoEnJuego(Carta carta) {
        /*if (carta instanceof Monstruo){
            Media musica = new Media(getClass().getResource("/algo3/fiuba/resources/media/monstruo.mp3").toExternalForm());
            MediaPlayer rprMusica = new MediaPlayer(musica);
            rprMusica.play();
        } else if (carta instanceof CartaCampo){
            Media musica = new Media(getClass().getResource("/algo3/fiuba/resources/media/cartacampofx.mp3").toExternalForm());
            MediaPlayer rprMusica = new MediaPlayer(musica);
            rprMusica.play();
        }*/
        return new BocaArriba();
    }
}
