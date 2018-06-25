package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoCarta;

public class BocaAbajo extends EnJuego {

    @Override
    public void activarEfecto(Carta carta, EfectoCarta efecto) {
        throw new CartaInhabilitadaParaActivarseExcepcion("No se puede activar efecto de una carta boca abajo");
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
        carta.setEstado(new BocaArriba());
    }

    @Override
    public void recibirAtaque(NoMonstruo carta) {
        throw new RuntimeException("No se pueden atacar cartas No Monstruos.");
    }

    @Override
    public void activarEfecto(Carta carta, Jugador jugador, EfectoCarta efecto){
        activarEfecto(carta, efecto);
    }
}
