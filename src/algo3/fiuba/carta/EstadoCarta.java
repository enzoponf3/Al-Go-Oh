package algo3.fiuba.carta;

public interface EstadoCarta {

    void atacar(Carta otraCarta, Integer puntosAtaque);

    boolean recibirAtaque(Integer ataqueAtacante, Integer ataqueDefensor, Integer defensaDefensor);
}
