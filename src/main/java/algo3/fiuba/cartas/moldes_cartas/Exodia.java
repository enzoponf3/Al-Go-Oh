package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoPartesExodia;

public class Exodia extends Monstruo {

    //EfectoPartesExodia efe = new E
    public Exodia(String nombre, Integer ataque, Integer defensa, Integer estrellas, Jugador jugador) {


        super(nombre, ataque, defensa, estrellas, new EfectoPartesExodia());
        setJugador(jugador);
    }
}
