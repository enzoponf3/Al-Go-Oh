package main.algo3.fiuba.cartas;

public class Monstruo extends Carta {

    private Integer ataque;
    private Integer defensa;

    public Monstruo(String nombre, Integer ataque, Integer defensa) {
        super(nombre);
    }

    public void atacar(Monstruo otraCarta) {
        estadoCarta.atacar(otraCarta, ataque);
    }

    public void recibirAtaque(Integer puntosAtaqueRival) {
        if (estadoCarta.recibirAtaque(puntosAtaqueRival, ataque, defensa)) {
            estadoCarta = new EnCementerio();
        }
    }

    public void pasarAModoJuego(EnJuego tipoEnJuego) {
        estadoCarta = tipoEnJuego;
    }

    public boolean estaVivo() {
        return estadoCarta.estaViva();
    }
}
