package main.algo3.fiuba.carta;

public class Carta {

    private String nombre;
    private Integer ataque;
    private Integer defensa;
    private EstadoCarta estadoCarta;

    public Carta(String nombre, Integer ataque, Integer defensa) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;

        this.estadoCarta = new FueraDeJuego();
    }

    public void atacar(Carta otraCarta) {
        estadoCarta.atacar(otraCarta, ataque);
    }

    public void recibirAtaque(Integer puntosAtaqueRival) {
        if (estadoCarta.recibirAtaque(puntosAtaqueRival, ataque, defensa)) {
            estadoCarta = new EnCementerio();
        }
    }
}
