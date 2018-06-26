package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.cartas.Trampa;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;

public class BocaArriba extends EnJuego {


    @Override
    public void activarEfecto(Carta carta, EfectoCarta efecto) {
        efecto.activar(carta);
    }

    @Override
    public void activarEfecto(Carta carta, Monstruo otraCarta1, Monstruo otraCarta2, EfectoCarta efecto) {
        efecto.activar(carta, otraCarta1, otraCarta2);
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
    public void activarEfecto(Trampa trampa, Monstruo atacante, Monstruo atacado, EfectoCarta efecto) {
        throw new CartaInhabilitadaParaActivarseExcepcion("No se puede Activar una carta Trampa en que esté boca arriba");
    }

    @Override
    public void activarEfecto(Carta carta, Jugador jugador, EfectoCarta efecto) {
        throw new CartaInhabilitadaParaActivarseExcepcion("Ya no puedes activar a exodia!");
    }
}
