package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.controladores.ControladorMonstruoAAtacar;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estado_en_turno.UsadaEnTurno;
import algo3.fiuba.modelo.cartas.moldes_cartas.MonstruoNulo;
import algo3.fiuba.modelo.excepciones.FaltaObjetivoAAtacarExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class ControladorAtacar implements EventHandler<ActionEvent> {

    private final Monstruo monstruoAtacante;
    private final Jugador jugador;
    private ControladorDeTurnos controladorDeTurnos;

    public ControladorAtacar(Monstruo monstruo, Jugador jugador) {
        this.monstruoAtacante = monstruo;
        this.jugador = jugador;
        this.controladorDeTurnos = ControladorDeTurnos.getInstancia();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Monstruo monstruoAtacado = ControladorMonstruoAAtacar.getMonstruoAAtacar();
        boolean oponenteNoTieneCartasEnCampo = this.cantidadDeMonstruos(jugador.getOponente().getMonstuosEnCampo()) == 0;

        if (oponenteNoTieneCartasEnCampo) {
            jugador.getOponente().modificarPuntosDeVida(-monstruoAtacante.getAtaque());
            monstruoAtacante.setEstadoEnTurno(new UsadaEnTurno());
        } else {
            if (monstruoAtacado == null) {
                throw new FaltaObjetivoAAtacarExcepcion("Seleccione un objetivo a atacar.");
            } else {
                monstruoAtacante.atacar(monstruoAtacado);
            }
        }

        controladorDeTurnos.actualizarTablero();
    }

    private Integer cantidadDeMonstruos(List<Monstruo> monstruos) {
        Integer i = 0;
        for (Monstruo m : monstruos) {
            if (!m.equals(new MonstruoNulo())) {
                i++;
            }
        }
        return i;
    }
}
