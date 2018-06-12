package main.algo3.fiuba.cartas;

public interface EstadoCarta {

    void atacar(Monstruo otraCarta, Integer puntosAtaque);

    boolean recibirAtaque(Integer ataqueAtacante, Integer ataqueDefensor, Integer defensaDefensor);

    boolean estaViva();
}
