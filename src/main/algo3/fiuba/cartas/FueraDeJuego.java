package main.algo3.fiuba.cartas;

public class FueraDeJuego implements EstadoCarta {

    public boolean estaViva() {
        throw new RuntimeException("La carta no se ha jugado aún.");
    }

}
