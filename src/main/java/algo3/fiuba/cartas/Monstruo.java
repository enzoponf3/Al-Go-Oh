package algo3.fiuba.cartas;

public class Monstruo extends Carta {

    private Integer ataque;
    private Integer defensa;
    private ModoMonstruo modoMonstruo;

    public Monstruo(String nombre, Integer ataque, Integer defensa) {
        super(nombre);
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public void atacar(Monstruo otraCarta) {
        modoMonstruo.atacar(otraCarta, ataque);
    }

    public void recibirAtaque(Integer puntosAtaqueRival) {
        if (modoMonstruo.recibirAtaque(puntosAtaqueRival, ataque, defensa)) {
            estadoCarta = new EnCementerio();
        }
    }

    public void pasarAModoJuego(EnJuego tipoEnJuego) {
        estadoCarta = tipoEnJuego;
    }

    public boolean estaVivo() {
        return estadoCarta.estaViva();
    }

    public void pasarAModoAtaque() {
        modoMonstruo = ModoAtaque.INSTANCIA();
    }

    public void pasarAModoDefensa() {
        modoMonstruo = ModoDefensa.INSTANCIA();
    }
}
