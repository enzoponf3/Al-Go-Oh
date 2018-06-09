package algo3.fiuba.carta;

public class EnJuego implements EstadoCarta {

    private TipoEnJuego tipoEnJuego;

    @Override
    public void atacar(Carta otraCarta, Integer puntosAtaque) {
        tipoEnJuego.atacar(otraCarta, puntosAtaque);
    }

    @Override
    public boolean recibirAtaque(Integer ataqueAtacante, Integer ataqueDefensor, Integer defensaDefensor) {
        return tipoEnJuego.recibirAtaque(ataqueAtacante, ataqueDefensor, defensaDefensor);
    }
}
