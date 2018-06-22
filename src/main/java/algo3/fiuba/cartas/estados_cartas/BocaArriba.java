package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoCarta;

public class BocaArriba extends EnJuego {

    private static BocaArriba INSTANCIA;

    private BocaArriba() {
    }

    public static BocaArriba getInstancia() {
        if (INSTANCIA == null){
            INSTANCIA = new BocaArriba();
        }

        return INSTANCIA;
    }

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
        carta.setEstado(BocaArriba.getInstancia());
    }

    @Override
    public void recibirAtaque(NoMonstruo carta) {
        throw new RuntimeException("No se pueden atacar cartas No Monstruos.");
    }

    @Override
    public void activarEfecto(Trampa trampa, Monstruo atacante, Monstruo atacado, EfectoCarta efecto) {
        throw new RuntimeException("No se puede Activar una carta Trampa en modo defensa");
    }
}
