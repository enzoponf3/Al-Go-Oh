package algo3.fiuba.cartas;

import algo3.fiuba.cartas.estados_cartas.EstadoCarta;
import algo3.fiuba.cartas.estados_cartas.FueraDeJuego;

public abstract class Carta {

    private String nombre;
    protected EstadoCarta estadoCarta;

    public Carta(String nombre) {
        this.nombre = nombre;

        this.estadoCarta = new FueraDeJuego();
    }


}
