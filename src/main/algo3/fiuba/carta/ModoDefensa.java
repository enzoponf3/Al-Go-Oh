package main.algo3.fiuba.carta;

public class ModoDefensa implements EnJuego {

    private static ModoDefensa INSTANCIA;

    private ModoDefensa() {
    }

    public static ModoDefensa INSTANCIA() {
        if (INSTANCIA == null){
            INSTANCIA = new ModoDefensa();
        }

        return INSTANCIA;
    }

    @Override
    public void atacar(Carta otraCarta, Integer puntosAtaque) {
        throw new RuntimeException("No puede atacar cuando está en modo defensa");
    }

    @Override
    public boolean recibirAtaque(Integer ataqueAtacante, Integer ataqueDefensor, Integer defensaDefensor) {
        return ataqueAtacante >= defensaDefensor;
    }

}
