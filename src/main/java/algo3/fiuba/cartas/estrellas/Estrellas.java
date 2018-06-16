package algo3.fiuba.cartas.estrellas;

import algo3.fiuba.cartas.Monstruo;

public interface Estrellas {
    
    boolean sacrificiosSuficientes(Monstruo... sacrificios);

    Integer sacrificiosRequeridos();
}
