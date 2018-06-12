package main.algo3.fiuba.cartas;

public abstract class Carta {

    private String nombre;
    protected EstadoCarta estadoCarta;

    public Carta(String nombre) {
        this.nombre = nombre;

        this.estadoCarta = new FueraDeJuego();
    }


}
