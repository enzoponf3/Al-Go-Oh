package algo3.fiuba.carta;

public class ModoAtaque implements EstadoCarta {

    @Override
    public void atacar(Carta otraCarta, Integer puntosAtaque) {
        otraCarta.recibirAtaque(puntosAtaque);
    }

    @Override
    public boolean recibirAtaque(Integer ataqueAtacante, Integer ataqueDefensor, Integer defensaDefensor) {
        return ataqueAtacante >= ataqueDefensor;
    }
}
