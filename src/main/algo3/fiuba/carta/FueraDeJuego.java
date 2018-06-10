package main.algo3.fiuba.carta;

public class FueraDeJuego implements EstadoCarta {

    @Override
    public void atacar(Carta otraCarta, Integer puntosAtaque) {
        throw new RuntimeException("No puede atacar"); //!!!
    }

    @Override
    public boolean recibirAtaque(Integer ataqueAtacante, Integer ataqueDefensor, Integer defensaDefensor) {
        throw new RuntimeException("No se puede atacar a una carta que no está en juego");
    }

    @Override
    public boolean estaViva() {
        throw new RuntimeException("La carta no se ha jugado aún.");
    }

}
