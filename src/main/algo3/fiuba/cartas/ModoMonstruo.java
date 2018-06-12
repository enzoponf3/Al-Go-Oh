package main.algo3.fiuba.cartas;

public interface ModoMonstruo {

    void atacar(Monstruo otraCarta, Integer puntosAtaque);

    boolean recibirAtaque(Integer ataqueAtacante, Integer ataqueDefensor, Integer defensaDefensor);

}
