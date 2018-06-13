package algo3.fiuba.cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.efectos_cartas.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EstadoCarta;
import algo3.fiuba.cartas.estados_cartas.FueraDeJuego;

public abstract class Carta {

    private String nombre;
    protected EstadoCarta estadoCarta;
    protected Jugador jugador;
    protected EfectoCarta efecto;

    public Carta(String nombre, EfectoCarta efecto) {
        this.nombre = nombre;
        this.estadoCarta = new FueraDeJuego();
    }


}
