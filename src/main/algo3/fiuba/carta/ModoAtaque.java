package main.algo3.fiuba.carta;

public class ModoAtaque implements EnJuego {

    private static ModoAtaque INSTANCIA;

    private ModoAtaque() {
    }

    public static ModoAtaque INSTANCIA() {
        if (INSTANCIA == null){
            INSTANCIA = new ModoAtaque();
        }

        return INSTANCIA;
    }

    @Override
    public void atacar(Carta otraCarta, Integer puntosAtaque) {
        otraCarta.recibirAtaque(puntosAtaque);
    }

    @Override
    public boolean recibirAtaque(Integer ataqueAtacante, Integer ataqueDefensor, Integer defensaDefensor) {
        return ataqueAtacante >= ataqueDefensor;
    }
}
