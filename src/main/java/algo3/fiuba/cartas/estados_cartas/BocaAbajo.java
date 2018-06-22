package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.excepciones.InhabilitadaParaActivarseExcepcion;

public class BocaAbajo extends EnJuego {

    private static BocaAbajo INSTANCIA;

    private BocaAbajo() {
    }

    public static BocaAbajo getInstancia() {
        if (INSTANCIA == null){
            INSTANCIA = new BocaAbajo();
        }

        return INSTANCIA;
    }

    @Override
    public void activarEfecto(Carta carta, EfectoCarta efecto) {
        throw new InhabilitadaParaActivarseExcepcion("No se puede activarEfecto efecto de una carta boca abajo");
    }

    @Override
    public void activarEfecto(Carta carta, Monstruo otraCarta1, Monstruo otraCarta2, EfectoCarta efecto) {
        activarEfecto(carta, efecto);
    }

    @Override
    public void activarEfecto(Trampa trampa, Monstruo atacante, Monstruo atacado, EfectoCarta efecto) {
        efecto.activar(trampa, atacante, atacado);
    }

    @Override
    public void recibirAtaque(Monstruo carta) {
        carta.setEstado(BocaArriba.getInstancia());
    }

    @Override
    public void recibirAtaque(NoMonstruo carta) {
        throw new RuntimeException("No se pueden atacar cartas No Monstruos.");
    }


    // exodia, esto deberia desactivar el efecto
    @Override
    public void activarEfecto(Carta carta, Jugador jugador){
        activarEfecto(carta, jugador);
    }
}
